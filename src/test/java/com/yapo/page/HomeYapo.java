package com.yapo.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import com.yapo.config.BaseConfig;
import com.yapo.util.WaitWebDriver;

public class HomeYapo extends BaseConfig {	
	public HomeYapo(WebDriver driver) {
		 this.driver = driver;
		    PageFactory.initElements(driver, this);
	}
	@FindBy(css = ".header-right .btn-home")
	private WebElement publicarAviso;	
	
	
public boolean clickPublicarAviso() {
	try {			
		System.out.println("Ingresando a publicarAviso");
		WaitWebDriver.waitVisibility(driver, publicarAviso, 10);
		Actions action = new Actions(driver);
		System.out.println(String.format("Haciendo click en %s", publicarAviso.getText()));
		action.moveToElement(publicarAviso).build().perform();
		publicarAviso.click();
		return true;
	} catch (Exception e) {
		e.printStackTrace();
		return false;
	}
}
}
