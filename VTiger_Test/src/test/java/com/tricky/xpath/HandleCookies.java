package com.tricky.xpath;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleCookies {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.amazon.com");
		driver.manage().window().maximize();
		
		//1] How to get cookies. 
		Set<Cookie> cookies=driver.manage().getCookies();
		System.out.println("The size of Cookies are: "+cookies.size());
		
		//2] How to Print cookies.
		for(Cookie cookie:cookies) {
			System.out.println(cookie.getName()+"==>"+cookie.getValue());
		}
		
		//3] How to Add cookies.
		Cookie cookieobj=new Cookie("Sanjeeb Cookie", "8984263538");
		driver.manage().addCookie(cookieobj);
		cookies=driver.manage().getCookies();
		System.out.println("The size of Cookies are: "+cookies.size());
		
		//4] How to delete Cookies.
		driver.manage().deleteCookie(cookieobj);
		driver.manage().deleteCookieNamed("session-id-time");
		cookies=driver.manage().getCookies();
		System.out.println("The size of Cookies are: "+cookies.size());
		
		//5] How to delete All cookies.
		driver.manage().deleteAllCookies();
		cookies=driver.manage().getCookies();
		System.out.println("The size of Cookies are: "+cookies.size());
		
		driver.quit();
	}

}
