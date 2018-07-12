package kafka;

public class OverSpeedCar {

	private String licencePlate;

	private double speed;

	public OverSpeedCar() {
		// TODO Auto-generated constructor stub
	}

	public int getFees() {
		int fees = 25;

		if (speed > 90)
			fees = 125;
		else if (speed > 82)
			fees = 80;
		else if (speed > 77)
			fees = 45;

		return fees;
	}

	public OverSpeedCar(String licencePlate, double speed) {
		super();
		this.licencePlate = licencePlate;
		this.speed = speed;
	}

	public String getLicencePlate() {
		return licencePlate;
	}

	public void setLicencePlate(String licencePlate) {
		this.licencePlate = licencePlate;
	}

	public double getSpeed() {
		return speed;
	}

	public void setSpeed(double speed) {
		this.speed = speed;
	}

	@Override
	public String toString() {
		return "OverSpeedCar [licencePlate=" + licencePlate + ", speed=" + speed + " your fee amount is " + getFees()
				+ "]";
	}

}
