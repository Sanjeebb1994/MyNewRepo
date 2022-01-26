package com.tricky.xpath;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CaptureScreenShot {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.amazon.com/");
		driver.manage().window().maximize();
		
		//1] Capture ScreenShot of A entire Page.
		/*TakesScreenshot ts=(TakesScreenshot)driver;
		File src=ts.getScreenshotAs(OutputType.FILE);
		File dest=new File(".\\ScreenShot\\fullpage.png");
		FileUtils.copyFile(src, dest);*/
		
		//2] Capture ScreenShot of a Particular section .
		WebElement section=driver.findElement(By.xpath("//div[@id='desktop-1']"));
		File src=section.getScreenshotAs(OutputType.FILE);
		File tar=new File(".\\ScreenShot\\sectionpage.png");
		FileUtils.copyFile(src, tar);
		
		//3] Capture particular Element
		WebElement logo=driver.findElement(By.xpath("//a[@id='nav-logo-sprites']"));
		File src1=logo.getScreenshotAs(OutputType.FILE);
		File tar1=new File(".\\ScreenShot\\element.png");
		FileUtils.copyFile(src1, tar1);
		
//		driver.close();
	}

}
