package com.util.Banking.MavenBank1;



import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.opera.OperaDriver;

public class Function {
	
	 public FileInputStream fis = null;
	    public XSSFWorkbook workbook = null;
	    public XSSFSheet sheet = null;
	    public XSSFRow row = null;
	    public XSSFCell cell = null;
	    
	    
	
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
	public static void Scroll(String path) {
		WebElement ele=driver.findElement(By.xpath(path));
		JavascriptExecutor js=((JavascriptExecutor)driver);
		js.executeScript("arguments[0].scrollIntoView(true);", ele);
	}
	public String getCellData(String xlFilePath,String sheetName, String colName, int rowNum) throws IOException
    {
		fis = new FileInputStream(xlFilePath);
        workbook = new XSSFWorkbook(fis);
        try
        {
            int col_Num = -1;
            sheet = workbook.getSheet(sheetName);
            row = sheet.getRow(0);
            for(int i = 0; i < row.getLastCellNum(); i++)
            {
                if(row.getCell(i).getStringCellValue().trim().equals(colName.trim()))
                    col_Num = i;
            }
 
            row = sheet.getRow(rowNum - 1);
            cell = row.getCell(col_Num);
 
            if(cell.getCellTypeEnum() == CellType.STRING)
                return cell.getStringCellValue();
            else if(cell.getCellTypeEnum() == CellType.NUMERIC || cell.getCellTypeEnum() == CellType.FORMULA)
            {
                String cellValue = String.valueOf(cell.getNumericCellValue());
                if(HSSFDateUtil.isCellDateFormatted(cell))
                {
                    DateFormat df = new SimpleDateFormat("dd/MM/yy");
                    Date date = cell.getDateCellValue();
                    cellValue = df.format(date);
                }
                return cellValue;
            }else if(cell.getCellTypeEnum() == CellType.BLANK)
                return "";
            else
                return String.valueOf(cell.getBooleanCellValue());
        }
        catch(Exception e)
        {
            e.printStackTrace();
            return "row "+rowNum+" or column "+colName +" does not exist  in Excel";
        }
    }
	public static void AlertMessg() throws InterruptedException {
	Alert alert = driver.switchTo().alert();		
	
    // Capturing alert message.    
    String alertMessage= driver.switchTo().alert().getText();		
    		
    // Displaying alert message		
    System.out.println(alertMessage);	
    Thread.sleep(5000);
    		
    // Accepting alert		
    alert.accept();	
	}
	public static void takescreenshot() throws IOException {
		File fil=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		//String timestamp=new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
		FileUtils.copyFile(fil, new File("D:\\screen\\Bank1" + System.currentTimeMillis() +".png"));
	}
}

