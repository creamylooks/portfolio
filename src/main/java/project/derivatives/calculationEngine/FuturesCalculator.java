package project.derivatives.calculationEngine;

import java.util.ArrayList;

public class FuturesCalculator extends Calculator {
	private double spotPrice;
	private double income;
	private double incomeRate;
	private double daysToIncPayment;
	private double yield;
	private boolean isIncome;
	private boolean isYeild;
	
	
	public FuturesCalculator(double intrate, double maturity,DayCountConv day, double spotP,boolean isInc, boolean isYld) {
		super(intrate, maturity, day);
		// TODO Auto-generated constructor stub
		this.spotPrice=spotP;
		this.isIncome=isInc;
		this.isYeild=isYld;
	}
	public FuturesCalculator(double intrate, double maturity,DayCountConv day, double spotP,boolean isInc, 
			                  boolean isYld, double inc,double incRate, double daysTIncP){
		super(intrate, maturity,day);
		// TODO Auto-generated constructor stub
		this.spotPrice=spotP;
		this.income=inc;
		this.incomeRate=incRate;
		if(day.equals(DayCountConv.Calendar)){
			this.daysToIncPayment=daysTIncP/365;
			}
			else if (day.equals(DayCountConv.Trading)){
				this.daysToIncPayment=daysTIncP/252;
			}
		this.isIncome=isInc;
		this.isYeild=isYld;
	}
	public FuturesCalculator(double intrate, double maturity,DayCountConv day, double spotP,
							 boolean isInc, boolean isYld, double yld ) {
		super(intrate, maturity, day);
		// TODO Auto-generated constructor stub
		this.spotPrice=spotP;
		this.yield=yld;
		this.isIncome=isInc;
		this.isYeild=isYld;
	}
	@Override
	public  double calcFutures(){
		double futureP = 0.0;
		if(!this.getIsIncome()&&!this.getIsYeild()){
			futureP = this.getSpotPrice()*(Math.exp(this.getIr()*this.getDaysToExp()));
		}
		else if (this.isIncome){
			if(this.incomeRate>1){
				this.setIncomeRate(this.incomeRate/100);
			}
			this.setIncome(this.getIncome()*Math.exp(this.getIncomeRate()*this.getDaysToIncPayment()));
			futureP=(this.getSpotPrice()-this.getIncome())*(Math.exp(this.getIr()*this.getDaysToExp()));
		}
		else if(this.isYeild){
			futureP=this.getSpotPrice()*(Math.exp(this.getIr()-this.getYield())*this.getDaysToExp());
		}
		
		return futureP;
	}
	@Override
	public  ArrayList<Double> calcOptions(){
		return null;
	};

	public double getSpotPrice() {
		return spotPrice;
	}
	public void setSpotPrice(double spotPrice) {
		this.spotPrice = spotPrice;
	}
	public double getIncome() {
		return income;
	}
	public void setIncome(double income) {
		this.income = income;
	}
	public double getIncomeRate() {
		return incomeRate;
	}
	public void setIncomeRate(double incomeRate) {
		this.incomeRate = incomeRate;
	}
	public double getDaysToIncPayment() {
		return daysToIncPayment;
	}
	public void setDaysToIncPayment(double daysToIncPayment) {
		this.daysToIncPayment = daysToIncPayment;
	}
	public double getYield() {
		return yield;
	}
	public void setYield(double yield) {
		this.yield = yield;
	}
	public boolean getIsIncome() {
		return isIncome;
	}
	public void setIsIncome(boolean isIncome) {
		this.isIncome = isIncome;
	}
	public boolean getIsYeild() {
		return isYeild;
	}
	public void setIsYeild(boolean isYeild) {
		this.isYeild = isYeild;
	}
	




public static void main(String[] args) {
		Calculator ca = new FuturesCalculator(20, 115,DayCountConv.Trading, 500,
				 false, false);
		System.out.println(""+ca.calcFutures());

}
}
