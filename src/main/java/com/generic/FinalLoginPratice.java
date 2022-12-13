package com.generic;

import java.time.Duration;

import org.openqa.selenium.WebDriver;

import com.driverManager.DiverManagers;
import com.utill.Constants;


public class FinalLoginPratice {

	public static void getFinalLogin() {
		
		WebDriver driver=DiverManagers.getBrowser("chrome");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		//go to url
		driver.get(Constants.url);
		//Click signinbtn
		
	}
	public static void main(String[] args) {
		getFinalLogin();
	}
}
