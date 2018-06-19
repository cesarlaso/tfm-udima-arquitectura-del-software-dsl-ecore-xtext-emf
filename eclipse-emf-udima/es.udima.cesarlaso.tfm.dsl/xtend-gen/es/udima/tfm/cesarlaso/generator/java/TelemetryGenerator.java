package es.udima.tfm.cesarlaso.generator.java;

import com.google.common.base.Objects;
import es.udima.cesarlaso.tfm.communicationstatus.CommunicationstatusFactory;
import es.udima.cesarlaso.tfm.communicationstatus.CommunicationstatusPackage;
import java.util.ArrayList;
import java.util.List;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.generator.IFileSystemAccess2;
import org.eclipse.xtext.generator.IGeneratorContext;
import org.eclipse.xtext.xbase.lib.Exceptions;

@SuppressWarnings("all")
public class TelemetryGenerator {
  private final Resource resource;
  
  private final IFileSystemAccess2 fsa;
  
  private final IGeneratorContext context;
  
  public TelemetryGenerator(final Resource resource, final IFileSystemAccess2 fsa, final IGeneratorContext context) {
    this.resource = resource;
    this.fsa = fsa;
    this.context = context;
  }
  
  public void build() {
    CommunicationstatusFactory f = CommunicationstatusFactory.eINSTANCE;
    final ArrayList<EClass> classes = new ArrayList<EClass>();
    classes.add(f.createPing().eClass());
    classes.add(f.createPong().eClass());
    final CharSequence writer = this.buildWriter(classes);
    final CharSequence reader = this.buildReader(classes);
    this.fsa.generateFile("writer.java", writer);
    this.fsa.generateFile("reader.java", reader);
  }
  
