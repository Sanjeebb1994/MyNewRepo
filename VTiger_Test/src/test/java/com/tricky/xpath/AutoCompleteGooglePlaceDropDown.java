package com.tricky.xpath;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AutoCompleteGooglePlaceDropDown {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.edgedriver().setup();
		WebDriver driver=new EdgeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.twoplugs.com/");
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//a[text()='Live Posting']")).click();
		WebElement element=driver.findElement(By.id("autocomplete"));
		element.clear();
		element.sendKeys("Toronto");
		String text;
		do {
			element.sendKeys(Keys.ARROW_DOWN);
			text=element.getAttribute("value");
			if(text.equals("Toronto, OH, USA")) {
				element.sendKeys(Keys.ENTER);
				break;
			}
		}while(!text.isEmpty());
			driver.close();
	}
}
