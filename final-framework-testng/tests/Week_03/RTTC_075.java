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
import com.training.generics.ScreenShot;
import com.training.pom.ProductPOM;
import com.training.pom.RegisterPOM;
import com.training.pom.OrderDetailsPOM;
import com.training.pom.SalesPOM;
import com.training.pom.RetailPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class RTTC_075 {
	private WebDriver driver;
	private String baseUrl2;
	private RegisterPOM RegisterPOM;
	private OrderDetailsPOM OrderDetailsPOM;
	private SalesPOM SalesPOM;
	private RetailPOM RetailPOM;
	
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
		RetailPOM = new RetailPOM(driver);
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
		//Main page
		screenShot.captureScreenShot("Main page");
		System.out.println("1.Navigated to Login page");
		RetailPOM.Main();
		screenShot.captureScreenShot("Login page");
		System.out.println("2.Navigated to Login page");
		
		//Login with E-Mail Address and password
		System.out.println("3.Given Email and password");
		RetailPOM.EmailAD();
		RetailPOM.PW();
		
		//click on login
		System.out.println("4.clicked on Login");
		RetailPOM.Login();
		screenShot.captureScreenShot("Home page");
		
		//click on user icon and click on my orders
		RetailPOM.UserIcon();
		System.out.println("5.clicked on user icon");
		screenShot.captureScreenShot("Order details page");
		
		//click on view icon
		RetailPOM.ViewIcon();
		System.out.println("6.clicked on veiw icon");
		screenShot.captureScreenShot("Order details page");
		
		//click on return 
		RetailPOM.Return();
		System.out.println("7.clicked on return");
		screenShot.captureScreenShot("Return page");
			
		//click on valid Reason for Return radio button
		RetailPOM.Reason();
		System.out.println("8.Given reason");
		screenShot.captureScreenShot("Order details page");
		
		//click on radio button of Product is opened category
		RetailPOM.Further();
		System.out.println("9.Give further details");
		
		// Click on Submit button
		RetailPOM.submit();
		System.out.println("10.clicked on submit");
		screenShot.captureScreenShot(" order Details");	

		// Click on Submit button
		RetailPOM.success();
		System.out.println("11.clicked on submit");
		screenShot.captureScreenShot(" order Details");
		
		
	}
}