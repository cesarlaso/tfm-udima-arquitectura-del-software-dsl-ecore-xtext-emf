/**
 */
package es.udima.cesarlaso.tfm.healthmonitors.tests;

import es.udima.cesarlaso.tfm.healthmonitors.HealthmonitorsFactory;
import es.udima.cesarlaso.tfm.healthmonitors.NetworkItem;

import junit.textui.TestRunner;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Network Item</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class NetworkItemTest extends HealthMonitorItemTest {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(NetworkItemTest.class);
	}

	/**
	 * Constructs a new Network Item test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NetworkItemTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this Network Item test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected NetworkItem getFixture() {
		return (NetworkItem)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(HealthmonitorsFactory.eINSTANCE.createNetworkItem());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#tearDown()
	 * @generated
	 */
	@Override
	protected void tearDown() throws Exception {
		setFixture(null);
	}

} //NetworkItemTest