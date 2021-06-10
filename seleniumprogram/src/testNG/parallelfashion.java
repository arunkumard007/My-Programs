package testNG;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class parallelfashion {
@Test
	public void opengoogle() {
		System.setProperty("webdriver.chrome.driver",  "C:\\selenium jars\\chromedriver.exe");
		WebDriver d=new ChromeDriver();
		d.get("http://www.google.co.in");
		d.quit();
	}
@Test
		public void openbing() {
			System.setProperty("webdriver.chrome.driver",  "C:\\selenium jars\\chromedriver.exe");
			WebDriver d=new ChromeDriver();
			d.get("http://www.bing.com");
			d.quit();
		}
			
		
}
