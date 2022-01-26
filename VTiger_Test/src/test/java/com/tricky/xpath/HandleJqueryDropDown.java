package com.tricky.xpath;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;


import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleJqueryDropDown {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.edgedriver().setup();
		WebDriver driver=new EdgeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.jqueryscript.net/demo/Drop-Down-Combo-Tree/");
		driver.manage().window().maximize();
		
		driver.findElement(By.id("justAnInputBox")).click();
//		jQueryDropDownHandle(driver,"choice 1");
//		jQueryDropDownHandle(driver,"choice 1","choice 2 1","choice 2 3","choice 6","choice 6 1","choice 6 2 2","choice 6 2 3");
		jQueryDropDownHandle(driver,"All");
		driver.close();
	}
	
	public static void jQueryDropDownHandle(WebDriver driver,String... value) {
		List<WebElement> choice=driver.findElements(By.xpath("//span[@class='comboTreeItemTitle'] "));
		if(!value[0].equalsIgnoreCase("All")) {
			for(WebElement wb1:choice) {
				String text=wb1.getText();
				for(String val:value) {
					if(text.equals(val)) {
						wb1.click();
						break;
					}
				}
			}
		}
		else {
			try {
			for(WebElement wb2:choice) {
				wb2.click();
			 }
		   }
			catch(Exception e) {
				
			}
		}
	}

}
