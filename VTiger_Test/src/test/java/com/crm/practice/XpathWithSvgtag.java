package com.crm.practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class XpathWithSvgtag {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.navigate().to("https://www.icc-cricket.com/teams/women");
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//div[contains(text(),'Rankings') and @class='global-navigation__link']")).click();
		driver.findElement(By.linkText("Team Rankings")).click();
		WebElement element=driver.findElement(By.xpath("//table[@class='table']/tbody/tr[3]/td[*]"));
		System.out.println(element.getText());
		
//		WebElement flag=driver.findElement(By.xpath("//table[@class='table']/tbody/tr[4]/td[2]/span[@class='flag-15 table-body_logo IND']"));
//		flag.getScreenshotAs(null);
		
		Thread.sleep(5000);
		driver.close();
	}

}
