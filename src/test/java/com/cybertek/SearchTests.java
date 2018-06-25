package com.cybertek;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SearchTests {
  
  @Test
  public void amazonSearchOne() {
    WebDriverManager.chromedriver().setup();
    WebDriver driver = new ChromeDriver();
    driver.get("http://amazon.com");
    String str = "Selenium Testing Tools Cookbook";
    
    driver.findElement(By.id("twotabsearchtextbox")).sendKeys(str+Keys.ENTER);
    
    String xpath = "//h2[@class='a-size-medium s-inline  s-access-title  a-text-normal'][.='Selenium Testing Tools Cookbook']";
    // isDisplayed  -> returns true of the element we located is displayed on the page
    
    //Assert.assertTrue(driver.findElement(By.xpath(xpath)).isDisplayed());
    driver.findElement(By.id("twotabsearchtextbox")).clear();
    driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Java OCA book" +Keys.ENTER);
    
    Assert.assertFalse(driver.findElement(By.xpath(xpath)).isDisplayed());
    
    driver.close();
    
  }

}