import java.util.Random;
import java.util.Scanner;

public class Passenger extends User{
	private String name, userName, email, password;
	private double averageRating;
	Scanner sc = new Scanner(System.in);
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public double getAverageRating() {
		return averageRating;
	}

	public void setAverageRating(double averageRating) {
		this.averageRating = averageRating;
	}

	public Passenger(String a, String b, String c, String d) {
		name = a;
		userName = b;
		email = c;
		password = d;
	}
	public Passenger() {
		
	}
	public static void addData() {
		DataBase d = new DataBase();
		d.passengers.add(new Passenger("Kunal","kunalk","abc", "123"));
		d.passengers.add(new Passenger("Parv","parvc","abc", "123"));
		d.dataStored.put("kunalk", "123");
		d.dataStored.put("parvc", "123");
	}
	public boolean act(Driver d) {
		System.out.println("Are you satisfied with the assigned driver? [y/n]");
		String s = sc.nextLine();
		if(s.charAt(0)=='y') {
			return true;
		}
		else return false;
	}
}
