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


public abstract class Product {
	
	protected String productId;

    public Product() {
    }

    public String getProductId() {
		return productId;
    }

    public abstract void fetch();

}