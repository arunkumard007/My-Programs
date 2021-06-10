package testNG;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;


public class extentreport {
	WebDriver d;
	long startTime;
	long endTime;
	ExtentReports reports;
	ExtentHtmlReporter htmlreport;
	ExtentTest testcase;
	
	@BeforeSuite
	
	public void launchBrowser() {
	startTime=System.currentTimeMillis();
	System.setProperty("webdriver.chrome.driver",  "C:\\selenium jars\\chromedriver.exe");
	d=new ChromeDriver();
	reports =new ExtentReports();
	htmlreport= new ExtentHtmlReporter("ExtentReport.html");
	reports.attachReporter(htmlreport);
	}
	@Test
	public void openGoogle() {
		testcase=reports.createTest("Verify the google Test");
		d.get("http://www.google.co.in");
		String title1= d.getTitle();
		System.out.println("Title is" +title1);
		if(title1.equals("Google")) {
			testcase.log(Status.PASS,"Operation google sucess");}
		else {
			System.out.println("Google fail");
		testcase.log(Status.FAIL,"Operation google fail");}
	}
	
	@Test
	public void openBing() {
		testcase=reports.createTest("Verify the Bing Test");
		d.get("http://www.bing.com");
		String title2= d.getTitle();
		System.out.println("Title is" +title2);
		if(title2.equals("Bing")) {
			System.out.println("Bing Success");
		testcase.log(Status.PASS,"Operation bing sucess");}
		else {
			System.out.println("Bing fail");
		testcase.log(Status.FAIL,"Operation bing fail");}
	}
	
	@Test
	public void openYahoo() {
		testcase=reports.createTest("Verify the Yahoo Test");
		d.get("http://www.yahoo.com");
		String title= d.getTitle();
		System.out.println("Title is" +title);
		if(title.equals("yahoo")) {
			System.out.println("yahoo Success");
		testcase.log(Status.PASS,"Operation yahoo sucess");}
		else {
			System.out.println("Bing fail");
		testcase.log(Status.FAIL,"Operation yahoo failure");}
	}
	
	@AfterSuite
	
	public void closebrowser() {
		d.quit();
		endTime=System.currentTimeMillis();
		long totalTime= startTime - endTime;
		System.out.println("Total Time Takem"+totalTime);
		reports.flush();
		
	}

}
