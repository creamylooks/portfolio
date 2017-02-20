package project.derivatives.calculationEngine;

import java.util.ArrayList;

public abstract class Calculator {
	private ContractType contractType;
	private double ir;
	private double daysToExp;
	private DayCountConv dayConv;
	public abstract double calcFutures();
	public abstract ArrayList<Double> calcOptions();
	public Calculator(double intrate, double maturity,DayCountConv day){
		if(intrate>1){
			this.ir=intrate/100;
		}else{
		this.ir=intrate;}
		if(day.equals(DayCountConv.Calendar)){
		this.daysToExp=maturity/365;
		}
		else if (day.equals(DayCountConv.Trading)){
			this.daysToExp=maturity/252;
		}
	}

	public ContractType getContractType() {
		return contractType;
	}
	public void setContractType(ContractType contractType) {
		this.contractType = contractType;
	}
	public double getIr() {
		return ir;
	}
	public void setIr(double ir) {
		this.ir = ir;
	}
	public double getDaysToExp() {
		return daysToExp;
	}
	public void setDaysToExp(double daysToExp) {
		this.daysToExp = daysToExp;
	}
	public DayCountConv getDayConv() {
		return dayConv;
	}
	public void setDayConv(DayCountConv dayConv) {
		this.dayConv = dayConv;
	}
	
}
