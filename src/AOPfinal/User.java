package AOPfinal;
import java.util.Calendar;
import java.util.Date;
import java.util.Enumeration;
import java.util.GregorianCalendar;

public class User {
	private String userName;
	private String password;
	private boolean handicap;
	private boolean colorblind;
	private boolean presbytie;
	private Date date;
	private Calendar calendar;
	public Calendar getCalendar() {
		return calendar;
	}
	public void setCalendar(Calendar calendar) {
		this.calendar = calendar;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		Calendar calendar=new GregorianCalendar();
		calendar.setTime(date);
		setCalendar(calendar);
		this.date = date;
	}
	public static String fileColorblind;
	public static String filePresbytie;

	public boolean isHandicap() {
		return handicap;
	}
	public void setHandicap(boolean handicap) {
		this.handicap = handicap;
	}
	public boolean isColorblind() {
		return colorblind;
	}
	public void setColorblind(boolean colorblind) {
		this.colorblind = colorblind;
		
	}
	public boolean isPresbytie() {
		return presbytie;
	}
	public void setPresbytie(boolean presbytie) {
		this.presbytie = presbytie;
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
