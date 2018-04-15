import java.util.Random;

public class Driver extends RegisteredUser {
	private int driverId;
	private double averageRating;
	private String driverName;
	
	Driver(int id, String name, double rating){
		driverId = id;
		driverName = name;
		averageRating = rating;
	}

	public int getDriverId() {
		return driverId;
	}

	public void setDriverId(int driverId) {
		this.driverId = driverId;
	}

	public double getAverageRating() {
		return averageRating;
	}

	public void setAverageRating(double averageRating) {
		this.averageRating = averageRating;
	}

	public String getDriverName() {
		return driverName;
	}

	public void setDriverName(String driverName) {
		this.driverName = driverName;
	}

	public static Driver getNearestDriver(double latitude, double longitude) {
		DataBase d = new DataBase();
		return d.drivers.get((int)(new Random().nextInt(d.drivers.size())));
	}
	public static void addData() {
		DataBase.drivers.add(new Driver(12,"Parv", 3.8));
		DataBase.drivers.add(new Driver(2,"askl", 4.5));
		DataBase.drivers.add(new Driver(1,"Pava", 3.9));
	}
}
