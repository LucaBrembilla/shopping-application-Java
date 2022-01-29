package Activity;

import java.util.*;
import java.lang.*;
import javax.swing.*;
import java.awt.*;
import javax.swing.border.*;
import java.awt.event.*;
import Attributi.*;
import Activity.*;
/**
 * 
 */
public class MyProfileActivity extends JFrame implements ActionListener  {
	private JPanel panel;
	private JButton buttonEdit, buttonBack, buttonLogout, buttonSubmit, buttonPass, buttonDelete;
	private JFrame backActivity;
	private User usr;
	private Employee employee;
	private Customer customer;
	private JLabel title, header, usernameLabel, nameLabel, phoneLabel, addressLabel;
	private JTextField nameTF, phoneTF1, phoneTF2, addressTF;
	private JLabel roleLabel, salaryLabel;
	public MyProfileActivity(JFrame activity, Customer customer) {
		super("Profilo");
		
		this.setSize(Theme.GUI_WIDTH, Theme.GUI_HEIGHT);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		
		panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(Theme.BACKGROUND_PANEL);
		
		backActivity = activity;
		this.customer = customer;
		this.usr = (User) customer;
		
		title = new JLabel("Profilo");
		title.setBounds(30, 115, 165,75);
		title.setOpaque(true);
		title.setBorder(new EmptyBorder(0,20,0,0));
		title.setFont(Theme.FONT_TITLE);
		title.setForeground(Theme.COLOR_TITLE);
		panel.add(title);
		
		buttonEdit = new JButton("Modifica Profilo");
		buttonEdit.setBounds(60, 405, 200, 30);
		buttonEdit.setFont(Theme.FONT_BUTTON);
		buttonEdit.setBackground(Theme.BACKGROUND_BUTTON_PRIMARY);
		buttonEdit.setForeground(Theme.COLOR_BUTTON_PRIMARY);
		buttonEdit.addActionListener(this);
		panel.add(buttonEdit);
		
		buttonSubmit = new JButton("Invia");
		buttonSubmit.setBounds(60, 405, 120, 30);
		buttonSubmit.setFont(Theme.FONT_BUTTON);
		buttonSubmit.setBackground(Theme.BACKGROUND_BUTTON_PRIMARY);
		buttonSubmit.setForeground(Theme.COLOR_BUTTON_PRIMARY);
		buttonSubmit.setVisible(false);
		buttonSubmit.addActionListener(this);
		panel.add(buttonSubmit);
		
		buttonPass = new JButton("Cambia Password");
		buttonPass.setBounds(Theme.GUI_WIDTH-180, 290, 160, 30);
		buttonPass.setFont(Theme.FONT_BUTTON);
		buttonPass.setBackground(Theme.BACKGROUND_BUTTON_PRIMARY);
		buttonPass.setForeground(Theme.COLOR_BUTTON_PRIMARY);
		buttonPass.addActionListener(this);
		panel.add(buttonPass);
		
		buttonDelete = new JButton("Cancella Account");
		buttonDelete.setBounds(Theme.GUI_WIDTH-180, 225, 160, 30);
		buttonDelete.setFont(Theme.FONT_BUTTON);
		buttonDelete.setBackground(Theme.BACKGROUND_BUTTON_PRIMARY);
		buttonDelete.setForeground(Theme.COLOR_BUTTON_PRIMARY);
		buttonDelete.addActionListener(this);
		panel.add(buttonDelete);
		
		buttonLogout = new JButton("Logout");
		buttonLogout.setBounds(Theme.GUI_WIDTH-140, 115, Theme.BUTTON_PRIMARY_WIDTH, 30);
		buttonLogout.setFont(Theme.FONT_BUTTON);
		buttonLogout.setBackground(Color.WHITE);
		buttonLogout.setForeground(Theme.COLOR_TITLE);
		buttonLogout.addActionListener(this);
		panel.add(buttonLogout);
		
		buttonBack = new JButton("Indietro");
		buttonBack.setBounds(Theme.GUI_WIDTH-140, 165, Theme.BUTTON_PRIMARY_WIDTH, 30);
		buttonBack.setFont(Theme.FONT_BUTTON);
		buttonBack.setBackground(Theme.BACKGROUND_BUTTON_PRIMARY);
		buttonBack.setForeground(Theme.COLOR_BUTTON_PRIMARY);
		buttonBack.addActionListener(this);
		panel.add(buttonBack);
		
		usernameLabel = new JLabel("ID Utente:       "+customer.getUserId());
		usernameLabel.setBounds(60, 215, 440, 30);
		usernameLabel.setFont(Theme.FONT_REGULAR);
		panel.add(usernameLabel);
		
		nameLabel = new JLabel("Nome: ");
		nameLabel.setBounds(60, 265, 440, 30);
		nameLabel.setFont(Theme.FONT_REGULAR);
		panel.add(nameLabel);
		
		phoneLabel = new JLabel("Cellulare: ");
		phoneLabel.setBounds(60, 315, 440, 30);
		phoneLabel.setFont(Theme.FONT_REGULAR);
		panel.add(phoneLabel);
		
		nameTF = new JTextField(customer.getCustomerName());
		nameTF.setBounds(180, 265, 220, 30);
		nameTF.setFont(Theme.FONT_INPUT);
		nameTF.setEnabled(false);
		nameTF.setDisabledTextColor(Color.BLACK);
		panel.add(nameTF);
		
		phoneTF1 = new JTextField("+39");
		phoneTF1.setBounds(180, 315, 40, 30);
		phoneTF1.setFont(Theme.FONT_INPUT);
		phoneTF1.setEnabled(false);
		phoneTF1.setDisabledTextColor(Color.BLACK);
		panel.add(phoneTF1);
		
		phoneTF2 = new JTextField(customer.getPhoneNumber().substring(3));
		phoneTF2.setBounds(220, 315, 180, 30);
		phoneTF2.setFont(Theme.FONT_INPUT);
		phoneTF2.setEnabled(false);
		phoneTF2.setDisabledTextColor(Color.BLACK);
		panel.add(phoneTF2);
		
		addressTF = new JTextField(customer.getAddress());
		addressTF.setBounds(180, 365, 220, 30);
		addressTF.setEnabled(false);
		addressTF.setFont(Theme.FONT_INPUT);
		addressTF.setDisabledTextColor(Color.BLACK);
		panel.add(addressTF);
		
		addressLabel = new JLabel("Indirizzo: ");
		addressLabel.setBounds(60, 365, 440, 30);
		addressLabel.setFont(Theme.FONT_REGULAR);
		panel.add(addressLabel);
		
		header = new JLabel();
		header.setIcon(Theme.IMAGE_HEADER);
		header.setOpaque(true);
		header.setBounds(0, 0, Theme.GUI_WIDTH, 150);
		panel.add(header);
		
		this.add(panel);
	}
	
