package com.tricky.xpath;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleCheckbox {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.edgedriver().setup();
		WebDriver driver=new EdgeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://itera-qa.azurewebsites.net/home/automation");
		driver.manage().window().maximize();
		
		//1]-->Select a specific CheckBox.
//		driver.findElement(By.id("thursday")).click();
		
		//2]-->Select all checkbox.
		List<WebElement>checkbox=driver.findElements(By.xpath("//input[@type='checkbox' and contains(@id,'day')]"));
		System.out.println("The No. of heckBox are: "+checkbox.size());
		
		/*
		 * for(int i=0;i<checkbox.size();i++) { checkbox.get(i).click(); }
		 */
		/*
		 * for(WebElement wb:checkbox) { wb.click(); }
		 */
		
		//3]-->Select multiple checkBox.
		/*
		 * for(WebElement wb:checkbox) { String text=wb.getAttribute("id");
		 * if(text.equals("wednesday")||text.equals("thursday")||text.equals("friday"))
		 * { wb.click(); } }
		 */
		
		//4]-->Select last two CheckBox.
		//apply formula TotalNo.of = checkbox-how many want to select
		/*
		 * int totalnoofcheckbox=checkbox.size(); for(int
		 * i=totalnoofcheckbox-2;i<totalnoofcheckbox;i++) { checkbox.get(i).click(); }
		 */
		
		//5]-->Select First two CheckBox.
		for(int i=0;i<checkbox.size();i++) {
			if(i<2) {
				checkbox.get(i).click();
			}
			
		}
	}

}
