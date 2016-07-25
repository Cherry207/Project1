package homework2;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import wrapper.WrapperMethods;

public class OpenTaps extends WrapperMethods{

	@BeforeSuite
	public void openTapsSuite(){
		System.out.println("Opentaps Suite has been launched");
	
	}
	
	@BeforeTest
	public void openTapsTest() throws InterruptedException{
		System.out.println("Opentaps Test has been launched");
		
		}
	
	@BeforeMethod
	public void login() throws InterruptedException{
	launchBrowser("chrome", "http://demo1.opentaps.org/");
	enterTextById("username", "DemoSalesManager");
	enterTextById("password", "crmsfa");
	clickByClassName("decorativeSubmit");
	clickByPartialLinkText("CRM/SFA");
	Thread.sleep(3000);
//		System.out.println("Im at before method");
		
	}

	@AfterMethod(alwaysRun=true)
	public void closeTheBrowser(){
		closeBrowser();
	}
}
