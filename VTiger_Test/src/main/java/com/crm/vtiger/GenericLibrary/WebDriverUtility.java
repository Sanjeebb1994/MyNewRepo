/**
 * 
 */
package com.crm.vtiger.GenericLibrary;


import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;



/**
 * @author DELL
 *
 */
public class WebDriverUtility {
	/**
	 * This Method is design to lunch multiple browser option.
	 * @param Browser
	 */
	
	public void  getCrossBrowserExecutioin( String Browser) {
		if(Browser=="chrome" ) {
			WebDriverManager.chromedriver().setup();
		}else if(Browser=="firefox") {
			WebDriverManager.firefoxdriver().setup();
		}else {
			System.out.println("No such Browser Available");
		}
	}
	
	
	/**
	 * This method is used For implicitly Wait.
	 * @param driver
	 */
	public void waitForPagetobeLoaded(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	
	/**
	 * This method is Use for Explicitly wait.
	 * @param driver
	 * @param location
	 * @param timeouts
	 */
	
	public void waitForElementTobeLoaded(WebDriver driver, By location, int timeouts) {
		WebDriverWait wait=new WebDriverWait(driver, timeouts);
		wait.until(ExpectedConditions.elementToBeClickable(location));
	}
	
	public void windowHandles(WebDriver driver,String title) {
		String mainId=driver.getWindowHandle();
		Set<String> windId=driver.getWindowHandles();
		for(String id:windId) {
			if(!id.equals(mainId)) {
				driver.switchTo().window(title);
				break;
			}
		}
	}
}
