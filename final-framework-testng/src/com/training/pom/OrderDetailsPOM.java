package com.training.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import org.testng.Assert;

public class OrderDetailsPOM {
	private WebDriver driver; 
	
	public OrderDetailsPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}

	//click on guest radio button
	@FindBy(xpath="//*[@id='collapse-checkout-option']/div/div/div[1]/div[1]/div/div[2]/label/input")
	private WebElement GuestCheckout; 
	
	//click on product
	@FindBy(xpath="//*[@id='BestsellerProducts_Yllc2v2l']/div/div/div[2]/div/div[3]/div/div/div[1]/h4/a")
	private WebElement Product; 
	
	//click on add to cart
	@FindBy(xpath="//*[@id='button-cart']")
	private WebElement AddtoCart; 
	
	//click on Go to cart
	@FindBy(xpath="//*[@id='cart']/ul/li/h3/a")
	private WebElement GotoCart; 
	
	//checkout
	@FindBy(xpath="//*[@id='System_V2Exp1o9']/div[3]/div[2]/a")
	private WebElement Checkout; 
	
	//billing AD
	@FindBy(xpath="//*[@id='button-payment-address']")
	private WebElement BillingAddress; 
	
	//Shipping AD
	@FindBy(xpath="//*[@id='button-shipping-address']")
	private WebElement DeliveryAddress; 
	
	//shipping Comment
	@FindBy(xpath="//*[@id='button-shipping-method']")
	private WebElement DeliveryComment; 
	
	//payment comment
	@FindBy(xpath="//*[@id='button-payment-method']")
	private WebElement PaymentComment; 
	
	//agree
	@FindBy(xpath="//*[@name='agree']")
	private WebElement agree; 
	
	//payment continue
	@FindBy(xpath="//*[@id='button-payment-method']")
	private WebElement Continue; 
	
	//confirm order
	@FindBy(xpath="//*[@id='button-confirm']")
	private WebElement ConfirmOrder; 
	
	//view order
	@FindBy(xpath="//*[@id='System_mY98YHaM's]/div[1]/table/tbody/tr[1]/td[7]/a")
	private WebElement ViewOrder; 
	
	//go to my orders
	@FindBy(xpath="//*[@id='Menu_Wmt3OMY3']/nav/ul/li[2]/ul/li[3]/a/span")
	private WebElement MyOrders; 
	
	//radio button1
	@FindBy(xpath="//*[@id='collapse-payment-address']/div/div[1]/label/input")
	private WebElement RadioBtn1; 
	
	//radio button2
	@FindBy(xpath="//*[@id='collapse-shipping-address']/div/div[1]/label/input")
	private WebElement RadioBtn2; 
	
	//Delivery method comment
	@FindBy(xpath="//*[@id='collapse-shipping-method']/div/p[4]/textarea")
	private WebElement Comment1; 
		
	//shipping method comment
	@FindBy(xpath="//*[@id='collapse-payment-method']/div/p[3]/textarea")
	private WebElement Comment2; 
	
	//Delivery method comment
	@FindBy(xpath="//*[@id='button-account']")
	private WebElement Continue_1; 
	
	//shipping method comment
	@FindBy(xpath="//*[@id='button-guest']")
	private WebElement Continue_2; 
	
	
	public void Continue_1() {
		this.Continue_1.click();
		
	}
	
	public void Continue_2() {
		this.Continue_2.click();
		
	}
	
	public void Comment1() {
		this.Comment1.sendKeys("need fast delivery");
		
	}
	
	public void GuestCheckout() {
		this.GuestCheckout.click();
		
	}
	public void Comment2() {
		this.Comment2.clear();
		this.Comment2.sendKeys("Paid");
		
	}
	
	public void ViewOrder() {
		this.ViewOrder.click();
		
	}
	
	public void Details() {
		
		String Order_details =driver.findElement(By.xpath("//*[@id='invoice']")).getText();
		System.out.println(Order_details);
	}
	
	public void ConfirmOrder() {
		this.ConfirmOrder.click();
		
	}
	
	public void Continue() {
		this.Continue.click();
		
	}
	
	public void agree() {
		this.agree.click();
		
	}
	public void PaymentComment() {
		this.PaymentComment.click();
		
	}
	public void DeliveryComment() {
		this.DeliveryComment.click();
		
	}
	public void BillingAddress() {
		boolean radioBtnIsSelected = RadioBtn1.isSelected();
        System.out.println("I want to use an existing address : "+radioBtnIsSelected);
		this.BillingAddress.click();
		
	}
	public void DeliveryAddress() {
		boolean radioBtnIsSelected = RadioBtn2.isSelected();
        System.out.println("I want to use an existing address : "+radioBtnIsSelected);
		this.DeliveryAddress.click();
		
	}
	
	public void  BillingAd() {
		String BillingAd =driver.findElement(By.xpath("//*[@id='payment-existing']/select")).getText();
		System.out.println("The Billing address is : "+ BillingAd);
	}
	
	public void  ShippingAd() {
		String ShippingAd =driver.findElement(By.xpath("//*[@id='shipping-existing']/select")).getText();
		System.out.println("The Shipping address is : "+ ShippingAd);
	}
	
	public void Checkout() {
		this.Checkout.click();
	}
	
	public void Product() {
			this.Product.click();
		}
	
	
	public void AddtoCart() {
			this.AddtoCart.click();
			
		}
	
	
	public void GotoCart() throws InterruptedException {
		this.GotoCart.click();
		}

	
	public void  OrderPlaced() {
		String content =driver.findElement(By.xpath("//*[@id='System_mY98YHaM']/div[1]/p[1]")).getText();
		System.out.println("The success message : "+ content);
				if (driver.findElement(By.xpath("//*[@id='System_mY98YHaM']/div[1]/p[1]")).isDisplayed()){
					System.out.println("Your order has been successfully processed!");
					}
					else
					{
		Assert.fail();
					}
			}	
	

	public void MyOrders() throws InterruptedException {
		Actions actions = new Actions(driver);
		WebElement target = driver.findElement(By.xpath("//*[@id='Menu_Wmt3OMY3']/nav/ul/li[2]"));
		actions.moveToElement(target).perform();
		this.MyOrders.click();
		Thread.sleep(1500);
		
		}
	
	
	
}