package com.yapo.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.yapo.config.BaseConfig;
import com.yapo.util.WaitWebDriver;

public class Formulario extends BaseConfig {
	public Formulario(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "#category_group")
	private WebElement categoria;
	@FindBy(css = "#estate_type")
	private WebElement tipoInmueble;
	@FindBy(css = "#rooms")
	private WebElement dormitorios;
	@FindBy(css = "#bathrooms")
	private WebElement banos;
	public boolean clickSeleccionandoCategoria(String vendo) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 60);
			wait.until(ExpectedConditions.elementToBeClickable(categoria));
			System.out.println("Seleccionando categoria");
			Select selectCategoria = new Select(categoria);
			selectCategoria.selectByVisibleText(vendo);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	public boolean seleccionandotipoInmueble(String casa) {
		try {
			WaitWebDriver.waitVisibility(driver, tipoInmueble, 10);
			System.out.println("Seleccionando tipo de inmueble");
			Select selectTipoInmueble = new Select(tipoInmueble);
			selectTipoInmueble.selectByVisibleText("Casa");
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean seleccionandodormitorios(String dormitorio) {
		try {
			WaitWebDriver.waitVisibility(driver, dormitorios, 10);
			System.out.println("Seleccionando cantidad de dormitorios");
			Select selectDormitorios = new Select(dormitorios);
			selectDormitorios.selectByVisibleText(dormitorio);
			return true;
		} catch (Exception e) {
			System.out.println(e);
			e.printStackTrace();
			return false;
		}
	}

	public boolean seleccionandobanos(String bano) {
		try {
			
			WaitWebDriver.waitVisibility(driver, banos, 10);
			System.out.println("Seleccionando cantidad de baños");
			Select selectBanos = new Select(banos);
			selectBanos.selectByVisibleText(bano);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean continuarflujo() {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 60);
			WebElement equipamientoBodega = wait
					.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.cssSelector("#eqp_3_1"))));
			System.out.println("Seleccionando bodega");
			if (!equipamientoBodega.isSelected())
				equipamientoBodega.click();

			WebElement tamano = wait
					.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.cssSelector("#size"))));
			System.out.println("Ingresando tamaño");
			tamano.sendKeys("120");

			WebElement gastoComun = wait
					.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.cssSelector("#condominio"))));
			System.out.println("Ingresando valor proximado del gasto comun");
			gastoComun.sendKeys("60000");

			WebElement titulo = wait
					.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.cssSelector("#subject"))));
			System.out.println("Ingresando un titulo");
			titulo.sendKeys("Selenium");
			System.out.println(String.format("Titulo: %s", titulo.getAttribute("value")));

			WebElement descripcion = wait
					.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.cssSelector("#body"))));
			System.out.println("Ingresando un titulo");
			descripcion.sendKeys("Capacitacion de Selenium WebDriver");
			System.out.println(String.format("Descripcion: %s", descripcion.getAttribute("value")));
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}
}
