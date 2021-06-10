package testNG;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Assertion {

	
	String name ="Arun";
	@Test
	public void equals() {
		/*if(name.equals(Arun)){
		 System.out.println("NAme is equal");}
		 else {
			 System.out.println("NAme is not equal");
		 }*/
		
	Assert.assertEquals(name, "Arun");
	//Assert.assertNotEquals(actual1, actual2);
	//Assert.assertTrue(condition);
	//Assert.assertFalse(condition);
	
	}
	
}
