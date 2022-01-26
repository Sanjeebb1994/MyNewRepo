package com.tricky.xpath;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleIframe3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriverManager.edgedriver().setup();
		WebDriver driver=new EdgeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.w3schools.com/html/tryit.asp?filename=tryhtml_iframe_height_width");
		driver.manage().window().maximize();
		
		driver.switchTo().frame("iframeResult");
		driver.switchTo().frame(0);
		WebElement text=driver.findElement(By.xpath("//h1[text()='This page is displayed in an iframe']"));
		System.out.println("The innerFrame text is: "+text.getText());
		
		driver.switchTo().parentFrame();
		WebElement text2=driver.findElement(By.xpath("//p[contains(text(),'use the height and width ')]"));
		System.out.println("The outerFrame text is: "+text2.getText());
		
		driver.close();
	}

}
