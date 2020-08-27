package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.StudentLoanSimulator;	

public class ButtonClickListener implements ActionListener {
	
	private StudentLoanSimulator panel;

	public ButtonClickListener(StudentLoanSimulator panel) {
		this.panel = panel;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		var button = e.getSource();
		String m = panel.getDisplay().getText() + "\n";

		if(button == panel.getComputeButton()) {
			double loanValue = Double.parseDouble(panel.getLoanField().getText());
			double termValue = Double.parseDouble(panel.getTermField().getText());
			double interestValue =  Double.parseDouble(panel.getInterestField().getText());

			panel.getStudentLoan().enterLoan(loanValue);
			panel.getDisplay().setText(m + loanValue + " Entered");
			panel.getStudentLoan().enterTerm(termValue);
			panel.getStudentLoan().enterRate(interestValue);
			panel.getStudentLoan().computePayment();
			panel.getDisplay().setText("Loan Total: $" + panel.getStudentLoan().getResult() +
							"\nMonthly Payment: $" + panel.getStudentLoan().getMonthlyPayment());
		} else if(button == panel.getExtra50Button()) {
			panel.getStudentLoan().extra50();

			if(panel.getStudentLoan().getMonths() == 0) {
				panel.getDisplay().setText(m + "By paying $50 extra a month, you'll pay off your loan in " 
										+ panel.getStudentLoan().getYears() + " years ");
			} else {
				panel.getDisplay().setText(m + "By paying $50 extra a month, you'll pay off your loan in " 
										+ panel.getStudentLoan().getYears() + " years " 
										+ panel.getStudentLoan().getMonths() + " months");
			}
		
		} else if(button == panel.getExtra100Button()) {
			panel.getStudentLoan().extra100();

			if(panel.getStudentLoan().getMonths() == 0) {
				panel.getDisplay().setText(m + "By paying $100 extra a month, you'll pay off your loan in " 
										+ panel.getStudentLoan().getYears() + " years ");
			} else {
				panel.getDisplay().setText(m + "By paying $100 extra a month, you'll pay off your loan in " 
										+ panel.getStudentLoan().getYears() + " years " 
										+ panel.getStudentLoan().getMonths() + " months");
			}
		}

	}


}