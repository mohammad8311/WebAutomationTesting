package testCase;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import base.DriverSetup;

// Locator Practice advance

public class TC002 extends DriverSetup{
	static String baseUrl = "https://rahulshettyacademy.com/locatorspractice/";
	
	@Test
	public void locatorLearning() throws InterruptedException
	{
		
		
		driver.get(baseUrl);
		driver.manage().window().maximize();
		Thread.sleep(2000);
				

		//Find out element by id
		driver.findElement(By.id("inputUsername")).sendKeys("didar");
		Thread.sleep(2000);
		
		driver.findElement(By.name("inputPassword")).sendKeys("Password");
		driver.findElement(By.className("signInBtn")).click();
		Thread.sleep(2000);
		
		String errorMessage = driver.findElement(By.cssSelector("p.error")).getText();

		System.out.println(errorMessage);
	
		

		String password = getPassword(driver);
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys("didar");
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//input[@type='text'][2]")).sendKeys("didar@gmail.com");
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//input[@type='text'][3]")).sendKeys("123456");
		Thread.sleep(2000); 
		

		driver.findElement(By.xpath("//div[@class='forgot-pwd-btn-conainer']/button[1]")).click();
		Thread.sleep(2000);
		
		
		driver.findElement(By.cssSelector("#inputUsername")).sendKeys("Didar");
		driver.findElement(By.cssSelector("input[type*='pass']")).sendKeys(password);
		
		driver.findElement(By.id("chkboxOne")).click();
		
		driver.findElement(By.xpath("//button[contains(@class,'submit')]")).click();
		
		Thread.sleep(2000);
		
		
		//Tagname[@attribute='value']
		/* 
			//relative xpath < // means relatove xpath
			/absolute xpath	 < / means absolute xpath

		 */
	}

	

	
	public static String getPassword(WebDriver driver) throws InterruptedException {
		// TODO Auto-generated method stub
		
		driver.get(baseUrl);
		driver.findElement(By.linkText("Forgot your password?")).click();
		Thread.sleep(2000);
		
		driver.findElement(By.cssSelector(".reset-pwd-btn")).click();
		String getPasswordTxt = driver.findElement(By.cssSelector("form P")).getText();
		
		String[] passwordArray = getPasswordTxt.split("'");
		String password = passwordArray[1].split("'")[0];
		
		return password;
	}

}
