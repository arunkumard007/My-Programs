package dataprovidertestng;

import java.io.FileInputStream;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class login {
	
	WebDriver d;

	String[][] data=null;
		//{
		//	{"sylix","admin"},
			//{"sylix","admin12"},
			//{"syli","admin@"},
			//{"sylix",""}
	//};
		public String[][] getexceldata() throws BiffException, IOException{
			FileInputStream f= new FileInputStream("D:\\spreadsheet login.xls");
			Workbook b =Workbook.getWorkbook(f);
			Sheet s= b.getSheet(0);
			
			int rowcount =s.getRows();
			int columncount=s.getColumns();
			
			String testData[][]= new String [rowcount-1][columncount];
			
			for(int i=1;i<rowcount;i++) {
				for(int j=0;j<columncount;j++){
				 testData[i-1][j]=s.getCell(j, i).getContents();
			}
		}
			return testData;
	}
@DataProvider(name="logindata")
public String[][] loginDataProvider() throws BiffException, IOException{
	 data= getexceldata();
	 return data;
    }

@BeforeTest
public void beforetest() {
	System.setProperty("webdriver.chrome.driver", "C:\\selenium jars\\chromedriver.exe");
	 d=new ChromeDriver();
}
@AfterTest
public void aftertest() {
	d.quit();
}

@Test(dataProvider="logindata")
public void logincorrectly(String uname,String pword) {
	
	d.get("http://www.brm.tremplintech.in/web_pages/login.aspx");
	
	
	WebElement username=d.findElement(By.id("txt_unam"));
	username.sendKeys(uname);
	
	WebElement password=d.findElement(By.id("txt_pass"));
	password.sendKeys(pword);
	
	WebElement login=d.findElement(By.xpath("//*[@id=\"Button3\"]"));
	login.click();
	
    }
}



