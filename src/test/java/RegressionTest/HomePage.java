package RegressionTest;

import java.io.IOException;

import org.testng.annotations.AfterTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.LandingPage;
import pageObjects.LoginPage;
import resources.Base;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class HomePage extends Base {
	
	public static Logger log = LogManager.getLogger(Base.class.getName());
	
	@Test(dataProvider="getData")
	public void basePageNavigation(String Username, String Password, String text) throws IOException {
		driver = initializeDriver();
		log.info("Driver is initialized");
		driver.get("https://www.facebook.com");
		log.info("Navigated to the home page");
	    LandingPage lp = new LandingPage(driver);
	    lp.getEmails().sendKeys(Username);
	    lp.getPassword().sendKeys(Password);
	    log.info(text);
	    LoginPage l = new LoginPage(driver);
	    l.getLogin().click();
	}
	
	@AfterTest
	public void teardown() {
		driver.close();
		driver=null;
	}
	
	@DataProvider
	public Object[][] getData(){
		Object[][]data = new Object[2][3];
		data[0][0]="nonerestrictiveuser@facebook.com";
		data[0][1]="123456";
		data[0][2] = "None Restricitive User";
		
		data[1][0] = "restricitiveuser@facebook.com";
		data[1][1] = "678910";
		data[1][2] = "Restrictive User";
		
		return data;
		
	}

}
