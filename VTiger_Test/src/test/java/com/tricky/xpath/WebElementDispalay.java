package com.tricky.xpath;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebElementDispalay {

	public static void main(String[] args) {
		WebDriverManager.edgedriver().setup();
		WebDriver driver=new EdgeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://demo.nopcommerce.com/register");
		
		//isDisplay(),isEnable().
		WebElement element=driver.findElement(By.id("small-searchterms"));
		System.out.println(element.isDisplayed());//true
		System.out.println(element.isEnabled());//true
		
		//isSelected();
		WebElement male=driver.findElement(By.id("gender-male"));
		WebElement female=driver.findElement(By.id("gender-female"));
		System.out.println(male.isSelected());//false
		System.out.println(female.isSelected());//false
		
		male.click();
		System.out.println(male.isSelected());//true
		System.out.println(female.isSelected());//false
		
		female.click();
		System.out.println(male.isSelected());//false
		System.out.println(female.isSelected());//true
		
		driver.close();
	}
}
