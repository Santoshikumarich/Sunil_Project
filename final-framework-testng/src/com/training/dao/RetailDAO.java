package com.training.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import com.training.bean.LoginBean;
import com.training.bean.ProductDetailsBean;
import com.training.connection.GetConnection;
import com.training.utility.LoadDBDetails;

// Data Access Object 
public class RetailDAO {
	
	Properties properties; 
	
	public RetailDAO() {
		 try {
			properties = new Properties();
			FileInputStream inStream = new FileInputStream("./resources/sql.properties");
			properties.load(inStream);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public List<ProductDetailsBean> getProductDetails(){
		String sql = properties.getProperty("get.ProductDetails"); 
		
		GetConnection gc  = new GetConnection(); 
		List<ProductDetailsBean> list = null;
		
		try {
			gc.ps1 = GetConnection.getMySqlConnection(LoadDBDetails.getDBDetails()).prepareStatement(sql); 
			list = new ArrayList<ProductDetailsBean>(); 
			
			gc.rs1 = gc.ps1.executeQuery(); 
			
			while(gc.rs1.next()) {
			
				ProductDetailsBean temp = new ProductDetailsBean(); 
				
				temp.setProductName(gc.rs1.getString(1));
				temp.setMetaTagTitle(gc.rs1.getString(2));
				temp.setPrice(gc.rs1.getString(3));
				temp.setModel(gc.rs1.getString(4));
				temp.setQuantity(gc.rs1.getString(5));
				temp.setCategory(gc.rs1.getString(6));
				

				list.add(temp); 
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list; 
	}
	
	public static void main(String[] args) {
		new RetailDAO().getProductDetails().forEach(System.out :: println);
	}
	
	
}
