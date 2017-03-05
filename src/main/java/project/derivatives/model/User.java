package project.derivatives.model;


import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;



@Entity(name="users")

public class User {
	@Id
	@GeneratedValue
	private long userId;
	@Column(nullable=false)
	private String fname;
	@Column(nullable=false)
	private String lname;
	@Column(unique=true, nullable=false)
	private String user;
	@Column(nullable=false)
	private String rdoGender;
	@Column(nullable=false)
	private String email;
	private String mobile;
	@Column(nullable=false)
	private String pass1;
	
	@OneToMany(cascade= CascadeType.ALL, mappedBy="user")
	private Set<Options> option = new HashSet<Options>(0);
	@OneToMany(cascade= CascadeType.ALL, mappedBy="user")
	private Set<Future> futures = new HashSet<Future>(0);
	@ManyToMany(cascade=CascadeType.ALL)
	private Set<Asset> assets = new HashSet<Asset>(0);
	

	public Set<Asset> getAssets() {
		return assets;
	}
	public void setAssets(Set<Asset> assets) {
		this.assets = assets;
	}
	public Set<Future> getFutures() {
		return futures;
	}
	public void setFutures(Set<Future> futures) {
		this.futures = futures;
	}
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	public Set<Options> getOption() {
		return option;
	}
	public void setOption(Set<Options> option) {
		this.option = option;
	}
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
