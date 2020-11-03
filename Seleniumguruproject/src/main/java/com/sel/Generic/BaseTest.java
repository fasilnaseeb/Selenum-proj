package com.sel.Generic;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseTest implements IAutoConstant {

	
	public static WebDriver driver;
	public static Properties prop;

	public BaseTest() {
		try

		{
			prop = new Properties();
			FileInputStream ip = new FileInputStream(PROP_PATH);
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void initilization() {
		String browserName = prop.getProperty("browser");
		if (browserName.equals("chrome")) {
			System.setProperty(CHROME_KEY, CHROME_VALUE);
			driver = new ChromeDriver();

		}

		else if (browserName.equals("firefox")) {

			System.setProperty(GECKO_KEY, GECKO_VALUE);
			driver = new FirefoxDriver();

		}

		else 
		{
			System.out.println("Invalid browser");
		}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(IMPLICIT_WAIT, TimeUnit.SECONDS);
		
	    driver.get(prop.getProperty("url"));

	}

	
	
}
