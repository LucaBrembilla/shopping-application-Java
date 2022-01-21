package Activity;

import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import Attributi.*;
import Activity.*;

/**
 * 
 */
public class ManageFood extends JFrame implements ActionListener  {
	private JPanel panel;
	ViewFoodActivity prev;
	private Food product;
	private JButton buttonBack, buttonEdit, buttonDelete, buttonSell, buttonSubmit;
	private JLabel title, header, productIdLabel, productDesLabel, productNameLabel, productQtLabel, productPriceLabel, userIdLabel;
	private JTextField productIdTF, productNameTF, productDesTF, productQtTF, productPriceTF, userIdTF;
	
	public ManageFood(String pid, ViewFoodActivity prev, Customer customer) {
		super("Acquista Panino");
		
		this.setSize(500,400);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.prev = prev;
		
		product = new Food(pid);
		product.fetch();
		
		panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(Theme.BACKGROUND_PANEL);
		
		productIdLabel = new JLabel("ID Prodotto: "+ product.getProductId());
		productIdLabel.setBounds(60, 20, 140, 30);
		productIdLabel.setFont(Theme.FONT_INPUT);
		panel.add(productIdLabel);
		
		productNameLabel = new JLabel("Nome: " + product.getFoodName());
		productNameLabel.setBounds(60, 60, 200, 30);
		productNameLabel.setFont(Theme.FONT_INPUT);
		panel.add(productNameLabel);
		
		productDesLabel = new JLabel("Descrizione: " + product.getDescription());
		productDesLabel.setBounds(60, 100, 400, 30);
		productDesLabel.setFont(Theme.FONT_INPUT);
		panel.add(productDesLabel);
		
		productPriceLabel = new JLabel("Prezzo: " + product.getPrice());
		productPriceLabel.setBounds(60, 140, 140, 30);
		productPriceLabel.setFont(Theme.FONT_INPUT);
		panel.add(productPriceLabel);
		
		userIdLabel = new JLabel("ID Cliente: "+ customer.getUserId());
		userIdLabel.setBounds(60, 180, 140, 30);
		userIdLabel.setFont(Theme.FONT_INPUT);
		panel.add(userIdLabel);
		userIdTF = new JTextField(customer.getUserId());
		userIdTF.setVisible(false);
		panel.add(userIdTF);
		
		productQtLabel = new JLabel("Quantità: ");
		productQtLabel.setBounds(60, 220, 140, 30);
		productQtLabel.setFont(Theme.FONT_INPUT);
		panel.add(productQtLabel);
		
		productQtTF = new JTextField("");
		productQtTF.setBounds(180, 220, 220, 30);
		productQtTF.setFont(Theme.FONT_INPUT);
		panel.add(productQtTF);
		
		buttonSell = new JButton("Compra");
		buttonSell.setBounds(60, 260, Theme.BUTTON_PRIMARY_WIDTH,30);
		buttonSell.setFont(Theme.FONT_BUTTON);
		buttonSell.setBackground(Theme.BACKGROUND_BUTTON_PRIMARY);
		buttonSell.setForeground(Theme.COLOR_BUTTON_PRIMARY);
		buttonSell.addActionListener(this);
		panel.add(buttonSell);
		
		this.add(panel);
	}
	
