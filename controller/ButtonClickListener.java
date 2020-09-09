package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.StudentLoanSimulator;	

public class ButtonClickListener implements ActionListener {
	
	private StudentLoanSimulator panel;
	private int button1Click = 0;
	private int button2Click = 0;
	private int button3Click = 0;


	public ButtonClickListener(StudentLoanSimulator panel) {
		this.panel = panel;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		var button = e.getSource();
		String m = panel.getDisplay().getText() + "\n";
		panel.getStudentLoanCanvas().repaint();
		if(button == panel.getComputeButton()) {
			try {
			panel.setOptions(StudentLoanSimulator.Options.FULL);
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
							//panel.getStudentLoanCanvas().getUpdatedTime(results);
							
						} catch (NumberFormatException exception) {
							panel.getDisplay().setText("Error - Invalid input");
							panel.getDisplay().setText("Error - Invalid input");
							panel.getDisplay().setText("Error - Invalid input");
				panel.getLoanField().setText("");
				panel.getTermField().setText("");
				panel.getInterestField().setText("");
				}
		} else if(button == panel.getExtra50Button()) {
			panel.setOptions(StudentLoanSimulator.Options.FIFTY);
			panel.getStudentLoan().extra50();

			int results = panel.getStudentLoan().getAdjustedTime();
			panel.getStudentLoanCanvas().getUpdatedTime(results);

		if(button2Click == 0) {
			if(panel.getStudentLoan().getMonths() == 0) {
				panel.getDisplay().setText(m + "By paying $50 extra a month:\nYou'll pay off your loan in " 
										+ (int)(panel.getStudentLoan().getYears()) + " years ");
			} else {
				panel.getDisplay().setText(m + "By paying $50 extra a month:\nYou'll pay off your loan in " 
										+ (int)(panel.getStudentLoan().getYears()) + " years " 
										+ (int)(panel.getStudentLoan().getMonths()) + " months");
			}
			button2Click += 1;
		}
		
		} else if(button == panel.getExtra100Button()) {
			panel.setOptions(StudentLoanSimulator.Options.HUNDRED);
			panel.getStudentLoan().extra100();

			int results = panel.getStudentLoan().getAdjustedTime();
			panel.getStudentLoanCanvas().getUpdatedTime(results);
		if(button3Click == 0) {
			if(panel.getStudentLoan().getMonths() == 0) {
				panel.getDisplay().setText(m + "If you pay an extra $100/month:\nYou'll pay off your loan in " 
										+ (int)(panel.getStudentLoan().getYears()) + " years ");
			} else {
				panel.getDisplay().setText(m + "By paying $100 extra a month:\nYou'll pay off your loan in " 
										+ (int)(panel.getStudentLoan().getYears()) + " years " 
										+ (int)(panel.getStudentLoan().getMonths()) + " months");
			}
			button3Click += 1;
		}
		} else if(button == panel.getCoffeeButton()) {
			panel.setOptions(StudentLoanSimulator.Options.COFFEE);
			panel.getStudentLoan().coffee();

			int results = panel.getStudentLoan().getAdjustedTime();
			panel.getStudentLoanCanvas().getUpdatedTime(results);

		if(button1Click == 0) {
			if(panel.getStudentLoan().getMonths() == 0) {
				panel.getDisplay().setText(m + "By paying 1 coffee/month:\nYou'll pay off your loan in " 
										+ (int)(panel.getStudentLoan().getYears()) + " years ");
			} else {
				panel.getDisplay().setText(m + "By paying 1 coffee/month:\nYou'll pay off your loan in " 
										+ (int)(panel.getStudentLoan().getYears()) + " years " 
										+ (int)(panel.getStudentLoan().getMonths()) + " months");
			}
		button1Click += 1;
			}
		}

	}


}