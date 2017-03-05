package project.derivatives.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity(name="asset")
public class Asset {
	
	//Many to many with User table (Asset must be owned by a user (or not if you want to have a list of assets they can choose from))
	//Asset may be future(May)
	//Asset may be Option(May)
	@Id
	@GeneratedValue
	private long Asset_Id;
	@Column(unique=true, nullable=false)
	private String Asset_Name;
	private double Current_Price;
	@Temporal(TemporalType.DATE)
	private Date Last_CurPrice_Update;
	
	
	@OneToMany(cascade= CascadeType.ALL, mappedBy="asset")
	private Set<Future> futures = new HashSet<Future>(0);
	
	@OneToMany(cascade= CascadeType.ALL, mappedBy="asset")
	private Set<Options> option = new HashSet<Options>(0);
	
	
	public Set<Options> getOption() {
		return option;
	}
	public void setOption(Set<Options> option) {
		this.option = option;
	}
	//Setters and getters
	public Date getLast_CurPrice_Update() {
		return Last_CurPrice_Update;
	}
	public void setLast_CurPrice_Update(Date last_CurPrice_Update) {
		Last_CurPrice_Update = last_CurPrice_Update;
	}
	
	public Set<Future> getFutures() {
		return futures;
	}
	public void setFutures(Set<Future> futures) {
		this.futures = futures;
	}
	public long getAsset_Id() {
		return Asset_Id;
	}
	public void setAsset_Id(long asset_Id) {
		Asset_Id = asset_Id;
	}
	public String getAsset_Name() {
		return Asset_Name;
	}
	public void setAsset_Name(String asset_Name) {
		Asset_Name = asset_Name;
	}
	public double getCurrent_Price() {
		return Current_Price;
	}
	public void setCurrent_Price(double current_Price) {
		Current_Price = current_Price;
	}
	
}
