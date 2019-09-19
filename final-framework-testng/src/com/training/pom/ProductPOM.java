package com.training.pom;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class ProductPOM {
	private WebDriver driver; 
public ProductPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
		@FindBy(xpath ="//input[@id='input-name']")
		private WebElement Product_Name;	

	@FindBy(xpath ="//*[@id='form-product']/ul/li[3]/a")
	private WebElement Links;
	
	@FindBy(xpath ="//*[@id='form-product']/ul/li[4]/a")
	private WebElement Atribute;
	
	@FindBy(xpath ="//*[@id='form-product']/ul/li[5]/a")
	private WebElement Option;
	
	@FindBy(xpath ="//*[@id='form-product']/ul/li[6]/a")
	private WebElement Recurring;
	
	@FindBy(xpath ="//*[@id='form-product']/ul/li[7]/a")
	private WebElement Discount;

	@FindBy(xpath ="//*[@id='form-product']/ul/li[8]/a")
	private WebElement Special;

	@FindBy(xpath ="//*[@id='form-product']/ul/li[9]/a")
	private WebElement Image;

	@FindBy(xpath ="//*[@id='form-product']/ul/li[10]/a")
	private WebElement RewardPoints;

	@FindBy(xpath ="//*[@id='form-product']/ul/li[11]/a")
	private WebElement Design;

	@FindBy(xpath ="//*[@id='menu-catalog']/ul/li[2]/a")
	private WebElement Product;
	
	//data link
	@FindBy(xpath ="//*[@id='form-product']/ul/li[2]/a")
	private WebElement data;
	
	//click on save
	@FindBy(xpath ="//*[@id='content']/div[1]/div/div/button/i")
	private WebElement save;
	
	//click on AddNew
	@FindBy(xpath ="//*[@id='content']/div[1]/div/div/a")
	private WebElement AddNew;
	
	//click on ProductName
	@FindBy(xpath ="//*[@id='input-name1']")
	private WebElement ProductName;
	
	//click on MetaTagTitle
	@FindBy(xpath ="//*[@id='input-meta-title1']")
	private WebElement MetaTagTitle;
	
	@FindBy(xpath ="//*[@id='button-filter']")
	private WebElement Filter;

	//click on Model
	@FindBy(xpath ="//*[@id='input-model']")
	private WebElement Model;
	
	//click on Price
	@FindBy(xpath ="//*[@id='input-price']")
	private WebElement Price;
	
	//clear quantity data
	@FindBy(xpath ="//*[@id='input-quantity' and @name='quantity']")
	private WebElement clear;
	
	//click on Quantity
	@FindBy(xpath ="//*[@id='input-quantity']")
	private WebElement Quantity;
	
		@FindBy(xpath ="//*[@id='form-product']/div/table/tbody/tr[2]/td[1]/input")
		private WebElement Earrings;
		
		@FindBy(xpath ="//*[@id='form-product']/div/table/tbody/tr[2]/td[1]/input")
		private WebElement Earrings_1;
		
		//Delete
		@FindBy(xpath ="//*[@id='content']/div[1]/div/div/button[2]")
		private WebElement Delete;
		
		//edit icon
		@FindBy(xpath ="//*[@id='form-product']/div/table/tbody/tr[1]/td[8]/a/i")
		private WebElement Edit_icon;
		
		//click on fingerring
		@FindBy(xpath ="//*[@id='form-product']/div/table/tbody/tr[11]/td[1]/input")
		private WebElement Fingerring;

	public void Edit_icon() {
			this.Edit_icon.click();
		}
	
	public void Fingerring() {
		this.Fingerring.click();
		String content =driver.findElement(By.xpath("//*[@id='form-product']/div/table/tbody/tr[3]/td[1]/input")).getText();
		//System.out.println("clicked on " + content);
		if ( content.equals("Finger Ring")){
				System.out.println("checked Finger ring");
		}
		else{
			Assert.fail();
		}
	}
	
	
	
	public void Product_Name() {
		this.Product_Name.sendKeys("Integer vitae iaculis massa");
	}

	public void Filter() {
		this.Filter.sendKeys("Integer vitae iaculis massa");
	}
	public void Categories(String I) {
		WebElement element=driver.findElement(By.xpath("//*[@id='input-category']"));
		element.click();
		WebElement ER = driver.findElement(By.xpath("//*[@id='tab-links']/div[2]/div/ul/li/a[contains(.,'"+I+"')]"));
		 ER.click();
		
	}
	
	public void Delete() {
		this.Delete.click();
	}
	
	public void Earrings_1() {
		this.Earrings_1.click();
		String content =driver.findElement(By.xpath("//*[@id='form-product']/div/table/tbody/tr[2]/td[3]")).getText();
		System.out.println("clicked on " + content);
		if ( content.equals("Ear Rings")){
			System.out.println("checked Ear Rings");
	}
		else{
			Assert.fail();
		}

	}

	public void Earrings() {
		this.Earrings.click();
		String content =driver.findElement(By.xpath("//*[@id='form-product']/div/table/tbody/tr[2]/td[3]")).getText();
		System.out.println("clicked on " + content);
		if ( content.equals("Ear Rings")){
			System.out.println("checked Ear Rings");
	}
		else{
			Assert.fail();
		}

	}
	
	public void Accept_Alert() {
		Alert alert= driver.switchTo().alert();
		String AlertText = alert.getText();
		System.out.println(AlertText);
		alert.accept();	

	}
	public void Model_Display() {

		 boolean Model = driver.findElement(By.xpath(" //*[@id='form-product']/div/table/tbody/tr[1]/td[3]")).isDisplayed();
        System.out.println("Integer vitae iaculis massa is displayed :" + Model);

	}

	

	public void Model_Display_Price() {

		boolean Model_Final = driver.findElement(By.xpath(" //*[@id='form-product']/div/table/tbody/tr[1]/td[3]")).isDisplayed();

       System.out.println("Integer vitae iaculis massa with price is filtered :" + Model_Final);

	}
	
	public void clear()  {
		this.clear.clear();
	}

	public void Quantity(String Q) {
		this.Quantity.sendKeys("Q");
	}
	
	public void Model(String M) {
		this.Model.sendKeys("M");
	}
	
	public void MetaTagTitle(String MT) {
		this.MetaTagTitle.sendKeys("MT");
	}
	
	public void ProductName(String PN) {
		this.ProductName.sendKeys("PN");
	}
	public void AddNew() {
		this.AddNew.click();
	}
	public void Links() {
		this.Links.click();
	}
	public void Atribute() {
		this.Atribute.click();
	}
	public void Option() {
		this.Option.click();
	}
	public void Recurring() {
		this.Recurring.click();
	}
	public void Discount() {
		this.Discount.click();
	}
	public void Special() {
		this.Special.click();
	}
	public void Image() {
		this.Image.click();
	}
	public void RewardPoints() {
		this.RewardPoints.click();
	}
	public void Design() {
		this.Design.click();
	}
			
	public void save() {
		this.save.click();
	}
	public void data() {
		this.data.click();
	}	
	
	public void Product() {
		this.Product.click();
	}
	
	public void Price(String P) {
		this.Price.sendKeys("P");
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
