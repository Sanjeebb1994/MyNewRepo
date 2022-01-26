package com.tricky.xpath;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import com.crm.vtiger.GenericLibrary.JavaScriptUtil;

import io.github.bonigarcia.wdm.WebDriverManager;

public class JavascriptExecuter {

	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		
		WebDriverManager.edgedriver().setup();
		WebDriver driver=new EdgeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://demo.nopcommerce.com/");
		driver.manage().window().maximize();
		
		WebElement element=driver.findElement(By.xpath("//img[@alt='nopCommerce demo store']"));
		
		//1. Draw boarder
		//JavaScriptUtil.drawBoarder(element, driver);
		
		//2.Return Title
//		String title=JavaScriptUtil.returnTitleByJS(driver);
//		System.out.println(title);
		
		//3. Draw boarder and Take ScreenShot
		/*
		 * WebElement
		 * logo=driver.findElement(By.xpath("//img[@alt='nopCommerce demo store']"));
		 * JavaScriptUtil.drawBoarder(logo, driver); TakesScreenshot
		 * ts=(TakesScreenshot)driver; File src=ts.getScreenshotAs(OutputType.FILE);
		 * File trg=new File(".\\ScreenShot\\logo.png"); FileUtils.copyFile(src, trg);
		 */
		
		//4. Flash Element
		JavaScriptUtil.flash(element, driver);
		
		//5. Page Zoom In And ZoomOut
//		JavaScriptUtil.zoomPageByJS(driver);
		
		//6. ScrollUp And ScrllDown
		Thread.sleep(5000);
		JavaScriptUtil.pageScrollDown(driver);
		
//		Thread.sleep(5000);
//		JavaScriptUtil.pageScrollUP(driver);
		
		driver.close();
	}

}
