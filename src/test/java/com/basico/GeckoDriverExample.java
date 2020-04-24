package com.basico;

import java.nio.file.Paths;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class GeckoDriverExample {

	public static void main(String[] args) throws Exception {
		String path = Paths.get(System.getProperty("user.dir"), "./driver/geckodriver.exe").toString();
		System.setProperty("webdriver.gecko.driver", path);
		WebDriver driver = new FirefoxDriver();
		driver.get("https://www.google.cl/");
		Thread.sleep(5000);
		driver.quit();
	}
}