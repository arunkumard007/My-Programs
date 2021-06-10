package testNG;

import org.testng.annotations.Test;

public class dependenciesManagement {

	@Test(enabled=true)
	public void highschool() {
		System.out.println("High School");
	}
	@Test(dependsOnMethods="highschool")
	public void highSecondaryschool() {
		System.out.println("High School");
	}
	@Test(dependsOnMethods="highSecondaryschool")
	public void College() {
		System.out.println("High School");
	}
}
