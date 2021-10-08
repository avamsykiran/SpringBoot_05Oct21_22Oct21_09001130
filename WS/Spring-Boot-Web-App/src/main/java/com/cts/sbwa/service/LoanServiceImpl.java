package com.cts.sbwa.service;

import org.springframework.stereotype.Service;

import com.cts.sbwa.model.Loan;

@Service
public class LoanServiceImpl implements LoanService	 {

	@Override
	public void computeEMI(Loan loan) {
		if(loan!=null) {
			double p = loan.getPrinicpal();
			double n = loan.getTerm();
			double r = loan.getRateOfInterest()/12/100;
			
			double emi = (p*r*Math.pow(1+r,n))/(Math.pow(1+r,n)-1);
			loan.setEmi(emi);
		}		
	}
}
