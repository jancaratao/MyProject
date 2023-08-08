package com.mystore.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.mystore.base.BaseClass;
import com.mystore.pageobjects.IndexPage;
import com.mystore.utility.Log;

public class IndexPageTest extends BaseClass {

	IndexPage indexPage;
	
	@Parameters("browser")
	@BeforeMethod(groups = {"Smoke", "Sanity"})
	public void setup(String browser) {
		launchApp(browser);
	}
	
	@AfterMethod(groups = {"Smoke", "Sanity"})
	public void tearDown() {
		getDriver().quit();
	}
	
	@Test(groups = "Smoke")
	public void verifyLogo() throws Throwable {
		Log.startTestCase("indexPageTest");
		indexPage = new IndexPage();
		Log.info("Verify whether logo is available and correct");
		boolean result = indexPage.validateLogo();
		Assert.assertTrue(result);
	}
	
	@Test(groups = "Smoke")
	public void verifyTitle() {
		indexPage = new IndexPage();
		String title = indexPage.getMyStoreTitle();
		Log.info("Verify whether page title is correct");
		Assert.assertEquals(title, "Home Page");
		Log.endTestCase("indexPageTest");
	}
}
