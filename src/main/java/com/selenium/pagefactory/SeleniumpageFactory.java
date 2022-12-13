package com.selenium.pagefactory;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SeleniumpageFactory {
	WebDriver driver;

	public SeleniumpageFactory(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//*[@class='authorization-link']") // 1 of 2
	private List<WebElement> signinBtn;// findElements()
	@FindBy(xpath = "//*[@id='email']")
	private WebElement email;
	@FindBy(xpath = "//*[@title='Password']")
	private WebElement password;
	@FindBy(xpath = "//*[@class='action login primary']")
	private WebElement secondSigninBtn;
	@FindBy(xpath = "//*[@class='greet welcome']") // 1 of 2
	private List<WebElement> welcome;// findElements()<== new
	// Cosco WebPage
	@FindBy(xpath = "//*[@id='navigation-widget']//a")
	private List<WebElement> CoscoMenuBtn;

	@FindBy(xpath = "//*[text()='Sign In / Register']")
	private List<WebElement> coscoSignin;

	@FindBy(xpath = "//*[@class='sub-item']")
	private List<WebElement> dealOptions;
	
	
	public WebDriver getDriver() {
		return driver;
		
	}

	public List<WebElement> getSigninBtn() {
		return signinBtn;
	}

	public WebElement getEmail() {
		return email;
	}

	public WebElement getPassword() {
		return password;
	}

	public WebElement getSecondSigninBtn() {
		return secondSigninBtn;
	}

	public List<WebElement> getWelcome() {
		return welcome;
	}
/// Cosco xpath
	public List<WebElement> getCoscoSignin() {
		return coscoSignin;
	}

	public List<WebElement> getCoscoMenuBtn() {
		return CoscoMenuBtn;

	}
	public List<WebElement> getDealOptions() {
		return dealOptions;
	}
}
