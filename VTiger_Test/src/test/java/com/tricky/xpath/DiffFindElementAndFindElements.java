package com.tricky.xpath;


import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DiffFindElementAndFindElements {
	public static void main(String[] args) {
		WebDriverManager.edgedriver().setup();
		WebDriver driver=new EdgeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://demo.nopcommerce.com/register");
		driver.manage().window().maximize();
		
		//FindElement-->
//		//1
//		WebElement searchbox=driver.findElement(By.name("q"));
//		searchbox.sendKeys("items");
//		//2
//		WebElement footer=driver.findElement(By.xpath("//div[@class='footer-upper']//a"));
//		System.out.println(footer.getText());
//		//3
//		WebElement logo=driver.findElement(By.xpath("//img[@src='https://demo.nopcommerce.com/Themes/DefaultClean/Content/images/log.png']"));
//		System.out.println(logo.getText());
		
		//FindElements-->
		List<WebElement>list =driver.findElements(By.xpath("//div[@class='footer-upper']//a"));
		System.out.println("No of Links are Presents: "+list.size());
		
		List<WebElement>image=driver.findElements(By.id("small-searchterms"));
		System.out.println(image.size());
		List<WebElement>image1=driver.findElements(By.xpath("//img[@src='https://demo.nopcommerce.com/Themes/DefaultClean/Content/images/log.png']"));
		System.out.println(image1.size());
	
		List<WebElement>links=driver.findElements(By.xpath("//div[@class='footer-upper']//a"));
		for(WebElement element:links) {
			System.out.println(element.getText());
		}
		
		driver.close();
	}
}
