package testCase;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import base.DriverSetup;

public class TC001_LocatorLearing extends DriverSetup {
	
	@Test
	public void locatorLearning() throws InterruptedException
	{
		String baseUrl = "https://rahulshettyacademy.com/locatorspractice/";
		
		driver.get(baseUrl);
		driver.manage().window().maximize();
		Thread.sleep(2000);
		
		
		//Find out element by Xpath
		/*
		driver.findElement(By.xpath("//input[@id='inputUsername']")).sendKeys("didar");
		Thread.sleep(2000); */
		

		//Find out element by id
		driver.findElement(By.id("inputUsername")).sendKeys("Marry");
		Thread.sleep(2000);
		
		driver.findElement(By.name("inputPassword")).sendKeys("Password");
		driver.findElement(By.className("signInBtn")).click();
		Thread.sleep(2000);
		
		String errorMessage = driver.findElement(By.cssSelector("p.error")).getText();
		//Formula: tagname.value(if class is given)
		//Formula: tagname#value(if id is given)
		System.out.println(errorMessage);
		
		//Link Text
		driver.findElement(By.linkText("Forgot your password?")).click();
		Thread.sleep(2000);
		

		
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys("didar");
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//input[@type='text'][2]")).sendKeys("didar@gmail.com");
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//input[@type='text'][3]")).sendKeys("123456");
		Thread.sleep(2000);
		
		driver.findElement(By.cssSelector(".reset-pwd-btn")).click();
		driver.findElement(By.xpath("//div[@class='forgot-pwd-btn-conainer']/button[1]")).click();
		Thread.sleep(2000);
		
		
		driver.findElement(By.cssSelector("#inputUsername")).sendKeys("Didar");
		driver.findElement(By.cssSelector("input[type*='pass']")).sendKeys("rahulshettyacademy");
		
		driver.findElement(By.id("chkboxOne")).click();
		
		driver.findElement(By.xpath("//button[contains(@class,'submit')]")).click();
		
		Thread.sleep(2000);
		
		
		//Tagname[@attribute='value']
		/* 
			//relative xpath < // means relatove xpath
			/absolute xpath	 < / means absolute xpath

		 */
	}

}
