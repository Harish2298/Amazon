package com.amazonTestNG;

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.testng.annotations.Test;

import com.BaseClassAzamon.BaseClassAz;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class TEstNG extends BaseClassAz{
	public WebDriver driver = null;

	@Test(priority = -1)
	public void browserLaunch() {
//		System.setProperty("webdriver.chrome.driver", "/Users/r.harish/eclipse-workspace/DataDriven/chromedriver");
//		 driver = new ChromeDriver();
		driver=browserLaunch("chrome");
	}

	@Test(priority = 0)
	public void url() {
//		driver.get("https://www.amazon.in/");
	currentUrl("https://www.amazon.in/");
		//driver.manage().window().maximize();
	    maxi();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Test(dependsOnMethods ="url" )
	public void searchDrop() {
		WebElement dropDown = driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));
		String expected = "Books";
		Select s = new Select(dropDown);
		List<WebElement> options = s.getOptions();
		for (WebElement option : options) {
			String dDown = option.getText();
			if (expected.equalsIgnoreCase(dDown)) {
				s.selectByVisibleText(expected);
				
			} //else {
//				continue;
//			}

		}
	}

	@Test(priority = 1)
	public void search() {
		WebElement search = driver.findElement(By.xpath("//input[@type='text']"));
		String value = "ikigai";
		//search.sendKeys(value);
sendKeys(search, value);
	}

	@Test(dependsOnMethods ="search" )
	public void text() throws InterruptedException {
		Thread.sleep(2000);
		WebElement search = driver.findElement(By.xpath("(//div[@class='s-suggestion-container'])[3]"));
		//.click();
		click(search);

		List<WebElement> results = driver
				.findElements(By.xpath("//span[@class='a-size-medium a-color-base a-text-normal']"));

		for (WebElement result : results) {
			String text = result.getText();

		}

		System.out.println("The Total count is" + "=" + results.size());
		//driver.close();
		close();
	}

}
