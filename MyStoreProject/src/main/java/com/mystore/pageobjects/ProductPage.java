package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;

public class ProductPage extends BaseClass {
	
	Action action= new Action();
	
	@FindBy(id = "qty") 
	private WebElement qty;
	
	@FindBy(xpath = "//span[contains(.,'Add to Cart')]") 
	private WebElement addToCartBtn;
	
	@FindBy(xpath = "//main[@id='maincontent']/div/div[2]/div/div/div") 
	private WebElement addToCartText;
	
	@FindBy(xpath = "//div[2]/div/a")
	private WebElement shoppingCart;
	
	@FindBy(xpath = "//button[contains(.,'Proceed to Checkout')]")
	private WebElement proceedToCheckoutBtn;
	
	public ProductPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	public ShippingPage clickOnSignIn() throws Throwable {
		action.isDisplayed(getDriver(), addToCartText);
		action.click(getDriver(), addToCartBtn);
		action.click(getDriver(),  shoppingCart);
		action.click(getDriver(), proceedToCheckoutBtn);		
		return new ShippingPage();
	}
}
