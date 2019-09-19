package Week_02;

    import java.awt.AWTException;

	import java.io.FileInputStream;

	import java.io.IOException;

	import java.util.ArrayList;

	import java.util.Properties;

	import org.openqa.selenium.JavascriptExecutor;

	import org.openqa.selenium.WebDriver;

	import org.testng.annotations.AfterMethod;

    import org.testng.annotations.BeforeClass;

	import org.testng.annotations.BeforeMethod;

	import org.testng.annotations.Test;

	import com.training.generics.ScreenShot;

	import com.training.pom.ProductPOM;

	import com.training.pom.RegisterPOM;

	import com.training.pom.OrderDetailsPOM;

	import com.training.pom.SalesPOM;

	import com.training.pom.LoginPOM;

	import com.training.utility.DriverFactory;

	import com.training.utility.DriverNames;

	public class RTTC_045  extends RTTC_044{
		private WebDriver driver;
		private String baseUrl2;
		private RegisterPOM RegisterPOM;
		private OrderDetailsPOM OrderDetailsPOM;
		private SalesPOM SalesPOM;
		private LoginPOM LoginPOM;
		private static Properties properties;
		private ScreenShot screenShot;

		@BeforeClass
		public static void setUpBeforeClass() throws IOException {
			properties = new Properties();
			FileInputStream inStream = new FileInputStream("./resources/others.properties");
			properties.load(inStream);
		}
		
		@BeforeMethod
		//All data
		public void setUp() throws Exception {
			driver = DriverFactory.getDriver(DriverNames.CHROME);
			new ProductPOM(driver);
			new SalesPOM(driver);
			RegisterPOM = new RegisterPOM(driver);
			OrderDetailsPOM = new OrderDetailsPOM(driver);
			SalesPOM = new SalesPOM(driver);
			LoginPOM = new LoginPOM(driver);
			baseUrl2 = properties.getProperty("baseURL2");
			screenShot = new ScreenShot(driver); 
			// open the browser 
			driver.get(baseUrl2);
		}
	
		@AfterMethod
		public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
		}

		@Test
		public void validLoginTest() throws InterruptedException, AWTException {
			//Register
			screenShot.captureScreenShot("login page");
			System.out.println("1.Navigated to Login page");
			RegisterPOM.Register();
			screenShot.captureScreenShot("Register page");
			System.out.println("2.Clicked on Register Link");
		
			//giving all the details to Register
			RegisterPOM.FirstName();
			RegisterPOM.LastName();
			RegisterPOM.Email();
			RegisterPOM.Telephone();
			RegisterPOM.Address1();
			RegisterPOM.City();
			RegisterPOM.PostCode();
			RegisterPOM.Region_State();
			RegisterPOM.Password();
			RegisterPOM.Password_Confirm();
			RegisterPOM.agree();
			Thread.sleep(1000);
			System.out.println("3.Entered all Required Register details");
			screenShot.captureScreenShot("Register details page");
			RegisterPOM.continue_button();
			Thread.sleep(5000);
			
			//validating the account created message
			RegisterPOM.account_created();
			Thread.sleep(5000);
			System.out.println("4.Validated the account created message");
			screenShot.captureScreenShot("account created message");
			
			//click on home
			System.out.println("5.Clicked on home");
			RegisterPOM.Home();
			Thread.sleep(1500);
			screenShot.captureScreenShot("navigated to Home ");

			//scroll down
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollTo(0, document.body.scrollHeight)");	

			//click on product
			System.out.println("6.clicked on the product");
			OrderDetailsPOM.Product();
			screenShot.captureScreenShot("Product page");

			//click on cart
			System.out.println("7.clicked on the Add to cart");
			OrderDetailsPOM.AddtoCart();
			Thread.sleep(1000);
			driver.navigate().refresh();
			screenShot.captureScreenShot("Add to cart page");
		
			//go to cart
			System.out.println("8.clicked on the Go to cart");
			OrderDetailsPOM.GotoCart();
			screenShot.captureScreenShot("Go to cart page");

			//click on checkout
			System.out.println("9.clicked on the Checkout");
			OrderDetailsPOM.Checkout();
			screenShot.captureScreenShot("Checkout page");

			//click on I want to use an existing address===continue==billing details
			System.out.println("10.checked billing detials and clicked continue");
			OrderDetailsPOM.BillingAd();
			Thread.sleep(1000);
			OrderDetailsPOM.BillingAddress();
			screenShot.captureScreenShot("billing detials page");

			//Click on i want to use an existing address==continue==Delivery details
			System.out.println("11.checked Delivery details and clicked continue");
			OrderDetailsPOM.ShippingAd();
			Thread.sleep(1000);
			OrderDetailsPOM.DeliveryAddress();
			screenShot.captureScreenShot("Delivery details page");
			
			//give details in comment box==delivery method
			System.out.println("12.Given delivery method comments and clicked continue");
			OrderDetailsPOM.Comment1();
			Thread.sleep(1000);
			OrderDetailsPOM.DeliveryComment();
			screenShot.captureScreenShot("delivery method comments page");
			
			//scroll down
			JavascriptExecutor js1 = (JavascriptExecutor) driver;
			js1.executeScript("window.scrollTo(0, document.body.scrollHeight)");	
			
			//give details in comment box==payment method
			System.out.println("13.Given payment method comments and clicked continue");
			OrderDetailsPOM.Comment2();
			Thread.sleep(1000);
			OrderDetailsPOM.PaymentComment();
			screenShot.captureScreenShot("payment method comments page");

			//click on agree
			System.out.println("14.clicked on agree");
			OrderDetailsPOM.agree();
			screenShot.captureScreenShot("agree page");

			//click on continue
			System.out.println("15.clicked on continue");
			OrderDetailsPOM.Continue();
			
			//confirm order
			System.out.println("16.clicked on confirm order");
			OrderDetailsPOM.ConfirmOrder();
			screenShot.captureScreenShot("Confirm order page");

			//order placed message
			System.out.println("17.order placed successfully and validated the success message");
			OrderDetailsPOM.OrderPlaced();
			screenShot.captureScreenShot("success message");

			//go to my orders
			System.out.println("18.clicked on my orders and placed order is displayed");
			OrderDetailsPOM.MyOrders();
			screenShot.captureScreenShot("Order details");
		
			//go to new chrome tab --admin URL
			 ((JavascriptExecutor) driver).executeScript("window.open('http://retail.upskills.in/admin/');");
			 ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
			 driver.switchTo().window(tabs.get(1));
			 System.out.println("19.Opened new tab to login as admin");
		
			 
			//Login with credentials
			screenShot.captureScreenShot("login page");
			Thread.sleep(3000);
			LoginPOM.sendUserName("admin");
			LoginPOM.sendPassword("admin@123");	
			LoginPOM.clickLoginBtn(); 
			System.out.println("20.Login as Admin");
			Thread.sleep(3000);
		
			//Click ok dashboard
			System.out.println("21.Clicked on Dashboard");
			SalesPOM.Dashborad();
			screenShot.captureScreenShot("DashBoard page");
			
			//click on sales
			System.out.println("22.Clicked on Sales");
			SalesPOM.Sales();
			screenShot.captureScreenShot("clicked on Sales Link");
				
			//displaying the list
			System.out.println("23.Displayed all the list");
			SalesPOM.DisplayList();
			screenShot.captureScreenShot("List under sales Link");
			
			//click on orders
			System.out.println("24.clicked on orders");
			SalesPOM.Orders();
			screenShot.captureScreenShot("Orders Link");
			
			//give cutomer details
			System.out.println("25.Given customer details");
			SalesPOM.Customer();
			screenShot.captureScreenShot("customer details");

			//Give filter
			System.out.println("26.Clicked on filter");
			SalesPOM.Filter();
								
			//click on the view of the order
			System.out.println("27.clicked on View Order");
			SalesPOM.View();
			Thread.sleep(1000);
			
			//click on invoice
			System.out.println("28.Clicked on Generate invoice");
			SalesPOM.GenerateInvoice();
			Thread.sleep(1000);
			screenShot.captureScreenShot("Generate invoice");


		}

	}