package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;

public class IndexPage extends BaseClass {
	
	Action action= new Action();
	
	@FindBy(xpath= "//a[contains(text(),'Sign In')]") 
	private WebElement signInBtn;
	
	@FindBy(xpath = "//a/img")
	private WebElement myStoreLogo;
	
	@FindBy(id="search")
	private WebElement searchProductBox;
	
	@FindBy(name="search_mini_form")
	private WebElement searchButton;
	
	@FindBy(xpath = "//button[@type='button']")
	private WebElement topMenuBtn;
	
	@FindBy(xpath = "//a[contains(.,'My Account')]")
	private WebElement myAccountBtn;
	
	public IndexPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	public LoginPage clickOnSignIn() throws Throwable {
		action.implicitWait(getDriver(), 20);
		action.fluentWait(null, signInBtn, 10);
		action.click(getDriver(), signInBtn);
		return new LoginPage();
	}
	
	public boolean validateLogo() throws Throwable {
		return action.isDisplayed(getDriver(), myStoreLogo);
	}
	
	public String getMyStoreTitle() {
		String myStoreTitle=getDriver().getTitle();
		return myStoreTitle;
	}
	
	public SearchResultPage searchProduct(String productName) throws Throwable {
		action.type(searchProductBox, productName);
		action.scrollByVisibilityOfElement(getDriver(), searchButton);
		action.click(getDriver(), searchButton);
		Thread.sleep(3000);
		return new SearchResultPage();
	}
	
	public HomePage goToMyAccount () throws Throwable {
		action.click(getDriver(), topMenuBtn);
		action.click(getDriver(), myAccountBtn);
		return new HomePage();
	}
	
	public String getCurrURL() {
		String indexPageURL = getDriver().getCurrentUrl();
		return indexPageURL;
	}
	
	

}