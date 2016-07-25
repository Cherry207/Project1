package week4_class1;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

public class commonMethodsInAll extends OpenTapsWrapperForTestNG{

	@BeforeSuite
	public void launchBrowser(){
		launchBrowser("chrome", "http://demo1.opentaps.org/");
	}
	
	@BeforeTest
	public void login() {
		
		enterTextById("username", "DemoSalesManager");
		enterTextById("password", "crmsfa");
		clickByClassName("decorativeSubmit");
	}
	
	@AfterSuite
	public void browserclose() throws InterruptedException {
		closeBrowser();
	}
}
