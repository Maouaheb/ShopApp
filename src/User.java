import java.util.Enumeration;

public class User {
	private String userName;
	private String password;
	public static enum handicap{colorblind,myopic,normal}
	private handicap disability;
	public handicap getDisability() {
		return disability;
	}
	public void setDisability(handicap disability) {
		this.disability = disability;
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
	};
	

}
