package com.training.pom;

import java.awt.AWTException;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class CatalogPOM {
	private WebDriver driver; 
	
	public CatalogPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	    //DashBoard
		@FindBy(id="button-menu")
		private WebElement Dashboard;
		
		//Catalog 
		@FindBy(id="menu-catalog")
		private WebElement Catalog;
		
		//Catagories
		@FindBy(xpath ="//*[@id='menu-catalog']/ul/li[1]/a")
		private WebElement Catagories;
		
		//checkbox
		@FindBy(xpath ="//*[@id='form-category']/div/table/tbody/tr[1]/td[1]/input")
		private WebElement Checkbox;
			
		//Delete
		@FindBy(xpath ="//*[@id='content']/div[1]/div/div/button")
		private WebElement Delete;
		
		
		public void Dashboard() {
			this.Dashboard.click(); 
		}
		public void Catalog() {
			this.Catalog.click(); 
		}
		public void Catagories() {
			this.Catagories.click(); 
		}
		public void Checkbox() {
			
			this.Checkbox.click();			
		}
		public void Delete() {
			
			this.Delete.click();
			
		}
		
		public void Icons_Display() {
		
			List<WebElement> Links = driver.findElements(By.tagName("a"));
			for(WebElement link:Links){
			String actual = link.getText();
			
			if (actual.equals("Categories")||actual.equals("Products")||actual.equals("Recurring Profiles"))
			{
					System.out.println("displayed  "+ actual);
			}
		  
			}
		}
		
		
		public void Product_List()		{	
			String catagorylist;
			List<WebElement> list = driver.findElements(By.xpath(("//*[@id='form-category']/div/table/thead")));
			for (int i=0;i<list.size();i++){
			catagorylist= list.get(i).getText();
			System.out.println(catagorylist);
			}
			if (driver.findElement(By.xpath("//*[@id='form-category']/div/table/thead")).isDisplayed()){
			System.out.println("list is displyed");
			}
			else
			{
			Assert.fail();
			}
			}	
		
		// other method to get list in categories
		
	    /*String actual = driver.findElement(By.xpath("//*[@id='content']/div[2]/div[1]")).getText();
		System.out.println(actual);
	
		if (actual.contains("Category Name")  && actual.contains("Sort Order") && actual.contains("Action"))
		{
				System.out.println("displayed Category Name,Sort Order and Action");	
		}
		}*/
		
		public void Accept_Alert() throws AWTException {
			
			Alert alert= driver.switchTo().alert();
			String AlertText = alert.getText();
			System.out.println(AlertText);
			alert.accept();
			
		}
		
		public void Success_Content() {
				
			String content =driver.findElement(By.xpath("//*[@id='content']/div[2]/div[1]")).getText();
			System.out.println("The success message : "+ content);
			if (driver.findElement(By.xpath("//*[@id='content']/div[2]/div[1]")).isDisplayed()){
				System.out.println("Success: You have modified categories");
			 }
			else
			{
			 Assert.fail();
			}
			}

	}