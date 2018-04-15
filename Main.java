import java.util.*;
import java.util.concurrent.TimeUnit;


public class Main {
	
	public static void main(String[] args) throws InterruptedException {
		String username = null;
		Scanner sc = new Scanner(System.in);
		boolean b = false;
		Passenger.addData();
		Driver.addData();
		Renter.addData();
		while (!b) {
			System.out.println("Welcome! Please select from the following options.");
			System.out.println();
			System.out.println("1) Create Account");
			System.out.println("2) Login");
			System.out.println("Enter the desired choice.");
			int n = sc.nextInt();
			switch (n) {
			case 1:
				System.out.println("Enter Name: ");
				sc.nextLine();
				String name = sc.nextLine();
				System.out.println("Enter Email Id: ");
				String email = sc.nextLine();
				System.out.println("Enter desired Username:");
				username = sc.nextLine();
				System.out.println("Enter desired password:");
				String password = sc.nextLine();
				System.out.println("Confirm Password: ");
				String confirm = sc.nextLine();
				if(password.equals(confirm)) {
					b = true;
					Passenger p = new Passenger(name, username, email, password);
					DataBase d = new DataBase();
					d.passengers.add(p);
					d.dataStored.put(username,password);
					System.out.println("Value successfully added to database");
				}
				else {
					System.out.println("Passwords do not match.");
				}
				break;
			case 2:
				System.out.println("Enter Username:");
				sc.nextLine();
				username = sc.nextLine();
				System.out.println("Enter password:");
				password = sc.nextLine();
				Login l = new Login(username, password);
				b = l.authenticate(); 
				if (!b) {
					System.out.println("Sorry wrong username or password.");
					System.out.println("Forgot Password? [y/n]");
					String ans = sc.nextLine();
					if(ans.charAt(0)=='y') {
						System.out.println("A link has been sent to your registered Email Id; "
								+ "Use the link to change your password");
						System.out.println("-----------------------------------------------------------------");
					}
					else {
						
					}
				}
				break;
			}
		}
		
		System.out.println("Welcome " + username);
		System.out.println("Fetching Location...");
		TimeUnit.SECONDS.sleep(1);
		Location l = new Location();
		String loc[] = l.getLocation().split(",");
		double latitude = Double.parseDouble(loc[0]);
		double longitude = Double.parseDouble(loc[1]);
		System.out.println("Your location is : "+ l.getLocation());			
		System.out.println("-----------------------------------------------------------------");
		System.out.println();			
		Passenger p = new Passenger();
		TimeUnit.SECONDS.sleep(1);
		//break;
		loop1 : while (true) {
			System.out.println("Welcome!");
			System.out.println("Please select from the following options.");
			System.out.println();
			System.out.println("1) Book a ride");
			System.out.println("2) Rent a car");
			System.out.println("3) Payment");
			System.out.println("4) Logout");
			int n = sc.nextInt();
			System.out.println();
			TimeUnit.SECONDS.sleep(1);
			switch (n) {
				case 1:
					Booking book = new Booking();
					Driver assignedDriver = book.bookRide(1, latitude, longitude, true);
					System.out.println("Fetching nearby driver...");
					TimeUnit.SECONDS.sleep(2);
					System.out.println("Your assigned Driver is "+assignedDriver.getDriverName() + " with an "
							+"average rating of " + assignedDriver.getAverageRating());
					TimeUnit.MILLISECONDS.sleep(200);
					boolean boo = p.act(assignedDriver);
					if(boo) {
						System.out.println("Driver "+ assignedDriver.getDriverName() +" is confirmed.");
						System.out.println("Enjoy your ride!");
						break loop1;
					}
					else {
						System.out.println("Request Declined. Sorry for the inconvience caused.");
						System.out.println("Redirecting back to the main page...");
						System.out.println("-------------------------------------------------");
						System.out.println();
						TimeUnit.SECONDS.sleep(2);
						continue loop1;
					}
				case 2:
					Booking book1 = new Booking();
					ArrayList<Renter> r = book1.bookRide(latitude, longitude, false);
					System.out.println("Fetching nearby renters...");
					TimeUnit.SECONDS.sleep(2);
					System.out.println();
					System.out.println("Following are the nearby renters-");
					System.out.println();
					for(int i = 0; i<3; i++){
						System.out.println("Details of Renter " + (i+1) + " are as follow:");
						System.out.println("---------------------------------------------");
						System.out.println("Renter ID : " + r.get(i).getRenterId());
						System.out.println("Renter Name : "+ r.get(i).getRenterName());
						System.out.println("Renter Average Rating : " + r.get(i).getAverageRating());
						System.out.println("Renter's Car : "+r.get(i).getCarName());
						System.out.println("Daily Charge : "+ r.get(i).getChargePerDay());
						System.out.println();
					}
					System.out.println("Please enter Renter number to confirm the booking of the car. Else print \"0\" to exit");
					int z = sc.nextInt();
					if(z==0) {
						System.out.println("Redirecting back to the main page...");
						System.out.println();
						System.out.println("-------------------------------------------------");
						TimeUnit.SECONDS.sleep(2);
						continue loop1;
					}
					else {
						System.out.println("Renter " + r.get(z-1).getRenterName() +" is confirmed. You will shortly get "
								+ "a text message from where to collect your car." );
						System.out.println();
						System.out.println("Enjoy your trip!");
						break loop1;
					}
				case 3:
					System.out.println("Driver is ending the ride...");
					TimeUnit.SECONDS.sleep(1);
					System.out.println("Ride ended.");
					System.out.println("Calculating Fare ...");
					TimeUnit.SECONDS.sleep(2);
					Payment pay = new Payment();
					double amount = pay.getAmount();
					System.out.println("Your total amount is " + amount);
					System.out.println();
					TimeUnit.MILLISECONDS.sleep(200);
					System.out.println("Do you have any coupons for discount? [y/n]");
					sc.nextLine();
					String s = sc.nextLine();
					if(s.charAt(0)=='y') {
						System.out.println("Enter coupon code-");
						String s1 = sc.nextLine();
						System.out.println();
						System.out.println("Authenticating...");
						TimeUnit.MILLISECONDS.sleep(2000);
						System.out.println();
						System.out.println("Calculating amount after applying discount...");
						TimeUnit.MILLISECONDS.sleep(2000);
						System.out.println("Your amount is "+ 
								Discount.applyDiscount(amount));
					}
					System.out.println();
					TimeUnit.MILLISECONDS.sleep(300);
					System.out.println("Choose payment method:");
					System.out.println("1) Cash");
					System.out.println("2) Paytm");
					System.out.println("3) Net Banking");
					int c = sc.nextInt();
					System.out.println("Payment mode selected. Initiating Payment...");
					TimeUnit.MILLISECONDS.sleep(800);
					System.out.println();
					System.out.println("Payment process completed.");
					TimeUnit.MILLISECONDS.sleep(200);
					System.out.println();
					System.out.println("Please rate the Driver on a scale of 1 to 5.");
					double rating  = sc.nextDouble();
					System.out.println("Thank you for your feedback.");
					System.out.println();
					System.exit(0);
				case 4:
					System.out.println("Logging out...");
					TimeUnit.SECONDS.sleep(1);
					System.out.println("Logged out");
					break loop1;
			}
			System.out.println("-----------------------------------------------------------------");
		}
	}
}
