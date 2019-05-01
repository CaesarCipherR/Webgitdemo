package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class Base {
	
	public static WebDriver driver;
	public Properties prop;
	public WebDriver initializeDriver() throws IOException {
		prop = new Properties();
		FileInputStream fis = new FileInputStream("C:\\Users\\Mariana\\ApplicationMaven\\src\\main\\java\\resources\\data.properties");
		prop.load(fis);
		String browser = prop.getProperty("browser");
		System.out.println(browser);
		if (browser.equals("chrome"))
		{
			String nodeURL="http://192.168.5.17:5555/wd/hub";
			DesiredCapabilities cap	= DesiredCapabilities.chrome();
			cap.setBrowserName("chrome");
			cap.setPlatform(Platform.WIN10);
			System.setProperty("webdriver.chrome.driver", "C:\\Drivers\\chromedriver.exe");
			driver = new RemoteWebDriver(new URL(nodeURL),cap);
		}
		else if (browser.equals("firefox")) {
			driver = new FirefoxDriver();
		}
		else if (browser.equals("IE")) {
			driver = new InternetExplorerDriver();
			
		}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;
	}
	public void getScreenshot(String result) throws IOException {
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File("C:\\Users\\Mariana\\test\\"+result+"screenshot.png"));
	}

}
