package com.util.testscripts;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import com.util.func.Env;
import com.util.func.Functions;
public class SmokeBasic {
static WebDriver driver;
	public static void main(String[] args) {
		try {
			
			Functions func=new Functions();
			func.OpenBrowser("gc");
			func.Navigate("https://www.amazon.in/");
			/*func.mousemoveover("//*[@id='nav-link-yourAccount']/span[2]");
			
			for (int i = 1; i <=func.Listsize(".//*[@id='nav-flyout-yourAccount']/div[3]/a/span"); i++) {
				func.mousemoveover("//*[@id='nav-link-yourAccount']/span[2]");
				func.mousemoveover(".//*[@id='nav-flyout-yourAccount']/div[3]/a["+(i)+"]/span");
				func.click(".//*[@id='nav-flyout-yourAccount']/div[3]/a["+(i)+"]/span");
				func.appExceptionhandler();
			}
			for (int i = 1; i <=func.Listsize(".//*[@id='nav-flyout-wishlist']/div[2]/a/span"); i++) {
				func.mousemoveover("//*[@id='nav-link-wishlist']/span[2]");
				func.mousemoveover(".//*[@id='nav-flyout-wishlist']/div[2]/a["+(i)+"]/span");
				func.click(".//*[@id='nav-flyout-wishlist']/div[2]/a["+(i)+"]/span");
				func.appExceptionhandler();
			}
			*/
		/*func.maxi();
		func.BrowserTitle();
			func.ExtractingallLinks("a",func.BrowserTitle());
			
			*/
			func.Scroll();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
