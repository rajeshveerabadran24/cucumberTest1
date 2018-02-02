package com.util.testscripts;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestScript {
	static WebDriver driver;

public static void main(String[] args) throws InterruptedException  {
	System.setProperty("webdriver.chrome.driver", "D:\\selenium beta3.03\\driver\\chromedriver.exe");
	 driver=new ChromeDriver();
	driver.get("http://jqueryui.com/sortable/");
	driver.manage().window().maximize();
		
	//driver.findElement(By.xpath("//a[@class='btn btn-primary btn-lg'  and @href='#']")).click();
	
	/*WebDriverWait wait1=new WebDriverWait(driver, 20);
	wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@class='btn btn-primary btn-lg' and text()='Open Login Modal']")));
	*/

	/*driver.findElement(By.xpath("//button[@class='w3-button w3-bar-item w3-green w3-hover-white w3-hover-text-green']")).click();
	Thread.sleep(3000);
	driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@id='iframeResult']")));
	driver.findElement(By.xpath("//a[text()='Show Popup Form']")).click();
	driver.findElement(By.xpath("//input[@id='usrnm']")).sendKeys("Rajesh");
	driver.findElement(By.xpath("//input[@id='pswd']")).sendKeys("vr12345");
	driver.findElement(By.xpath("//label[@for='log']")).click();
	driver.findElement(By.xpath("//input[@type='submit']")).click();
	Thread.sleep(5000);
    String value=driver.findElement(By.xpath("//div[@class='w3-container w3-large w3-border']")).getText();   
	System.out.println(value);
	*/
/*driver.findElement(By.xpath("//button[@id='googleLoginButton']")).click();
String parent=driver.getWindowHandle();
for (String string : driver.getWindowHandles()) {
	System.out.println(string);
	if (!string.equals(parent)) {
		driver.switchTo().window(string);
	}
}
//driver.findElement(By.xpath("//p[text()='Use another account']")).click();
driver.findElement(By.xpath("//*[@id='identifierId']")).sendKeys("vrajesh.lucky");
driver.findElement(By.xpath("//span[text()='Next']")).click();
Thread.sleep(3000);
driver.findElement(By.xpath("//input[@name='password']")).sendKeys("sumathilat");
driver.findElement(By.xpath("//span[text()='Next']")).click();*/
	//Thread.sleep(9000);
	WebDriverWait wait=new WebDriverWait(driver, 20);
	wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//ul[@id='sortable']")));
	
	WebElement al=driver.findElement(By.xpath("//ul[@id='sortable']"));
	List<WebElement> cl=al.findElements(By.tagName("li"));
	
		int size=cl.size();
		System.out.println(size);
	}
	
}
