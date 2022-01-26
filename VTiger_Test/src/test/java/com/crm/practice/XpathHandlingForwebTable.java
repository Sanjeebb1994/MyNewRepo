package com.crm.practice;

//import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class XpathHandlingForwebTable {
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://localhost:8888");
		driver.manage().window().maximize();
		
		WebElement login=driver.findElement(By.name("user_name"));
		login.sendKeys("admin",Keys.TAB,"root",Keys.ENTER);
		
		driver.findElement(By.linkText("Organizations")).click();
//		driver.findElement(By.xpath("//table[@class='lvt small']/tbody/tr[4]/td[1]")).click();
//		driver.findElement(By.xpath("//table[@class='lvt small']/tbody/tr[*]/td[*]")).click();
//		List<WebElement> element=driver.findElements(By.xpath("//table[@class='lvt small']/tbody/tr[5]/td[*]"));
//		System.out.println(element);
//		driver.findElement(By.xpath("//table[@class='lvt small']/tbody/tr[*]/td[3]")).click();
		driver.findElement(By.xpath("//table[@class='lvt small']/tbody/tr[3]/td[*]")).click();
//		driver.findElement(By.xpath("//table[@class='lvt small']/tbody/tr[contains(.,'ACC15')]/td[3]")).click();
//		driver.findElement(By.xpath("//table[@class='lvt small']/tbody/tr[last()]/td[last()]")).click();
		
		Thread.sleep(5000);
		WebElement logout=driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		Actions act=new Actions(driver);
		act.moveToElement(logout).perform();
		driver.findElement(By.linkText("Sign Out")).click();
		
		driver.close();
	}
}
