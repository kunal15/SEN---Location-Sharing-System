
public class Login {
	private String userName, password;
	
	Login(String u, String v){
		userName = u;
		password = v;
	}
	
	public boolean authenticate() {
		DataBase d = new DataBase();
		if(d.dataStored.containsKey(this.userName)) {
			if(d.dataStored.get(userName).equals(this.password)) {
				return true;
			}
		}
		return false;
	}
	
	public void changePassword(String p) {
		
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
