package testNG;

import org.testng.annotations.Test;

public class groupings {
@Test(groups= {"Apple"})
	public void Apple1() {
		System.out.println("Apple1 Running");
	}
@Test(groups= {"Apple"})
	public void Apple2() {
		System.out.println("Apple2 Running");
	}
@Test(groups= {"Samsung"})
	public void Samsung1() {
		System.out.println("Samsung1 Running");
	}
@Test(groups= {"Samsung"})
	public void Samsung2() {
		System.out.println("Samsung2 Running");
	}
@Test(groups= {"Oneplus"})
	public void Oneplus1() {
		System.out.println("Oneplus1 Running");
	}
@Test(groups= {"Oneplus"})	
	public void Oneplus2() {
		System.out.println("Oneplus2 Running");
	}
@Test(groups= {"Mi"})
	public void Mi1() {
		System.out.println("Mi1 Running");
	}
@Test(groups= {"Mi"})
	public void Mi2() {
		System.out.println("Mi2 Running");
	}
	
	
	
	
	
}
