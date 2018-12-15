package com.durgasoft.crm.tests;

import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.durgasoft.crm.base.TestBase;
import com.durgasoft.crm.util.TestUtil;

public class TestFrames extends TestBase {

	// FramesPage framesPage;

	public TestFrames() {

	}

	@BeforeMethod
	public void setUp() {
		System.out.println(prop.getProperty("url"));
		initialization();
		// framesPage = new FramesPage();
	}

	@Test(enabled = true)
	public void testPageTitle() {

		driver.switchTo().frame("classFrame");
		driver.findElement(By.linkText("com.thoughtworks.selenium")).click();
		TestUtil.IMPLICIT_WAIT = 10;
		String expectedTitle = driver.getCurrentUrl();
		System.out.println(expectedTitle);
		driver.switchTo().defaultContent();
		driver.switchTo().frame("packageFrame");
		driver.findElement(By.xpath("html/body/div[1]/ul/li[1]/a")).click();
		System.out.println(driver.getCurrentUrl());
		

		// Assert.assertEquals(expectedTitle, "org.openqa.selenium");
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
