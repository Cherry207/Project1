package amazon;

import org.junit.Test;

import wrapper.WrapperMethods;

public class TestingAmazon extends WrapperMethods {

	@Test
	public void login() throws InterruptedException {
		launchBrowser("chrome", "http://www.amazon.in");
		mouseoverMainMenuByXPath("//*[@id='nav-link-yourAccount']");
//		WebElement menu = driver.findElementByXPath("//*[@id='nav-link-yourAccount']");
////		WebElement submenu = driver.findElementByXPath("//*[@id='nav_prefetch_yourorders']");
//		Actions mouse = new Actions(driver);
//		mouse.moveToElement(menu).perform();
		Thread.sleep(3000);
		mouseoverSubMenuByXPath("//*[@id='nav_prefetch_yourorders']");
		
		clickByXPath("//*[@id='nav_prefetch_yourorders']/span");
	enterTextById("ap_email", "alaharicharanteja@gmail.com");
	enterTextById("ap_password", "Password2");
			clickById("signInSubmit");
			mouseoverMainMenuByXPath("//*[@id='nav-link-yourAccount']");
			
//			mouse.clickAndHold(driver.findElementByXPath("//*[@id='nav_prefetch_yourorders']"));
	}
}
