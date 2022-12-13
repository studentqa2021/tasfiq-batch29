package com.cucumber.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import com.driverManager.DiverManagers;
import com.selenium.pagefactory.SeleniumpageFactory;
import com.utill.Constants;
import com.utill.HighLighter;
import com.utill.ScreenShot;
import com.utill.SeleniumWait;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class StepDef {
	WebDriver driver;
	SeleniumpageFactory pf;

	@Given("open any browser")
	public void open_any_browser() {
		driver = DiverManagers.getBrowser("chrome");
		driver.manage().window().maximize();
		SeleniumWait.getImplicitWait(driver, 3);

	}

	@Given("go to application URL")
	public void go_to_application_URL() {
		driver.get(Constants.url);
		ScreenShot.getScreenShot(driver, "HomePage");

	}

	@When("click sign in button")
	public void click_sign_in_button() {
		pf = new SeleniumpageFactory(driver);
		SeleniumWait.getExplicitWait(driver, pf.getSigninBtn().get(0), 5);
		HighLighter.getColor(driver, pf.getSigninBtn().get(0));
		ScreenShot.getScreenShot(driver, "SignBtn");
		pf.getSigninBtn().get(0).click();

	}

	@When("put user name")
	public void put_user_name() {
		HighLighter.getColor(driver, pf.getEmail(), "blue");
		ScreenShot.getScreenShot(driver, "UserName");
		pf.getEmail().sendKeys(Constants.user);

	}

	@When("put password")
	public void put_password() {

		ScreenShot.getScreenShot(driver, "Password");
		HighLighter.getColor(driver, pf.getPassword(), "green");
		pf.getPassword().sendKeys(Constants.password);
	}

	@When("click second signin button")
	public void click_second_signin_button() {
		HighLighter.getColor(driver, pf.getSecondSigninBtn());
		ScreenShot.getScreenShot(driver, "2nd Signin btn");
		pf.getSecondSigninBtn().click();

	}

	@Then("validate login was successful")
	public void validate_login_was_successful() {
		HighLighter.getColor(driver, pf.getWelcome().get(0));
		ScreenShot.getScreenShot(driver, "Validation Welcome");
		boolean status = pf.getWelcome().get(0).isDisplayed();
		Assert.assertTrue(status);
		SoftAssert sa = new SoftAssert();
		sa.assertTrue(status);
		sa.assertAll();
		System.out.println(status);

	}
}
