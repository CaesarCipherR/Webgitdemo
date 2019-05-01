package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {
	public WebDriver driver;
	By email = By.id("email");
	By password = By.id("pass");
	By title = By.cssSelector(".fb_logo.img.sp_NAtlv9pBfsU.sx_dbc79a");
	By navBar = By.cssSelector("._6a._6b.product_desc");
	
	
	public LandingPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public WebElement getEmails() {
		return driver.findElement(email);
		
	}
	public WebElement getPassword() {
		return driver.findElement(password);
	}
	public WebElement getTitle() {
		return driver.findElement(title);
	}
	
	public WebElement getNavBar() {
		return driver.findElement(navBar);
	}

}
