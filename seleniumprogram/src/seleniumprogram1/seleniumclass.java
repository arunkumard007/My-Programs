package seleniumprogram1;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class seleniumclass {

	public static void main(String[] args) throws InterruptedException, IOException, BiffException {
		// TODO Auto-generated method stub
System.setProperty("webdriver.chrome.driver", "C:\\selenium jars\\chromedriver.exe");
WebDriver d=new ChromeDriver();
d.get("http://www.brm.tremplintech.in/web_pages/login.aspx");
Thread.sleep(2000);
d.manage().window().maximize();

//username password submit 

d.findElement(By.id("txt_unam")).sendKeys("sylix");
d.findElement(By.name("txt_pass")).sendKeys("admin");
d.findElement(By.xpath("//*[@id=\"Button3\"]")).click();

//first module

d.findElement(By.linkText("Customermanagement")).click();

//dropdown

Select sel = new Select(d.findElement(By.xpath("//*[@id=\"ContentPlaceHolder1_ddl_state\"]")));
//sel.selectByVisibleText("Tamil Nadu");
sel.selectByIndex(19);
//selectByValue
//deselectAll


//textbox
d.findElement(By.xpath("//*[@id=\"ContentPlaceHolder1_txt_compname\"]")).sendKeys("Infomats");
d.findElement(By.xpath("//*[@id=\"ContentPlaceHolder1_txt_addr\"]")).sendKeys("Pollachi");	


//DataDriven
d.get("http://www.brm.tremplintech.in/web_pages/login.aspx");
FileInputStream f= new FileInputStream("D:\\spreadsheet login.xls");
Workbook b =Workbook.getWorkbook(f);
Sheet s= b.getSheet(0);
int rowcount =s.getRows();

for(int i=1;i<=rowcount;i++) {
	String username=s.getCell(0,i).getContents();
	String Password =s.getCell(1,i).getContents();
	
	d.findElement(By.id("txt_unam")).sendKeys(username);
	d.findElement(By.name("txt_pass")).sendKeys(Password);
	d.findElement(By.xpath("//*[@id=\"Button3\"]")).click();
	d.findElement(By.xpath("//*[@id=\"LinkButton1\"]")).click();
	
	
}

//Scroll up and down
d.get("https://www.phptravels.net/home");

((JavascriptExecutor)d).executeScript("scroll(0,900)");
Thread.sleep(4000);
((JavascriptExecutor)d).executeScript("scroll(0,-500)");
Thread.sleep(4000);


// uploadfile 

d.get("http://demo.guru99.com/test/upload/");
WebElement uploadElement = d.findElement(By.id("uploadfile_0"));
uploadElement.sendKeys("C:\\Users\\Arunkumar\\Documents\\ERP.xlsx");

d.findElement(By.id("terms")).click(); // checkbox

d.findElement(By.name("send")).click();

//slider

d.get("https://jqueryui.com/slider/");
d.switchTo().frame(0);
WebElement Slider=d.findElement(By.xpath("//*[@id=\"slider\"]/span"));
for(int i=1; i<=50; i++)
     {
	Slider.sendKeys(Keys.ARROW_RIGHT);
     }	
	
// Drag and Drop 

d.get("http://demo.guru99.com/test/drag_drop.html");
WebElement From=d.findElement(By.xpath("//*[@id='credit2']/a"));	
WebElement From1=d.findElement(By.xpath("//*[@id=\"fourth\"]/a"));

//Element on which need to drop.		
WebElement To=d.findElement(By.xpath("//*[@id='bank']/li"));	
WebElement To1=d.findElement(By.xpath("//*[@id=\"amt7\"]/li"));
		
//Using Action class for drag and drop.		
Actions act=new Actions(d);					

//Dragged and dropped.		
act.dragAndDrop(From, To).build().perform();
act.dragAndDrop(From1, To1).build().perform();

//Mousehover or mouseover
d.get("https://demoqa.com/menu/");
WebElement menuoption = d.findElement(By.xpath("//*[@id=\"nav\"]/li[2]/a"));
act.moveToElement(menuoption).perform();
System.out.println("Done Mouse hover on 'main menu opened");
Thread.sleep(4000);

WebElement submenuoption = d.findElement(By.xpath("//*[@id=\"nav\"]/li[2]/ul/li[3]/a"));
act.moveToElement(submenuoption).perform();
System.out.println("Done Mouse hover on 'submain menu opened");
Thread.sleep(4000);

WebElement sub1menuoption = d.findElement(By.xpath("//*[@id=\"nav\"]/li[2]/ul/li[3]/ul/li[1]/a"));
sub1menuoption.click();
System.out.println("Sub1menuoptionclicked");
Thread.sleep(4000);

//Screenshot

File MenuClick= ((TakesScreenshot)d).getScreenshotAs(OutputType.FILE);
FileUtils.copyFile(MenuClick, new File("D:\\New folder\\Menu1.jpg"));
Thread.sleep(4000);

//Linktext

d.get("http://demo.guru99.com/test/accessing-link.html");
d.findElement(By.linkText("click here")).click();					
System.out.println("Title of page is: " + d.getTitle());

//ALERT AND TIMEOUT


//Thread.sleep(30000);
//d.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//d.manage().window().maximize();

d.get("http://brm.tremplintech.in/web_pages/ord_reg.aspx");
d.findElement(By.id("txt_unam")).sendKeys("sylix");
d.findElement(By.id("txt_pass")).sendKeys("admi");
d.findElement(By.name("Button3")).click();
Thread.sleep(3000);
d.switchTo().alert().accept();

//Navigation keys

d.get("http://www.amazon.in");
Thread.sleep(3000);
d.navigate().refresh();
Thread.sleep(3000);
d.navigate().refresh();
d.get("http://www.flipkart.com");
d.navigate().back();
d.navigate().forward(); 

// creating and switching to NewTabs
d.get("http://executeautomation.com/demosite/index.html?UserName=Rajkumar&Password=coolbuddy9&Login=Login"); 
((JavascriptExecutor)d).executeScript("window.open()");
ArrayList<String>tab2=new ArrayList<String>(d.getWindowHandles());
d.switchTo().window(tab2.get(1));
d.navigate().to("http://google.com");
Thread.sleep(2000);

((JavascriptExecutor)d).executeScript("window.open()");
ArrayList<String> tab3 = new ArrayList<String>(d.getWindowHandles());
d.switchTo().window(tab3.get(2));
d.get("http://google.com");
Thread.sleep(2000);

ArrayList<String> tab = new ArrayList<String>(d.getWindowHandles());
d.switchTo().window(tab.get(0));
d.get("https://www.amazon.in");
Thread.sleep(2000);

ArrayList<String> tab4 = new ArrayList<String>(d.getWindowHandles());
d.switchTo().window(tab4.get(1));
d.get("http://flipkart.com");
Thread.sleep(2000);

ArrayList<String> tab5 = new ArrayList<String>(d.getWindowHandles());
d.switchTo().window(tab5.get(2));
d.get("https://www.amazon.in/gp/product/B07DWP6GWB/ref=s9_acss_bw_cg_Sneakpee_2b1_w?pf_rd_m=A1K21FY43GMZF8&pf_rd_s=merchandised-search-5&pf_rd_r=J62K17T4SV2WKCT4C7VC&pf_rd_t=101&pf_rd_p=89ca6c5f-3ec5-4fb9-ba0f-268b8c8b0ffc&pf_rd_i=1389396031");
d.navigate().back();


System.out.println("All done");
d.quit();
 }
}