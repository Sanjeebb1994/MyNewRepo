package com.tricky.xpath;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleBrowserWindows {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.edgedriver().setup();
		WebDriver driver=new EdgeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://opensource-demo.orangehrmlive.com/");
		driver.manage().window().maximize();
		
		//getWindowHandle().
//		String windowId=driver.getWindowHandle();
//		System.out.println(windowId);
		
		//getWindowHandles().
		driver.findElement(By.linkText("OrangeHRM, Inc")).click();
		Set<String>windowId=driver.getWindowHandles();
		//1st Approach By iteretor().
		/*
		 * Iterator<String>it=windowId.iterator(); String parentID=it.next(); String
		 * childID=it.next();
		 * 
		 * System.out.println("Parent Id is: "+parentID);
		 * System.out.println("Child Id is: "+childID);
		 */
		
		//2nd Approach By ArrayList
//		List<String>windowIDList=new ArrayList(windowId);
//		String ParentId=windowIDList.get(0);
//		String childId=windowIDList.get(1);
//		
//		System.out.println("Parent Id is: "+ParentId);
//		System.out.println("Child Id is: "+childId);
//		
//		//SwitchWindow().
//		driver.switchTo().window(ParentId);
//		System.out.println("The title of Parent Window is: "+driver.getTitle());
//		
//		driver.switchTo().window(childId);
//		System.out.println("The title of Child Window is: "+driver.getTitle());
		
		for(String winId:windowId) {
			String title=driver.getTitle();
			if(title.equals("OrangeHRM HR Software | Free & Open Source HR Software | HRMS | HRIS")) {
				Thread.sleep(5000);
				driver.switchTo().window(winId);
				System.out.println(driver.getTitle());
				break;
			}
		}
		driver.quit();
	}
}
