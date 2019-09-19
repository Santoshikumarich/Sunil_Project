package com.training.dataproviders;

import java.util.List;
import org.testng.annotations.DataProvider;
import com.training.bean.LoginBean;
import com.training.bean.ProductDetailsBean;
import com.training.dao.RetailDAO;
import com.training.readexcel.ApachePOIExcelRead;
import com.training.readexcel.ReadExcel;

public class LoginDataProvidersRetail {

	@DataProvider(name = "db-inputs")
	public Object [][] getDBData() {

		List<ProductDetailsBean> list = new RetailDAO().getProductDetails(); 
		
		Object[][] result = new Object[list.size()][]; 
		int count = 0; 
		for(ProductDetailsBean temp : list){
			Object[]  obj = new Object[6]; 
			obj[0] = temp.getProductName();
			obj[1] = temp.getMetaTagTitle();
			obj[2] = temp.getModel();
			obj[3] = temp.getPrice();
			obj[4] = temp.getQuantity();
			obj[5] = temp.getCategory();
			
			result[count ++] = obj; 
		}
		
		
		return result;
	}
	
	@DataProvider(name = "excel-inputs")
	public Object[][] getExcelData(){
		String fileName ="C:\\Users\\ChakkaKumari\\Desktop\\TestData.xlsx"; 
		String Sheet = "Sheet1";
		return new ApachePOIExcelRead().getExcelContent(fileName,Sheet); 
	}
	
	@DataProvider(name = "xls-inputs")
	public Object[][] getXLSData(){
		// ensure you will have the title as first line in the file 
		return new ReadExcel().getExcelData("C:/Users/Naveen/Desktop/Testing.xls", "Sheet1"); 
	}
}
