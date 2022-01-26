package com.crm.practice;

import java.awt.AWTException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ScrollingHandling {

	public static void main(String[] args) throws AWTException, InterruptedException {
		// TODO Auto-generated method stub
		
		WebDriverManager.edgedriver().setup();
		WebDriver driver=new EdgeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.flipkart.com/");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//button[text()='✕']")).click();
		
		//By using Robot class.
		Thread.sleep(5000);
//		Robot r=new Robot();
//		r.keyPress(KeyEvent.VK_PAGE_DOWN);
//		Thread.sleep(5000);
//		r.keyPress(KeyEvent.VK_PAGE_DOWN);
//		Thread.sleep(5000);
//		r.keyRelease(KeyEvent.VK_PAGE_UP);
//		
		//By using Java ScriptExecuter
		JavascriptExecutor jse=(JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0, 2000);");
		Thread.sleep(5000);
		
		driver.close();
		
	}

}
