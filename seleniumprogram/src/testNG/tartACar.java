package testNG;

import org.testng.annotations.Test;

public class tartACar {
	
	@Test(priority=0)
	public void startacar() {
		System.out.println("car started");
	}
	@Test(priority=1)
	public void firstgear() {
		System.out.println("firstgear");
	}
	@Test(priority=2)
	public void secondgear() {
		System.out.println("secondgear");
	}
	@Test(priority=3)
	public void thirdgear() {
		System.out.println("thirdgear");
	}
	@Test(priority=4)
	public void fourthgear() {
		System.out.println("fourthgear");
	}
}