  public CharSequence generateCommunications(final EClass eclasz) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("public void PacketWriter {");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public static void write(final Packet packet, final DataOutputStream out) {");
    _builder.newLine();
    {
      EList<EAttribute> _eAttributes = eclasz.getEAttributes();
      for(final EAttribute attr : _eAttributes) {
      }
    }
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence buildWriter(final List<EClass> classes) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("public class TelemetryWriter {");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("private final DataOutputStream out;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public TelemetryWriter(final DataOutputStream out) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("this.out = out;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    {
      for(final EClass eclasz : classes) {
        _builder.append("\t");
        CharSequence _writeFunc = this.writeFunc(eclasz);
        _builder.append(_writeFunc, "\t");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence buildReader(final List<EClass> classes) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("import ");
    String _name = CommunicationstatusPackage.class.getPackage().getName();
    _builder.append(_name);
    _builder.append(".*;");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("public class TelemetryReader {");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("private final DataInputStream in;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public TelemetryReader(final DataInputStream in) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("this.in = in;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("Service readFromStream() throws IOException {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("final int serviceType = in.readInt();");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("switch (serviceType) {");
    _builder.newLine();
    {
      for(final EClass eclasz : classes) {
        _builder.append("\t\t\t");
        _builder.append("case ");
        int _classifierID = eclasz.getClassifierID();
        _builder.append(_classifierID, "\t\t\t");
        _builder.append(": ");
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t\t");
        _builder.append("\t");
        CharSequence _readFuncName = this.readFuncName(eclasz);
        _builder.append(_readFuncName, "\t\t\t\t");
        _builder.append("();");
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t\t");
        _builder.append("\t");
        _builder.append("break;");
        _builder.newLine();
      }
    }
    _builder.append("\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    {
      for(final EClass eclasz_1 : classes) {
        _builder.append("\t");
        CharSequence _readFunc = this.readFunc(eclasz_1);
        _builder.append(_readFunc, "\t");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
  
  private CharSequence writeFuncName(final EClass eclasz) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("write");
    String _name = eclasz.getName();
    _builder.append(_name);
    return _builder;
  }
  
  public CharSequence writeFunc(final EClass eclasz) {
    StringConcatenation _builder = new StringConcatenation();
    {
      boolean _isAbstract = eclasz.isAbstract();
      boolean _not = (!_isAbstract);
      if (_not) {
        _builder.append("public");
        _builder.newLine();
      }
    }
    {
      boolean _isAbstract_1 = eclasz.isAbstract();
      if (_isAbstract_1) {
        _builder.append("private");
        _builder.newLine();
      }
    }
    _builder.newLine();
    _builder.append("void ");
    CharSequence _writeFuncName = this.writeFuncName(eclasz);
    _builder.append(_writeFuncName);
    _builder.append("(final ");
    String _name = eclasz.getName();
    _builder.append(_name);
    _builder.append(" value) throws IOException {");
    _builder.newLineIfNotEmpty();
    {
      boolean _isAbstract_2 = eclasz.isAbstract();
      boolean _not_1 = (!_isAbstract_2);
      if (_not_1) {
        _builder.append("\t");
        _builder.append("out.writeInt(");
        int _classifierID = eclasz.getClassifierID();
        _builder.append(_classifierID, "\t");
        _builder.append(");");
        _builder.newLineIfNotEmpty();
        {
          EList<EClass> _eSuperTypes = eclasz.getESuperTypes();
          for(final EClass superType : _eSuperTypes) {
            _builder.append("\t");
            CharSequence _writeFuncName_1 = this.writeFuncName(superType);
            _builder.append(_writeFuncName_1, "\t");
            _builder.newLineIfNotEmpty();
          }
        }
        _builder.append("\t");
        _builder.newLine();
      }
    }
    {
      EList<EAttribute> _eAttributes = eclasz.getEAttributes();
      for(final EAttribute attr : _eAttributes) {
        _builder.append("\t");
        CharSequence _generateWriterType = this.generateWriterType(attr);
        _builder.append(_generateWriterType, "\t");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence generateWriterType(final EAttribute attribute) {
    CharSequence _xifexpression = null;
    int _upperBound = attribute.getUpperBound();
    boolean _notEquals = (_upperBound != 1);
    if (_notEquals) {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("out.writeInt(");
      String _name = attribute.getName();
      _builder.append(_name);
      _builder.append(".length());");
      _builder.newLineIfNotEmpty();
      _builder.append("for (");
      String _name_1 = attribute.getEType().getName();
      _builder.append(_name_1);
      _builder.append(" element : ");
      String _name_2 = attribute.getName();
      _builder.append(_name_2);
      _builder.append(") {");
      _builder.newLineIfNotEmpty();
      _builder.append("\t");
      CharSequence _writeFuncName = this.writeFuncName(attribute.getEType().eClass());
      _builder.append(_writeFuncName, "\t");
      _builder.append("(element);");
      _builder.newLineIfNotEmpty();
      _builder.append("}");
      _builder.newLine();
      _xifexpression = _builder;
    } else {
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("out.");
      String _simpleTypeWriter = this.simpleTypeWriter(attribute.getEType());
      _builder_1.append(_simpleTypeWriter);
      _builder_1.append("(");
      String _name_3 = attribute.getName();
      _builder_1.append(_name_3);
      _builder_1.append(");");
      _xifexpression = _builder_1;
    }
    return _xifexpression;
  }
  
  public String simpleTypeWriter(final EClassifier etype) {
    try {
      String _switchResult = null;
      String _name = etype.getName();
      boolean _matched = false;
      if (_name instanceof String) {
        if (Objects.equal(_name, "EBoolean")) {
          _matched=true;
          _switchResult = "writeBoolean";
        }
      }
      if (!_matched) {
        if (_name instanceof String) {
          if (Objects.equal(_name, "EInt")) {
            _matched=true;
            _switchResult = "writeInt";
          }
        }
      }
      if (!_matched) {
        if (_name instanceof String) {
          if (Objects.equal(_name, "ELong")) {
            _matched=true;
            _switchResult = "writeLong";
          }
        }
      }
      if (!_matched) {
        if (_name instanceof String) {
          if (Objects.equal(_name, "EString")) {
            _matched=true;
            _switchResult = "writeUTF";
          }
        }
      }
      if (!_matched) {
        throw new Exception("Invalid type");
      }
      return _switchResult;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  private CharSequence readFuncName(final EClass eclasz) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("read");
    String _name = eclasz.getName();
    _builder.append(_name);
    return _builder;
  }
  
  public CharSequence readFunc(final EClass eclasz) {
    StringConcatenation _builder = new StringConcatenation();
    String _name = eclasz.getName();
    _builder.append(_name);
    _builder.append(" ");
    CharSequence _readFuncName = this.readFuncName(eclasz);
    _builder.append(_readFuncName);
    _builder.append("() throws IOException {");
    _builder.newLineIfNotEmpty();
    {
      EList<EAttribute> _eAttributes = eclasz.getEAttributes();
      for(final EAttribute attr : _eAttributes) {
        _builder.append("\t");
        CharSequence _generateReaderType = this.generateReaderType(attr);
        _builder.append(_generateReaderType, "\t");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    String _name_1 = eclasz.getName();
    _builder.append(_name_1, "\t");
    _builder.append(" obj = ");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.append("CommunicationstatusPackage.eINSTANCE.communicationstatusFactory.create");
    String _name_2 = eclasz.getName();
    _builder.append(_name_2, "\t\t");
    _builder.append("();");
    _builder.newLineIfNotEmpty();
    _builder.append("\t ");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("//CommunicationstatusFactoryImpl.eINSTANCE;");
    _builder.newLine();
    {
      EList<EAttribute> _eAttributes_1 = eclasz.getEAttributes();
      for(final EAttribute attr_1 : _eAttributes_1) {
        _builder.append("\t");
        _builder.append("obj.set");
        _builder.append(attr_1, "\t");
        _builder.append("(");
        String _name_3 = attr_1.getName();
        _builder.append(_name_3, "\t");
        _builder.append(");");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("\t");
    _builder.append("/*");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("return new ");
    String _name_4 = eclasz.getName();
    _builder.append(_name_4, "\t");
    _builder.append("(");
    _builder.newLineIfNotEmpty();
    {
      EList<EAttribute> _eAttributes_2 = eclasz.getEAttributes();
      boolean _hasElements = false;
      for(final EAttribute attr_2 : _eAttributes_2) {
        if (!_hasElements) {
          _hasElements = true;
        } else {
          _builder.appendImmediate(", ", "\t");
        }
        _builder.append("\t");
        String _name_5 = attr_2.getName();
        _builder.append(_name_5, "\t");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("\t");
    _builder.append(");");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("*/");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence generateReaderType(final EAttribute attribute) {
    CharSequence _xifexpression = null;
    int _upperBound = attribute.getUpperBound();
    boolean _notEquals = (_upperBound != 1);
    if (_notEquals) {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("final int ");
      String _name = attribute.getName();
      _builder.append(_name);
      _builder.append("_size = in.readInt();");
      _builder.newLineIfNotEmpty();
      _builder.append("final List<");
      String _name_1 = attribute.getEType().getName();
      _builder.append(_name_1);
      _builder.append("> ");
      String _name_2 = attribute.getName();
      _builder.append(_name_2);
      _builder.append(" = new ArrayList<>(");
      String _name_3 = attribute.getName();
      _builder.append(_name_3);
      _builder.append("_size);");
      _builder.newLineIfNotEmpty();
      _builder.append("for (int i=0; i<");
      String _name_4 = attribute.getName();
      _builder.append(_name_4);
      _builder.append("_size; i++) {");
      _builder.newLineIfNotEmpty();
      _builder.append("\t");
      CharSequence _readFuncName = this.readFuncName(attribute.getEType().eClass());
      _builder.append(_readFuncName, "\t");
      _builder.append("();");
      _builder.newLineIfNotEmpty();
      _builder.append("}");
      _builder.newLine();
      _xifexpression = _builder;
    } else {
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("final ");
      String _name_5 = attribute.getEType().getName();
      _builder_1.append(_name_5);
      _builder_1.append(" ");
      String _name_6 = attribute.getName();
      _builder_1.append(_name_6);
      _builder_1.append(" = in.");
      String _simpleTypeReader = this.simpleTypeReader(attribute.getEType());
      _builder_1.append(_simpleTypeReader);
      _builder_1.append("();");
      _builder_1.newLineIfNotEmpty();
      _xifexpression = _builder_1;
    }
    return _xifexpression;
  }
  
  public String simpleTypeReader(final EClassifier etype) {
    try {
      String _switchResult = null;
      String _name = etype.getName();
      boolean _matched = false;
      if (_name instanceof String) {
        if (Objects.equal(_name, "EBoolean")) {
          _matched=true;
          _switchResult = "readBoolean";
        }
      }
      if (!_matched) {
        if (_name instanceof String) {
          if (Objects.equal(_name, "EInt")) {
            _matched=true;
            _switchResult = "readInt";
          }
        }
      }
      if (!_matched) {
        if (_name instanceof String) {
          if (Objects.equal(_name, "ELong")) {
            _matched=true;
            _switchResult = "readLong";
          }
        }
      }
      if (!_matched) {
        if (_name instanceof String) {
          if (Objects.equal(_name, "EString")) {
            _matched=true;
            _switchResult = "readUTF";
          }
        }
      }
      if (!_matched) {
        throw new Exception("Invalid type");
      }
      return _switchResult;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
