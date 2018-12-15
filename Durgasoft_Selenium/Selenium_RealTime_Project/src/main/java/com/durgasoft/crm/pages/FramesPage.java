package com.durgasoft.crm.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.durgasoft.crm.base.TestBase;

public class FramesPage extends TestBase {

	@FindBy(linkText = "org.openqa.selenium")
	WebElement lnkSelenium;

	public FramesPage() {

		PageFactory.initElements(driver, this);
		}
	
	public String getSeleniumLinkText() {
		
		driver.switchTo().frame(2);
		lnkSelenium.click();
		
		return driver.getTitle();
		
	}

}
