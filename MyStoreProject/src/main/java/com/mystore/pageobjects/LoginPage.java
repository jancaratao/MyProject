package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;


public class LoginPage extends BaseClass {
	
	Action action= new Action();
	
	@FindBy(id="email")
	private WebElement userName;
	
	@FindBy(id="pass")
	private WebElement password;
	
	@FindBy(xpath = "//div[4]/div/button/span")
	private WebElement signInBtn;
	
	@FindBy(xpath= "//span[contains(.,'Create an Account')]")
	private WebElement createNewAccountBtn;
	
	@FindBy(id="login-form")
	private WebElement forgotYourPasswordBtn;
	
	public LoginPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	public IndexPage login(String uname, String pswd) throws Throwable {
		action.type(userName, uname);
		action.type(password, pswd);
		action.implicitWait(getDriver(), 20);
		action.fluentWait(null, signInBtn, 10);
		action.click(getDriver(), signInBtn);
		action.pause(5000);
		return new IndexPage();
	}
	
	public AccountCreationPage createNewAccount(String newEmail) throws Throwable {
		action.click(getDriver(), createNewAccountBtn);
		return new AccountCreationPage();
	}
	
}