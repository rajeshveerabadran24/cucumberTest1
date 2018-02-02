package com.util.func;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Functions  {
	public static WebDriver driver;
public static WebDriver OpenBrowser(String browsername) {
	if(browsername.equalsIgnoreCase("ff")) {
		driver=new FirefoxDriver();
	}else if (browsername.equalsIgnoreCase("gc")) {
		System.setProperty("webdriver.chrome.driver", Env.Driverpath + "\\chromedriver.exe");
		driver=new ChromeDriver();
	
	}else {
		driver=new OperaDriver();
	}
	return driver;
	
}

public static void Navigate(String url) {
	driver.navigate().to(url);
}
public static boolean click(String xpath) {
	try {
		boolean bvalue;
		
		bvalue=driver.findElement(By.xpath(xpath)).isEnabled();
		if(bvalue=true) {
			driver.findElement(By.xpath(xpath)).click();
		}
		


		} catch (Exception e) {
		e.printStackTrace();
	
}
	return false;
	
}
public static boolean Typekeys(String xpath,String value) {
	try {
		boolean bvalue;
		
		bvalue=driver.findElement(By.xpath(xpath)).isEnabled();
		if(bvalue=true) {
			driver.findElement(By.xpath(xpath)).sendKeys(value);
		}
		


		} catch (Exception e) {
		e.printStackTrace();
	
}
	return false;
	
}
public void mousemoveover(String xpath) {
	try {
		Actions act=new Actions(driver);
		WebElement ele=driver.findElement(By.xpath(xpath));
		act.moveToElement(ele).build().perform();
	} catch (Exception e) {
		e.printStackTrace();
	}
	
}
public int Listsize(String xpath) {
	List<WebElement> al=driver.findElements(By.xpath(xpath));
	int val=al.size();
	return val;
}
public void appExceptionhandler() {
	try {
		driver.navigate().back();
		String BrowseTitleAfterRecovery=driver.getTitle();
		
		if(BrowseTitleAfterRecovery.contains("Online Shopping site")) {
			System.out.println("Its landed in the particular page");} else {
				Navigate(Env.url);
			}
	} catch (Exception e) {
		e.printStackTrace();
	}
	
	
}
public static void maxi() {
	driver.manage().window().maximize();
}
public static void ExtractingallLinks(String tag, String value1) {
	
	List<WebElement> al=driver.findElements(By.tagName(tag));
	int i=0;
	String []text=new String[al.size()];
	for (WebElement webElement : al) {
		text[i]=webElement.getText();
		i++;	
	} 
	for (String string : text) {
		System.out.println(string);
		driver.findElement(By.linkText(string)).click();
		if (driver.getTitle().equals(value1)) {
			System.out.println("\"" + string + "\""								
                    + " is under construction.");			
        } else {			
            System.out.println("\"" + string + "\""								
                    + " is working.");			
        }		
		driver.navigate().back();			
    }		
		driver.quit();			
}	
public static String BrowserTitle() {
	System.out.println(driver.getTitle());
	return driver.getTitle();
}
public static void Scroll() {
	WebElement ele=driver.findElement(By.xpath("//a[text()='Instagram']"));
	JavascriptExecutor js=((JavascriptExecutor)driver);
	js.executeScript("arguments[0].scrollIntoView(true);", ele);
}
		}
	
