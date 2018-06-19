/**
 */
package es.udima.cesarlaso.tfm.gpios;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Interrupt Mode</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * <!-- begin-model-doc -->
 * Modo de interrupción
 * <!-- end-model-doc -->
 * @see es.udima.cesarlaso.tfm.gpios.GpiosPackage#getInterruptMode()
 * @model
 * @generated
 */
public enum InterruptMode implements Enumerator {
	/**
	 * The '<em><b>Rising</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #RISING_VALUE
	 * @generated
	 * @ordered
	 */
	RISING(1, "Rising", "Rising"),

	/**
	 * The '<em><b>Falling</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #FALLING_VALUE
	 * @generated
	 * @ordered
	 */
	FALLING(2, "Falling", "Falling"),

	/**
	 * The '<em><b>Changes</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CHANGES_VALUE
	 * @generated
	 * @ordered
	 */
	CHANGES(3, "Changes", "Changes"),

	/**
	 * The '<em><b>Low</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #LOW_VALUE
	 * @generated
	 * @ordered
	 */
	LOW(4, "Low", "Low"),

	/**
	 * The '<em><b>High</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #HIGH_VALUE
	 * @generated
	 * @ordered
	 */
	HIGH(5, "High", "High");

	/**
	 * The '<em><b>Rising</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * La interrupción se activa cuando el estado pasa de bajo a alto
	 * <!-- end-model-doc -->
	 * @see #RISING
	 * @model name="Rising"
	 * @generated
	 * @ordered
	 */
	public static final int RISING_VALUE = 1;

	/**
	 * The '<em><b>Falling</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * La interrupción se activa cuando el estado pasa de alto a bajo
	 * <!-- end-model-doc -->
	 * @see #FALLING
	 * @model name="Falling"
	 * @generated
	 * @ordered
	 */
	public static final int FALLING_VALUE = 2;

	/**
	 * The '<em><b>Changes</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * La interrupción se activa cuando cambia de estado
	 * <!-- end-model-doc -->
	 * @see #CHANGES
	 * @model name="Changes"
	 * @generated
	 * @ordered
	 */
	public static final int CHANGES_VALUE = 3;

	/**
	 * The '<em><b>Low</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * La interrupción se activa de forma continua mientras el estado sea bajo
	 * <!-- end-model-doc -->
	 * @see #LOW
	 * @model name="Low"
	 * @generated
	 * @ordered
	 */
	public static final int LOW_VALUE = 4;

	/**
	 * The '<em><b>High</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * La interrupción se activa de forma continua mientras el estado sea alto
	 * <!-- end-model-doc -->
	 * @see #HIGH
	 * @model name="High"
	 * @generated
	 * @ordered
	 */
	public static final int HIGH_VALUE = 5;

	/**
	 * An array of all the '<em><b>Interrupt Mode</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final InterruptMode[] VALUES_ARRAY =
		new InterruptMode[] {
			RISING,
			FALLING,
			CHANGES,
			LOW,
			HIGH,
		};

	/**
	 * A public read-only list of all the '<em><b>Interrupt Mode</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<InterruptMode> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Interrupt Mode</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param literal the literal.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static InterruptMode get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			InterruptMode result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Interrupt Mode</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param name the name.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static InterruptMode getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			InterruptMode result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Interrupt Mode</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the integer value.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static InterruptMode get(int value) {
		switch (value) {
			case RISING_VALUE: return RISING;
			case FALLING_VALUE: return FALLING;
			case CHANGES_VALUE: return CHANGES;
			case LOW_VALUE: return LOW;
			case HIGH_VALUE: return HIGH;
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final int value;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final String name;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final String literal;

	/**
	 * Only this class can construct instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private InterruptMode(int value, String name, String literal) {
		this.value = value;
		this.name = name;
		this.literal = literal;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getValue() {
	  return value;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
	  return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getLiteral() {
	  return literal;
	}

	/**
	 * Returns the literal value of the enumerator, which is its string representation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		return literal;
	}
	
} //InterruptMode
