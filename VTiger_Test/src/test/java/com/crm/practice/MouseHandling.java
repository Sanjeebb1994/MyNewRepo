package com.crm.practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MouseHandling {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(12, TimeUnit.SECONDS);
		driver.get("http://localhost:8888");
		driver.manage().window().maximize();
		WebElement login=driver.findElement(By.name("user_name"));
		login.sendKeys("admin",Keys.TAB,"root",Keys.ENTER);
		
		Actions act=new Actions(driver);
		WebElement logout=driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		act.moveToElement(logout).perform();
		driver.findElement(By.linkText("Sign Out")).click();
		
		driver.close();
	}

}
