package testCase;

import java.time.Duration;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import base.DriverSetup;

//Verify the page title
public class TC003 extends DriverSetup {

	public static String baseUrl = "http://automationpractice.com/index.php";
	
	
	@Test(priority=1)
	public void verifyPageTitle_ShoudBePass()
	{
		driver.get(baseUrl);
		new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.manage().window().maximize();
		
		String GetTitleFromWebsite = driver.getTitle();
		System.out.println("Website Title is: "+GetTitleFromWebsite);
	}
	
	
	@Test(priority=2)
	public static void WebsiteSecurityStatus()
	{
		String x = driver.getCurrentUrl();
		if(x.contains("https"))
		{
			System.out.println("This website is secured");
		}
		else
		{
			System.out.println("This website is not secured");
		}
	}

}
