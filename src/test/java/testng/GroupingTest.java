package testng;

import org.testng.annotations.Ignore;
import org.testng.annotations.Test;


public class GroupingTest {
	
	@Test(groups= {"smoke","regression"})
	public void login1() {
		System.out.println("login1");
	}

	@Test(groups= {"smoke"})
	public void login2() {
		System.out.println("login2");
	}
	
	@Test(groups= {"smoke"})
	public void login3() {
		System.out.println("login3");
	}
}
