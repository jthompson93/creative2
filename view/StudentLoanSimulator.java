package view;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import controller.ButtonClickListener;
import model.StudentLoan;

public class StudentLoanSimulator {

	private StudentLoan studentLoan = new StudentLoan();

	private JFrame window;
	private JLabel loanLabel = new JLabel("Loan Amount    ");
	private JLabel termLabel = new JLabel("Term Length    ");
	private JLabel interestLabel = new JLabel("Interest Amount");

	private JTextArea  display = new JTextArea();

	private JTextField loanField = new JTextField(15);
	private JTextField termField = new JTextField(15);
	private JTextField interestField = new JTextField(15);

	private JButton computeButton = new JButton("Compute");
	private JButton extra50Button = new JButton("Extra $50");
	private JButton extra100Button = new JButton("Extra $100");


	public StudentLoanSimulator(JFrame window) {
		this.window = window;
		window.setTitle("Student Loan Calculator");
		termField.setForeground(Color.gray);
		loanField.setForeground(Color.gray);
		interestField.setForeground(Color.gray);
		
	}

	public void init() {
		
		Container cp = window.getContentPane();
		var scrollPane = new JScrollPane(display, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
			JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

		scrollPane.setPreferredSize(new Dimension(500,500));
		cp.add(BorderLayout.CENTER, scrollPane);

		JPanel northPanel = new JPanel();
		cp.add(BorderLayout.NORTH, northPanel);

		northPanel.setLayout(new GridLayout(5,1));
		JPanel row1 = new JPanel();
		row1.add(loanLabel);
		row1.add(loanField);
		northPanel.add(row1);	
		

		JPanel row2 = new JPanel();
		row2.add(termLabel);
		row2.add(termField);
		northPanel.add(row2);

		JPanel row3 = new JPanel();
		row3.add(interestLabel);
		row3.add(interestField);
		northPanel.add(row3);

		JPanel row4 = new JPanel();
		row4.add(computeButton);
		northPanel.add(row4);

		JPanel row5 = new JPanel();
		row5.add(extra50Button);
		row5.add(extra100Button);
		northPanel.add(row5);


		ButtonClickListener buttonClickListener = new ButtonClickListener(this);
		computeButton.addActionListener(buttonClickListener);
		extra50Button.addActionListener(buttonClickListener);
		extra100Button.addActionListener(buttonClickListener);

	}

	public JTextField getLoanField() {
		return loanField;
	}
	public JTextField getTermField() {
		return termField;
	}
	public JTextField getInterestField() {
		return interestField;
	}

	public JFrame getWindow() {
		return window;
	}

	public StudentLoan getStudentLoan() {
		return studentLoan;
	}

	public JButton getComputeButton() {
		return computeButton;
	}
	public JButton getExtra50Button() {
		return extra50Button;
	}
	public JButton getExtra100Button() {
		return extra100Button;
	}
	public JTextArea getDisplay() {
		return display;
	}
}