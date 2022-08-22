package testCase;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginPage {
	
	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().timeouts().scriptTimeout(Duration.ofMinutes(2));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		
		driver.get("https://rahulshettyacademy.com/locatorspractice");
		
		driver.findElement(By.id("inputUsername")).sendKeys("Mohammad");
		driver.findElement(By.name("inputPassword")).sendKeys("123456789");
		driver.findElement(By.xpath("//input[@id='chkboxTwo']")).click();
		
		driver.findElement(By.xpath("//button[contains(text(),'Sign In')]")).click();
		
		String ErrorMessage = driver.findElement(By.xpath("//p[contains(text(),'* Incorrect username or password')]")).getText();
		System.out.println("Error Message: "+ErrorMessage);
		
		driver.findElement(By.xpath("//a[contains(text(),'Forgot your password?')]")).click();
		
		driver.findElement(By.xpath("//body/div[@id='root']/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/form[1]/input[1]")).sendKeys("Mohammad");
		driver.findElement(By.xpath("//body/div[@id='root']/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/form[1]/input[2]")).sendKeys("didar@gmail.com");
		driver.findElement(By.xpath("//body/div[@id='root']/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/form[1]/input[3]")).sendKeys("01843650796");
		driver.findElement(By.xpath("//button[contains(text(),'Reset Login')]")).click();
		
		//driver.close();
		
	}
	

}
