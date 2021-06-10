package testNG;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class TestSuite {

	WebDriver d;
	long startTime;
	long endTime;
	
	@BeforeSuite
	
	public void launchBrowser() {
	startTime=System.currentTimeMillis();
	System.setProperty("webdriver.chrome.driver",  "C:\\selenium jars\\chromedriver.exe");
	d=new ChromeDriver();
	}
	@Test
	public void openGoogle() {
		d.get("http://www.google.co.in");
	}
	
	@Test
	public void openBing() {
		d.get("http://www.bing.com");
	}
	
	@Test
	public void openYahoo() {
		d.get("http://www.yahoo.com");
	}
	
	@AfterSuite
	
	public void closebrowser() {
		d.quit();
		endTime=System.currentTimeMillis();
		long totalTime= startTime - endTime;
		System.out.println("Total Time Takem"+totalTime);
		
	}
}
