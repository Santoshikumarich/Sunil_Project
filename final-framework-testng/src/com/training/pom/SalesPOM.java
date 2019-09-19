package com.training.pom;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class SalesPOM {
	private WebDriver driver; 
	
	public SalesPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	
	//click on sales
	@FindBy(xpath="//*[@id='menu-sale']/a/span")
	private WebElement Sales; 
	
	//click on orders
	@FindBy(xpath="//*[@id='menu-sale']/ul/li[1]/a")
	private WebElement Orders; 
	
	//click on Customer
	@FindBy(xpath="//*[@id='input-customer']")
	private WebElement Customer;
	
	//click on View
	@FindBy(xpath="//*[@id='form-order']/div/table/tbody/tr[1]/td[8]/a[1]")
	private WebElement View;
	
	//click on generate invoice
	@FindBy(xpath="//*[@id='button-invoice']")
	private WebElement GenerateInvoice;
	
	@FindBy(xpath ="//*[@id='button-filter']")
	private WebElement Filter;
		
	//get the invoice number
	@FindBy(xpath="//*[@id='invoice']")
	private WebElement InvoiceNumber;
	
	//dashborad
	@FindBy(xpath="//*[@id='button-menu']")
	private WebElement Dashborad;
	
	//Addhistorys
	@FindBy(xpath="//*[@id='button-history']")
	private WebElement Addhistory;
	
	//Add api
		@FindBy(xpath="//*[@id='button-ip-add']")
		private WebElement AddAPI;
	
	public void AddAPI() {
			this.AddAPI.click();
			
		}

	public void Addhistory() {
		this.Addhistory.click();
		
	}
	
	public void Dashborad() {
		this.Dashborad.click();
		
	}
	
	public void OrderStatuslist() {
		
		String s= driver.findElement(By.xpath("//*[@id='input-order-status']")).getText();
        System.out.println("The list under order status is :"+ s);
   	
	}
	
	public void Complete() {
		
		Select dropdownValue= new Select(driver.findElement(By.xpath("//*[@id='input-order-status']")));
		dropdownValue.selectByIndex(3);
			
	}
	
	
	
	public void View() {
		this.View.click();
		
	}
	public void Filter() {
		this.Filter.click();
		
	}
	public void GenerateInvoice() {
		this.GenerateInvoice.click();
		
	}
	
	public void Success_Content() {
		
		String content =driver.findElement(By.xpath("//*[@id='tab-history']/div[1]")).getText();
		System.out.println("The success message : "+ content);
		if (driver.findElement(By.xpath("//*[@id='tab-history']/div[1]")).isDisplayed()){
			System.out.println("Success: You have modified categories");
		 }
		else
		{
		 Assert.fail();
		}
		}
	

	public void InvoiceNumber() {
		
		String Invoice_details =driver.findElement(By.xpath("//*[@id='invoice']")).getText();
		System.out.println("The gernerated invoice number is :" + Invoice_details);
		
	}

	public void Sales() {
		this.Sales.click();
		
	}

	public void Customer() {
		this.Customer.sendKeys("Test Retails");
		
	}
	
	public void Orders() {
		this.Orders.click();
		
	}
	
	public void DisplayList() {
		
		List<WebElement> Links = driver.findElements(By.tagName("a"));
		for(WebElement link:Links){
		String actual = link.getText();
		
		if (actual.equals("Orders")||actual.equals("Recurring Profiles")||actual.equals("Returns")||actual.equals("Gift Vouchers"))
		{
				System.out.println("displayed  "+ actual);
		}
	  
		}
	}}