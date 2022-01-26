package com.tricky.xpath;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleIframePopup {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		WebDriverManager.edgedriver().setup();
		WebDriver driver=new EdgeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.selenium.dev/selenium/docs/api/java/index.html?overview.summary.html");
		driver.manage().window().maximize();
		
		Thread.sleep(3000);
		
		//1st frame-->
		driver.switchTo().frame("packageListFrame");
		driver.findElement(By.linkText("org.openqa.selenium")).click();
		driver.switchTo().defaultContent();
		
		Thread.sleep(3000);
		
		//2nd Frame-->
		driver.switchTo().frame("packageFrame");
		driver.findElement(By.xpath("//span[text()='JavascriptExecutor']")).click();
		driver.switchTo().defaultContent();
		
		Thread.sleep(3000);
		
		//3rd Frame-->
		driver.switchTo().frame("classFrame");
		driver.findElement(By.linkText("InternetExplorerDriver")).click();
//		driver.switchTo().defaultContent();
		
		driver.close();
	}

}	
