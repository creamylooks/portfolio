package project.derivatives.calculationEngine;

import java.util.ArrayList;

import maygard.classes.options.BlackScholes;

public class OptionsCalculator extends Calculator {
	private PricingModel model;
	private double stockP;
	private double strikeP;
	private double volatility;
	private boolean isDividend;
	private double dividendAmount;
	private double daysToExDividend;
	private DividendFreq Freq;
	
	public OptionsCalculator(double intrate, double maturity, DayCountConv day,PricingModel mod, double stckP, 
							 double strkP,double vol,boolean isDiv) {
		super(intrate, maturity, day);
		// TODO Auto-generated constructor stub
		this.model=mod;
		this.stockP=stckP;
		this.strikeP=strkP;
		this.volatility=vol;
		this.isDividend=isDiv;
		
	}
	
	public OptionsCalculator(double intrate, double maturity, DayCountConv day,PricingModel mod, double stckP, 
							 double strkP,double vol,boolean isDiv, double divAmnt, double daysToExDiv, DividendFreq frequent) {
						super(intrate, maturity, day);
						// TODO Auto-generated constructor stub
						this.model=mod;
						this.stockP=stckP;
						this.strikeP=strkP;
						this.volatility=vol;
						this.isDividend=isDiv;
						this.dividendAmount=divAmnt;
						if(day.equals(DayCountConv.Calendar)){
						this.daysToExDividend=daysToExDiv/365;
						}else if(day.equals(DayCountConv.Trading)){
							this.daysToExDividend=daysToExDiv/252;
						}
						this.Freq=frequent;
		
	}
	@Override
	public double calcFutures(){
		return 0.0;
	}
	@Override
	public  ArrayList<Double> calcOptions(){
		ArrayList<Double> greeks = new ArrayList<Double>();
		if(this.getModel().equals(PricingModel.Black_Scholes)){
			BlackScholes black = new BlackScholes();
			if(!this.isDividend){
				black.bscholEprice(this.getStockP(),this.getStrikeP(), this.getVolatility(), this.getDaysToExp(), this.getIr());
				black.setTheta(this.getStockP(),this.getStrikeP(), this.getVolatility(), this.getDaysToExp(), this.getIr());
				black.setRho(this.getStockP(),this.getStrikeP(), this.getVolatility(), this.getDaysToExp(), this.getIr());
			}
			else if(this.isDividend){
				
				
			}
			
			greeks.add(black.getCalle());
			greeks.add(black.getPute());
			greeks.add(black.getDeltac());
			greeks.add(black.getDeltap());
			greeks.add(black.getGamma());
			greeks.add(black.getVega());
			greeks.add(black.getThetac());
			greeks.add(black.getThetap());
			greeks.add(black.getRhoc());
			greeks.add(black.getRhop());
		}else if(this.getModel().equals(PricingModel.Binomial)){}
		
			
		return greeks;
	};

	
	public PricingModel getModel() {
		return model;
	}
	public void setModel(PricingModel model) {
		this.model = model;
	}
	public double getStockP() {
		return stockP;
	}
	public void setStockP(double stockP) {
		this.stockP = stockP;
	}
	public double getStrikeP() {
		return strikeP;
	}
	public void setStrikeP(double strikeP) {
		this.strikeP = strikeP;
	}
	public double getVolatility() {
		return volatility;
	}
	public void setVolatility(double volatility) {
		this.volatility = volatility;
	}
	public boolean isDividend() {
		return isDividend;
	}
	public void setDividend(boolean isDividend) {
		this.isDividend = isDividend;
	}
	public double getDividendAmount() {
		return dividendAmount;
	}
	public void setDividendAmount(double dividendAmount) {
		this.dividendAmount = dividendAmount;
	}
	public double getDaysToExDividend() {
		return daysToExDividend;
	}
	public void setDaysToExDividend(double daysToExDividend) {
		this.daysToExDividend = daysToExDividend;
	}
	public DividendFreq getFreq() {
		return Freq;
	}
	public void setFreq(DividendFreq freq) {
		Freq = freq;
	}
	
}
