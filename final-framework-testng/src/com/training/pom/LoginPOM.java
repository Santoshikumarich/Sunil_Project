package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPOM {
	private WebDriver driver; 
	
	public LoginPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	//username
	@FindBy(id="input-username")
	private WebElement Username; 
	
	//password
	@FindBy(id="input-password")
	private WebElement Password;
	
	//Login button
	@FindBy(xpath ="//*[@class='btn btn-primary']")
	private WebElement loginBtn; 
	
	//log out button
	@FindBy(xpath ="//*[@id='header']/ul/li[4]/a/span")
	private WebElement logout;

	//E-Mail Address
		@FindBy(xpath="//*[@id='input-email']")
		private WebElement EMailAddress; 

	//Password
		@FindBy(xpath="//*[@id='input-password']")
		private WebElement Password_1; 
		
		//Login button
		@FindBy(xpath ="//*[@value='Login']")
		private WebElement login; 
		
	public void EMailAddress() {
		this.EMailAddress.clear();
		this.EMailAddress.sendKeys("example199@gamil.com");
		}
		
	public void Password_1() {
		this.Password_1.clear(); 
		this.Password_1.sendKeys("Techcom4.0"); 
		} 	
		
	
	public void sendUserName(String Username) {
		this.Username.clear();
		this.Username.sendKeys(Username);
	}
	
	public void sendPassword(String Password) {
		this.Password.clear(); 
		this.Password.sendKeys(Password); 
	} 
	
	public void login() {
		this.login.click(); 
	}
	

	public void clickLoginBtn() {
		this.loginBtn.click(); 
	}
	
	public void logout() {
		this.logout.click(); 
	}

	
}
