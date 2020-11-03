package com.sel.Generic;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseTest implements IAutoConstant {

	
	WebDriver driver = new ChromeDriver();
	
	driver.get("");
}
