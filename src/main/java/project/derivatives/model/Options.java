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

@Entity(name="Optionstable")
public class Options {
	
	//One option contract must belong to only one user
		//Option must be an Asset(One to one with asset must)
		
	
	
	@Id
	@GeneratedValue
	private long Contract_No;
	
	
	private String Option_Type;
	@Column(nullable=false)
	@Temporal(TemporalType.DATE)
	private Date Expiry_date;
	@Column(nullable=false)
	private double Strike_Price;
	@Column(nullable=false)
	private double Stock_Price;
	@Column(nullable=false)
	private double Option_Price;
	@Column(nullable=false)
	private double Amount_Paid;
	
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

	
	public Date getExpiry_date() {
		return Expiry_date;
	}
	public void setExpiry_date(Date expiry_date) {
		Expiry_date = expiry_date;
	}
	public double getStrike_Price() {
		return Strike_Price;
	}
	public void setStrike_Price(double strike_Price) {
		Strike_Price = strike_Price;
	}
	public double getStock_Price() {
		return Stock_Price;
	}
	public void setStock_Price(double stock_Price) {
		Stock_Price = stock_Price;
	}
	public double getOption_Price() {
		return Option_Price;
	}
	public void setOption_Price(double option_Price) {
		Option_Price = option_Price;
	}
	public double getAmount_Paid() {
		return Amount_Paid;
	}
	public void setAmount_Paid(double amount_Paid) {
		Amount_Paid = amount_Paid;
	}
	public long getContract_No() {
		return Contract_No;
	}
	public void setContract_No(long contract_No) {
		Contract_No = contract_No;
	}
	public String getOption_Type() {
		return Option_Type;
	}
	public void setOption_Type(String option_Type) {
		Option_Type = option_Type;
	}
	
	
	
	

}
