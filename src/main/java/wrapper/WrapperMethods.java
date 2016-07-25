package wrapper;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.NoSuchSessionException;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.UnreachableBrowserException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WrapperMethods {

	// initialize the driver before all methods to use for all methods
	protected RemoteWebDriver driver = null;
	static int snap = 1;

	public void launchBrowser(String browser, String url) {

		if (browser.equalsIgnoreCase("firefox")) {
			// assign value to the object
			driver = new FirefoxDriver();
			System.out.println("Firefox driver launched");
		} else if (browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
			driver = new ChromeDriver();
			System.out.println("Chrome driver launched");
		}

		// Maximize
		driver.manage().window().maximize();

		// Set timeouts
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		// Enter URL -
		driver.get(url);

	}

	// enter text by id
	public boolean enterTextById(String id, String Textkey) {
		// initialize the boolean value
		boolean name = false;
		try {
			driver.findElementById(id).clear();
			driver.findElementById(id).sendKeys(Textkey);
			System.out.println("Values were entered for :" + id);
			name = true;

		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			System.out.println(id + " is wrong");
		} finally {
			takeScreenshot();
		}
		return name;
	}

	// enter text by classname
	public boolean enterTextByClassName(String classname, String Textkey) {
		// initialize the boolean value
		boolean name = false;
		try {
			driver.findElementByClassName(classname).clear();
			driver.findElementByClassName(classname).sendKeys(Textkey);
			System.out.println("Values were entered for :" + classname);

			name = true;

		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			System.out.println(classname + " is wrong");
		} finally {
			takeScreenshot();
		}
		return name;
	}

	// enter text by xpath
	public boolean enterTextByXPath(String xpath, String Textkey) {
		// initialize the boolean value
		boolean name = false;
		try {
			driver.findElementByXPath(xpath).clear();
			driver.findElementByXPath(xpath).sendKeys(Textkey);
			System.out.println("Values were entered for :" + xpath);
			name = true;

		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			System.out.println(xpath + " is wrong");
		} finally {
			takeScreenshot();
		}
		return name;
	}

	// click by classname
	public boolean clickByClassName(String classname) {
		boolean name = false;
		try {
			driver.findElementByClassName(classname).click();
			System.out.println("Clicked by :" + classname);
			name = true;
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			System.out.println(classname + " is wrong");
		} finally {
			if (switchTOAlert()) {
				System.out.println("Switched to alerts");
			} else {
				takeScreenshot();
			}
		}
		return name;
	}

	// click by name
	public boolean clickByName(String name) {
		boolean name1 = false;
		try {
			driver.findElementByName(name).click();
			System.out.println("Clicked by :" + name);
			name1 = true;
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			System.out.println(name + " is wrong");
		} finally {
			if (switchTOAlert()) {
				System.out.println("Switched to alerts");
			} else {
				takeScreenshot();
			}
		}
		return name1;
	}

	// click by id
	public boolean clickById(String id) {
		boolean name = false;
		try {
			driver.findElementById(id).click();
			System.out.println("Clicked by :" + id);
			name = true;
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			System.out.println(id + " is wrong");
		} finally {
			if (switchTOAlert()) {
				System.out.println("Switched to alerts");
			} else {
				takeScreenshot();
			}
		}
		return name;
	}

	// click by linktext
	public boolean clickByLinkText(String linktext) {
		boolean name = false;
		try {
			driver.findElementByLinkText(linktext).click();
			System.out.println("Clicked by :" + linktext);
			name = true;
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			System.out.println(linktext + " is wrong");
		} finally {
			if (switchTOAlert()) {
				System.out.println("Switched to alerts");
			} else {
				takeScreenshot();
			}
		}
		return name;
	}

	// click by partiallinktext
	public boolean clickByPartialLinkText(String linktext) {
		boolean name = false;
		try {
			driver.findElementByPartialLinkText(linktext).click();
			System.out.println("Clicked by :" + linktext);
			name = true;
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			System.out.println(linktext + " is wrong");
		} finally {
			if (switchTOAlert()) {
				System.out.println("Switched to alerts");
			} else {
				takeScreenshot();
			}
		}
		return name;
	}

	// click by xpath
	public boolean clickByXPath(String xpath) {
		boolean name = false;
		try {
			driver.findElementByXPath(xpath).click();
			System.out.println("Clicked by :" + xpath);
			name = true;
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			System.out.println(xpath + " is wrong");
		}
		// finally {
		// takeScreenshot();
		// }
		return name;
	}

	// gettext by xpath
	public String getTextByXPath(String xpath) {

		// initialize the text value
		String text = null;
		try {
			// storing the value to text
			text = driver.findElementByXPath(xpath).getText();
			System.out.println("Got the text by :" + xpath);
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			System.out.println(xpath + " is wrong");
		} finally {
			takeScreenshot();
		}

		return text;
	}

	// screen shot
	public void takeScreenshot() {

		File img = driver.getScreenshotAs(OutputType.FILE);

		try {
			FileUtils.copyFile(img, new File("./screen/snap" + snap + ".jpeg"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("problem in screenshot");
		}
		snap++;
	}

	// select by index
	public boolean selectByIndex(String id, int index) {
		boolean name = false;
		try {
			Select dropdown = new Select(driver.findElementById(id));
			dropdown.selectByIndex(index);
			name = true;
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			System.out.println("Error Occured with :" + index + " or " + id);
		} finally {
			takeScreenshot();
		}
		return name;
	}

	// select by value
	public boolean selectByValue(String id, String value) {
		boolean name = false;
		try {
			Select dropdown = new Select(driver.findElementById(id));
			dropdown.selectByValue(value);
			name = true;
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			System.out.println("Error Occured with :" + value + " or " + id);
		} finally {
			takeScreenshot();
		}
		return name;
	}

	// select by visibletext
	public boolean selectByVisibleText(String id, String value) {
		boolean name = false;
		try {
			Select dropdown = new Select(driver.findElementById(id));
			dropdown.selectByVisibleText(value);
			name = true;
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			System.out.println("Error Occured with :" + value + " or " + id);
		} finally {
			takeScreenshot();
		}
		return name;
	}

	// enter text by tagname
	public boolean enterTextByTagName(String tagname, String Textkey) {
		// initialize the boolean value
		boolean name = false;
		try {
			driver.findElementByTagName(tagname).clear();
			driver.findElementByTagName(tagname).sendKeys(Textkey);
			System.out.println("Entered text by :" + tagname);
			name = true;

		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			System.out.println(tagname + " is wrong");
		} finally {
			takeScreenshot();
		}
		return name;
	}

	// enter text by name
	public boolean enterTextByName(String name, String Textkey) {
		// initialize the boolean value
		boolean name1 = false;
		try {
			driver.findElementByName(name).clear();
			driver.findElementByName(name).sendKeys(Textkey);
			System.out.println("Entered text by :" + name);
			name1 = true;

		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			System.out.println(name + " is wrong");
		} finally {
			takeScreenshot();
		}
		return name1;
	}

	// get the background color
	public String backgroundColorByCssSelector(String tagname) throws IOException {
		String color = null;
		try {

			color = driver.findElementByTagName(tagname).getCssValue("background-color");
			System.out.println(color);
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			System.out.println(tagname + " id wrong");
		} finally {
			takeScreenshot();
		}

		return color;
	}

	// getsize by Xpath
	public Dimension getSizeByXPath(String xpath) throws IOException {
		// initialize the text value
		Dimension text = null;
		try {
			// storing the value to text
			text = driver.findElementByXPath(xpath).getSize();
			System.out.println(text);
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			System.out.println(xpath + " is wrong");
		} finally {
			takeScreenshot();
		}

		return text;
	}

	// getsize by id
	public Dimension getSizeById(String id) throws IOException {
		// initialize the text value
		Dimension text = null;
		try {
			// storing the value to text
			text = driver.findElementById(id).getSize();
			System.out.println(text);
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			System.out.println(id + " is wrong");
		} finally {
			takeScreenshot();
		}

		return text;
	}

	// getsize by classname
	public Dimension getSizeByClassName(String classname) throws IOException {
		// initialize the text value
		Dimension text = null;
		try {
			// storing the value to text
			text = driver.findElementById(classname).getSize();
			System.out.println(text);
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			System.out.println(classname + " is wrong");
		} finally {
			takeScreenshot();
		}

		return text;
	}

	// dismiss alert
	public boolean dismissAlerts() {
		boolean flag = false;
		try {

			driver.switchTo().alert().dismiss();
			System.out.println("Alert was Dismissed");
			flag = true;
		} catch (UnhandledAlertException e) {
			System.out.println("Alert was not handled");
		} catch (NoAlertPresentException e) {
			System.out.println("No Alert was there");
		} finally {
			takeScreenshot();
		}
		return flag;
	}

	// getlocation by Xpath
	public Point getLocationByXPath(String xpath) throws IOException {
		// initialize the text value
		Point text = null;
		try {
			// storing the value to text
			text = driver.findElementByXPath(xpath).getLocation();
			System.out.println(text);
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			System.out.println(xpath + " is wrong");
		} finally {
			takeScreenshot();
		}

		return text;
	}

	// getlocation by casename
	public Point getLocationByCaseName(String casename) throws IOException {
		// initialize the text value
		Point text = null;
		try {
			// storing the value to text
			text = driver.findElementByClassName(casename).getLocation();
			System.out.println(text);
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			System.out.println(casename + " is wrong");
		} finally {
			takeScreenshot();
		}

		return text;
	}

	// getlocation by id
	public Point getLocationById(String id) throws IOException {
		// initialize the text value
		Point text = null;
		try {
			// storing the value to text
			text = driver.findElementById(id).getLocation();
			System.out.println(text);
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			System.out.println(id + " is wrong");
		} finally {
			takeScreenshot();
		}

		return text;
	}

	// size of element in a list by id
	public int sizeOfListById(String id) {
		int size = 0;
		try {
			size = driver.findElementsById(id).size();
			System.out.println(size);
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			System.out.println(id + " is wrong");
		}
		return size;
	}

	// size of element in a list by casename
	public int sizeOfListByClassName(String classname) {
		int size = 0;
		try {
			size = driver.findElementsById(classname).size();
			System.out.println(size);
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			System.out.println(classname + " is wrong");
		}
		return size;
	}

	// gettitle
	public void getTitle() {

		String getString = null;
		try {
			getString = driver.getTitle();
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			System.out.println("The Element with Xpath :" + getString + "is not available");
		} finally {
			takeScreenshot();
		}
	}

	// gettext by name
	public String getTextByName(String name) {
		String text = null;

		try {
			text = driver.findElementByName(name).getText();
			System.out.println(text);
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			System.out.println("The Element with id :" + name + "is not available");
		} finally {
			takeScreenshot();
		}
		return text;
	}

	// gettext by linktext
	public String getTextByLinkText(String name) {
		String text = null;

		try {
			text = driver.findElementByLinkText(name).getText();
			System.out.println(text);
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			System.out.println("The Element with id :" + name + "is not available");
		} finally {
			takeScreenshot();
		}
		return text;
	}

	// gettext by id
	public String getTextById(String id) {
		String text = null;

		try {
			text = driver.findElementById(id).getText();
			System.out.println(text);
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			System.out.println("The Element with id :" + id + "is not available");
		} finally {
			takeScreenshot();
		}
		return text;
	}

	// gettext by className
	public String getTextByClassName(String Classname) {
		String text = null;

		try {
			text = driver.findElementByClassName(Classname).getText();
			System.out.println(text);
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			System.out.println("The Element with id :" + Classname + "is not available");
		} finally {
			takeScreenshot();
		}
		return text;
	}

	// select frame by index.
	public void switchToFrame(int frame) {
		try {
			driver.switchTo().frame(frame);
			System.out.println("Navigated to frame using id " + frame);
		} catch (NoSuchFrameException e) {
			System.out.println("Unable to locate frame using frame id" + frame);

		} finally {
			takeScreenshot();
		}
	}

	// frames by name or id
	public void switchToFrame(String frame) {

		try {
			driver.switchTo().frame(frame);
			System.out.println("Navigated to frame using name" + frame);
		} catch (NoSuchFrameException e) {
			System.out.println("Unable to locate frame using name" + frame);

		} finally {
			takeScreenshot();
		}

	}

	// frames by webelement
	public void switchToFrame(WebElement frameElement) {

		try {
			driver.switchTo().frame(frameElement);
			System.out.println("the frame with " + frameElement + "is available");
		} catch (NoSuchFrameException e) {
			System.out.println("the frame with " + frameElement + "is not available");

		} finally {
			takeScreenshot();
		}
	}

	// defaultcontent
	public void switchToDefaultContent() {
		try {
			driver.switchTo().defaultContent();
			System.out.println("Navigate back to the web page from frame");
		} catch (NoSuchFrameException e) {

			System.out.println("unable to navigate back to the web page from frame");
		} finally {
			takeScreenshot();
		}
	}

	// frames size
	public void switchTotalCount() {
		try {

			List<WebElement> allframes = driver.findElementsByTagName("iframe");
			System.out.println("Total number of frames is" + allframes.size());
		} catch (NoSuchFrameException e) {
			System.out.println("The frame is not available");

		} finally {
			takeScreenshot();
		}

	}

	// verify text that contains by xpath
	public boolean verifyTextContainsByXPath(String Xpath, String str2)

	{
		boolean flag = false;
		String str1 = null;

		try {
			str1 = driver.findElementByXPath(Xpath).getText();
			if (str1.contains(str2)) {
				System.out.println("String1 in contains String2");
				flag = true;
			} else {
				System.out.println("String1 in doesn't contains string2");
			}
			flag = false;

		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block ex
			System.out.println("Verify text contain by xpath failed due to the element not found");
		} catch (UnreachableBrowserException ex) {
			System.out.println(
					"Verify text contains by Xpath could not work due to browser has closed or the address in the URL is wrong");
		} catch (Exception exx) {
			System.out.println("Verify text contains by Xpath has failed due to some exception");
		} finally {
			takeScreenshot();
		}
		return flag;
	}

	// verify text that contains by id
	public boolean verifyTextContainsById(String id, String str2)

	{
		boolean flag = false;
		String str1 = null;
		str1 = driver.findElementById(id).getText();
		try {

			if (str1.contains(str2)) {
				System.out.println("String1 contains String2");
				flag = true;
			} else {
				System.out.println("String1 doesn't contains string2");
			}
			flag = false;

		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block ex
			System.out.println("Verify text contain by" + id + "  failed due to the element not found");
		} catch (UnreachableBrowserException ex) {
			System.out.println("Verify text contains by" + id
					+ " could not work due to browser has closed or the address in the URL is wrong");
		} catch (Exception exx) {
			System.out.println("Verify text contains by" + id + " has failed due to some exception");
		} finally {
			takeScreenshot();
		}
		return flag;
	}

	// verify text equals by id
	public boolean verifyTextEqualsById(String id, String str2)

	{
		boolean flag = false;
		String str1 = null;

		try {
			str1 = driver.findElementById(id).getText();
			if (str1.equals(str2)) {
				System.out.println("String1 equals String2");
				flag = true;
			} else {
				System.out.println("String1 doesn't equals String2");
			}
			flag = false;

		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block ex
			System.out.println("Verify text contain by id failed due to the element not found");
		} catch (UnreachableBrowserException ex) {
			System.out.println(
					"Verify text contains by id could not work due to browser has closed or the address in the URL is wrong");
		} catch (Exception exx) {
			System.out.println("Verify text contains by id has failed due to some exception");
		} finally {
			takeScreenshot();
		}
		return flag;
	}

	// verify text equals by classname
	public boolean verifyTextEqualsByClassName(String classname, String str2)

	{
		boolean flag = false;
		String str1 = null;

		try {
			str1 = driver.findElementByClassName(classname).getText();
			if (str1.equals(str2)) {
				System.out.println("String1 equals String2");
				flag = true;
			} else {
				System.out.println("String1 doesn't equals String2");
			}
			flag = false;

		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block ex
			System.out.println("Verify text contain by id failed due to the element not found");
		} catch (UnreachableBrowserException ex) {
			System.out.println(
					"Verify text contains by id could not work due to browser has closed or the address in the URL is wrong");
		} catch (Exception exx) {
			System.out.println("Verify text contains by id has failed due to some exception");
		} finally {
			takeScreenshot();
		}
		return flag;
	}

	// verify text equals by xpath
	public boolean verifyTextEqualsByXPath(String xpath, String str2)

	{
		boolean flag = false;
		String str1 = null;

		try {
			str1 = driver.findElementByXPath(xpath).getText();
			if (str1.equals(str2)) {
				System.out.println("String1 in" + xpath + " equals String2");
				flag = true;
			} else {
				System.out.println("String1 in" + xpath + " doesn't equals String2");
			}
			flag = false;

		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block ex
			System.out.println("Verify text contain by xpath failed due to the element not found");
		} catch (UnreachableBrowserException ex) {
			System.out.println(
					"Verify text contains by xpath could not work due to browser has closed or the address in the URL is wrong");
		} catch (Exception exx) {
			System.out.println("Verify text contains by xpath has failed due to some exception");
		} finally {
			takeScreenshot();
		}
		return flag;
	}

	// quit browser
	public void quitBrowser() {

		try {
			driver.quit();
			System.out.println("All Browsers were closed");
		} catch (NoSuchSessionException e) {
			// TODO Auto-generated catch block
			System.out.println("Browser quit has failed");
		}

	}

	// close browser
	public void closeBrowser() {

		try {
			driver.close();
			System.out.println("Browser was closed");
		} catch (NoSuchSessionException e) {
			// TODO Auto-generated catch block
			System.out.println("No Browser to close");
		}

	}

	// Explicitly for the visibility of the element
	public void explicitWaitForElementByVisibility(WebElement Element, int Seconds) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.visibilityOf(Element));
		} catch (TimeoutException e) {

			// TODO Auto-generated catch block
			System.out.println("Element was not found");
		} finally {
			takeScreenshot();
		}
	}

	// Explicitly wait for the text to be present
	public void explicitWaitForElementByTextPresent(WebElement element, String Text) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.textToBePresentInElement(element, Text));
		} catch (Exception e) {

			// TODO Auto-generated catch block
			System.out.println("Exception in explicit wait by element for Text ");
		}
	}

	// verify title
	public boolean verifyTitle(String expectedTitle) {
		boolean flag = false;
		try {

			String title = driver.getTitle();
			if (title.equals(expectedTitle)) {
				System.out.println("Title Matches");
				flag = true;
			} else {
				System.out.println("Title does not Match");
				flag = false;
			}

		} catch (WebDriverException e) {
			// TODO Auto-generated catch block
			System.out.println("Unable to verfiy the title");
		} finally {
			takeScreenshot();

		}
		return flag;

	}

	// get text in alerts
	public String getAlertsText() {
		String txt = null;
		try {
			txt = driver.switchTo().alert().getText();
			System.out.println(txt);
		} catch (UnhandledAlertException e1) {
			System.out.println("Alert was not handled");
		} catch (NoAlertPresentException e2) {
			System.out.println("No Alert was there");
		}

		return txt;
	}

	// switch to alerts
	public boolean switchTOAlert() {
		boolean flag = false;
		try {
			driver.switchTo().alert();
			flag = true;
		} catch (UnhandledAlertException e) {
			System.out.println("Alert was not handled");
		} catch (NoAlertPresentException e1) {
			System.out.println("No Alert was there");
		}
		return flag;
	}

	// accept alert
	public void acceptAlerts() {

		try {
			driver.switchTo().alert().accept();
			System.out.println("Alert was handled");
		} catch (UnhandledAlertException e) {
			System.out.println("Alert was not handled");
		} catch (NoAlertPresentException e1) {
			System.out.println("No Alert was there");
		}

	}

	// get window handle of parentwindow
	public String getWindowHandle() {
		String parentwindow = null;
		try {
			parentwindow = driver.getWindowHandle();
			System.out.println(" Parent window handle was stored");
		} catch (NoSuchWindowException e) {
			// TODO Auto-generated catch block
			System.out.println(" No windows are there to take the window handle");
		}
		return parentwindow;
	}

	// get window handles of allchildwindows
	public Set<String> getWindowHandles() {
		Set<String> windowhandle = null;
		try {
			Set<String> Allwindowhandles = driver.getWindowHandles();
			System.out.println(" All window handle was stored");
		} catch (NoSuchWindowException e) {
			// TODO Auto-generated catch block
			System.out.println(" No windows are there to take the window handle");
		}
		return windowhandle;
	}

	// switch to parent window
	public String switchToParentWindow(String parentwindow) {
		String text = null;
		try {

			driver.switchTo().window(parentwindow);

		} catch (NoSuchWindowException e) {
			System.out.println("The window is not available");

		}
		return text;
	}

	// switch to childwindow
	public void switchToChildWindow() {

		try {
			Set<String> Allwindowhandles = driver.getWindowHandles();
			for (String eachWindow : Allwindowhandles) {
				driver.switchTo().window(eachWindow);
			}

		} catch (NoSuchWindowException e) {
			System.out.println("The window is not available");

		}
	}

	// get the data from Excel to dataprovider
	public Object[][] excelToDataProvider(String filename) {
		// Read the file
		// Create an object array
		Object[][] obj = null;
		try {
			FileInputStream fis = new FileInputStream(new File("./data/" + filename + ".xlsx"));
			XSSFWorkbook Wbook = new XSSFWorkbook(fis);

			// go to first sheet
			XSSFSheet Sheet = Wbook.getSheetAt(0);

			// get number of rows
			int lastRow = Sheet.getLastRowNum();

			// get number of cells
			int LastCell = Sheet.getRow(0).getLastCellNum();
			obj = new Object[lastRow][LastCell];
			for (int i = 1; i <= lastRow; i++) {

				// go to the row
				XSSFRow Row = Sheet.getRow(i);

				for (int j = 0; j < LastCell; j++) {
					// go to Cell

					XSSFCell Cell = Row.getCell(j);

					String number = Integer.toString(j);
					// move the data in to created object array
					obj[i - 1][j] = Cell.getStringCellValue();
				}

			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("File '" + filename + "' is not found");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("problem occured");
		}
		return obj;

	}

}
