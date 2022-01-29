package Attributi;

import java.util.*;
import java.lang.*;
import java.sql.*;
import javax.swing.table.*;
import java.awt.*;
import java.text.*;
import Attributi.*;
import Activity.*;
import javax.swing.*;

public class Drink extends Product {
    
	private String DrinkName;
	private double price;
	private int quantity;
	public static String[] columnNames = {"DrinkId", "Name", "Price", "Quantity"};;

    public Drink() {
    }
    
	public Drink(String productId) {
		if (!productId.isEmpty())
			this.productId = productId;
		else
			throw new IllegalArgumentException("Inserisci un ID");
	}

    public void setDrinkName(String name) {
		if (!name.isEmpty())
			this.DrinkName = name;
		else
			throw new IllegalArgumentException("Inserisci un nome");
    }

    public void setPrice(double price) {
		this.price = price;
    }

    public void setQuantity(int qnt) {
		this.quantity = qnt;
    }

    public String getDrinkName() {
        return this.DrinkName;
    }

    public double getPrice() {
        return this.price;
    }

    public int getQuantity() {
        return this.quantity;
    }

    public void fetch() {
    	String query = "SELECT `drinkId`, `drinkName`, `price`, `quantity` FROM `drink` WHERE drinkId='"+this.productId+"';";     
        Connection con = null;
        Statement st = null;
		ResultSet rs = null;
		System.out.println(query);
        try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("driver loaded");
			con = DriverManager.getConnection(Database.HOST_URI, Database.USER, Database.PASSWORD);
			System.out.println("connection done");//connection with database established
			st = con.createStatement();//create statement
			System.out.println("statement created");
			rs = st.executeQuery(query);//getting result
			System.out.println("results received");
			
			while(rs.next()) {
				this.DrinkName = rs.getString("drinkName");
				this.price = rs.getDouble("price");
				this.quantity = rs.getInt("quantity");
			}
		}
        catch(Exception ex) {
			System.out.println("Exception : " +ex.getMessage());
        }
        finally {
            try {
                if(rs!=null)
					rs.close();

                if(st!=null)
					st.close();

                if(con!=null)
					con.close();
            }
            catch(Exception ex) {}
        }
    }

    public void sellDrink(String uid, int amount) {
	    if(this.quantity >= amount) {
		String date = new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime());
		String query = "INSERT INTO `purchaseInfo` (`userId`, `productId`, `amount`, `date`, `cost`) VALUES ('"+uid+"','"+this.productId+"',"+amount+", '"+date+"', "+(amount*this.price)+");";
		Connection con = null;
        Statement st = null;
		System.out.println(query);
        try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("driver loaded");
			con = DriverManager.getConnection(Database.HOST_URI, Database.USER, Database.PASSWORD);
			System.out.println("connection done");//connection with database established
			st = con.createStatement();//create statement
			System.out.println("statement created");
			st.execute(query);//insert
			System.out.println("data inserted");
			updateDrink(this.DrinkName, this.price, this.quantity-amount);
		}
        catch(Exception ex) {
			JOptionPane.showMessageDialog(null,"Cliente non esistente!"); 
			System.out.println("Exception : " +ex.getMessage());
        }
        finally {
            try {
                if(st!=null)
					st.close();

                if(con!=null)
					con.close();
            }
            catch(Exception ex) {}
        }}else {
    		JOptionPane.showMessageDialog(null,"Quantità non disponibile!"); 
    	}
    }

    public void updateDrink(String name, double price, int qnt) {
		String query = "UPDATE `drink` SET `drinkName`='"+name+"', `price`="+price+", `quantity`="+qnt+" WHERE `drinkId`='"+this.productId+"';";
		Connection con = null;
        Statement st = null;
		System.out.println(query);
        try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("driver loaded");
			con = DriverManager.getConnection(Database.HOST_URI, Database.USER, Database.PASSWORD);
			System.out.println("connection done");//connection with database established
			st = con.createStatement();//create statement
			System.out.println("statement created");
			st.executeUpdate(query);//insert
			System.out.println("data inserted");
			JOptionPane.showMessageDialog(null,"Fatto!");
		}
        catch(Exception ex) {
			JOptionPane.showMessageDialog(null,"Fallito!");
			System.out.println("Exception : " +ex.getMessage());
        }
        finally {
            try {
                if(st!=null)
					st.close();

                if(con!=null)
					con.close();
            }
            catch(Exception ex) {}
        }
    }

    public void createDrink() {
		String query = "INSERT INTO `drink` (`drinkName`, `price`, `quantity`) VALUES ('"+DrinkName+"','"+price+"','"+quantity+"');";
		Connection con = null;
        Statement st = null;
		System.out.println(query);
        try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("driver loaded");
			con = DriverManager.getConnection(Database.HOST_URI, Database.USER, Database.PASSWORD);
			System.out.println("connection done");//connection with database established
			st = con.createStatement();//create statement
			System.out.println("statement created");
			st.execute(query);//insert
			System.out.println("data inserted");
			JOptionPane.showMessageDialog(null,"Creato!");
		}
        catch(Exception ex) {
			JOptionPane.showMessageDialog(null,"Fallito!");
			System.out.println("Exception : " +ex.getMessage());
        }
        finally {
            try {
                if(st!=null)
					st.close();

                if(con!=null)
					con.close();
            }
            catch(Exception ex) {}
        }
    }

    public static DefaultTableModel searchDrink(String  keyword, String  byWhat) {
		DefaultTableModel model = new DefaultTableModel();
		model.setColumnIdentifiers(columnNames);
		String query = "SELECT `drinkId`, `drinkName`, `price`, `quantity` FROM `drink` WHERE `drinkId`='"+keyword+"';";
		if (byWhat.equals("By Name"))
			query = "SELECT `drinkId`, `drinkName`, `price`, `quantity` FROM `drink` WHERE `drinkName` LIKE '%"+keyword+"%';";
		else {}
        Connection con = null;
        Statement st = null;
		ResultSet rs = null;
		System.out.println(query);
        try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("driver loaded");
			con = DriverManager.getConnection(Database.HOST_URI, Database.USER, Database.PASSWORD);
			System.out.println("connection done");//connection with database established
			st = con.createStatement();//create statement
			System.out.println("statement created");
			rs = st.executeQuery(query);//getting result
			System.out.println("results received");
			
			while(rs.next()) {
				model.addRow(new Object[]{rs.getString("drinkId"), rs.getString("drinkName"), rs.getDouble("price"), rs.getInt("quantity")});
			}
		}
        catch(Exception ex) {
			System.out.println("Exception : " +ex.getMessage());
        }
        finally {
            try {
                if(rs!=null)
					rs.close();

                if(st!=null)
					st.close();

                if(con!=null)
					con.close();
            }
            catch(Exception ex) {}
        }
		return model;
    }

    public void deleteDrink() {
		String query1 = "DELETE FROM `drink` WHERE `drinkId`='"+this.productId+"';";
		Connection con = null;
        Statement st = null;
		System.out.println(query1);
        try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("driver loaded");
			con = DriverManager.getConnection(Database.HOST_URI, Database.USER, Database.PASSWORD);
			System.out.println("connection done");//connection with database established
			st = con.createStatement();//create statement
			System.out.println("statement created");
			st.execute(query1);//delete
			System.out.println("data deleted");
			JOptionPane.showMessageDialog(null,"Prodotto Cancellato!");
		}
        catch(Exception ex) {
			JOptionPane.showMessageDialog(null,"Fallito!");
			System.out.println("Exception : " +ex.getMessage());
        }
        finally {
            try {
                if(st!=null)
					st.close();

                if(con!=null)
					con.close();
            }
            catch(Exception ex) {}
        }
	}   



}