	public MyProfileActivity(JFrame activity, Employee employee) {
		super("Profilo");
		
		this.setSize(Theme.GUI_WIDTH, Theme.GUI_HEIGHT);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		
		panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(Theme.BACKGROUND_PANEL);
		
		backActivity = activity;
		this.employee = employee;
		this.usr = (User) employee;
		
		title = new JLabel("Profilo");
		title.setBounds(30, 115, 165,75);
		title.setOpaque(true);
		title.setBorder(new EmptyBorder(0,20,0,0));
		title.setFont(Theme.FONT_TITLE);
		title.setForeground(Theme.COLOR_TITLE);
		panel.add(title);
		
		buttonEdit = new JButton("Modifica profilo");
		buttonEdit.setBounds(60, 455, 200, 30);
		buttonEdit.setFont(Theme.FONT_BUTTON);
		buttonEdit.setBackground(Theme.BACKGROUND_BUTTON_PRIMARY);
		buttonEdit.setForeground(Theme.COLOR_BUTTON_PRIMARY);
		buttonEdit.addActionListener(this);
		panel.add(buttonEdit);
		
		buttonSubmit = new JButton("Invia");
		buttonSubmit.setBounds(60, 455, 120, 30);
		buttonSubmit.setFont(Theme.FONT_BUTTON);
		buttonSubmit.setBackground(Theme.BACKGROUND_BUTTON_PRIMARY);
		buttonSubmit.setForeground(Theme.COLOR_BUTTON_PRIMARY);
		buttonSubmit.setVisible(false);
		buttonSubmit.addActionListener(this);
		panel.add(buttonSubmit);
		
		buttonPass = new JButton("Cambia Password");
		buttonPass.setBounds(Theme.GUI_WIDTH-180, 190, 160, 30);
		buttonPass.setFont(Theme.FONT_BUTTON);
		buttonPass.setBackground(Theme.BACKGROUND_BUTTON_PRIMARY);
		buttonPass.setForeground(Theme.COLOR_BUTTON_PRIMARY);
		buttonPass.addActionListener(this);
		panel.add(buttonPass);
		
		buttonLogout = new JButton("Logout");
		buttonLogout.setBounds(Theme.GUI_WIDTH-140, 115, Theme.BUTTON_PRIMARY_WIDTH, 30);
		buttonLogout.setFont(Theme.FONT_BUTTON);
		buttonLogout.setBackground(Color.WHITE);
		buttonLogout.setForeground(Theme.COLOR_TITLE);
		buttonLogout.addActionListener(this);
		panel.add(buttonLogout);
		
		buttonBack = new JButton("Indietro");
		buttonBack.setBounds(Theme.GUI_WIDTH-140, 155, Theme.BUTTON_PRIMARY_WIDTH, 30);
		buttonBack.setFont(Theme.FONT_BUTTON);
		buttonBack.setBackground(Theme.BACKGROUND_BUTTON_PRIMARY);
		buttonBack.setForeground(Theme.COLOR_BUTTON_PRIMARY);
		buttonBack.addActionListener(this);
		panel.add(buttonBack);
		
		usernameLabel = new JLabel("ID Utente:        "+employee.getUserId());
		usernameLabel.setBounds(60, 215, 440, 30);
		usernameLabel.setFont(Theme.FONT_REGULAR);
		panel.add(usernameLabel);
		
		nameLabel = new JLabel("Nome: ");
		nameLabel.setBounds(60, 265, 440, 30);
		nameLabel.setFont(Theme.FONT_REGULAR);
		panel.add(nameLabel);
		
		phoneLabel = new JLabel("Cellulare: ");
		phoneLabel.setBounds(60, 315, 440, 30);
		phoneLabel.setFont(Theme.FONT_REGULAR);
		panel.add(phoneLabel);
		
		roleLabel = new JLabel("Ruolo:             "+employee.getRole());
		roleLabel.setBounds(60, 365, 440, 30);
		roleLabel.setFont(Theme.FONT_REGULAR);
		panel.add(roleLabel);
		
		salaryLabel = new JLabel("Salario:          "+employee.getSalary());
		salaryLabel.setBounds(60, 415, 440, 30);
		salaryLabel.setFont(Theme.FONT_REGULAR);
		panel.add(salaryLabel);
		
		
		nameTF = new JTextField(employee.getEmployeeName());
		nameTF.setBounds(180, 265, 220, 30);
		nameTF.setFont(Theme.FONT_INPUT);
		nameTF.setEnabled(false);
		nameTF.setDisabledTextColor(Color.BLACK);
		panel.add(nameTF);
		
		phoneTF1 = new JTextField("+39");
		phoneTF1.setBounds(180, 315, 40, 30);
		phoneTF1.setFont(Theme.FONT_INPUT);
		phoneTF1.setEnabled(false);
		phoneTF1.setDisabledTextColor(Color.BLACK);
		panel.add(phoneTF1);
		
		phoneTF2 = new JTextField(employee.getPhoneNumber().substring(3));
		phoneTF2.setBounds(220, 315, 180, 30);
		phoneTF2.setFont(Theme.FONT_INPUT);
		phoneTF2.setEnabled(false);
		phoneTF2.setDisabledTextColor(Color.BLACK);
		panel.add(phoneTF2);
		
		header = new JLabel();
		header.setIcon(Theme.IMAGE_HEADER);
		header.setOpaque(true);
		header.setBounds(0, 0, Theme.GUI_WIDTH, 150);
		panel.add(header);
		
		this.add(panel);
	}
	
	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource().equals(buttonBack)) {
			this.setVisible(false);
			backActivity.setVisible(true);
		}
		else if (ae.getSource().equals(buttonLogout)) {
			this.setVisible(false);
			new LoginActivity().setVisible(true);
		}
		else if (ae.getSource().equals(buttonEdit)) {
			buttonEdit.setVisible(false);
			buttonSubmit.setVisible(true);
			nameTF.setEnabled(true);
			phoneTF2.setEnabled(true);
			if (customer!=null)
				addressTF.setEnabled(true);
		}
		else if (ae.getSource().equals(buttonSubmit)) {
			
			if (customer!=null) {
				addressTF.setEnabled(false);
				try {
					customer.updateCustomer(nameTF.getText().trim(), Long.parseLong(phoneTF2.getText()), addressTF.getText().trim());
					buttonEdit.setVisible(true);
					buttonSubmit.setVisible(false);
					nameTF.setEnabled(false);
					phoneTF2.setEnabled(false);
				}
				catch (NumberFormatException e) {
					JOptionPane.showMessageDialog(null,"Dati non Validi!");
				}
			}
			else if (employee!=null) {
				try {
					employee.updateEmployee(nameTF.getText().trim(), Long.parseLong(phoneTF2.getText()), employee.getRole(), employee.getSalary());
					buttonEdit.setVisible(true);
					buttonSubmit.setVisible(false);
					nameTF.setEnabled(false);
					phoneTF2.setEnabled(false);
				}
				catch (NumberFormatException e) {
					JOptionPane.showMessageDialog(null,"Dati non Validi!");
				}
			}
		}
		else if (ae.getSource().equals(buttonPass)) {
			new ChangePasswordActivity(this.usr).setVisible(true);
		}
		else if (ae.getSource().equals(buttonDelete)) {
			int input = JOptionPane.showConfirmDialog(null, "Continuare?", "Elimina "+customer.getUserId()+"?", JOptionPane.YES_NO_OPTION);
			if (input == 0) {
				customer.deleteCustomer();
				this.setVisible(false);
				new LoginActivity().setVisible(true);
			}
			else {}
		}
		else {}
	}
}
