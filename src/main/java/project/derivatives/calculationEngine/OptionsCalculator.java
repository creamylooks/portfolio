package project.derivatives.calculationEngine;

import java.util.ArrayList;
import maygard.classes.core.BinomParams;
import maygard.classes.options.BlackScholes;
import maygard.classes.options.PutCallPar;

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
		}else if(this.getModel().equals(PricingModel.Binomial)){
			BinomParams params = new BinomParams();
			double calle=0;
			double pute=0;
			this.setDividendAmount(0);
			params.binomodel(this.getDaysToExp(), this.getIr(), this.getVolatility(), this.getDividendAmount());
			double CUpJump = params.getU()-this.getStrikeP();
			double deltaC = CUpJump/(params.getU()-params.getD());
			//we need to find the borrowing required to get the same value for upjump and downjump using delta hedging
			//i.e. the amount required to get the same value for selling 1 call option and buying delta number of shares such that the 
			// portfolio value remains the same regardless of f the price goes up or down
			double Bup=(this.getStrikeP()-params.getU())+deltaC*params.getU();
			double Bdown= deltaC*params.getD();
			double deltaP=0;
			BlackScholes blackb=null;
			
			if (Bup==Bdown){
				double Bnow=Bup/(1+this.getIr());
				calle = Bnow+(deltaC*this.getStockP());
				PutCallPar putAlt = new PutCallPar();
				pute=putAlt.europarity(calle,this.strikeP, this.getStockP(), this.getIr(),this.getDaysToExp());
				deltaP =( 0-(1-deltaC));
				 blackb =new BlackScholes();
				 blackb.setGamma(this.getStockP(), this.getStrikeP(),this.getVolatility(),this.getDaysToExp(), this.getIr());
				 blackb.setVega(this.getStockP(), this.getStrikeP(),this.getVolatility(),this.getDaysToExp(), this.getIr());
				 blackb.setTheta(this.getStockP(), this.getStrikeP(),this.getVolatility(),this.getDaysToExp(), this.getIr());
				 blackb.setRho(this.getStockP(), this.getStrikeP(),this.getVolatility(),this.getDaysToExp(), this.getIr());
			}
			
			greeks.add(calle);
			greeks.add(pute);
			greeks.add(deltaC);
			greeks.add(deltaP);
			greeks.add(blackb.getGamma());
			greeks.add(blackb.getVega());
			greeks.add(blackb.getThetac());
			greeks.add(blackb.getThetap());
			greeks.add(blackb.getRhoc());
			greeks.add(blackb.getRhop());
		}
		
			
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
