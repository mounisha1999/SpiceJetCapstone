package utilities;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebUtils extends FileUtils {
	public static WebDriver driver = null;
	public static Actions action;
	public static Select select;
	public static ExtentHtmlReporter htmlreporter;
	public static ExtentReports reports;
	public static ExtentTest test;

	public static void startReport() {
		htmlreporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "/AutomationTestReport.html");
		reports = new ExtentReports();
		reports.attachReporter(htmlreporter);
	}

	public static void stopReport() {
		reports.flush();
	}

	public static boolean browserlaunch(String value) {
		boolean flag = false;
		try {
			switch (value) {
			case "Chrome":
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
				flag = true;
				test.log(Status.INFO, "Chrome browser launched");
				break;
			case "Edge":
				WebDriverManager.edgedriver().setup();
				driver = new EdgeDriver();
				flag = true;
				test.log(Status.INFO, "Edge browser launched");
				break;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		driver.manage().window().maximize();
		return flag;
	}

	public static boolean browserEnd() {
		boolean flag = false;
		try {
			driver.close();
			test.log(Status.INFO, "Browser Closed");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}

	public static boolean implicitWait(int value) {
		boolean flag = false;
		try {
			driver.manage().timeouts().implicitlyWait(value, TimeUnit.SECONDS);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}

	public static boolean explicitWait(WebElement element, int value) {
		boolean flag = false;
		try {
			WebDriverWait wait = new WebDriverWait(driver, value);
			wait.until(ExpectedConditions.visibilityOf(element));
		} catch (Exception e) {
			e.printStackTrace();

		}
		return flag;
	}

	public static boolean pageLaunch(String value) {
		boolean flag = false;
		try {
			driver.get(value);
			test.log(Status.INFO, "Navigated to : " + value);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}

	public static boolean clickbutton(WebElement element) {
		boolean flag = false;
		try {
			element.click();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}

	public static boolean sendkey(WebElement element, String value) {
		boolean flag = false;
		try {
			element.sendKeys(value);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}
//
//	public static void navigateBackward() {
//		try {
//			driver.navigate().back();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}

//	public static boolean clearText(WebElement element) {
//		boolean flag = false;
//		try {
//			element.clear();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return flag;
//	}

//	public static boolean enterKey(WebElement element) {
//		boolean flag = false;
//		try {
//			Robot r = new Robot();
//			r.keyPress(KeyEvent.VK_ENTER);
//		} catch (Exception e) {
//		}
//		return flag;
//	}
	public String getCurrentUrl() {
		String currenturl = driver.getCurrentUrl();
		return currenturl;
	}

	public static String getText(WebElement element) {
		String value = null;
		try {
			value = element.getText();
		} catch (Exception e) {
		}
		return value;
	}

//	public static void selectDownIndex(WebElement element, int value) {
//
//		try {
//			select = new Select(element);
//			select.selectByIndex(value);
//			element.click();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//
//	}
//
	public static void selectDownValue(WebElement element, String value) {

		try {
			select = new Select(element);
			select.selectByValue(value);
			element.click();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void selectDownVisible(WebElement element, String value) {
		try {
			select = new Select(element);
			select.selectByVisibleText(value);
			element.click();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	public static boolean windowHandles() {
		boolean flag = false;
		try {
			Set<String> alldata = driver.getWindowHandles();
			for (String data: alldata) {
				driver.switchTo().window(data).getTitle();	
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}

	public static String getTitle() {
		String value = null;
		try {
			value = driver.getTitle();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return value;
	}

	public static String currenturl() {
		String value = null;
		try {
			value = driver.getCurrentUrl();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return value;
	}
	public void click(WebElement element) {
		try {
			explicitWait(element, 20);
			JavascriptExecutor js = (JavascriptExecutor)driver;
			js.executeScript("arguments[0].click();",element);
		} catch (Exception e) {
			e.printStackTrace();
		}


	}
	public static void frameIn(WebElement element) {
		try {
			explicitWait(element, 10);
			driver.switchTo().frame(element);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void frameOut() {
		try {
			driver.switchTo().defaultContent();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	

	public static void getScreenShot(String screenshotName) {
		try {
			TakesScreenshot ts = (TakesScreenshot) driver;
			File source = ts.getScreenshotAs(OutputType.FILE);
			File destination = new File("./Screenshots/" + screenshotName + ".png");
			FileHandler.copy(source, destination);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
