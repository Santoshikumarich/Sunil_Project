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
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class RTTC_013  {
	public WebDriver driver;
	private String baseUrl;
	private LoginPOM LoginPOM;
	private CatalogPOM CatalogPOM;
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
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver); 
		//open the browser 
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
		System.out.println("First step : DashBoard is clicked");
		CatalogPOM.Dashboard();
		screenShot.captureScreenShot("2.DashBoard page");

		//click on catalog
		System.out.println("3.Catalog is clicked");
		CatalogPOM.Catalog();	
		screenShot.captureScreenShot("Catalog Menu");	

		//click on catagories
		System.out.println("4.Catagories is clicked");
		CatalogPOM.Catagories();
		screenShot.captureScreenShot("Catagories");
		Thread.sleep(3000);

		//verify Categories,Products,Recurring Profiles is displaying
		System.out.println("5.Verifying Categories,Products,Recurring Profiles");
		CatalogPOM.Icons_Display();	
	
		//verify page contains Category Name, Sort Order & Actions for list of categories
		System.out.println("6.Verifying Category Name, Sort Order and Actions");
		CatalogPOM.Product_List();

		//click on check box
		System.out.println("7.Checkbox is clicked");
		CatalogPOM.Checkbox();
		screenShot.captureScreenShot("Checkbox");
		Thread.sleep(3000);

		//click on delete
		System.out.println("8.delete is clicked");
		CatalogPOM.Delete();
		Thread.sleep(3000);

		//accept the alert
		System.out.println("9.Accepted alert");
		CatalogPOM.Accept_Alert();
		screenShot.captureScreenShot("Accepted Alert");

		//success content verify
		System.out.println("10.success message");
		CatalogPOM.Success_Content();
		screenShot.captureScreenShot("Final message validation");

	}

}