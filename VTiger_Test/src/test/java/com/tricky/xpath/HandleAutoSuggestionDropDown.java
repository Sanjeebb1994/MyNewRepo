package com.tricky.xpath;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleAutoSuggestionDropDown {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.edgedriver().setup();
		WebDriver driver=new EdgeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.bing.com/");
		driver.manage().window().maximize();
		
		driver.findElement(By.name("q")).sendKeys("Selenium");
		List<WebElement>element=driver.findElements(By.xpath("//li[@class='sa_sg']//span"));
		System.out.println("The size of list is: "+element.size());
		Thread.sleep(5000);
		for(WebElement wb:element) {
			if(wb.getText().contains("download")) {
				wb.click();
				break;
			}
		}
		
		driver.close();
	}

}
