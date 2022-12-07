package com.amazon_pom;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.PageFactoryFinder;

public class Amazon_Pom {
	public static WebDriver driver;

	

	@FindBy(xpath = "//span[@class='a-size-medium a-color-base a-text-normal']")
	private List<WebElement> results;

	public List<WebElement> getResults() {
		return results;
	}

	public Amazon_Pom(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "(//div[@class='s-suggestion-container'])[3]")
	private WebElement searchOption;

	public WebElement getSearchOption() {
		return searchOption;
	}

}
