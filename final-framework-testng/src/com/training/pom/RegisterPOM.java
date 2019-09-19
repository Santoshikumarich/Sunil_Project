package com.training.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class RegisterPOM {
	private WebDriver driver; 
	
	public RegisterPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	//Login_Register
	@FindBy(xpath="//*[@id='Menu_Wmt3OMY3']/nav/ul/li[2]/ul/li[1]/a/span")
	private WebElement Login_Register; 
	
	//Register
	@FindBy(xpath="//*[@id='System_nyHsmShk']/div/div[1]/div/div[2]/div/a")
	private WebElement Register; 
	
	//FirstName
	@FindBy(id="input-firstname")
	private WebElement FirstName; 
	
	//LastName
	@FindBy(id="input-lastname")
	private WebElement LastName; 
	
	//Email
	@FindBy(id="input-email")
	private WebElement Email; 
	
	//Telephone
	@FindBy(id="input-telephone")
	private WebElement Telephone; 
	
	//Address1
	@FindBy(id="input-address-1")
	private WebElement Address1; 
	
	//City
	@FindBy(id="input-city")
	private WebElement City; 
	
	//Region_State
	@FindBy(id="input-zone")
	private WebElement Region_State; 
		
	//Password
	@FindBy(id="input-password")
	private WebElement Password; 
	
	//Password_Confirm
	@FindBy(id="input-confirm")
	private WebElement Password_Confirm; 
		
	//agree
	@FindBy(xpath="//input[@name='agree']")
	private WebElement agree; 

	//continue_1
	@FindBy(xpath="//*[@class='btn btn-primary']")
	private WebElement continue_button; 
	
	//home
	@FindBy(xpath="//*[@id='menu_url_R28IP']/a/span")
	private WebElement Home; 
	
	@FindBy(xpath="//*[@name='postcode']")
	private WebElement PostCode; 
	
	public void PostCode() {
		this.PostCode.sendKeys("560045");
	}
	
	public void Home() {
		this.Home.click();
	}
	
	public void FirstName() {
		this.FirstName.sendKeys("Test");
	}
	
	public void LastName() {
		this.LastName.sendKeys("Retails");
	}
	public void Email() {
		this.Email.sendKeys("example@gmail.com");
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
		WebElement element=driver.findElement(By.xpath("//*[@id='input-zone']"));
		element.click();
		Select se=new Select(element);
		se.selectByVisibleText("Karnataka");
	}
	
	public void Password() {
		this.Password.sendKeys("Techcom4.0");
	}
	
	public void Password_Confirm() {
		this.Password_Confirm.sendKeys("Techcom4.0");
	}
	
	public void agree() {
		this.agree.click();
	}
	
	public void continue_button() {
		this.continue_button.click();
	}
	
	
	public void Register() throws InterruptedException {
	Actions actions = new Actions(driver);
	WebElement target = driver.findElement(By.xpath("//*[@id='Menu_Wmt3OMY3']/nav/ul/li[2]"));
	actions.moveToElement(target).perform();
	this.Login_Register.click();
	Thread.sleep(1500);
	this.Register.click();
	Thread.sleep(1500);
	}

	public void  account_created() {
		String content =driver.findElement(By.xpath("//*[@id='System_nyHsmShk']/div[1]/p[1]")).getText();
		System.out.println("The success message : "+ content);
				if (driver.findElement(By.xpath("//*[@id='System_nyHsmShk']/div[1]/p[1]")).isDisplayed()){
					System.out.println("Congratulations! Your new account has been successfully created!");
					}
					else
					{
		Assert.fail();
					}
			}	
	}
