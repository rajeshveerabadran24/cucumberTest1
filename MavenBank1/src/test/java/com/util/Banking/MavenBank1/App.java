package com.util.Banking.MavenBank1;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;

import com.util.Banking.MavenBank1.*;
public class App extends Function
{
	static WebDriver driver;
    public static void main( String[] args ) throws Exception {
    	Function fc=new Function();
    	fc.OpenBrowser("gc");
    	fc.Navigate(Env.url);
    	fc.maxi();
    	fc.Typekeys("//input[@name='uid']", Env.username);
    	fc.Typekeys("//input[@name='password']", Env.password);
    	fc.click("//input[@name='btnLogin']");
    	
    		fc.click("//a[text()='New Customer']");
    		
    		String [][]arr=new String[1][9];
			arr[0][0]="Customer Name";
			arr[0][1]="Address";
			
			arr[0][2]="City";
			arr[0][3]="State";
			arr[0][4]="PIN";
			arr[0][5]="Mobile Number";
			arr[0][6]="E-mail";
			arr[0][7]="Password";
			for (int i = 0; i < 1; i++) {
				for (int j = 0; j <=7; j++) {
					//fc.getCellData(Env.Excel_Filepath, "Sheet1", "Address", 2);
	    			System.out.println(fc.getCellData(Env.Excel_Filepath, "Sheet1", arr[i][j], 2));
	    			if (j==0) {
						
					int val=3;
	    			
						fc.Typekeys("//input[@name='name']", fc.getCellData(Env.Excel_Filepath, "Sheet1", arr[i][j], val));
						fc.Typekeys("//textarea[@name='addr']", fc.getCellData(Env.Excel_Filepath, "Sheet1", arr[i][j+1], val));
						fc.Typekeys("//input[@name='city']", fc.getCellData(Env.Excel_Filepath, "Sheet1", arr[i][j+2], val));
						fc.Typekeys("//input[@name='state']", fc.getCellData(Env.Excel_Filepath, "Sheet1", arr[i][j+3], val));
						fc.Typekeys("//input[@name='pinno']", fc.getCellData(Env.Excel_Filepath, "Sheet1", arr[i][j+4], val));
						//fc.Typekeys("//input[@name='telephoneno']", fc.getCellData(Env.Excel_Filepath, "Sheet1", arr[i][j+5], 2));
						fc.Typekeys("//input[@name='telephoneno']", "9789867477");
						fc.takescreenshot();
						fc.Typekeys("//input[@name='emailid']", fc.getCellData(Env.Excel_Filepath, "Sheet1", arr[i][j+6], val));
						fc.takescreenshot();
						fc.Typekeys("//input[@name='password']", fc.getCellData(Env.Excel_Filepath, "Sheet1", arr[i][j+7], val));
						fc.takescreenshot();
						fc.Typekeys("//input[@id='dob']", "03241988");
						fc.takescreenshot();
						fc.click("//input[@name='sub']");
						fc.takescreenshot();
						fc.AlertMessg();
						fc.takescreenshot();
	    			}	
				}
	    			
			}
    			
    		
		
    
    
}
}

