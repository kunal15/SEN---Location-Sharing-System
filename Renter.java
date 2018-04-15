import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;

public class Renter extends RegisteredUser{
	private int renterId;
	private double averageRating;
	private String renterName;
	private String carType;
	private double chargePerDay;
	
	Renter (int id, String name, double rating, String name1, double charge){
		renterId = id;
		renterName = name;
		averageRating = rating;
		carType= name1;
		chargePerDay = charge;
	}
	
	public int getRenterId() {
		return renterId;
	}

	public void setRenterId(int renterId) {
		this.renterId = renterId;
	}

	public double getAverageRating() {
		return averageRating;
	}

	public void setAverageRating(double averageRating) {
		this.averageRating = averageRating;
	}

	public String getRenterName() {
		return renterName;
	}

	public void setRenterName(String renterName) {
		this.renterName = renterName;
	}

	public String getCarName() {
		return carType;
	}

	public void setCarName(String carName) {
		this.carType = carName;
	}

	public double getChargePerDay() {
		return chargePerDay;
	}

	public void setChargePerDay(double chargePerDay) {
		this.chargePerDay = chargePerDay;
	}
	
	public static ArrayList<Renter> getNearestRenter(double latitude, double longitude) {
		DataBase d = new DataBase();
		ArrayList<Renter> r = new ArrayList<Renter>();
		HashSet<Integer> hs = new HashSet<>();
		while(r.size()<3) {
			int x = (int)(new Random().nextInt(d.renters.size()));
			Renter temp = d.renters.get(x);
			if(hs.contains(temp.renterId)) continue;
			else r.add(temp);
			hs.add(temp.renterId);
		}
		return r;
	}
	
	public String getCarType() {
		return carType;
	}

	public void setCarType(String carType) {
		this.carType = carType;
	}

	public static void addData() {
		DataBase.renters.add(new Renter(12,"Parv", 3.8, "WagonR", 300.00));
		DataBase.renters.add(new Renter(2,"Kunal", 4.5, "Indica", 500.00));
		DataBase.renters.add(new Renter(1,"Shubham", 3.9, "Vento", 800.00));
		DataBase.renters.add(new Renter(3,"Mayank", 3.6, "Maruti", 200.00));
		DataBase.renters.add(new Renter(5,"Nahar", 4.3, "Indica", 400.00));
		DataBase.renters.add(new Renter(7,"Jay", 3.2, "Audi A4", 2000.00));
	}
}
