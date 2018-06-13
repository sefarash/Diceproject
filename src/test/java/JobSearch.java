import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class JobSearch {
	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().fullscreen();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		String url = "http://dice.com";
		//driver.navigate().to(url);
		driver.get(url);
		String actualTitle = driver.getTitle();
		String expected = "Job Search for Technology Professionals | Dice.com";
		if(actualTitle.equals(expected))
				System.out.println("passed");
		else
			System.out.println("failed");
		String keyword = "Java Programmer";
		String location = "22102";
		driver.findElement(By.id("search-field-keyword")).sendKeys(keyword);
		driver.findElement(By.id("search-field-location")).clear();
		driver.findElement(By.id("search-field-location")).sendKeys(location);
		driver.findElement(By.id("findTechJobs")).click();
		String count = driver.findElement(By.id("posiCountId")).getText();
		System.out.println(count);
		int countResult = Integer.parseInt(count.replaceAll(",", ""));
		if (countResult>0) {
			System.out.println("Step PASS:Keyword: "+keyword+" serach returned "+countResult+" results in "+ location);
		}else {
			System.out.println( "Step FAIL: Keyword : " + keyword +" search returned " +
					countResult +" results in " + location);
		}
		
	}
	
	

}
