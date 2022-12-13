package com.generic;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import com.driverManager.DiverManagers;
import com.selenium.pagefactory.SeleniumpageFactory;
import com.utill.Constants;
import com.utill.HighLighter;
import com.utill.ScreenShot;
import com.utill.SeleniumWait;

public class BaseLogin {
	public static void getLogin() {
		WebDriver driver;
		SeleniumpageFactory pf;

		// open browser
		driver = DiverManagers.getBrowser("chrome");
		driver.manage().window().fullscreen();
		SeleniumWait.getImplicitWait(driver, 3);
		// go to URL
		driver.get(Constants.url);
		ScreenShot.getScreenShot(driver, "HomePage");
		// click sign in
		pf = new SeleniumpageFactory(driver);
		SeleniumWait.getExplicitWait(driver, pf.getSigninBtn().get(0), 5);
		HighLighter.getColor(driver, pf.getSigninBtn().get(0));
		ScreenShot.getScreenShot(driver, "SignBtn");
		pf.getSigninBtn().get(0).click();
		// put user
		HighLighter.getColor(driver, pf.getEmail(), "blue");
		ScreenShot.getScreenShot(driver, "UserName");
		pf.getEmail().sendKeys(Constants.user);
		// put password
		ScreenShot.getScreenShot(driver, "Password");
		HighLighter.getColor(driver, pf.getPassword(), "green");
		pf.getPassword().sendKeys(Constants.password);
		// click second signin btn
		HighLighter.getColor(driver, pf.getSecondSigninBtn());
		ScreenShot.getScreenShot(driver, "2nd Signin btn");
		pf.getSecondSigninBtn().click();
		// Validation
		HighLighter.getColor(driver, pf.getWelcome().get(0));
		ScreenShot.getScreenShot(driver, "Validation Welcome");
		boolean status = pf.getWelcome().get(0).isDisplayed();
		Assert.assertTrue(status);
		SoftAssert sa = new SoftAssert();
		sa.assertTrue(status);
		sa.assertAll();
		System.out.println(status);

//		if(pf.getWelcome().get(0).isDisplayed()) {
//			System.out.println("Test Pass");
//		}else
//		{System.out.println("test fail");}
	}
}
