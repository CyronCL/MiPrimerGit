package com.yapo.page;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.yapo.config.BaseConfig;
import com.yapo.util.WaitWebDriver;

public class Buscar extends BaseConfig {
	public Buscar(WebDriver driver) {
		super();
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = ".gLFyf")
	private WebElement txtBox;
	@FindBy(xpath = "//*[@id = 'resultStats']")
	private WebElement resultStats;

	public boolean ingresarTexto(String texto) {
		try {
			WaitWebDriver.waitVisibility(driver, txtBox, 4);
			txtBox.sendKeys(texto);
			txtBox.sendKeys(Keys.ENTER);
			return true;
		} catch (Exception e) {
			System.out.println(e);
			return false;
		}

	}

	public boolean encontrebusqueda() {
		try {
			WaitWebDriver.waitVisibility(driver, resultStats, 4);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
}
