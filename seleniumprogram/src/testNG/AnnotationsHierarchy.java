package testNG;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class AnnotationsHierarchy {
	
	 @Test
	  public void f1() {
		  System.out.println("I am Test2");
	  }
  @Test
  public void f() {
	  System.out.println("I am Test");
  }
  @BeforeMethod
  public void beforeMethod() {
	  System.out.println("I am BeforeMethod");
  }

  @AfterMethod
  public void afterMethod() {
	  System.out.println("I am AfterMethod");
  }

  @BeforeClass
  public void beforeClass() {
	  System.out.println("I am BeforeClass");
  }

  @AfterClass
  public void afterClass() {
	  System.out.println("I am AfterClass");
  }

  @BeforeTest
  public void beforeTest() {
	  System.out.println("I am BeforeTest");
  }

  @AfterTest
  public void afterTest() {
	  System.out.println("I am AfterTest");
  }

  @BeforeSuite
  public void beforeSuite() {
	  System.out.println("I am BeforeSuite");
  }

  @AfterSuite
  public void afterSuite() {
	  System.out.println("I am AfterSuite");
  }

}
