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

public class PrashanthLifeCycle extends JavaJoesRules {
	

	@BeforeClass
	public void switchToDeliveryAttire() {
		System.out.println("Prasanth switches To Delivery Attire");
	}

	@BeforeMethod
	public void collectOrders() {
		System.out.println("Prasanth takes the orders from Swathi");
	}

	@Test
	public void driveAndDeliverPizza() {
		System.out.println("Prasanth driveAndDeliverPizza");
	}

	@AfterMethod
	public void returnToStore() {
		System.out.println("Prasanth returnToStore");
	}

	@AfterClass
	public void backToHisAttire() {
		System.out.println("Prasanth is back To His Attire");
	}

	

}
