package Week_02;

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

	public class RTTC_043  {
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
			Thread.sleep(3000);
	
			//Click ok dashboard
			CatalogPOM.Dashboard();
			System.out.println("1.DashBoard is clicked");
			screenShot.captureScreenShot("DashBoard page");
		
			//click on catalog
			CatalogPOM.Catalog();
			System.out.println("2.Catalog is clicked");
			screenShot.captureScreenShot("Catalog Menu");
			
			//verify Categories,Products,Recurring Profiles is displaying
			CatalogPOM.Icons_Display();
			System.out.println("3.displayed Categories,Products,Recurring Profiles");
			Thread.sleep(3000);
			
			//click on Product
			ProductPOM.Product();
			System.out.println("4.Product is clicked");
			screenShot.captureScreenShot("Product page");
		  
			//click on edit icon of a product
			ProductPOM.Edit_icon();	
			System.out.println("5.Product edit icon is clicked");
			screenShot.captureScreenShot("Edit icon ");

			//click on data link
			ProductPOM.data();
			System.out.println("6.edit page is displayed");
			screenShot.captureScreenShot("data page");

			//clear the data in quantity
			ProductPOM.clear();
			String Q="50";
			ProductPOM.Quantity(Q);
			System.out.println("7.cleared the value in quantity and sent value 45");
			screenShot.captureScreenShot("quantity");
			Thread.sleep(3000);
		
			//clicking on all the links
			ProductPOM.Links();
			Thread.sleep(1000);
			ProductPOM.Atribute();
			Thread.sleep(1000);
			ProductPOM.Option();
			Thread.sleep(1000);
			ProductPOM.Recurring();
			Thread.sleep(1000);
			ProductPOM.Discount();
			Thread.sleep(1000);
			ProductPOM.Special();
			Thread.sleep(1000);
			ProductPOM.Image();
			Thread.sleep(1000);
			ProductPOM.RewardPoints();
			Thread.sleep(1000);
			ProductPOM.Design();
			Thread.sleep(1000);
			System.out.println("8.Clicked on all the other Links");
			
			//click on savE
			ProductPOM.save();
			System.out.println("9.click on save");
			screenShot.captureScreenShot("save");
			Thread.sleep(1500);

			//success content verify
			ProductPOM.Success_Content();
			System.out.println("10.success message");
			Thread.sleep(1000);
			screenShot.captureScreenShot("Final message validation");

		}

	}