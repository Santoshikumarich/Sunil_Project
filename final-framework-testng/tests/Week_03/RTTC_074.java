package Week_03;

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
	import com.training.pom.LoginPOM;
	import com.training.pom.RetailPOM;
	import com.training.pom.SalesPOM;
	import com.training.pom.OrderDetailsPOM;
	import com.training.utility.DriverFactory;
	import com.training.utility.DriverNames;

	public class RTTC_074{
		
		private WebDriver driver;
		private String baseUrl2;
		private LoginPOM LoginPOM;
		private RetailPOM RetailPOM;
		private SalesPOM SalesPOM;
		private OrderDetailsPOM OrderDetailsPOM;
		private static Properties properties;
		private ScreenShot screenShot;

		@BeforeClass
		public static void setUpBeforeClass() throws IOException {
			properties = new Properties();
			FileInputStream inStream = new FileInputStream("./resources/others.properties");
			properties.load(inStream);				
		}
			
		
		@BeforeMethod
		
		public void setUp() throws Exception {
			driver = DriverFactory.getDriver(DriverNames.CHROME);
			LoginPOM = new LoginPOM(driver); 
			RetailPOM = new RetailPOM(driver);
			SalesPOM = new SalesPOM(driver);
			OrderDetailsPOM = new OrderDetailsPOM(driver);
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
			
			//scroll down
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollTo(0, document.body.scrollHeight)");	
			//click on product
			System.out.println("1.clicked on the product");
			OrderDetailsPOM.Product();
			screenShot.captureScreenShot("Product page");

			//click on cart
			System.out.println("2.clicked on the Add to cart");
			OrderDetailsPOM.AddtoCart();
			Thread.sleep(1000);
			driver.navigate().refresh();
			screenShot.captureScreenShot("Add to cart page");
		
			//go to cart
			System.out.println("3.clicked on the Go to cart");
			OrderDetailsPOM.GotoCart();
			screenShot.captureScreenShot("Go to cart page");

			//click on checkout
			System.out.println("4.clicked on the Checkout");
			OrderDetailsPOM.Checkout();
			screenShot.captureScreenShot("Checkout page");

			//click on guest checkout radio button
			System.out.println("5.checked the Guest Checkout radio button");
			OrderDetailsPOM.GuestCheckout();
			screenShot.captureScreenShot("GuestCheckout page");
			
			//click continue
			System.out.println("6.click on continue");
			OrderDetailsPOM.Continue_1();
			Thread.sleep(1000);
			
			//give all the required personal details
			RetailPOM.FirstName();
			RetailPOM.LastName();
			RetailPOM.Email();
			RetailPOM.Telephone();
			RetailPOM.Address1();
			RetailPOM.City();
			RetailPOM.PostCode();
			RetailPOM.Region_State();
			screenShot.captureScreenShot("Personal details page");
			System.out.println("7.Given all personal details");
		
			//click on continue
			System.out.println("8.click on continue");
			OrderDetailsPOM.Continue_2();

			//give details in comment box==delivery method
			System.out.println("9.Given delivery method comments and clicked continue");
			OrderDetailsPOM.Comment1();
			Thread.sleep(1000);
			OrderDetailsPOM.DeliveryComment();
			screenShot.captureScreenShot("delivery method comments page");
			
			//give details in comment box==payment method
			System.out.println("10.Given payment method comments and clicked continue");
			OrderDetailsPOM.Comment2();
			screenShot.captureScreenShot("payment method comments page");
			
			//click on agree
			System.out.println("11.clicked on agree");
			OrderDetailsPOM.agree();
			screenShot.captureScreenShot("agree page");

			//click on continue
			System.out.println("12.clicked on continue");
			OrderDetailsPOM.Continue();
			
			//confirm order
			System.out.println("13.clicked on confirm order");
			OrderDetailsPOM.ConfirmOrder();
			screenShot.captureScreenShot("Confirm order page");

			//order placed message
			System.out.println("14.order placed successfully and validated the success message");
			OrderDetailsPOM.OrderPlaced();
			screenShot.captureScreenShot("success message");
			
		
			//go to new chrome tab --admin URL
			 ((JavascriptExecutor) driver).executeScript("window.open('http://retail.upskills.in/admin/');");
			 ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
			 driver.switchTo().window(tabs.get(1));
			 System.out.println("15.Opened new tab to login as admin");		
			 
			//Login with credentials
			screenShot.captureScreenShot("login page");
			Thread.sleep(3000);
			LoginPOM.sendUserName("admin");
			LoginPOM.sendPassword("admin@123");	
			LoginPOM.clickLoginBtn(); 
			System.out.println("16.Login as Admin");
			Thread.sleep(3000);
			
			//Click ok dashboard
			System.out.println("17.Clicked on Dashboard");
			Thread.sleep(1000);
			SalesPOM.Dashborad();
			screenShot.captureScreenShot("DashBoard page");
			
			//click on sales
			System.out.println("18.Clicked on Sales");
			SalesPOM.Sales();
			screenShot.captureScreenShot("clicked on Sales Link");
			
			//displaying the list
			System.out.println("19.Displayed all the list");
			SalesPOM.DisplayList();
			screenShot.captureScreenShot("List under sales Link");
			
			//click on orders
			System.out.println("20.clicked on orders");
			SalesPOM.Orders();
			screenShot.captureScreenShot("Orders Link");
			
			//click on view icon of the ordered product
			System.out.println("21.clicked on Veiw icon");
			SalesPOM.View();
			Thread.sleep(2000);
			
			//scroll down
			JavascriptExecutor js2 = (JavascriptExecutor) driver;
			js2.executeScript("window.scrollTo(0, document.body.scrollHeight)");	
						
			//click on Order Status list box
			System.out.println("22.check order status list and change to complete");
			SalesPOM.OrderStatuslist();
			SalesPOM.Complete();
			System.out.println("23.Status changed to complete");
			screenShot.captureScreenShot("Order status page");
			
			//click on Add history 
			System.out.println("24.clicked on Add history");
			SalesPOM.Addhistory();
			Thread.sleep(2000);
			
			//verify success message
			SalesPOM.Success_Content();
			Thread.sleep(2000);
			System.out.println("25.Verified success message ");
			
			//get previos winodw
			ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
			driver.switchTo().window(tabs2.get(0));
			driver.navigate().refresh();
			
			
	
				
		}
	
		
	}