package kafka;

public class OverSpeedCar {
	
	private String licencePlate;
	
	private double speed;
	
	public OverSpeedCar() {
		// TODO Auto-generated constructor stub
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
	

}
