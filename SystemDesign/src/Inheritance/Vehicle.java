package Inheritance;

public class Vehicle {

	protected String color;
	private int maxSpeed;
	int noOfHeadLights; // default access modifier.

	public Vehicle() {

		this.maxSpeed = 100;
		this.color = "Blue";

	}

	public int getMaxSpeed() {
		return maxSpeed;
	}

	public void setMaxSpeed(int maxSpeed) {
		this.maxSpeed = maxSpeed;
	}

}
