package com.durgasoft.crm.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.durgasoft.crm.base.TestBase;

public class LoginPage extends TestBase {

	@FindBy(name = "username")
	WebElement txtUsername;
	@FindBy(name = "password")
	WebElement txtPassword;
	@FindBy(xpath = "//*[@id='loginForm']/div/div/input")
	WebElement btnLogin;

	public LoginPage() {

		PageFactory.initElements(driver, this);
	}
	
	
	public String getPageTitle() {
		return driver.getTitle();
	}

	public HomePage login(String un, String pw) {
		txtUsername.sendKeys(un);
		txtPassword.sendKeys(pw);
		btnLogin.click();

		return new HomePage();
	}

}
