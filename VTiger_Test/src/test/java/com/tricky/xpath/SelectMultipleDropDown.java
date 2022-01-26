package com.tricky.xpath;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SelectMultipleDropDown {
	static WebDriver driver;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.edgedriver().setup();
		 driver=new EdgeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.orangehrm.com/orangehrm-30-day-trial-old/");
		driver.manage().window().maximize();
		
		WebElement employees=driver.findElement(By.name("NoOfEmployees"));
		selectListDropDown(employees,"16 - 20");
		WebElement industry=driver.findElement(By.name("Industry"));
		selectListDropDown(industry,"Automotive");
		WebElement country=driver.findElement(By.name("Country"));
		selectListDropDown(country,"Mauritius");
	}
	public static void selectListDropDown(WebElement ele,String value) {
		Select sel=new Select(ele);
		List<WebElement>option=sel.getOptions();
		for(WebElement we:option) {
			if(we.getText().equals(value)) {
				we.click();
				break;
			}
		}
	}

}
