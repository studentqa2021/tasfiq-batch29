package com.generic;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.asserts.SoftAssert;

import com.driverManager.DiverManagers;
import com.selenium.pagefactory.SeleniumpageFactory;
import com.utill.Constants;
import com.utill.HighLighter;
import com.utill.ScreenShot;
import com.utill.SeleniumWait;

public class CoscoAutomation {

	public static void productHandles() throws InterruptedException {
		// open browser
		WebDriver driver = DiverManagers.getBrowser("chrome");
		driver.manage().window().maximize();
		driver.navigate().to(Constants.coscoUrl);
		SeleniumWait.getImplicitWait(driver, 3);
		System.out.println("Home Page Title: " + driver.getTitle());
		ScreenShot.getScreenShot(driver, "Cosco Welcome Page");
		System.out.println("Current pg URL= " + driver.getCurrentUrl());
		SoftAssert sa = new SoftAssert();
		sa.assertEquals(driver.getCurrentUrl(), Constants.coscoUrl);

		//
		SeleniumpageFactory pf = new SeleniumpageFactory(driver);
		HighLighter.getColor(driver, pf.getCoscoSignin().get(0), "red");
		pf.getCoscoSignin().get(0).click();
		System.out.println("Login Page Title: " + driver.getTitle());
		ScreenShot.getScreenShot(driver, "Cosco Login page");
		// step 6= Go back to hm page
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
//		for(int i=0;i<10;i++) {
//			if(pf.getCoscoSignin().size()>0) {
//				break;
//			}else {
//				driver.navigate().back();
//			}
//		}
		while (true) {// infinite loop
			if (pf.getCoscoSignin().size() > 0) {
				break;
			} else {
				driver.navigate().back();
				Thread.sleep(3000);
			}
		}
		// 7) Read all options and count options below the login button
		// total count
		System.out.println("Menu Count = " + pf.getCoscoMenuBtn().size());// menu count
		for (int i = 0; i < pf.getCoscoMenuBtn().size(); i++) {// looping
			HighLighter.getColor(driver, pf.getCoscoMenuBtn().get(i));// highlight
			System.out.println(pf.getCoscoMenuBtn().get(i).getText());// read the name by getText() method

		}
		// 8) If the deal was there, then mouse over it and read all options
		// Mouse Hover ==> by Action Action = moveElement()

		for (int i=0;i<pf.getCoscoMenuBtn().size();i++) {
			if (pf.getCoscoMenuBtn().get(i).getText().contains("Deals")) {// if it's true
				HighLighter.getColor(driver, pf.getCoscoMenuBtn().get(i), "green");
				Actions ac = new Actions(driver);
				ac.moveToElement(pf.getCoscoMenuBtn().get(i)).perform();;
				Thread.sleep(2000);
				System.out.println("Deal Options count = "+pf.getDealOptions().size());
				//Read name of All options==>Looping= all options
				for(int j=0;j<pf.getDealOptions().size();j++) {
					HighLighter.getColor(driver, pf.getDealOptions().get(j));	
					System.out.println(pf.getDealOptions().get(j).getText());
				}
			}
		}
		sa.assertAll();
	}

	public static void main(String[] args) throws InterruptedException {
		CoscoAutomation.productHandles();
	}
}
