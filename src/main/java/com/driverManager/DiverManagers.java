package com.driverManager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.safari.SafariDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DiverManagers {

	static WebDriver driver ;
	public static WebDriver getBrowser(String BrowserName){
		
		if(BrowserName.contains("chrome")) {
			WebDriverManager.chromedriver().setup();
			 driver = new ChromeDriver();
		}else if(BrowserName.contains("safari")) {
			WebDriverManager.safaridriver().setup();
			 driver = new SafariDriver();
		}else if(BrowserName.contains("edge")) {
			WebDriverManager.edgedriver().setup();
			 driver = new EdgeDriver();
		}
	return driver;	
	}

}