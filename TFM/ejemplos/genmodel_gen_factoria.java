public interface GpiosFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	GpiosFactory eINSTANCE = es.udima.cesarlaso.tfm.gpios.impl.GpiosFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Digital Input Pin</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Digital Input Pin</em>'.
	 * @generated
	 */
	DigitalInputPin createDigitalInputPin();