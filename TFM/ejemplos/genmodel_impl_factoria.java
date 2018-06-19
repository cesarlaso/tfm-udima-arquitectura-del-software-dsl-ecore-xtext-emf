public class GpiosFactoryImpl extends EFactoryImpl implements GpiosFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static GpiosFactory init() {
		try {
			GpiosFactory theGpiosFactory = (GpiosFactory)EPackage.Registry.INSTANCE.getEFactory(GpiosPackage.eNS_URI);
			if (theGpiosFactory != null) {
				return theGpiosFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new GpiosFactoryImpl();
	}
