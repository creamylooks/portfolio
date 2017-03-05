package project.derivatives.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity(name="futurestable")
public class Future {
	//One Futures contract must belong to only one user
	//Futures contract must be on an Asset(One to one with asset Must)
	@Id
	@GeneratedValue
	private long Contract_No;
	
	@Column(nullable=false)
	private double Spot_Price;
	@Column(nullable=false)
	@Temporal(TemporalType.DATE)
	private Date Expiry_Date;
	@Column(nullable=false)
	private double Amount_Paid;
	@Column(nullable=false)
	private double Fair_Price;
	@Column(nullable=false)
	private String position;
	
	
	@ManyToOne(cascade=CascadeType.ALL)
	private Asset asset;
	
	
	@ManyToOne(cascade=CascadeType.ALL)
	private User user;
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	
	public Asset getAsset() {
		return asset;
	}
	public void setAsset(Asset asset) {
		this.asset = asset;
	}
	
	public double getSpot_Price() {
		return Spot_Price;
	}
	public void setSpot_Price(double spot_Price) {
		Spot_Price = spot_Price;
	}
	public Date getExpiry_Date() {
		return Expiry_Date;
	}
	public void setExpiry_Date(Date expiry_Date) {
		Expiry_Date = expiry_Date;
	}
	public double getAmount_Paid() {
		return Amount_Paid;
	}
	public void setAmount_Paid(double amount_Paid) {
		Amount_Paid = amount_Paid;
	}
	public double getFair_Price() {
		return Fair_Price;
	}
	public void setFair_Price(double fair_Price) {
		Fair_Price = fair_Price;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public long getContract_No() {
		return Contract_No;
	}
	public void setContract_No(long contract_No) {
		Contract_No = contract_No;
	}
	

}
