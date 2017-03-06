
package project.derivatives.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
@Entity(name="volatility")
public class Volatility {
	
@Id
@GeneratedValue
private long volatility_Id;
@Column(nullable=false)
private String Option_Type;
private double implied_vol;
private double historical_vol;
public long getVolatility_Id() {
	return volatility_Id;
}
public void setVolatility_Id(long volatility_Id) {
	this.volatility_Id = volatility_Id;
}
public String getOption_Type() {
	return Option_Type;
}
public void setOption_Type(String option_Type) {
	Option_Type = option_Type;
}
public double getImplied_vol() {
	return implied_vol;
}
public void setImplied_vol(double implied_vol) {
	this.implied_vol = implied_vol;
}
public double getHistorical_vol() {
	return historical_vol;
}
public void setHistorical_vol(double historical_vol) {
	this.historical_vol = historical_vol;
}

		@ManyToOne(cascade=CascadeType.ALL)
		private User user;

		@ManyToOne(cascade=CascadeType.ALL)
		private Asset asset;
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
}
