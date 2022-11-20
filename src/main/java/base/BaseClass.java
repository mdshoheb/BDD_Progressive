package base;

import static utils.IConstant.*;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import com.google.common.io.Files;
import io.github.bonigarcia.wdm.WebDriverManager;
import pages.auto.AboutYou;
import pages.common.HomePage;
import pages.homeOwners.ConfirmPropertyAddressPage;
import pages.homeOwners.HomeOwnerZipCode;
import pages.homeOwners.PropertyAddressPage;
import reporting.Logs;
import utils.Configuration;

public class BaseClass {

	public Configuration config = new Configuration();
	public static WebDriver driver;
	public static HomePage homePage;
	public static AboutYou aboutYou;
	public static HomeOwnerZipCode homeOwnerZipCode;
	public static PropertyAddressPage propertyAddressPage;
	public static ConfirmPropertyAddressPage confirnPropertyAddressPage;

	public void setUpDriver() {
	
		initDriver(config.getProperty(BROWSER));
		driver.manage().window().maximize();
		driver.get(config.getProperty((URL)));
		long pageLoadTime = Long.parseLong(config.getProperty(PAGELOAD_WAIT));
		long implicitWait = Long.parseLong(config.getProperty(IMPLICIT_WAIT));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(pageLoadTime));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(implicitWait));
		initClasses();
	}

	private void initDriver(String browser) {
		 switch (browser) {
		case CHROME:
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;
		case FIREFOX:
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;
		case EDGE:
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			break;
		case SAFARI:
			WebDriverManager.safaridriver().setup();
			driver = new SafariDriver();
		default:
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;
		}
	}

	public static void initClasses() {
		homePage = new HomePage(driver);
		aboutYou = new AboutYou(driver);
		homeOwnerZipCode = new HomeOwnerZipCode(driver);
		propertyAddressPage = new PropertyAddressPage(driver);
		confirnPropertyAddressPage = new ConfirmPropertyAddressPage(driver);
	}

	public WebDriver getDriver() {
		return driver;
	}

	public void closingDriverSession() {
		getDriver().quit();
	}

	public String takeScreenShot(String testName) {
		Date date = new Date();
		SimpleDateFormat format = new SimpleDateFormat("_MMddyyyy_hhmmss");
		File localFile = new File("test-output/screenShots/" + testName + format.format(date) + ".png");
		TakesScreenshot ss = (TakesScreenshot) driver;
		File driverSS = ss.getScreenshotAs(OutputType.FILE);
		try {
			Files.copy(driverSS, localFile);
			Logs.log("Screen Shot captured at \n" + localFile.getAbsolutePath());
		} catch (IOException e) {
			Logs.log("Error occurs during taking ScreenShot..!");
		}
		return localFile.getAbsolutePath();
	}

}
