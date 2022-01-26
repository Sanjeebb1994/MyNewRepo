package com.tricky.xpath;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DropDownHandling {
	public static void main(String[] args) {
		WebDriverManager.edgedriver().setup();
		WebDriver driver=new EdgeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.opencart.com/index.php?route=account/register");
		driver.manage().window().maximize();
		
		//Handle Drop Down==>
		//1st Approach:
		WebElement element=driver.findElement(By.id("input-country"));
//		Select sel=new Select(element);
//		sel.selectByIndex(8);
//		sel.selectByValue("55");
//		sel.selectByVisibleText("Cote D'Ivoire");
		
		//2nd Approach:
		Select country=new Select(element);
		List<WebElement>countryEle=country.getOptions();
		for(WebElement select:countryEle) {
			if(select.getText().equals("Macedonia")) {
				select.click();
				break;
			}
		}
		
	}
}
