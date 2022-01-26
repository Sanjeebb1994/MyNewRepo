package com.crm.practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DropDOwnHandling {
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(12, TimeUnit.SECONDS);
		driver.get("http://localhost:8888");
		driver.manage().window().maximize();
		WebElement login=driver.findElement(By.name("user_name"));
		login.sendKeys("admin",Keys.TAB,"root",Keys.ENTER);
		driver.findElement(By.linkText("Organizations")).click();
		driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']/../../../..//tr/td//a[1]")).click();
		WebElement listbox=driver.findElement(By.xpath("//select[@name='industry']"));
		
		Select s=new Select(listbox);
		s.selectByIndex(2);
		s.selectByValue("Education");
		s.selectByVisibleText("Insurance");
		
		java.util.List<WebElement> option=s.getOptions();
		int count=0;
		for(WebElement op:option) {
			count++;
			System.out.println(op);
		}
		System.out.println("Total No of Links present==> "+count);
		
		driver.close();
	}
}