	public ManageFood(String pid, ViewFoodActivity prev, Employee employee) {
		super("Gestore Panini");
		
		this.setSize(500,400);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.prev = prev;
		
		product = new Food(pid);
		product.fetch();
		
		panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(Theme.BACKGROUND_PANEL);
		
		productIdLabel = new JLabel("ID Prodotto: "+product.getProductId());
		productIdLabel.setBounds(60, 20, 140, 30);
		productIdLabel.setFont(Theme.FONT_INPUT);
		panel.add(productIdLabel);
		
		productNameLabel = new JLabel("Nome: " );
		productNameLabel.setBounds(60, 60, 140, 30);
		productNameLabel.setFont(Theme.FONT_INPUT);
		panel.add(productNameLabel);
		
		productDesLabel = new JLabel("Descrizione: " );
		productDesLabel.setBounds(60, 100, 700, 30);
		productDesLabel.setFont(Theme.FONT_INPUT);
		panel.add(productDesLabel);
		
		productPriceLabel = new JLabel("Prezzo: ");
		productPriceLabel.setBounds(60, 140, 140, 30);
		productPriceLabel.setVisible(false);
		productPriceLabel.setFont(Theme.FONT_INPUT);
		panel.add(productPriceLabel);
		
		userIdLabel = new JLabel("ID Cliente: ");
		userIdLabel.setBounds(60, 140, 140, 30);
		userIdLabel.setFont(Theme.FONT_INPUT);
		panel.add(userIdLabel);
		
		productQtLabel = new JLabel("Quantità: ");
		productQtLabel.setBounds(60, 180, 140, 30);
		productQtLabel.setFont(Theme.FONT_INPUT);
		panel.add(productQtLabel);
		
		productNameTF = new JTextField(product.getFoodName());
		productNameTF.setBounds(180, 60, 220, 30);
		productNameTF.setEnabled(false);
		productNameTF.setFont(Theme.FONT_INPUT);
		panel.add(productNameTF);
		
		productDesTF = new JTextField(product.getDescription());
		productDesTF.setBounds(180, 100, 220, 30);
		productDesTF.setEnabled(false);
		productDesTF.setFont(Theme.FONT_INPUT);
		panel.add(productDesTF);
		
		userIdTF = new JTextField("");
		userIdTF.setBounds(180, 140, 220, 30);
		userIdTF.setFont(Theme.FONT_INPUT);
		panel.add(userIdTF);
		
		productPriceTF = new JTextField(product.getPrice()+"");
		productPriceTF.setBounds(180, 140, 220, 30);
		productPriceTF.setFont(Theme.FONT_INPUT);
		productPriceTF.setVisible(false);
		panel.add(productPriceTF);
		
		productQtTF = new JTextField("");
		productQtTF.setBounds(180, 180, 220, 30);
		productQtTF.setFont(Theme.FONT_INPUT);
		panel.add(productQtTF);
		
		buttonEdit = new JButton("Modifica");
		buttonEdit.setBounds(180, 220, Theme.BUTTON_PRIMARY_WIDTH,30);
		buttonEdit.setFont(Theme.FONT_BUTTON);
		buttonEdit.setBackground(Theme.BACKGROUND_BUTTON_PRIMARY);
		buttonEdit.setForeground(Theme.COLOR_BUTTON_PRIMARY);
		buttonEdit.addActionListener(this);
		panel.add(buttonEdit);
		
		buttonSubmit = new JButton("Invia");
		buttonSubmit.setBounds(180, 220, Theme.BUTTON_PRIMARY_WIDTH,30);
		buttonSubmit.setFont(Theme.FONT_BUTTON);
		buttonSubmit.setBackground(Theme.BACKGROUND_BUTTON_PRIMARY);
		buttonSubmit.setForeground(Theme.COLOR_BUTTON_PRIMARY);
		buttonSubmit.setVisible(false);
		buttonSubmit.addActionListener(this);
		panel.add(buttonSubmit);
		
		buttonDelete = new JButton("Elimina Panino");
		buttonDelete.setBounds(300, 220, Theme.BUTTON_PRIMARY_WIDTH+40,30);
		buttonDelete.setFont(Theme.FONT_BUTTON);
		buttonDelete.setBackground(Theme.BACKGROUND_BUTTON_PRIMARY);
		buttonDelete.setForeground(Theme.COLOR_BUTTON_PRIMARY);
		buttonDelete.addActionListener(this);
		panel.add(buttonDelete);
		
		buttonSell = new JButton("Vendi");
		buttonSell.setBounds(60, 220, Theme.BUTTON_PRIMARY_WIDTH,30);
		buttonSell.setFont(Theme.FONT_BUTTON);
		buttonSell.setBackground(Theme.BACKGROUND_BUTTON_PRIMARY);
		buttonSell.setForeground(Theme.COLOR_BUTTON_PRIMARY);
		buttonSell.addActionListener(this);
		panel.add(buttonSell);
		
		this.add(panel);
	}

    public void actionPerformed(ActionEvent ae) {
		if (ae.getSource().equals(buttonSell)) {
			try {
				product.sellFood(userIdTF.getText().trim(),Integer.parseInt(productQtTF.getText()));
				if (!prev.keywordTF.getText().trim().isEmpty())
					prev.table.setModel(Food.searchFood(prev.keywordTF.getText().trim(), prev.byWhatCB.getSelectedItem().toString()));
				else
					prev.table.setModel(Food.searchFood("", "By Name"));
				this.setVisible(false);
			}
			catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(this,"Dati non Validi!"); 
			}
		}
		else if (ae.getSource().equals(buttonEdit)) {
			buttonEdit.setVisible(false);
			buttonSubmit.setVisible(true);
			buttonSell.setEnabled(false);
			productQtTF.setText(product.getQuantity()+"");
			productNameTF.setEnabled(true);
			productDesTF.setEnabled(true);
			userIdLabel.setVisible(false);
			userIdTF.setVisible(false);
			productPriceLabel.setVisible(true);
			productPriceTF.setVisible(true);
		}
		else if (ae.getSource().equals(buttonSubmit)) {
			try {
				product.updateFood(productNameTF.getText(),productDesTF.getText(),Double.parseDouble(productPriceTF.getText()),Integer.parseInt(productQtTF.getText()));
				if (!prev.keywordTF.getText().trim().isEmpty())
					prev.table.setModel(Food.searchFood(prev.keywordTF.getText().trim(), prev.byWhatCB.getSelectedItem().toString()));
				else
					prev.table.setModel(Food.searchFood("", "By Name"));
				this.setVisible(false);
			}
			catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(this,"Dati non Validi!"); 
			}
		}
		else if (ae.getSource().equals(buttonDelete)) {
			product.deleteFood();
			if (!prev.keywordTF.getText().trim().isEmpty())
				prev.table.setModel(Food.searchFood(prev.keywordTF.getText().trim(), prev.byWhatCB.getSelectedItem().toString()));
			else
				prev.table.setModel(Food.searchFood("", "By Name"));
			this.setVisible(false);
		}
		else {}
	}
}
