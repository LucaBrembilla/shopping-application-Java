package Activity;

import java.lang.*;
import javax.swing.*;
import java.awt.*;
import javax.swing.table.*;
import javax.swing.border.*;
import java.awt.event.*;
import Attributi.*;
import Activity.*;

/**
 * 
 */
public class ViewEmployeeActivity extends JFrame implements ActionListener {
	private JPanel panel;
	private JFrame activity;
	private Employee employee;
	private JScrollPane frame;
	JComboBox byWhatCB;
	JTable table;
	private JButton buttonLogout, buttonBack, buttonCheck, buttonAddEmployee;
	private JLabel title, header, keywordLabel;
	JTextField keywordTF;
	
	public ViewEmployeeActivity(JFrame prev, Employee employee) {
		super("Vista Impiegati");
		
		this.setSize(Theme.GUI_WIDTH, Theme.GUI_HEIGHT);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.activity = prev;
		
		panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(Theme.BACKGROUND_PANEL);
		
		title = new JLabel("Vista Impiegati");
		title.setBounds(30, 115, 330,75);
		title.setOpaque(true);
		title.setBorder(new EmptyBorder(0,20,0,0));
		title.setFont(Theme.FONT_TITLE);
		title.setForeground(Theme.COLOR_TITLE);
		panel.add(title);
		
		buttonLogout = new JButton("Logout");
		buttonLogout.setBounds(Theme.GUI_WIDTH-140, 115, Theme.BUTTON_PRIMARY_WIDTH,30);
		buttonLogout.setFont(Theme.FONT_BUTTON);
		buttonLogout.setBackground(Color.WHITE);
		buttonLogout.setForeground(Theme.COLOR_TITLE);
		buttonLogout.addActionListener(this);
		panel.add(buttonLogout);
		
		buttonBack = new JButton("Indietro");
		buttonBack.setBounds(Theme.GUI_WIDTH-140, 155, Theme.BUTTON_PRIMARY_WIDTH,30);
		buttonBack.setFont(Theme.FONT_BUTTON);
		buttonBack.setBackground(Theme.BACKGROUND_BUTTON_PRIMARY);
		buttonBack.setForeground(Theme.COLOR_BUTTON_PRIMARY);
		buttonBack.addActionListener(this);
		panel.add(buttonBack);
		
		buttonAddEmployee = new JButton("Aggiungi");
		buttonAddEmployee.setBounds(Theme.GUI_WIDTH-140, 190, Theme.BUTTON_PRIMARY_WIDTH, 30);
		buttonAddEmployee.setFont(Theme.FONT_BUTTON);
		buttonAddEmployee.setBackground(Theme.BACKGROUND_BUTTON_PRIMARY);
		buttonAddEmployee.setForeground(Theme.COLOR_BUTTON_PRIMARY);
		buttonAddEmployee.addActionListener(this);
		panel.add(buttonAddEmployee);
		
		keywordLabel = new JLabel("Chiave: ");
		keywordLabel.setBounds(60, 215, 140, 30);
		keywordLabel.setFont(Theme.FONT_REGULAR);
		panel.add(keywordLabel);
		
		keywordTF = new JTextField();
		keywordTF.setBounds(160, 215, 240, 30);
		keywordTF.setFont(Theme.FONT_INPUT);
		panel.add(keywordTF);
		
		byWhatCB = new JComboBox(new Object[]{"By ID", "By Name"});
		byWhatCB.setBounds(400, 215, 100,30);
		byWhatCB.setFont(Theme.FONT_INPUT);
		panel.add(byWhatCB);
		
		buttonCheck = new JButton("Cerca");
		buttonCheck.setBounds(500, 215, Theme.BUTTON_PRIMARY_WIDTH,30);
		buttonCheck.setFont(Theme.FONT_BUTTON);
		buttonCheck.setBackground(Theme.BACKGROUND_BUTTON_PRIMARY);
		buttonCheck.setForeground(Theme.COLOR_BUTTON_PRIMARY);
		buttonCheck.addActionListener(this);
		panel.add(buttonCheck);
		
		table = new JTable();
		DefaultTableModel model = new DefaultTableModel();
		model.setColumnIdentifiers(Employee.columnNames);
		table.setModel(model);
		table.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent evt) {
               jTable_ClickMouseClicked(evt);
            }
		});
		frame = new JScrollPane(table);
		frame.setBounds(40,260,600,300);
		panel.add(frame);
		
		table.setModel(Employee.searchEmployee("", "By Name"));
		
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
		else if (ae.getSource().equals(buttonAddEmployee)) {
			this.setVisible(false);
			new AddEmployeeActivity(this, employee).setVisible(true);
		}
		else if (ae.getSource().equals(buttonCheck)) {
			table.setModel(Employee.searchEmployee(keywordTF.getText().trim(), byWhatCB.getSelectedItem().toString()));
		}
		else {}
	}
	
	private void jTable_ClickMouseClicked(MouseEvent evt) {                                          
       int index = table.getSelectedRow();

       TableModel model = table.getModel();

       String value1 = model.getValueAt(index, 0).toString();
	   new ManageEmployee(value1, this).setVisible(true);
    }
}
