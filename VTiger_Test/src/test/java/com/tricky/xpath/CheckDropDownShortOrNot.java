package com.tricky.xpath;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;


import io.github.bonigarcia.wdm.WebDriverManager;

public class CheckDropDownShortOrNot {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.edgedriver().setup();
		WebDriver driver=new EdgeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.twoplugs.com/");
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//a[text()='Live Posting']")).click();
		WebElement elements=driver.findElement(By.name("category_id"));
		Select selectoption=new Select(elements);
		List<WebElement> element=selectoption.getOptions();
		
		ArrayList originallist=new ArrayList();
		ArrayList templist=new ArrayList();
		
		for(WebElement wb:element) {
			originallist.add(wb.getText());
			templist.add(wb.getText());
		}
		System.out.println("Original List is: "+originallist);
		System.out.println("Temp List is: "+templist);
		
		Collections.sort(templist);
		System.out.println("Original List is: "+originallist);
		System.out.println("Temp List After sorting: "+templist);
		
		if(originallist.equals(templist)) {
			System.out.println("DropDown is Sorting Order...");
		}else {
			System.out.println("DropDown is Unshorting!!!!!");
		}
		
		driver.close();
		
	}

}
