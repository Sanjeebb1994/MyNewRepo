package com.crm.practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class XpathWithClinique {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.navigate().to("https://www.clinique.com/");
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//*[name()='svg' and @class='svgicon svgicon--arrow-8 hide_auth']")).click();
		
		Thread.sleep(5000);
		driver.quit();
	}

}
