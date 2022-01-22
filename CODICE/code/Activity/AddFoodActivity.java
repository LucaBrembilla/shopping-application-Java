package Activity;

import java.lang.*;
import javax.swing.*;
import java.awt.*;
import javax.swing.border.*;
import java.awt.event.*;
import Attributi.*;

/**
 * 
 */
public class AddFoodActivity extends JFrame implements ActionListener  {
    
    private JPanel panel;
    private ViewFoodActivity activity;
    private Employee employee;
    private JButton buttonLogout;
    private JButton buttonBack;
    private JButton buttonAdd;
    private JLabel title;
    private JLabel header;
    private JLabel productNameLabel;
    private JLabel productQtLabel;
    private JLabel productPriceLabel;
    private JTextField productNameTF;
    private JTextField productQtTF;
    private JTextField productPriceTF;
    private JLabel productDescriptionLabel;
    private JTextField productDescriptionTF;

    
	public AddFoodActivity(ViewFoodActivity prev, Employee employee) {
		super("Aggiungi Panini");
		
		this.setSize(Theme.GUI_WIDTH, Theme.GUI_HEIGHT);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.activity = prev;
		this.employee = employee;
		
		panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(Theme.BACKGROUND_PANEL);
		
		title = new JLabel("Aggiungi panino");
		title.setBounds(30, 115, 350,75);
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
		productNameLabel.setBounds(60, 265, 140, 30);
		productNameLabel.setFont(Theme.FONT_REGULAR);
		panel.add(productNameLabel);
		
		productPriceLabel = new JLabel("Prezzo: ");
		productPriceLabel.setBounds(60, 315, 140, 30);
		productPriceLabel.setFont(Theme.FONT_REGULAR);
		panel.add(productPriceLabel);
		
		productQtLabel = new JLabel("Quantità: ");
		productQtLabel.setBounds(60, 365, 140, 30);
		productQtLabel.setFont(Theme.FONT_REGULAR);
		panel.add(productQtLabel);
		
		productDescriptionLabel = new JLabel("Descrizione: ");
		productDescriptionLabel.setBounds(60, 415, 140, 30);
		productDescriptionLabel.setFont(Theme.FONT_REGULAR);
		panel.add(productDescriptionLabel);
		
		productNameTF = new JTextField();
		productNameTF.setBounds(180, 265, 220, 30);
		productNameTF.setFont(Theme.FONT_INPUT);
		panel.add(productNameTF);
		
		productPriceTF = new JTextField();
		productPriceTF.setBounds(180, 315, 220, 30);
		productPriceTF.setFont(Theme.FONT_INPUT);
		panel.add(productPriceTF);
		
		productQtTF = new JTextField();
		productQtTF.setBounds(180, 365, 220, 30);
		productQtTF.setFont(Theme.FONT_INPUT);
		panel.add(productQtTF);
		
		productDescriptionTF = new JTextField();
		productDescriptionTF.setBounds(180, 415, 220, 30);
		productDescriptionTF.setFont(Theme.FONT_INPUT);
		panel.add(productDescriptionTF);
		
		buttonAdd = new JButton("Aggiungi");
		buttonAdd.setBounds(60, 465, Theme.BUTTON_PRIMARY_WIDTH,30);
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

    /**
     * @param ae
     */
	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource().equals(buttonLogout)) {
			this.setVisible(false);
			new LoginActivity().setVisible(true);
		}
		else if (ae.getSource().equals(buttonBack)) {
			this.setVisible(false);
			new ViewFoodActivity(new EmployeeActivity(employee.getUserId()), employee).setVisible(true);
		}
		else if (ae.getSource().equals(buttonAdd)) {
			try {
				Food f = new Food();
				f.setFoodName(productNameTF.getText().trim());
				f.setPrice(Double.parseDouble(productPriceTF.getText()));
				f.setQuantity(Integer.parseInt(productQtTF.getText()));
				f.setDescription(productDescriptionTF.getText().trim());
				f.createFood();
				productNameTF.setText("");
				productPriceTF.setText("");
				productQtTF.setText("");
				productDescriptionTF.setText("");
				if (!activity.keywordTF.getText().trim().isEmpty())
					activity.table.setModel(Food.searchFood(activity.keywordTF.getText().trim(), activity.byWhatCB.getSelectedItem().toString()));
				else
					activity.table.setModel(Food.searchFood("", "By Name"));
			}
			catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(this,"Inserisci Prezzo/Quantità corretta!"); 
			}
			catch (IllegalArgumentException e) {
				JOptionPane.showMessageDialog(this,e.getMessage()); 
			}
		}
		else {}
	}

}
