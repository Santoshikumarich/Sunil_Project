package com.training.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class RetailPOM {
	private WebDriver driver; 
	
	public RetailPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	//main
	@FindBy(id="//*[@id='Menu_Wmt3OMY3']/nav/ul/li[2]/a/span/span/i")
	private WebElement Main;
	
	//FirstName
	@FindBy(id="input-payment-firstname")
	private WebElement FirstName; 
	
	//LastName
	@FindBy(id="input-payment-lastname")
	private WebElement LastName; 
	
	//Email
	@FindBy(id="input-payment-email")
	private WebElement Email; 
	
	//Telephone
	@FindBy(id="input-payment-telephone")
	private WebElement Telephone; 
	
	//Address1
	@FindBy(id="input-payment-address-1")
	private WebElement Address1; 
	
	//City
	@FindBy(id="input-payment-city")
	private WebElement City; 
		
	//Postal code
	@FindBy(id="input-payment-postcode")
	private WebElement PostCode; 
	
	//Region_State
	@FindBy(id="input-zone")
	private WebElement Region_State; 
	
	//login_user
	@FindBy(xpath="//*[@id='Menu_Wmt3OMY3']/nav/ul/li[2]/a")
	private WebElement login_user; 
	
	//email ad
	@FindBy(xpath="//*[@id='input-email']")
	private WebElement EmailAD; 
	
	//password
	@FindBy(xpath="//*[@id='input-password']")
	private WebElement PW; 
	
	//login
	@FindBy(xpath="//*[@value='Login']")
	private WebElement Login; 
	
	//MyOrders
	@FindBy(xpath="//*[@id='Menu_Wmt3OMY3']/nav/ul/li[2]/ul/li[3]/a/span/text()")
	private WebElement MyOrders; 
	
	//ViewIcon
	@FindBy(xpath="//*[@id='System_mY98YHaM']/div[1]/table/tbody/tr/td[7]/a")
	private WebElement ViewIcon; 

	//Return
	@FindBy(xpath="//*[@id='System_mY98YHaM']/div/div[1]/table/tbody/tr/td[6]/a[2]")
	private WebElement Return; 
	
	//Reason
	@FindBy(xpath="//*[@id='return_request_form']/fieldset[2]/div[4]/div/div[2]/label/input")
	private WebElement Reason; 

	//further details
	@FindBy(xpath="//*[@id='input-comment']")
	private WebElement Further; 

	//submit
	@FindBy(xpath="//*[@id='return_request_form']/div/div/input")
	private WebElement submit; 
	
	
	public void success() {
		
		String content =driver.findElement(By.xpath("//*[@id='System_mY98YHaM']/div[1]/p[1]")).getText();
		System.out.println("The success message : "+ content);
		if (driver.findElement(By.xpath("//*[@id='System_mY98YHaM']/div[1]/p[1]")).isDisplayed()){
			System.out.println("Thank you for submitting your return request. Your request has been sent to the relevant department for processing.");
		 }
		else
		{
		 Assert.fail();
		}
		}
	public void submit() {
		this.submit.click();
	}
	
	public void Further() {
		this.Further.sendKeys("Return");
	}
	
	public void Reason() {
		this.Reason.click();
	}
	public void Return() {
		this.Return.click();
	}
	
	public void ViewIcon() {
		this.ViewIcon.click();
	}

	
	public void UserIcon() throws InterruptedException {
		Actions actions = new Actions(driver);
		WebElement target = driver.findElement(By.xpath("//*[@class='tb_link dropdown tb_menu_system_account_account tb_selected']/a//i"));
		actions.moveToElement(target).perform();
		this.MyOrders.click();
		Thread.sleep(1500);
	
	}
	
	
	public void EmailAD() {
		this.EmailAD.sendKeys("example@gmail.com");
	}
	
	public void PW() {
		this.PW.sendKeys("Techcom4.0");
	}
	
	public void Login() {
		this.Login.click();
	}
	
	public void login_user() throws InterruptedException {
		this.login_user.click();
	}
		
	public void Main() {
		this.Main.click();
	}
	public void PostCode() {
		this.PostCode.sendKeys("560045");
	}
	
	public void FirstName() {
		this.FirstName.sendKeys("Test");
	}
	
	public void LastName() {
		this.LastName.sendKeys("Retail");
	}
	public void Email() {
		this.Email.sendKeys("example202@gmail.com");
	}
	
	public void Telephone() {
		this.Telephone.sendKeys("8989898988");
	}
	public void Address1() {
		this.Address1.sendKeys("1234");
	}
	public void City() {
		this.City.sendKeys("Bangalore");
	}

	public void Region_State() {
		WebElement element=driver.findElement(By.id("input-payment-zone"));
		element.click();
		Select se=new Select(element);
		se.selectByVisibleText("Karnataka");
	}

	
}