package project.derivatives.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;



@Entity(name="users")

public class User {
	@Id
	@GeneratedValue
	private long userId;
	private String fname;
	private String lname;
	@Column(unique=true)
	private String user;
	private String rdoGender;
	private String email;
	private String mobile;
	private String pass1;
	
	

	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getRdoGender() {
		return rdoGender;
	}
	public void setRdoGender(String rdoGender) {
		this.rdoGender = rdoGender;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	
	public String getPass1() {
		return pass1;
	}
	public void setPass1(String pass1) {
		this.pass1 = pass1;
	}
	

}
