package com.tricky.xpath;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleBrokenLinks {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		WebDriverManager.edgedriver().setup();
		WebDriver driver=new EdgeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://www.deadlinkcity.com/");
		driver.manage().window().maximize();
		
		List<WebElement>links=driver.findElements(By.tagName("a"));
		int brokenLinks=0;
		for(WebElement element:links) {
			String url=element.getAttribute("href");
			if(url==null||url.isEmpty()) {
				System.out.println("URL is Empty...");
				continue;
			}
			
			URL link=new URL(url);
			try {
				HttpURLConnection httpconn=(HttpURLConnection) link.openConnection();
				httpconn.connect();
				if(httpconn.getResponseCode()>=400) {
					System.out.println(httpconn.getResponseCode()+url+" is BrokenLinks.");
					brokenLinks++;
				}else {
					System.out.println(httpconn.getResponseCode()+url+" is ValidLinks.");
				}
			} catch (Exception e) {
				
			}
		}
		System.out.println("No of BrokenLinks are: "+brokenLinks);
		driver.quit();
	}

}
