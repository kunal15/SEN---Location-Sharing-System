import java.util.Random;

public class Location{
	private float longitude;
	private float latitude;

	Location(){
		longitude = new Random().nextInt(360);
		latitude = new Random().nextInt(180);
	}
	public String getLocation() {
		return this.sendLocation();
	}
	public String sendLocation(){
		String location = (""+latitude + "," + longitude);
		return location;
	}
	public float getLongitude() {
		return longitude;
	}
	public void setLongitude(float longitude) {
		this.longitude = longitude;
	}
	public float getLatitude() {
		return latitude;
	}
	public void setLatitude(float latitude) {
		this.latitude = latitude;
	}
}