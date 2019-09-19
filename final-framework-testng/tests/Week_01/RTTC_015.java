package Week_01;

    import java.awt.AWTException;
	import java.io.FileInputStream;
	import java.io.IOException;
	import java.util.Properties;
	import org.openqa.selenium.WebDriver;
	import org.testng.annotations.AfterMethod;
	import org.testng.annotations.BeforeClass;
	import org.testng.annotations.BeforeMethod;
	import org.testng.annotations.Test;
	import com.training.generics.ScreenShot;
	import com.training.pom.CatalogPOM;
	import com.training.pom.LoginPOM;
	import com.training.pom.ProductPOM;
	import com.training.utility.DriverFactory;
	import com.training.utility.DriverNames;
		public class RTTC_015  {
		private WebDriver driver;
		private String baseUrl;
		private LoginPOM LoginPOM;
		private CatalogPOM CatalogPOM;
		private ProductPOM ProductPOM;
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
			LoginPOM = new LoginPOM(driver); 
			CatalogPOM = new CatalogPOM(driver);
			ProductPOM = new ProductPOM(driver); 
			baseUrl = properties.getProperty("baseURL");
			screenShot = new ScreenShot(driver); 
			// open the browser 
			driver.get(baseUrl);
		}
		
		@AfterMethod
		public void tearDown() throws Exception {
			Thread.sleep(1000);
			driver.quit();
		}

		@Test
		public void Test_1() throws InterruptedException, AWTException {

			//Login with credentials
			screenShot.captureScreenShot("login page");
			LoginPOM.sendUserName("admin");
			LoginPOM.sendPassword("admin@123");
			LoginPOM.clickLoginBtn(); 
			System.out.println("1.login successfull");
			Thread.sleep(3000);
		
			//Click ok dashboard
			CatalogPOM.Dashboard();
			System.out.println("2.DashBoard is clicked");
			screenShot.captureScreenShot("DashBoard page");
	
			//click on catalog
			CatalogPOM.Catalog();
			System.out.println("3.Catalog is clicked");
			screenShot.captureScreenShot("Catalog Menu");
			
			//verify Categories,Products,Recurring Profiles is displaying
			CatalogPOM.Icons_Display();
			System.out.println("4.Catalog is clicked");
			Thread.sleep(3000);

			//click on Product
			ProductPOM.Product();
			System.out.println("5.product is clicked");
			screenShot.captureScreenShot("Product page");
		     
		    //click on earring model name
			ProductPOM.Earrings();
			System.out.println("6.Ear rings product is checked");
			screenShot.captureScreenShot("Earrings  page");
		    Thread.sleep(3000);
		    
		    //click on delete
		    System.out.println("7.delete is clicked");
		    ProductPOM.Delete();	    	
	    
		 	//accept the alert
		    Thread.sleep(3000);
		    ProductPOM.Accept_Alert();
			System.out.println("8.Accepted alert");
			screenShot.captureScreenShot("Accepted Alert");
		
			//success content verify
			ProductPOM.Success_Content();
			System.out.println("9.success message");
			screenShot.captureScreenShot("Final message validation");
			Thread.sleep(3000);	

					

		}

	}

