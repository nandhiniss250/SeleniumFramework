package testng;

import org.testng.annotations.Test;

public class Dependsonmethod {
	@Test
	public void login1() {
		System.out.println("login1");
	}

	@Test(dependsOnMethods="login1")
	public void login2() {
		System.out.println("login2");
	}
	
	

}
