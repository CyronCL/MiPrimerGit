package com.basico;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.nio.file.Paths;

public class NavigateCommandsExample {

	public static void main(String[] args) throws Exception {
		String path = Paths.get(System.getProperty("user.dir"), "./driver/chromedriver.exe").toString();
		System.setProperty("webdriver.chrome.driver", path);
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.google.cl/");
		Thread.sleep(2500);
		driver.navigate().to("https://www.google.cl/search?q=hola+mundo");
		Thread.sleep(2500);
		driver.navigate().back();
		Thread.sleep(2500);
		driver.navigate().forward();
		Thread.sleep(2500);
		driver.navigate().refresh();
		Thread.sleep(2500);
		driver.close();
		driver.quit();
	}
}
