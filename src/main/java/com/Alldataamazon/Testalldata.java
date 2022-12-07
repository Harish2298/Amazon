package com.Alldataamazon;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Testalldata {
	public static void amazon() throws InterruptedException, IOException {
		System.setProperty("webdriver.chrome.driver", "/Users/r.harish/eclipse-workspace/DataDriven/chromedriver");
		WebDriver driver = new ChromeDriver();

		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		WebElement dropDown = driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));
		String expected = Amazonalldata.allData("Amazon", 1, 0);// replace of sendkeys(excel la irunthu get panrom)
		Select s = new Select(dropDown);

		List<WebElement> options = s.getOptions();
		for (WebElement option : options) {
			String dDown = option.getText();

			if (expected.equalsIgnoreCase(dDown)) {
				
				s.selectByVisibleText(expected);
			} else {
				continue;
			}
		
		}
        Thread.sleep(3000);
		WebElement search = driver.findElement(By.xpath("//input[@type='text']"));
		String searchValue = Amazonalldata.allData("Amazon", 2, 1);// replace of sendkeys(excel la irunthu get panrom)
		search.sendKeys(searchValue);

		Thread.sleep(2000);
		driver.findElement(By.xpath("(//div[@class='s-suggestion-container'])[3]")).click();

		List<WebElement> results = driver.findElements(By.xpath("//span[@class='a-size-medium a-color-base a-text-normal']"));
        
		for (WebElement result : results) {
			String text = result.getText();
			
		}
        System.out.println("The Total count is"+ "=" +results.size() );
		Thread.sleep(2000);
		driver.quit();
		
		
		
	}
   
	public static void main(String[] args) throws IOException, InterruptedException {
		amazon();
	}
}
