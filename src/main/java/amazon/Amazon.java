package amazon;

import java.util.Set;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class Amazon extends wrapper.WrapperMethods {

	@Test
	public void amazingamazon() throws InterruptedException{
		launchBrowser("chrome", "http://www.amazon.in/");
		Thread.sleep(5000);
		WebElement element = driver.findElementById("nav-link-yourAccount");
		WebElement element1 = driver.findElementByClassName("nav-action-inner");
		Actions builder = new Actions(driver);
		builder.moveToElement(element).click(element1).build().perform();
		enterTextById("ap_email", "alaharicharanteja@gmail.com");
		enterTextById("ap_password", "Password2");
		clickById("signInSubmit");
		String text = driver.findElementByXPath("//*[@id='nav-link-yourAccount']/span[1]").getText();
		String name = text.substring(7);
		System.out.println("Logged by the lovely user :"+name);
		WebElement element2 = driver.findElementById("nav-link-shopall");
		WebElement element3 = driver.findElementByXPath("//*[@id='nav-flyout-shopAll']/div[2]/span[5]/span");
		WebElement element4 = driver.findElementByXPath("//*[@id='nav-flyout-shopAll']/div[3]/div[5]/div[1]/div/a[3]/span");
		Actions builder1 = new Actions(driver);
		builder1.moveToElement(element2).moveToElement(element3).click(element4).build().perform();
		WebElement element5 = driver.findElementById("twotabsearchtextbox");
		enterTextById("twotabsearchtextbox", "Lenovo");
		Actions builder2 = new Actions(driver);
		builder2.click(element5).sendKeys(Keys.DOWN).sendKeys(Keys.ENTER).click().build().perform();
		String parentwindow = getWindowHandle();
		Set<String> totalwindows = getWindowHandles();
		System.out.println(totalwindows);
		clickByXPath("//*[@id='result_2']/div/div[3]/div[1]/a/h2");
		Thread.sleep(2000);
		switchToChildWindow();
		WebElement element6 = driver.findElementByXPath("//*[@id='a-autoid-9']/span/input");
		Actions builder3 = new Actions(driver);
		builder3.moveToElement(element6).pause(2000).build().perform();
		clickById("quantity");
		WebElement element7 = driver.findElementById("quantity");
		Actions builder4 = new Actions(driver);
		builder4.click(element7).sendKeys(Keys.DOWN).sendKeys(Keys.DOWN).click().build().perform();
		clickById("add-to-cart-button");
		String text2 = getTextByXPath("//*[@id='huc-v2-order-row-confirm-text']/h1");
		verifyTextEqualsByXPath("//*[@id='huc-v2-order-row-confirm-text']/h1", text2);
		clickById("hlb-view-cart-announce");
		clickByXPath("//*[@id='activeCartViewForm']/div[2]/div/div[4]/div[2]/div[1]/div/div/div[2]/div/span[1]/span/input");
		//System.out.println(driver.findElementByXPath("//*[@id='activeCartViewForm']/div[2]/div/div[3]/div[1]/span/text()").getText());
		String text1 = driver.findElementByXPath("//*[@id='activeCartViewForm']/div[2]/div/div[3]/div[1]/span/a").getText();
//		driver.findElementByXPath(using)
	}
}
