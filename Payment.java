import java.util.Random;

public class Payment {
	double amount;
	int paymentId;
	String method;
	
	public double getAmount() {
		return amount = 300 + new Random().nextInt(200);
	}
	
	public void setAmount(double amount) {
		this.amount = amount;
	}
	
	public int getPaymentId() {
		return paymentId;
	}
	
	public void setPaymentId(int paymentId) {
		this.paymentId = paymentId;
	}
	
	public String getMethod() {
		return method;
	}
	
	public void setMethod(String method) {
		this.method = method;
	}
	
	
}
