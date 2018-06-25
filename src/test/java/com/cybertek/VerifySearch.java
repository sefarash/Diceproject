package com.cybertek;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class VerifySearch {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver =new ChromeDriver();
		driver.get("http://etsy.com");
		driver.findElement(By.id("search-query")).sendKeys("fathers day gift"+Keys.ENTER);
		String title = driver.getTitle();
		if (title.equals("Fathers day gift | Etsy")) {
			System.out.println("PASS");
		}else {
			System.out.println("FAIL");
		}
		String search = driver.findElement(By.name("search_query")).getAttribute("value");
		System.out.println(search);
		if (search.equals("fathers day gift")) {
			System.out.println("PASS");
		}else {
			System.out.println("FAIL");
			System.out.println("expected:\t"+ "fathers day gift");
			System.out.println("found: \t" + search);
		}
		
		
		
		

	}

}
