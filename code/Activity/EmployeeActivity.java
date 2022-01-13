package Activity;

import java.util.*;

import java.lang.*;
import javax.swing.*;
import java.awt.*;
import javax.swing.border.*;
import java.awt.event.*;
import java.sql.*;
import Attributi.*;
import Activity.*;

/**
 * 
 */
public class EmployeeActivity extends JFrame implements ActionListener  {
	private JPanel panel;
	private Employee employee;
	private JButton buttonLogout, buttonProfile,  buttonViewFood, buttonViewDrink, buttonViewPurchases;
	private JButton buttonViewCustomer, buttonViewEmployee;
	private JLabel title, header;
	public EmployeeActivity(String userId) {
		super("Gestione");
		
		this.setSize(Theme.GUI_WIDTH, Theme.GUI_HEIGHT);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		
		employee = new Employee(userId);
		employee.fetch();
		
		panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(Theme.BACKGROUND_PANEL);
		
		title = new JLabel("Benvenuto, "+userId);
		title.setBounds(30, 40, userId.length()*30+220,75);
		title.setOpaque(true);
		title.setBorder(new EmptyBorder(0,20,0,0));
		title.setFont(Theme.FONT_TITLE);
		title.setForeground(Theme.COLOR_TITLE);
		panel.add(title);
		
		buttonLogout = new JButton("Logout");
		buttonLogout.setBounds(Theme.GUI_WIDTH-140, 40, Theme.BUTTON_PRIMARY_WIDTH,30);
		buttonLogout.setFont(Theme.FONT_BUTTON);
		buttonLogout.setBackground(Color.WHITE);
		buttonLogout.setForeground(Theme.COLOR_TITLE);
		buttonLogout.addActionListener(this);
		panel.add(buttonLogout);
		
		buttonProfile = new JButton("Profilo");
		buttonProfile.setBounds(Theme.GUI_WIDTH-150, 80, 120,30);
		buttonProfile.setFont(Theme.FONT_BUTTON);
		buttonProfile.setBackground(Theme.BACKGROUND_BUTTON_PRIMARY);
		buttonProfile.setForeground(Theme.COLOR_BUTTON_PRIMARY);
		buttonProfile.addActionListener(this);
		panel.add(buttonProfile);
		
		buttonViewFood = new JButton("Vedi Cibo");
		buttonViewFood.setBounds(60, 160, 200, 30);
		buttonViewFood.setFont(Theme.FONT_BUTTON);
		buttonViewFood.setBackground(Theme.BACKGROUND_BUTTON_PRIMARY);
		buttonViewFood.setForeground(Theme.COLOR_BUTTON_PRIMARY);
		buttonViewFood.addActionListener(this);
		panel.add(buttonViewFood);
		
		buttonViewDrink = new JButton("Vedi Bibite");
		buttonViewDrink.setBounds(60, 190, 200, 30);
		buttonViewDrink.setFont(Theme.FONT_BUTTON);
		buttonViewDrink.setBackground(Theme.BACKGROUND_BUTTON_PRIMARY);
		buttonViewDrink.setForeground(Theme.COLOR_BUTTON_PRIMARY);
		buttonViewDrink.addActionListener(this);
		panel.add(buttonViewDrink);
		
		buttonViewCustomer = new JButton("Gestisci Clienti");
		buttonViewCustomer.setBounds(60, 190, 200, 30);
		buttonViewCustomer.setFont(Theme.FONT_BUTTON);
		buttonViewCustomer.setBackground(Theme.BACKGROUND_BUTTON_PRIMARY);
		buttonViewCustomer.setForeground(Theme.COLOR_BUTTON_PRIMARY);
		buttonViewCustomer.addActionListener(this);
		panel.add(buttonViewCustomer);
		
		buttonViewPurchases = new JButton("Vedi Ordini");
		buttonViewPurchases.setBounds(60, 220, 200, 30);
		buttonViewPurchases.setFont(Theme.FONT_BUTTON);
		buttonViewPurchases.setBackground(Theme.BACKGROUND_BUTTON_PRIMARY);
		buttonViewPurchases.setForeground(Theme.COLOR_BUTTON_PRIMARY);
		buttonViewPurchases.addActionListener(this);
		panel.add(buttonViewPurchases);
		
		if (employee.getRole().equals("Manager")) {
			buttonViewEmployee = new JButton("Gestici Impiegati");
			buttonViewEmployee.setBounds(60, 250, 200, 30);
			buttonViewEmployee.setFont(Theme.FONT_BUTTON);
			buttonViewEmployee.setBackground(Theme.BACKGROUND_BUTTON_PRIMARY);
			buttonViewEmployee.setForeground(Theme.COLOR_BUTTON_PRIMARY);
			buttonViewEmployee.addActionListener(this);
			panel.add(buttonViewEmployee);
		}
		
		header = new JLabel();
		header.setBackground(Theme.BACKGROUND_HEADER);
		header.setOpaque(true);
		header.setBounds(0, 0, Theme.GUI_WIDTH, 75);
		panel.add(header);
		
		this.add(panel);
	}
	
	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource().equals(buttonProfile)) {
			this.setVisible(false);
			new MyProfileActivity(this, employee).setVisible(true);
		}
		else if (ae.getSource().equals(buttonLogout)) {
			this.setVisible(false);
			new LoginActivity().setVisible(true);
		}
		else if (ae.getSource().equals(buttonViewFood)) {
			this.setVisible(false);
			new ViewFoodActivity(this, employee).setVisible(true);
		}
		else if (ae.getSource().equals(buttonViewPurchases)) {
			this.setVisible(false);
			new ViewPurchasesActivity(this, employee).setVisible(true);
		}
		else if (ae.getSource().equals(buttonViewDrink)) {
			this.setVisible(false);
			new ViewDrinksActivity(this, employee).setVisible(true);
		}
		else if (ae.getSource().equals(buttonViewCustomer)) {
			this.setVisible(false);
			new ViewCustomerActivity(this, employee).setVisible(true);
		}
		else if (ae.getSource().equals(buttonViewEmployee)) {
			this.setVisible(false);
			new ViewEmployeeActivity(this, employee).setVisible(true);
		}
		else {}
	}
}