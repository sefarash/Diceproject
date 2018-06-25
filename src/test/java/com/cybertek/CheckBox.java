package com.cybertek;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CheckBox {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver =new ChromeDriver();
		
		driver.get("http://the-internet.herokuapp.com/checkboxes");
		//WebElement firstOne = driver.findElement(By.tagName("input"));
		WebElement firstOne = driver.findElement(By.xpath("//input[@type='checkbox']"));
		//WebElement secondOne = driver.findElement(null);
		System.out.println(firstOne.isSelected());
		
		firstOne.click();
		System.out.println(firstOne.isSelected());
		firstOne.click();
		driver.close();

	}

}
