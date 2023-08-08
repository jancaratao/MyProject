/**
 * 
 */
package com.mystore.pageobjects;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;

/**
 * @author Hitendra
 *
 */
public class AccountCreationPage extends BaseClass {
	
	Action action= new Action();
	
	@FindBy(xpath = "//span[contains(.,'Create New Customer Account')]")
	private WebElement formTitle;
	
	@FindBy(id = "firstname")
	private WebElement firstName;
	
	@FindBy(id = "lastname")
	private WebElement lastName;

	@FindBy(id = "email_address")
	private WebElement emailAddress;
	
	@FindBy(id = "password")
	private WebElement password;
	
	@FindBy(id = "password-confirmation")
	private WebElement confirmPassword;
	
	@FindBy(xpath = "xpath=//span[contains(.,'Create an Account')]")
	private WebElement createAccountBtn;
	
	public AccountCreationPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	public void createAccount(String fName, 
			String lName, 
			String eMail, 
			String pswd,
			String confPwd) throws Throwable {
		
		action.type(firstName, fName);
		action.type(lastName, lName);
		action.type(emailAddress, eMail);
		action.type(password, pswd);
		action.type(confirmPassword, confPwd);
	}
	
	public HomePage validateRegistration() throws Throwable {
		createAccountBtn.click();
		return new HomePage();
	}
	
	public boolean validateAcountCreatePage() throws Throwable {
		 return action.isDisplayed(getDriver(), formTitle);
	}
	
}