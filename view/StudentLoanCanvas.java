package view;

import java.awt.Dimension;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

public class StudentLoanCanvas extends JPanel {
	
	public static int WIDTH = 400;
	public static int HEIGHT = 250;

	private int results = 0;


	private StudentLoanSimulator panel;

	public StudentLoanCanvas(StudentLoanSimulator panel) {
		this.panel = panel;
		setPreferredSize(new Dimension(WIDTH, HEIGHT));
		setBackground(Color.black);
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		Graphics2D g2 = (Graphics2D) g;

		StudentLoanSimulator.Options state = panel.getOptions();

		if(state == StudentLoanSimulator.Options.NONE) {
		g2.setColor(Color.white);
		g2.setFont(new Font("Courier", Font.BOLD, 14));
		g2.drawString("ENTER LOAN DETAILS", 125, 125);
	
		} else if(state == StudentLoanSimulator.Options.FULL) {
			g2.setColor(Color.white);
			g2.setFont(new Font("Courier", Font.BOLD, 14));
			g2.drawString("TIME REMAINING", 70, 40);
			g2.drawString("TIME SAVED", 85, 220);
			g2.drawRect(100, 50, 50, 150);
			g2.fillRect(100, 50, 50, 150);
		} else if(state == StudentLoanSimulator.Options.COFFEE) {
			g2.setColor(Color.white);
			g2.setFont(new Font("Courier", Font.BOLD, 14));
			g2.drawString("TIME REMAINING", 70, 40);
			g2.drawString("TIME SAVED", 85, 220);
			g2.drawString("COFFEE", 250, 40);
			g2.drawRect(100, 50, 50, 150);
			g2.fillRect(100, 50, 50, 150);
			g2.drawRect(250, 50, 50, 150);
			g2.fillRect(250, 50, 50, results);

		} else if(state == StudentLoanSimulator.Options.FIFTY) {
			g2.setColor(Color.white);
			g2.setFont(new Font("Courier", Font.BOLD, 14));
			g2.drawString("TIME REMAINING", 70, 40);
			g2.drawString("TIME SAVED", 85, 220);
			g2.drawString("EXTRA $50", 240, 40);
			g2.drawRect(100, 50, 50, 150);
			g2.fillRect(100, 50, 50, 150);
			g2.drawRect(250, 50, 50, 150);
			g2.fillRect(250, 50, 50, results);
		} else if(state == StudentLoanSimulator.Options.HUNDRED) {
			g2.setColor(Color.white);
			g2.setFont(new Font("Courier", Font.BOLD, 14));
			g2.drawString("TIME REMAINING", 70, 40);
			g2.drawString("TIME SAVED", 85, 220);
			g2.drawString("EXTRA $100", 235, 40);
			g2.drawRect(100, 50, 50, 150);
			g2.fillRect(100, 50, 50, 150);
			g2.drawRect(250, 50, 50, 150);
			g2.fillRect(250, 50, 50, results);
		}

	}

	public void getUpdatedTime(int results) {
		this.results = results;
	}
}
