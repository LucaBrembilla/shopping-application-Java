package Activity;

import java.util.*;
import java.lang.*;
import javax.swing.*;
import java.awt.*;
import javax.swing.border.*;
import java.awt.event.*;
import java.sql.*;
import Attributi.*;

public class SignupActivity extends JFrame implements ActionListener {
	private JPanel panel;
	private JButton buttonExit, buttonSubmit, buttonBack;
	private JLabel title, header, usernameLabel, passwordLabel, nameLabel, phoneLabel, addressLabel;
	private JTextField usernameTF, nameTF, phoneTF1, phoneTF2, addressTF;
	private JPasswordField passwordF;
	public SignupActivity() {
		super("Registrati");
		
		this.setSize(Theme.GUI_WIDTH, Theme.GUI_HEIGHT);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		
		panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(Theme.BACKGROUND_PANEL);
		
		title = new JLabel("Registrazione");
		title.setBounds(30, 115, 300, 75);
		title.setOpaque(true);
		title.setBorder(new EmptyBorder(0,20,0,0));
		title.setFont(Theme.FONT_TITLE);
		title.setForeground(Theme.COLOR_TITLE);
		panel.add(title);
		
		buttonExit = new JButton("Esci");
		buttonExit.setBounds(Theme.GUI_WIDTH-140, 115, Theme.BUTTON_PRIMARY_WIDTH,30);
		buttonExit.setFont(Theme.FONT_BUTTON);
		buttonExit.setBackground(Color.WHITE);
		buttonExit.setForeground(Theme.COLOR_TITLE);
		buttonExit.addActionListener(this);
		panel.add(buttonExit);
		
		buttonBack = new JButton("Indietro");
		buttonBack.setBounds(Theme.GUI_WIDTH-140, 155, Theme.BUTTON_PRIMARY_WIDTH,30);
		buttonBack.setFont(Theme.FONT_BUTTON);
		buttonBack.setBackground(Theme.BACKGROUND_BUTTON_PRIMARY);
		buttonBack.setForeground(Theme.COLOR_BUTTON_PRIMARY);
		buttonBack.addActionListener(this);
		panel.add(buttonBack);
		
		usernameLabel = new JLabel("ID Utente: ");
		usernameLabel.setBounds(60, 215, 140, 30);
		usernameLabel.setFont(Theme.FONT_REGULAR);
		panel.add(usernameLabel);
		
		passwordLabel = new JLabel("Password: ");
		passwordLabel.setBounds(60, 265, 140, 30);
		passwordLabel.setFont(Theme.FONT_REGULAR);
		panel.add(passwordLabel);
		
		nameLabel = new JLabel("Nome: ");
		nameLabel.setBounds(60, 315, 140, 30);
		nameLabel.setFont(Theme.FONT_REGULAR);
		panel.add(nameLabel);
		
		phoneLabel = new JLabel("Cellulare: ");
		phoneLabel.setBounds(60, 365, 140, 30);
		phoneLabel.setFont(Theme.FONT_REGULAR);
		panel.add(phoneLabel);
		
		addressLabel = new JLabel("Indirizzo: ");
		addressLabel.setBounds(60, 415, 140, 30);
		addressLabel.setFont(Theme.FONT_REGULAR);
		panel.add(addressLabel);
		
		usernameTF = new JTextField();
		usernameTF.setBounds(180, 215, 220, 30);
		usernameTF.setFont(Theme.FONT_INPUT);
		panel.add(usernameTF);
		
		passwordF = new JPasswordField();
		passwordF.setBounds(180, 265, 220, 30);
		passwordF.setFont(Theme.FONT_INPUT);
		panel.add(passwordF);
		
		nameTF = new JTextField();
		nameTF.setBounds(180, 315, 220, 30);
		nameTF.setFont(Theme.FONT_INPUT);
		panel.add(nameTF);
		
		phoneTF1 = new JTextField("+39");
		phoneTF1.setBounds(180, 365, 40, 30);
		phoneTF1.setForeground(Theme.COLOR_BUTTON_PRIMARY);
		phoneTF1.setEnabled(false);
		phoneTF1.setFont(Theme.FONT_INPUT);
		phoneTF1.setDisabledTextColor(Color.BLACK);
		panel.add(phoneTF1);
		
		phoneTF2 = new JTextField();
		phoneTF2.setBounds(220, 365, 180, 30);
		phoneTF2.setFont(Theme.FONT_INPUT);
		panel.add(phoneTF2);
		
		addressTF = new JTextField();
		addressTF.setBounds(180, 415, 220, 30);
		addressTF.setFont(Theme.FONT_INPUT);
		panel.add(addressTF);
		
		buttonSubmit = new JButton("Invio");
		buttonSubmit.setBounds(70, 475, 300, 35);
		buttonSubmit.setFont(Theme.FONT_BUTTON);
		buttonSubmit.setBackground(Theme.BACKGROUND_BUTTON_PRIMARY);
		buttonSubmit.setForeground(Theme.COLOR_BUTTON_PRIMARY);
		buttonSubmit.addActionListener(this);
		panel.add(buttonSubmit);
		
		header = new JLabel();
		header.setIcon(Theme.IMAGE_HEADER);
		header.setOpaque(true);
		header.setBounds(0, 0, Theme.GUI_WIDTH, 150);
		panel.add(header);
		
		this.add(panel);
	}
	
	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource().equals(buttonExit))
			System.exit(0);
		else if (ae.getSource().equals(buttonBack)) {
			this.setVisible(false);
			new LoginActivity().setVisible(true);
		}
		else if (ae.getSource().equals(buttonSubmit)) {
			try {
				Customer c = new Customer(usernameTF.getText().trim());
				c.setPassword(passwordF.getText());
				c.setCustomerName(nameTF.getText());
				c.setPhoneNumber(Integer.parseInt(phoneTF2.getText()));
				c.setAddress(addressTF.getText());
				c.createCustomer(this);
			}
			catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(this,"Dati non Validi!"); 
			}
			catch (IllegalArgumentException e) {
				JOptionPane.showMessageDialog(this,"Dati non Validi!"); 
			}
		}
		else {}
	}
}
