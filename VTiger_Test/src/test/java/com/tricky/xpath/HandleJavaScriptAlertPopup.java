package com.tricky.xpath;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleJavaScriptAlertPopup {
	public static void main(String[] args) {
		
		WebDriverManager.edgedriver().setup();
		WebDriver driver=new EdgeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://the-internet.herokuapp.com/javascript_alerts");
		driver.manage().window().maximize();
		
		/*
		 * driver.findElement(By.xpath("//button[text()='Click for JS Alert']")).click();
		 * //Alert with only OK button driver.switchTo().alert().accept();
		 */
		
//		driver.findElement(By.xpath("//button[text()='Click for JS Confirm']")).click();
		//Alert with both OK and Cancel button.
//		Alert alt=driver.switchTo().alert();
//		alt.accept();
//		alt.dismiss();
		
		driver.findElement(By.xpath("//button[text()='Click for JS Prompt']")).click();
		//Alert with both for gettext() and Sendkey().
		Alert alt=driver.switchTo().alert();
//		System.out.println("The Alert text is: "+alt.getText());
		alt.sendKeys("Sanjeeb");
		alt.accept();
		
	}
}
