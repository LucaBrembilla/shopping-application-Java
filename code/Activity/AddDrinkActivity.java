package Activity;

import java.lang.*;
import javax.swing.*;
import java.awt.*;
import javax.swing.border.*;
import java.awt.event.*;
import Attributi.*;
import Activity.*;

public class AddDrinkActivity extends JFrame implements ActionListener  {
	private JPanel panel;
	private ViewDrinksActivity activity;
	private Employee employee;
	private JButton buttonLogout, buttonBack, buttonAdd;
	private JLabel title, header, productNameLabel, productQtLabel, productPriceLabel;
	private JTextField productNameTF, productQtTF, productPriceTF;
	
	public AddDrinkActivity(ViewDrinksActivity prev, Employee employee) {
		super("Aggiungi Bibite");
		
		this.setSize(Theme.GUI_WIDTH, Theme.GUI_HEIGHT);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.activity = prev;
		this.employee = employee;
		
		panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(Theme.BACKGROUND_PANEL);
		
		title = new JLabel("Aggiungi Bibite");
		title.setBounds(30, 40, 280,75);
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
		
		productNameLabel = new JLabel("Nome: ");
		productNameLabel.setBounds(60, 190, 140, 30);
		productNameLabel.setFont(Theme.FONT_REGULAR);
		panel.add(productNameLabel);
		
		productPriceLabel = new JLabel("Prezzo: ");
		productPriceLabel.setBounds(60, 240, 140, 30);
		productPriceLabel.setFont(Theme.FONT_REGULAR);
		panel.add(productPriceLabel);
		
		productQtLabel = new JLabel("Quantità: ");
		productQtLabel.setBounds(60, 290, 140, 30);
		productQtLabel.setFont(Theme.FONT_REGULAR);
		panel.add(productQtLabel);
		
		productNameTF = new JTextField();
		productNameTF.setBounds(180, 190, 220, 30);
		productNameTF.setFont(Theme.FONT_INPUT);
		panel.add(productNameTF);
		
		productPriceTF = new JTextField();
		productPriceTF.setBounds(180, 240, 220, 30);
		productPriceTF.setFont(Theme.FONT_INPUT);
		panel.add(productPriceTF);
		
		productQtTF = new JTextField();
		productQtTF.setBounds(180, 290, 220, 30);
		productQtTF.setFont(Theme.FONT_INPUT);
		panel.add(productQtTF);
		
		buttonAdd = new JButton("Aggiungi");
		buttonAdd.setBounds(60, 340, Theme.BUTTON_PRIMARY_WIDTH,30);
		buttonAdd.setFont(Theme.FONT_BUTTON);
		buttonAdd.setBackground(Theme.BACKGROUND_BUTTON_PRIMARY);
		buttonAdd.setForeground(Theme.COLOR_BUTTON_PRIMARY);
		buttonAdd.addActionListener(this);
		panel.add(buttonAdd);
		
		header = new JLabel();
		header.setBackground(Theme.BACKGROUND_HEADER);
		header.setOpaque(true);
		header.setBounds(0, 0, Theme.GUI_WIDTH, 75);
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
			new ViewDrinksActivity(new EmployeeActivity(employee.getUserId()), employee).setVisible(true);
		}
		else if (ae.getSource().equals(buttonAdd)) {
			try {
				Drink p = new Drink();
				p.setDrinkName(productNameTF.getText().trim());
				p.setPrice(Double.parseDouble(productPriceTF.getText()));
				p.setQuantity(Integer.parseInt(productQtTF.getText()));
				p.createDrink();
				productNameTF.setText("");
				productPriceTF.setText("");
				productQtTF.setText("");
				if (!activity.keywordTF.getText().trim().isEmpty())
					activity.table.setModel(Drink.searchDrink(activity.keywordTF.getText().trim(), activity.byWhatCB.getSelectedItem().toString()));
				else
					activity.table.setModel(Drink.searchDrink("", "By Name"));
			}
			catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(this,"Dati non validi!"); 
			}
			catch (IllegalArgumentException e) {
				JOptionPane.showMessageDialog(this,e.getMessage()); 
			}
		}
		else {}
	}

}