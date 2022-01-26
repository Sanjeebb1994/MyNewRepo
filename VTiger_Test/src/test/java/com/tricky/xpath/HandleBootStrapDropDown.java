package com.tricky.xpath;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleBootStrapDropDown {
	public static WebDriver driver;
	public static void main(String[] args) {
		WebDriverManager.edgedriver().setup();
		 driver=new EdgeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.hdfcbank.com/");;
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//div[@class='drp1']")).click();
		List<WebElement>dropdowntype=driver.findElements(By.xpath("//ul[@class='dropdown1 dropdown-menu']//li"));
		selectMultipleBootsrap(dropdowntype,"Accounts");
		
		driver.findElement(By.xpath("//div[@class='drp2']//div[@class='dropdown']")).click();
		List<WebElement>product=driver.findElements(By.xpath("//ul[@class='dropdown2 dropdown-menu']/li"));
		selectMultipleBootsrap(product,"Savings Accounts");
		driver.close();
	}
	
	public static void selectMultipleBootsrap(List<WebElement>option, String value) {
		System.out.println(option.size());
		for(WebElement wb:option) {
			if(wb.getText().equals(value)) {
				wb.click();
			}
		}
	}
	
}
