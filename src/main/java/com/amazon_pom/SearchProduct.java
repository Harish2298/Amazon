package com.amazon_pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchProduct {
	public static WebDriver driver;
	@FindBy(xpath = "//select[@id='searchDropdownBox']")
	private WebElement dropDown;

	public WebElement getDropDown() {
		return dropDown;
	}
	
	
	@FindBy(xpath = "//input[@type='text']")
	private WebElement search;

	public WebElement getSearch() {
		return search;
	}
	
	public SearchProduct(WebDriver driver1) {
		this.driver=driver1;
		PageFactory.initElements(driver, this);
	}
	
	
	
	
	
	
}
