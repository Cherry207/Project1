
package week4_class1;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

public class JavaJoesRules {
	@BeforeSuite
	public void wakeUpAndMakeUp() {
		System.out.println("wakesUp And MakeUp");
	}

	@BeforeTest
	public void openAndLogin() {
		System.out.println("Opened office and got into office");
	}
	@AfterTest
	public void signOutAndClose() {
		System.out.println(" signs Out And Closes the office");
	}

	@AfterSuite
	public void refreshAndSleep() {
		System.out.println(" refresh And Sleep");
	}
}
