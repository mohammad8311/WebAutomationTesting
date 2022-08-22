package testCase;


import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Browser {
	
	public static void main(String[] args) throws InterruptedException, IOException {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().timeouts().scriptTimeout(Duration.ofMinutes(2));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		
		driver.get("https://google.com");
		String orginalWindow = driver.getWindowHandle();
		
		
		driver.navigate().to("http://facebook.com");
		
		System.out.println(driver.getCurrentUrl());
		System.out.println(driver.getTitle());
		
		driver.navigate().back();
		Thread.sleep(2000);
		driver.navigate().forward();
		driver.navigate().refresh();

		
		driver.switchTo().newWindow(WindowType.WINDOW);
		driver.switchTo().newWindow(WindowType.TAB);
		driver.switchTo().window(orginalWindow);
		
		
		driver.navigate().to("https://www.selenium.dev/selenium/docs/api/java/index.html?overview-summary.html");
		driver.switchTo().frame("packageFrame"); 
		driver.findElement(By.linkText("Action")).click();
		driver.switchTo().defaultContent();
		

		driver.manage().window().getSize().getWidth();
		driver.manage().window().getSize().getHeight();
		
		Dimension size = driver.manage().window().getSize();
		System.out.println(size.getWidth());
		System.out.println(size.getHeight());
		
		driver.manage().window().setSize(new Dimension(800,600));
		
		driver.manage().window().getPosition().getX();
		driver.manage().window().getPosition().getY();
		
		Point Position = driver.manage().window().getPosition();
		System.out.println(Position.getX());
		System.out.println(Position.getY());
		
		driver.manage().window().setPosition(new Point(500, 100));
		
		driver.manage().window().maximize();
		Thread.sleep(2000);
		driver.manage().window().minimize();
		Thread.sleep(2000);
		driver.manage().window().fullscreen();
		
		
		
		File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(srcFile, new File("./scrImage1.png"));
		
		//Take Screenshot for specific module
		WebElement element = driver.findElement(By.cssSelector(".lnXdpd"));
		File srcFile1 = element.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(srcFile1, new File("./ImageSrc2.png"));
		
		
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		
		WebElement button = driver.findElement(By.name("btnI"));
		jse.executeScript("arguments[0].click()", button);
		jse.executeScript("console.log('Hello Google...')");
		
		Thread.sleep(2000);
		driver.close();
		driver.quit();
		
	}

}
