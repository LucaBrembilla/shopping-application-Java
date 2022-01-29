package Attributi;

import java.util.*;
import java.util.*;
import java.lang.*;
import java.sql.*;
import javax.swing.table.*;
import java.awt.*;
import java.text.*;
import Attributi.*;
import Activity.*;
import javax.swing.*;

public class Food extends Product {

    private String FoodName;
    private double price;
    private int quantity;
    private String Description;
    public static String[] columnNames = {"FoodID", "Name", "Price", "Quantity", "Description"};;

    public Food() {}
	public Food(String productId) {
		if (!productId.isEmpty())
			this.productId = productId;
		else
			throw new IllegalArgumentException("Inserisci un ID");
	}
	
    /**
     * @param name 
     * @return
     */
    public void setFoodName(String name) {
    	if (!name.isEmpty())
			this.FoodName = name;
		else
			throw new IllegalArgumentException("Inserisci un nome");
    }

    /**
     * @param price 
     * @return
     */
    public void setPrice(double  price) {
    	this.price = price;
    }

    /**
     * @param qnt 
     * @return
     */
    public void setQuantity(int  qnt) {
        this.quantity = qnt;
    }

    /**
     * @return
     */
    public String getFoodName() {
        return this.FoodName;
    }

    /**
     * @return
     */
    public double getPrice() {
        return this.price;
    }

    /**
     * @return
     */
    public int getQuantity() {
        return this.quantity;
    }
    
    /**
     * @return
     */
    public void fetch() {
    	String query = "SELECT `foodId`, `foodName`, `price`, `quantity`,`foodDescription` FROM `food` WHERE foodId='"+this.productId+"';";     
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
				this.FoodName = rs.getString("foodName");
				this.price = rs.getDouble("price");
				this.quantity = rs.getInt("quantity");
				this.Description = rs.getString("foodDescription");
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

    /**
     * @param uid 
     * @param amount 
     * @return
     */
    public void sellFood(String  uid, int  amount) {
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
			updateFood(this.FoodName,this.Description, this.price, this.quantity-amount);
		}
        catch(Exception ex) {
			JOptionPane.showMessageDialog(null,"Il Cliente non esiste!"); 
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
        } else {
    		JOptionPane.showMessageDialog(null,"Quantità non disponibile!"); 
    	}
    }

    /**
     * @param name 
     * @param price 
     * @param  qnt 
     * @return
     */
    public void updateFood(String  name, String description, double  price, int  qnt) {
    	String query = "UPDATE `food` SET `foodName`='"+name+"', `price`="+price+", `quantity`="+qnt+", `foodDescription`='"+description+"' WHERE `foodId`='"+this.productId+"';";
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

    /**
     * @return
     */
    public void createFood() {
    	String query = "INSERT INTO `food` (`foodName`, `price`, `quantity`,`foodDescription`) VALUES ('"+FoodName+"','"+price+"','"+quantity+"','"+Description+"');";
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

    /**
     * @param keyword 
     * @param byWhat
     */
    public static DefaultTableModel searchFood(String  keyword, String  byWhat) {
    	DefaultTableModel model = new DefaultTableModel();
		model.setColumnIdentifiers(columnNames);
		String query = "SELECT `foodId`, `foodName`, `price`, `quantity`,`foodDescription` FROM `food` WHERE `foodId`='"+keyword+"';";
		if (byWhat.equals("By Name"))
			query = "SELECT `foodId`, `foodName`, `price`, `quantity`,`foodDescription` FROM `food` WHERE `foodName` LIKE '%"+keyword+"%';";
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
				model.addRow(new Object[]{rs.getString("foodId"), rs.getString("foodName"), rs.getDouble("price"), rs.getInt("quantity"), rs.getString("foodDescription")});
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

    /**
     * @return
     */
    public void deleteFood() {
    	String query1 = "DELETE FROM `food` WHERE `foodId`='"+this.productId+"';";
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
			JOptionPane.showMessageDialog(null,"Prodotto cancellato!");
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
    

    /**
     * @param description 
     * @return
     */
    public void setDescription(String description) {
        this.Description=description;
    }

    /**
     * @return
     */
    public String getDescription() {
        return Description;
    }

}
