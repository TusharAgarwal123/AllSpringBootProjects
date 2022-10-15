package Inheritance;

public class VehicleUse {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Car c = new Car(5, false);
		System.out.println(c.color + " " + c.nGears + " " + c.isConvertible);
		System.out.println(c.getMaxSpeed());

	}

}
