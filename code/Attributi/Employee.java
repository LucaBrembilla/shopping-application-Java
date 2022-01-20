package Attributi;

import java.util.*;
import java.lang.*;
import java.sql.*;
import javax.swing.*;
import javax.swing.table.*;
import Attributi.*;
import Activity.*;

/**
 * 
 */
public class Employee extends User {
	private String employeeName;
	private String phoneNumber;
	private String role;
	public static String[] columnNames = {"EmployeeID", "EmployeeName", "PhoneNumber", "Role", "Salary"};
	public static String[] columnName = {"PurchaseID", "CustomerID", "ProductID", "ProductName", "Amount", "Cost", "Date"};
	public static String[] roles = {"General", "Manager"};
	private double salary;
	public Employee(String userId) {
		super(userId);
		this.setStatus(0);
	}
	
	public void setEmployeeName(String name) {
		if (!name.isEmpty())
			this.employeeName = name;
		else
			throw new IllegalArgumentException("Fill in the name");
	}
	public void setPhoneNumber(int num) {
		this.phoneNumber = "+39"+num;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public String getEmployeeName() {
		return employeeName;
	}
	public String getRole() {
		return role;
	}
	public double getSalary() {
		return salary;
	}
	
	public void createEmployee() {
		String query1 = "INSERT INTO `login` VALUES ('"+userId+"','"+password+"',"+status+");";
		String query2 = "INSERT INTO `employee` VALUES ('"+userId+"','"+employeeName+"','"+phoneNumber+"','"+role+"', "+salary+");";
		Connection con = null;
        Statement st = null;
		System.out.println(query1);
		System.out.println(query2);
        try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("driver loaded");
			con = DriverManager.getConnection(Database.HOST_URI, Database.USER, Database.PASSWORD);
			System.out.println("connection done");//connection with database established
			st = con.createStatement();//create statement
			System.out.println("statement created");
			st.execute(query1);//insert
			st.execute(query2);
			System.out.println("data inserted");
			JOptionPane.showMessageDialog(null,"Account Created!");
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
	
	public void fetch() {
		String query = "SELECT `userId`, `employeeName`, `phoneNumber`, `role`, `salary` FROM `employee` WHERE userId='"+this.userId+"';";     
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
			boolean flag = false;
			while(rs.next()) {
				this.employeeName = rs.getString("employeeName");
				this.phoneNumber = rs.getString("phoneNumber");
				this.role = rs.getString("role");
				this.salary = rs.getDouble("salary");
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
	
	public void updateEmployee(String name, int phone, String role, double salary) {
		String query = "UPDATE `employee` SET `employeeName`='"+name+"', `phoneNumber`='+39"+phone+"', `role`='"+role+"', `salary`="+salary+" WHERE `userId`='"+this.userId+"';";
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
			JOptionPane.showMessageDialog(null,"Information Updated!");
			this.employeeName = name;
			this.phoneNumber = "+39"+phone;
			this.role = role;
			this.salary = salary;
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
	
	public void deleteEmployee() {
		String query1 = "DELETE FROM `login` WHERE `userId`='"+this.userId+"';";
		String query2 = "DELETE FROM `employee` WHERE `userId`='"+this.userId+"';";
		Connection con = null;
        Statement st = null;
		System.out.println(query1);
		System.out.println(query2);
        try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("driver loaded");
			con = DriverManager.getConnection(Database.HOST_URI, Database.USER, Database.PASSWORD);
			System.out.println("connection done");//connection with database established
			st = con.createStatement();//create statement
			System.out.println("statement created");
			st.execute(query1);
			st.execute(query2);//delete
			System.out.println("data deleted");
			JOptionPane.showMessageDialog(null,"Account Deleted!");
			this.userId = "";
			this.employeeName = "";
			this.phoneNumber = "";
			this.role = "";
			this.salary = 0;
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
	
	public static DefaultTableModel searchEmployee(String keyword, String byWhat) {
		DefaultTableModel model = new DefaultTableModel();
		model.setColumnIdentifiers(columnNames);
		String query = "SELECT * FROM `employee` WHERE `userId`='"+keyword+"';";
		if (byWhat.equals("By Name"))
			query = "SELECT * FROM `employee` WHERE `employeeName` LIKE '%"+keyword+"%';";
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
				model.addRow(new Object[]{rs.getString("userId"), rs.getString("employeeName"), rs.getString("phoneNumber"), rs.getString("role"), rs.getString("salary")});
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

public DefaultTableModel AllProduct() {
	DefaultTableModel model1 = new DefaultTableModel();
	model1.setColumnIdentifiers(columnName);
	String query = "SELECT purchaseInfo.purchaseId, purchaseInfo.userId as CustomerId, purchaseInfo.productId, food.foodName AS productName, purchaseInfo.cost, purchaseInfo.amount, purchaseInfo.date FROM purchaseInfo, food WHERE  (purchaseInfo.productId=food.foodId) "
            + "UNION "
                 + "SELECT purchaseInfo.purchaseId, purchaseInfo.userId as CustomerId, purchaseInfo.productId, drink.drinkName AS productName, purchaseInfo.cost, purchaseInfo.amount, purchaseInfo.date FROM purchaseInfo, drink WHERE ( purchaseInfo.productId=drink.drinkId) ORDER BY date DESC;";
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
			String col1 = rs.getString("purchaseId");
			String col2 = rs.getString("CustomerId");
			String col3 = rs.getString("productId");
			String col4 = rs.getString("productName");
			int col5 = rs.getInt("amount");
			double col6 = rs.getDouble("cost");
			String col7 = rs.getString("date");
			model1.addRow(new Object[]{col1, col2, col3, col4, col5, col6, col7});
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
	return model1;
 }
}
