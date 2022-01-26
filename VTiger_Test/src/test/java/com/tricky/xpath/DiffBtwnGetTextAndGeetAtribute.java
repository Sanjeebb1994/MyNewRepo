package com.tricky.xpath;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DiffBtwnGetTextAndGeetAtribute {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.edgedriver().setup();
		WebDriver driver=new EdgeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://admin-demo.nopcommerce.com/login");
		driver.manage().window().maximize();
		
		//Clear & Enter value
		WebElement textbox=driver.findElement(By.id("Email"));
		textbox.clear();
		textbox.sendKeys("Sanjeebdash2050@gmail.com");
		
		//getText() & getAttribute
		System.out.println("The data present in TextBox is: "+textbox.getText());
		System.out.println("The data present in TextBox is: "+textbox.getAttribute("value"));
		
		String text=driver.findElement(By.id("Password")).getAttribute("value");
		String text1=driver.findElement(By.xpath("//label[text()='Password:']")).getText();
		System.out.print(text1+" is: ");
		System.out.println(text);
		
		driver.close();
		
	}

}
