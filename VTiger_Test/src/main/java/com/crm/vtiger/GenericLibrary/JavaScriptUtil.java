package com.crm.vtiger.GenericLibrary;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class JavaScriptUtil {
	
	public static void drawBoarder(WebElement element, WebDriver driver) {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].style.border='3px solid red'", element);
	}
	
	public static String returnTitleByJS(WebDriver driver) {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		String titlie=js.executeScript("return document.title;").toString();
		return titlie;
	}
	
	public static void cllickElementByJS(WebElement element, WebDriver driver) {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click;", element);
	}
	
	public static void generateAlertByJS(String message, WebDriver driver) {
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("alert('"+ message +"')");
	}
	
	public static void  pageRefreshByJS(WebDriver driver) {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("history.go(0)");
	}
	
	public static void pageScrollDown(WebDriver driver) {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("windows.scrollTo(0,2000)");
	}
	
	public static void pageScrollUP(WebDriver driver) {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("windows.scrollBy(0,2000)");
	}
	
	public static void zoomPageByJS(WebDriver driver) {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeAsyncScript("document.body.style.zoom='250%'");
	}
	
	public static void flash(WebElement element, WebDriver driver) {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		String bgColor=element.getCssValue("backgroundColor");
		for(int i=0;i<10;i++) {
			changeColor("#000000",element,driver);
			changeColor(bgColor,element,driver);
		}
	}
	
	public static void changeColor(String color, WebElement element, WebDriver driver) {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].style.backgroundColor ='"+ color +"'", element);
		try {
			Thread.sleep(50);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
