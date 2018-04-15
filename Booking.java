import java.util.ArrayList;

public class Booking {
	private int usedId, driverId;
	
	public Driver bookRide(int i, double latitude, double longitude, boolean serviceSelected) { 
			return findNearestDriver(latitude, longitude);
	}
	
	public ArrayList<Renter> bookRide(double latitude, double longitude, boolean serviceSelected) { 
		return findNearestRenters(latitude, longitude);
	}
	
	public Driver findNearestDriver(double latitude, double longitude) {
		return Driver.getNearestDriver(latitude, longitude);
	}
	
	public ArrayList<Renter> findNearestRenters(double latitude, double longitude) {
		return Renter.getNearestRenter(latitude, longitude);
	}

	public int getUsedId() {
		return usedId;
	}

	public void setUsedId(int usedId) {
		this.usedId = usedId;
	}

	public int getDriverId() {
		return driverId;
	}

	public void setDriverId(int driverId) {
		this.driverId = driverId;
	}
	
}
