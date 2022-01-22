package Activity;

import java.lang.*;
import java.util.*;
import javax.swing.*;
import java.awt.*;
import javax.swing.border.*;
import java.awt.event.*;
import Attributi.*;
import Activity.*;

/**
 * 
 */
public class AddEmployeeActivity extends JFrame implements ActionListener{
	private JPanel panel;
	private ViewEmployeeActivity activity;
	private JButton buttonLogout, buttonBack, buttonAdd, buttonEdit, buttonDelete, buttonRandom;
	private JLabel title, header, employeeIdLabel, employeeNameLabel, roleLabel, employeePhoneLabel, salaryLabel;
	private JComboBox roleCB;
	private JTextField employeeIdTF, employeeNameTF, salaryTF, employeePhoneTF1, employeePhoneTF2, passwordTF;
	private Random r;
	
	public AddEmployeeActivity(ViewEmployeeActivity prev, Employee employee) {
		super("Nuovo Impiegato");
		
		this.setSize(Theme.GUI_WIDTH, Theme.GUI_HEIGHT);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.activity = prev;
		r = new Random();
		
		panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(Theme.BACKGROUND_PANEL);
		
		title = new JLabel("Nuovo Impiegato");
		title.setBounds(30, 115, 360,75);
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
		
		buttonBack = new JButton("Indietro");
		buttonBack.setBounds(Theme.GUI_WIDTH-140, 80, Theme.BUTTON_PRIMARY_WIDTH,30);
		buttonBack.setFont(Theme.FONT_BUTTON);
		buttonBack.setBackground(Theme.BACKGROUND_BUTTON_PRIMARY);
		buttonBack.setForeground(Theme.COLOR_BUTTON_PRIMARY);
		buttonBack.addActionListener(this);
		panel.add(buttonBack);
		
		employeeIdLabel = new JLabel("ID Impiegato: ");
		employeeIdLabel.setBounds(60, 215, 140, 30);
		employeeIdLabel.setFont(Theme.FONT_REGULAR);
		panel.add(employeeIdLabel);
		
		employeeIdLabel = new JLabel("Password: ");
		employeeIdLabel.setBounds(60, 265, 140, 30);
		employeeIdLabel.setFont(Theme.FONT_REGULAR);
		panel.add(employeeIdLabel);
		
		employeeNameLabel = new JLabel("Nome: ");
		employeeNameLabel.setBounds(60, 315, 140, 30);
		employeeNameLabel.setFont(Theme.FONT_REGULAR);
		panel.add(employeeNameLabel);
		
		employeePhoneLabel = new JLabel("Cellulare: ");
		employeePhoneLabel.setBounds(60, 365, 140, 30);
		employeePhoneLabel.setFont(Theme.FONT_REGULAR);
		panel.add(employeePhoneLabel);
		
		roleLabel = new JLabel("Ruolo: ");
		roleLabel.setBounds(60, 415, 340, 30);
		roleLabel.setFont(Theme.FONT_REGULAR);
		panel.add(roleLabel);
		
		salaryLabel = new JLabel("Salario: ");
		salaryLabel.setBounds(60, 465, 140, 30);
		salaryLabel.setFont(Theme.FONT_REGULAR);
		panel.add(salaryLabel);
		
		employeeIdTF = new JTextField();
		employeeIdTF.setBounds(180, 215, 220, 30);
		employeeIdTF.setFont(Theme.FONT_INPUT);
		panel.add(employeeIdTF);
		
		passwordTF = new JTextField(""+(r.nextInt(89999999)+10000000));
		passwordTF.setBounds(180, 265, 220, 30);
		passwordTF.setFont(Theme.FONT_INPUT);
		passwordTF.setEnabled(false);
		passwordTF.setDisabledTextColor(Color.BLACK);
		panel.add(passwordTF);
		
		buttonRandom = new JButton("Genera");
		buttonRandom.setBounds(400, 265, Theme.BUTTON_PRIMARY_WIDTH,30);
		buttonRandom.setFont(Theme.FONT_BUTTON);
		buttonRandom.setBackground(Theme.BACKGROUND_BUTTON_PRIMARY);
		buttonRandom.setForeground(Theme.COLOR_BUTTON_PRIMARY);
		buttonRandom.addActionListener(this);
		panel.add(buttonRandom);
		
		employeeNameTF = new JTextField();
		employeeNameTF.setBounds(180, 315, 220, 30); 
		employeeNameTF.setFont(Theme.FONT_INPUT);
		panel.add(employeeNameTF);
		
		employeePhoneTF1 = new JTextField("+39");
		employeePhoneTF1.setBounds(180, 365, 40, 30);
		employeePhoneTF1.setEnabled(false);
		employeePhoneTF1.setFont(Theme.FONT_INPUT);
		panel.add(employeePhoneTF1);
	
		employeePhoneTF2 = new JTextField();
		employeePhoneTF2.setBounds(220, 365, 180, 30);
		employeePhoneTF2.setFont(Theme.FONT_INPUT);
		panel.add(employeePhoneTF2);
		
		roleCB = new JComboBox(Employee.roles);
		roleCB.setBounds(180, 415, 160, 30);
		roleCB.setFont(Theme.FONT_INPUT);
		panel.add(roleCB);
		
		salaryTF = new JTextField();
		salaryTF.setBounds(180, 465, 220, 30);
		salaryTF.setFont(Theme.FONT_INPUT);
		panel.add(salaryTF);
		
		buttonAdd = new JButton("Aggiungi");
		buttonAdd.setBounds(60, 515, Theme.BUTTON_PRIMARY_WIDTH,30);
		buttonAdd.setFont(Theme.FONT_BUTTON);
		buttonAdd.setBackground(Theme.BACKGROUND_BUTTON_PRIMARY);
		buttonAdd.setForeground(Theme.COLOR_BUTTON_PRIMARY);
		buttonAdd.addActionListener(this);
		panel.add(buttonAdd);
		
		header = new JLabel();
		header.setIcon(Theme.IMAGE_HEADER);
		header.setOpaque(true);
		header.setBounds(0, 0, Theme.GUI_WIDTH, 150);
		panel.add(header);
		
		this.add(panel);
	}

	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource().equals(buttonLogout)) {
			this.setVisible(false);
			new LoginActivity().setVisible(true);
		}
		else if (ae.getSource().equals(buttonBack)) {
			this.setVisible(false);
			activity.setVisible(true);
		}
		else if (ae.getSource().equals(buttonAdd)) {
			try {
				Employee e = new Employee(employeeIdTF.getText().trim());
				e.setPassword(passwordTF.getText().trim());
				e.setEmployeeName(employeeNameTF.getText().trim());
				e.setPhoneNumber(Integer.parseInt(employeePhoneTF2.getText()));
				e.setSalary(Double.parseDouble(salaryTF.getText()));
				e.setRole(roleCB.getSelectedItem().toString());
				e.createEmployee();
				employeeIdTF.setText("");
				employeeNameTF.setText("");
				employeePhoneTF2.setText("");
				salaryTF.setText("");
				roleCB.setSelectedIndex(0);
				if (!activity.keywordTF.getText().trim().isEmpty())
					activity.table.setModel(Employee.searchEmployee(activity.keywordTF.getText().trim(), activity.byWhatCB.getSelectedItem().toString()));
				else
					activity.table.setModel(Employee.searchEmployee("", "By Name"));
			}
			catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(this,"Numero non corretto!"); 
			}
			catch (IllegalArgumentException e) {
				JOptionPane.showMessageDialog(this,e.getMessage()); 
			}
		}
		else if (ae.getSource().equals(buttonRandom)) {
			passwordTF.setText(""+(r.nextInt(89999999)+10000000));
		}
		else {}
	}
}
