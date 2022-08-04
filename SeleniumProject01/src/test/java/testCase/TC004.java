package testCase;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import base.DriverSetup;

//Radio button and Check box verification

public class TC004 extends DriverSetup {
	public static String baseUrl = "https://jqueryui.com/checkboxradio/";
	
	@Test
	public static void CheckBoxRadioButtonWidgets() throws InterruptedException
	{
		driver.get(baseUrl);
		new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.manage().window().maximize();
		
		Thread.sleep(5000);
		//Switch to frame
		driver.switchTo().frame(0);
		//Operate elements
		driver.findElement(By.xpath("//body/div[1]/fieldset[1]/label[1]")).click();
		
		Thread.sleep(5000);
		driver.findElement(By.xpath("//body[1]/div[1]/fieldset[2]/label[3]/span[2]")).click();
		
		//Back to the page
		driver.switchTo().defaultContent();
		
		//Close window
		driver.close();
		
		
		
	}

}
