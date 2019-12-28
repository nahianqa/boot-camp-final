package com.gmail.testcase;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.gmai.elimentLocator.HomePage;
import com.gmai.elimentLocator.LoginPage;
import com.gmail.utilities.BasePage;
import com.gmail.utilities.Constant;
import com.gmail.utilities.LogCollection;


public class LoginPageTest {
	
	
WebDriver driver;
LoginPage loginpage;
BasePage basepage;
Properties prop;
HomePage homepage;


	@BeforeMethod
	public void browserSetup() {
		basepage= new BasePage();
		prop =basepage.init_properties();
		 driver =basepage.getBrowser(prop);
			loginpage = new LoginPage(driver);


	}
	
	
	@Test
	public void verfyLoginPageTitle() {
		String title=loginpage.getTitle();
		System.out.println("The page title is " + title);
		Assert.assertEquals(title, Constant.Login_Page_title);

	}
	
	@Test
	public void userlogin() {
		loginpage.doLogin(prop.getProperty("username"),prop.getProperty("pwd"));
		LogCollection.debug("logged in Successfully");

	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
