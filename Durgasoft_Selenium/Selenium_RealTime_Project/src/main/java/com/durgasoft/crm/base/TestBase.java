package com.durgasoft.crm.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.durgasoft.crm.util.TestUtil;

public class TestBase {

	public static WebDriver driver;
	public static Properties prop =new Properties();
	FileInputStream fileInput ;

	public TestBase() {
		try {
			
			File file = new File(
					"C:\\Users\\Mountain\\Durgasoft_Selenium\\Selenium_RealTime_Project\\src\\main\\java\\com\\durgasoft\\crm\\configurations\\config.properties");
			
			try {
				fileInput = new FileInputStream(file);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			prop.load(fileInput);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void initialization() {
		String browserName = prop.getProperty("browser");

		if (browserName.equals("chrome")) {

			//System.setProperty("webdriver.chrome.driver", "C:/Users/Mountain/Documents/Jars/chromedriver.exe");
			driver = new ChromeDriver();
		} else if (browserName.equals("ff")) {
			driver = new FirefoxDriver();

		}

		driver.manage().window().maximize();
		driver.get(prop.getProperty("url"));
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);

	}

}
