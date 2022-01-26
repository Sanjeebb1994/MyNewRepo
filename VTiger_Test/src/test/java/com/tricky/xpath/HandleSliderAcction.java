package com.tricky.xpath;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleSliderAcction {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.edgedriver().setup();
		WebDriver driver=new EdgeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.jqueryscript.net/demo/Price-Range-Slider-jQuery-UI/");
		driver.manage().window().maximize();
		
		WebElement Increase_Range=driver.findElement(By.xpath("//span[@class='ui-slider-handle ui-corner-all ui-state-default'][1]"));
		System.out.println("The location of Increase_Range is: "+Increase_Range.getLocation());//(59, 250)
		System.out.println("The size of Increase_Range is: "+Increase_Range.getSize());//(22, 21)
		
		Actions act=new Actions(driver);
		act.dragAndDropBy(Increase_Range, 100, 0).perform();
		
		System.out.println("The location of Increase_Range is: "+Increase_Range.getLocation());//(161, 250)
		System.out.println("The size of Increase_Range is: "+Increase_Range.getSize());//(22, 21)
		
		WebElement decrease_Range=driver.findElement(By.xpath("//span[2]"));
		System.out.println("The location of Increase_Range is: "+decrease_Range.getLocation());//(544, 250)
		System.out.println("The size of Increase_Range is: "+decrease_Range.getSize());//(22, 21)
		
		Action perform=act.dragAndDropBy(decrease_Range, -200, 0).build();
		perform.perform();
		
		System.out.println("The location of Increase_Range is: "+decrease_Range.getLocation());//(345, 250)
		System.out.println("The size of Increase_Range is: "+decrease_Range.getSize());//(22, 21)
		
		driver.close();
	}

}
