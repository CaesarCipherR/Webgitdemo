package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
	
	public WebDriver driver;
	By signin = By.id("u_0_2");
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

    public WebElement getLogin() {
    	return driver.findElement(signin);
    }

}
