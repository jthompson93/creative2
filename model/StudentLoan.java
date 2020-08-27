package model;

public class StudentLoan {

	private double loanAmount;
	private double loanTerm;
	//private double extraPayment;
	private double result;
	private double interestRate;
	private double monthlyPayment;
	private int timeRemaining;
	private int years;
	private int months;
	//private double dailyInterest;
	//private int months;


	public void enterLoan(double n) {
			loanAmount = n;
	}
	public void enterTerm(double n) {
			loanTerm = n;
	}
	public void enterRate(double n) {

			interestRate = n / 100;
	}
	
	public void computePayment() {
			result = (loanAmount * (1.0 + (interestRate * loanTerm)));
			result = Math.round(result * 100) / 100.0;
			monthlyPayment = result / ((int)loanTerm * 12);
			monthlyPayment = Math.round(monthlyPayment * 100) / 100.0;
	
	}

	public void extra50() {
			timeRemaining = (int)(result / (monthlyPayment + 50)) + 1;
			years = timeRemaining / 12;
			months = timeRemaining % 12;
			
	}

	public void extra100() {
			timeRemaining = (int)(result / (monthlyPayment + 100)) + 1;
			years = timeRemaining / 12;
			months = timeRemaining % 12;
			 
	}

	public double getResult() {
		return result;
	}

	public double getYears() {
		return years;
	}
	public double getMonths() {
		return months;
	}

	public double getMonthlyPayment() {
		return monthlyPayment;
	}


	
}