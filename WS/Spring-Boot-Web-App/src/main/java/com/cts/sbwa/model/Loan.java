package com.cts.sbwa.model;

public class Loan {
	
	private double prinicpal;
	private double rateOfInterest;
	private double term;
	private double emi;
	private LoanType type;
	
	public Loan() {}

	public Loan(double prinicpal, double rateOfInterest, double term, double emi,LoanType type) {
		super();
		this.prinicpal = prinicpal;
		this.rateOfInterest = rateOfInterest;
		this.term = term;
		this.emi = emi;
		this.type=type;
	}

	public double getPrinicpal() {
		return prinicpal;
	}

	public void setPrinicpal(double prinicpal) {
		this.prinicpal = prinicpal;
	}

	public double getRateOfInterest() {
		return rateOfInterest;
	}

	public void setRateOfInterest(double rateOfInterest) {
		this.rateOfInterest = rateOfInterest;
	}

	public double getTerm() {
		return term;
	}

	public void setTerm(double term) {
		this.term = term;
	}

	public double getEmi() {
		return emi;
	}

	public void setEmi(double emi) {
		this.emi = emi;
	}

	public LoanType getType() {
		return type;
	}

	public void setType(LoanType type) {
		this.type = type;
	}
	
	

}
