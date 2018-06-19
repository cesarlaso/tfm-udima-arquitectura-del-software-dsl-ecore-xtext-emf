package es.udima.tfm.cesarlaso.generator.java

import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.xtext.generator.IFileSystemAccess2
import org.eclipse.xtext.generator.IGeneratorContext
import java.util.ArrayList
import org.eclipse.emf.ecore.EAttribute
import org.eclipse.emf.ecore.EClass
import org.eclipse.emf.ecore.EClassifier
import java.util.List
import es.udima.cesarlaso.tfm.communications.impl.CommunicationsFactoryImpl
import es.udima.cesarlaso.tfm.communications.Packet
import es.udima.cesarlaso.tfm.communicationstatus.impl.StatusServiceImpl
import es.udima.cesarlaso.tfm.communicationstatus.impl.CommunicationstatusFactoryImpl
import es.udima.cesarlaso.tfm.communications.CommunicationsFactory
import es.udima.cesarlaso.tfm.communications.CommunicationsPackage
import es.udima.cesarlaso.tfm.communicationstatus.CommunicationstatusFactory
import es.udima.cesarlaso.tfm.communicationstatus.CommunicationstatusPackage

class TelemetryGenerator {
	
	private val Resource resource;
	private val IFileSystemAccess2 fsa;
	private val IGeneratorContext context;
	
	new(Resource resource, IFileSystemAccess2 fsa, IGeneratorContext context) {
		this.resource = resource;
		this.fsa = fsa;
		this.context = context;
	}
	
	def build() {
		var f = CommunicationstatusFactory.eINSTANCE;
		//new CommunicationstatusFactoryImpl();
		val classes = new ArrayList<EClass>;
		
		classes.add(f.createPing().eClass);
		classes.add(f.createPong().eClass);
		
		val writer = buildWriter(classes);
		val reader = buildReader(classes);
		
		fsa.generateFile("writer.java", writer);
		fsa.generateFile("reader.java", reader);
	}
	
	def generateCommunications(EClass eclasz) {
		'''
			public void PacketWriter {
				
				public static void write(final Packet packet, final DataOutputStream out) {
					«FOR attr : eclasz.getEAttributes»
					«ENDFOR»
				}
				
			}
			
		'''
				
	}
	
	
	def buildWriter(List<EClass> classes) {
		'''
			public class TelemetryWriter {
			
				private final DataOutputStream out;
			
				public TelemetryWriter(final DataOutputStream out) {
					this.out = out;
				}
			
				«FOR eclasz : classes»
					«writeFunc(eclasz)»
				«ENDFOR»
			}
		'''
	}
	
	def buildReader(List<EClass> classes) {
		'''
			import «es.udima.cesarlaso.tfm.communicationstatus.CommunicationstatusPackage.package.name».*;

			public class TelemetryReader {
			
				private final DataInputStream in;
			
				public TelemetryReader(final DataInputStream in) {
					this.in = in;
				}
			
				Service readFromStream() throws IOException {
					final int serviceType = in.readInt();
					switch (serviceType) {
						«FOR eclasz : classes»
							case «eclasz.classifierID»: 
								«readFuncName(eclasz)»();
								break;
						«ENDFOR»
					}
				}
			
				«FOR eclasz : classes»
					«readFunc(eclasz)»
				«ENDFOR»
			}
		'''
	}
	
	private def writeFuncName(EClass eclasz) {
		'''write«eclasz.name»'''
	}
	
	def writeFunc(EClass eclasz) {
		'''
			«IF !eclasz.isAbstract»
				public
			«ENDIF»
			«IF eclasz.isAbstract»
				private
			«ENDIF»
			
			void «writeFuncName(eclasz)»(final «eclasz.name» value) throws IOException {
				«IF !eclasz.isAbstract»
					out.writeInt(«eclasz.classifierID»);
					«FOR superType : eclasz.getESuperTypes»
						«writeFuncName(superType)»
					«ENDFOR»
					
				«ENDIF»
				«FOR attr : eclasz.getEAttributes»
					«generateWriterType(attr)»
				«ENDFOR»
			}
		'''
	}
	
	def generateWriterType(EAttribute attribute) {
		if (attribute.upperBound != 1) {
			//es un array
			'''
				out.writeInt(«attribute.name».length());
				for («attribute.getEType.name» element : «attribute.name») {
					«writeFuncName(attribute.getEType.eClass)»(element);
				}
			'''
		} else {
			'''out.«simpleTypeWriter(attribute.getEType)»(«attribute.name»);'''
		}
	}
	
	def simpleTypeWriter(EClassifier etype) {
		switch (etype.name) {
			String case "EBoolean": "writeBoolean" 
			String case "EInt": "writeInt" 
			String case "ELong": "writeLong"
			String case "EString": "writeUTF"
			default: throw new Exception("Invalid type")
		}
	}
	
	
	private def readFuncName(EClass eclasz) {
		'''read«eclasz.name»'''
	}
	
	def readFunc(EClass eclasz) {
		'''
			«eclasz.name» «readFuncName(eclasz)»() throws IOException {
				«FOR attr : eclasz.getEAttributes»
					«generateReaderType(attr)»
				«ENDFOR»
				
				«eclasz.name» obj = 
					CommunicationstatusPackage.eINSTANCE.communicationstatusFactory.create«eclasz.name»();
				 
				//CommunicationstatusFactoryImpl.eINSTANCE;
				«FOR attr : eclasz.getEAttributes»
				obj.set«attr»(«attr.name»);
				«ENDFOR»
				/*
				return new «eclasz.name»(
				«FOR attr : eclasz.getEAttributes SEPARATOR ", "»
					«attr.name»
				«ENDFOR»
				);
				*/
			}
		'''
	}
	
	def generateReaderType(EAttribute attribute) {
		if (attribute.upperBound != 1) {
			//es un array
			'''
				final int «attribute.name»_size = in.readInt();
				final List<«attribute.getEType.name»> «attribute.name» = new ArrayList<>(«attribute.name»_size);
				for (int i=0; i<«attribute.name»_size; i++) {
					«readFuncName(attribute.getEType.eClass)»();
				}
			'''
		} else {
			'''
				final «attribute.getEType.name» «attribute.name» = in.«simpleTypeReader(attribute.getEType)»();
			'''
		}
	}
	
	def simpleTypeReader(EClassifier etype) {
		switch (etype.name) {
			String case "EBoolean": "readBoolean" 
			String case "EInt": "readInt" 
			String case "ELong": "readLong"
			String case "EString": "readUTF"
			default: throw new Exception("Invalid type")
		}
	}
	
}
