package Inheritance;

public class Car extends Vehicle {

	int nGears;
	boolean isConvertible;

	public Car(int nGears, boolean isConvertible) {
		this.nGears = nGears;
		this.isConvertible = isConvertible;

	}

	public boolean isConvertible() {
		return this.isConvertible;
	}

}
