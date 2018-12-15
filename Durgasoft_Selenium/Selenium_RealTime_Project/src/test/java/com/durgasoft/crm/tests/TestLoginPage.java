package com.durgasoft.crm.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.durgasoft.crm.base.TestBase;
import com.durgasoft.crm.pages.LoginPage;

public class TestLoginPage extends TestBase {

	LoginPage loginpage;

	public TestLoginPage() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		System.out.println(prop.getProperty("url"));
		initialization();
		loginpage = new LoginPage();
	}

	@Test(enabled = true)
	public void testPageTitle() {
		String expectedTitle = loginpage.getPageTitle();
		System.out.println("expectedTitle:::"+expectedTitle);
		Assert.assertEquals(expectedTitle, "Overview");
	}

	//@Test
	public void testLogin() {
		loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
