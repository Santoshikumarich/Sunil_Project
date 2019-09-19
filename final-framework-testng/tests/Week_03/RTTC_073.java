package Week_03;

    import java.awt.AWTException;
	import java.io.FileInputStream;
	import java.io.IOException;
	import java.util.Properties;
	import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
	import org.testng.annotations.BeforeMethod;
	import org.testng.annotations.Test;

import com.training.dataproviders.LoginDataProviders;
import com.training.dataproviders.LoginDataProvidersRetail;
import com.training.generics.ScreenShot;
	import com.training.pom.CatalogPOM;
	import com.training.pom.LoginPOM;
	import com.training.pom.ProductPOM;
	import com.training.utility.DriverFactory;
	import com.training.utility.DriverNames;

	public class RTTC_073 {
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
		
		
		@Test(dataProvider = "db-inputs", dataProviderClass = LoginDataProvidersRetail.class)
		public void validLoginTest(String ProductName,String MetaTagTitle,String Model,String Price,String Quantity,String Category) throws InterruptedException, AWTException {
			
			//Login with credentials,
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
			
			//click on Add new icon
			ProductPOM.AddNew();
			Thread.sleep(1000);
			System.out.println("5.Add new is clicked");
			
			//Valid credentials in Product Name of General tab-fingerring
			ProductPOM.ProductName(ProductName);
			Thread.sleep(1000);
			System.out.println("6.Product Name is given-Finger Ring");
			screenShot.captureScreenShot("General tab-1");
			
			//Valid credentials in Meta Tag Title of General tab-Finger Ring for ladies
			String MT="Finger Ring for ladies";
			ProductPOM.MetaTagTitle(MetaTagTitle);
			Thread.sleep(1000);
			System.out.println("7. Meta Tag Title is given-Finger Ring for ladies");
			screenShot.captureScreenShot("General tab-2");
			
			//click on data link
			ProductPOM.data();
			Thread.sleep(1000);
			System.out.println("8.edit Data page is displayed");
			screenShot.captureScreenShot("data page");
			
			//Enter valid credentials in Model textbox
			ProductPOM.Model(Model);
			Thread.sleep(1000);
			System.out.println("9.Given Model -SKU-012");
			screenShot.captureScreenShot("Data page-Model");
			
			//Enter valid credentials in Price textbox
			ProductPOM.Price(Price);
			Thread.sleep(1000);
			System.out.println("10.Given Price -500");
			screenShot.captureScreenShot("Data page-Price");
			
			//Enter valid credentials in Quantity textbox
			ProductPOM.clear();
			ProductPOM.Quantity(Quantity);
			Thread.sleep(1000);
			System.out.println("11.Given Quantity -50");
			screenShot.captureScreenShot("Data page-Quantity");
			
			//clicking on links
			ProductPOM.Links();
			Thread.sleep(1500);
			System.out.println("12.Links tab is displayed");
			screenShot.captureScreenShot("Links tab");
			Thread.sleep(1000);
			
			//selecting Category from displayed category list
			ProductPOM.Categories(Category);
			Thread.sleep(1000);
			System.out.println("13.Given Categories -INDIAN");
			screenShot.captureScreenShot("Links tab-Categories");
			
			//clicking on Atribute
			ProductPOM.Atribute();
			Thread.sleep(1000);
			System.out.println("14.Atribute tab is displayed");
			screenShot.captureScreenShot("Atribute tab");
			
			//clicking on Option
			ProductPOM.Option();
			Thread.sleep(1000);
			System.out.println("15.Option tab is displayed");
			screenShot.captureScreenShot("Option tab");

			//clicking on Recurring
			ProductPOM.Recurring();
			Thread.sleep(1000);
			System.out.println("16.Recurring tab is displayed");
			screenShot.captureScreenShot("Recurring tab");
			
			//clicking on Discount
			ProductPOM.Discount();
			Thread.sleep(1000);
			System.out.println("17.Discount tab is displayed");
			screenShot.captureScreenShot("Discount tab");

			//clicking on Special
			ProductPOM.Special();
			Thread.sleep(1000);
			System.out.println("18.Special tab is displayed");
			screenShot.captureScreenShot("Special tab");

			//clicking on Image
			ProductPOM.Image();
			Thread.sleep(1000);
			System.out.println("19.Image tab is displayed");
			screenShot.captureScreenShot("Image tab");

			//clicking on RewardPoints
			ProductPOM.RewardPoints();
			Thread.sleep(1000);
			System.out.println("20.RewardPoints tab is displayed");
			screenShot.captureScreenShot("RewardPoints tab");

			//clicking on Design
			ProductPOM.Design();
			Thread.sleep(1000);
			System.out.println("21.Design tab is displayed");
			screenShot.captureScreenShot("Design tab");
			
			//Clicking on save
			ProductPOM.save();
			Thread.sleep(1000);
			System.out.println("22.Click on save");
			
			//success content verify
			ProductPOM.Success_Content();
			System.out.println("23.success message");
			screenShot.captureScreenShot("Final message validation");
			Thread.sleep(3000);
		
		
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			

		
	}
	}