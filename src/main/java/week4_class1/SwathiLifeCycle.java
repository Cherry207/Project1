package week4_class1;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SwathiLifeCycle extends JavaJoesRules{
	
	@Test(enabled=false)
	public void cookAndServeDonuts() {
		System.out.println("Swathi cooks And Serves Donuts");
	}
	
	@BeforeClass
	public void switchToStoreAttire() {
		System.out.println("Swathi switches To Store Attire");
	}

	@BeforeMethod
	public void takeAndBillOrder() {
		System.out.println("Swathi takes the order And Bills the Order");
	}

	@Test(invocationCount=10)
	public void cookAndServePizza() {
		System.out.println("Swathi cooks And Serves Pizza");
	}

	@AfterMethod
	public void cleanTheTable() {
		System.out.println("Swathi cleans the Table after the customer leaves");
	}

	@AfterClass
	public void backToHerAttire() {
		System.out.println("Swathi is back To Her Attire");
	}

	

}
