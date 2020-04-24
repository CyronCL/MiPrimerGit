package com.basico;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.nio.file.Paths;

public class ChromeDriverExample {

	public static void main(String[] args) throws Exception {
		String path = Paths.get(System.getProperty("user.dir"), "/driver/chromedriver.exe").toString();
		System.out.println(System.getProperty("user.dir"));
		System.setProperty("webdriver.chrome.driver", path);
		WebDriver driver = new ChromeDriver();
//		driver.get("https://www.google.cl/");
		Thread.sleep(5000);
		driver.navigate().to("https://www.google.cl/");
		driver.close();
		driver.quit();
		
	}
}
