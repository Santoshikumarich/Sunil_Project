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
		public class RTTC_014  {
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
			Thread.sleep(3000);
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
			System.out.println("5.Product is clicked");
			screenShot.captureScreenShot("Product page");

		     //give product name
			 ProductPOM.Product_Name();
			 System.out.println("6.Product name is searched");
			 screenShot.captureScreenShot("Produt name");
			 Thread.sleep(3000);
			 
		     //click on filter
		     ProductPOM.Filter();
		     Thread.sleep(3000);
		     System.out.println("7.filter is clicked");
		     screenShot.captureScreenShot("filtered Product");

		     //Verify the filtered model
		     ProductPOM.Model_Display();
		     System.out.println("8.Model is displayed");
		     screenShot.captureScreenShot("DashBoard page");

		     //give price
		     String P="500";
		     ProductPOM.Price(P);
		     System.out.println("9.Product with Price is searched");
			 screenShot.captureScreenShot("DashBoard page");

		     //click on filter
		     ProductPOM.Filter();
		     System.out.println("10.filter is clicked");
			 screenShot.captureScreenShot("filtered Product");
		     Thread.sleep(3000);
		     
		     //Verify the filtered model
		     ProductPOM.Model_Display_Price();
		     System.out.println("11.final product ");
		     screenShot.captureScreenShot("Final Product");
			

		}

	}