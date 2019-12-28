package com.gmai.elimentLocator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.gmail.utilities.BasePage;


public class LoginPage extends BasePage {
	
	WebDriver driver;
// page object/By locator
	By email = By.name("email"); 
	By password = By.name("pass");
	By loginBtn =  By.name("login");

	
	//login class constructor
	
	public LoginPage(WebDriver driver) {
		
		this.driver = driver;
	}
	
	public String getTitle() {
		 return driver.getTitle();
	}
	
	
	
	public HomePage doLogin(String username, String pwd) {
		driver.findElement(email).sendKeys(username);
		driver.findElement(password).sendKeys(pwd);
		
		driver.findElement(loginBtn).click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return new HomePage(driver);// page chaining 
	}
}
