package project.derivatives.calculationEngine;

import java.util.ArrayList;

public abstract class Calculator {
	private ContractType contractType;
	private double ir;
	private double daysToExp;
	private DayCountConv dayConv;
	public abstract double calcFutures();
	public abstract ArrayList<Double> calcOptions();

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
