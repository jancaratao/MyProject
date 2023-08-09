package com.mystore.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.mystore.base.BaseClass;
import com.mystore.dataprovider.DataProviders;
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.LoginPage;
import com.mystore.utility.Log;

public class LoginPageTest extends BaseClass{

	IndexPage indexPage;
	LoginPage loginPage;
	
	@Parameters("browser")
	@BeforeMethod(groups = {"Smoke", "Sanity"})
	public void setup(String browser) {
		launchApp(browser);
	}
	
	@AfterMethod(groups = {"Smoke", "Sanity"})
	public void tearDown() {
		getDriver().quit();
	}
	
	@Test(dataProvider = "credentials", dataProviderClass = DataProviders.class, groups = {"Sanity", "Smoke"})
	public void loginTest(String uname, String pswd) throws Throwable {
		Log.startTestCase("loginTest");
		indexPage = new IndexPage();
		Log.info("User clicks on Sign-in");
		loginPage = indexPage.clickOnSignIn();
		Log.info("User enters username and password");
		//indexPage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		indexPage = loginPage.login(uname, pswd);
		String actualURL = indexPage.getCurrURL();
		String expectedURL = "https://magento.softwaretestingboard.com/";
		Log.info("Verify whether user is able to login successfully");
		Assert.assertEquals(actualURL, expectedURL);
		Log.info("Login is successful");
		Log.endTestCase("loginTest");
	}
}
