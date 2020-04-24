package com.basico;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.nio.file.Paths;

public class TestYapoSample {

	public static void main(String[] args) throws Exception {
		String path = Paths.get(System.getProperty("user.dir"), "./driver/chromedriver.exe").toString();
		System.setProperty("webdriver.chrome.driver", path);
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.yapo.cl");

		WebDriverWait wait = new WebDriverWait(driver, 60);
		Actions action = new Actions(driver);

		WebElement publicarAviso = wait.until(
				ExpectedConditions.elementToBeClickable(driver.findElement(By.cssSelector(".header-right .btn-home"))));
		System.out.println(String.format("Haciendo click en %s", publicarAviso.getText()));
		action.moveToElement(publicarAviso).build().perform();
		Thread.sleep(1000);
		publicarAviso.click();

		Thread.sleep(1000);
		WebElement categoria = wait
				.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.cssSelector("#category_group"))));
		System.out.println("Seleccionando categoria");
		Select selectCategoria = new Select(categoria);
		selectCategoria.selectByVisibleText("Vendo");

		Thread.sleep(1000);
		WebElement tipoInmueble = wait
				.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.cssSelector("#estate_type"))));
		System.out.println("Seleccionando tipo de inmueble");
		Select selectTipoInmueble = new Select(tipoInmueble);
		selectTipoInmueble.selectByVisibleText("Casa");

		Thread.sleep(1000);
		WebElement dormitorios = wait
				.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.cssSelector("#rooms"))));
		System.out.println("Seleccionando cantidad de dormitorios");
		Select selectDormitorios = new Select(dormitorios);
		selectDormitorios.selectByVisibleText("1 dormitorio");

		Thread.sleep(1000);
		WebElement banos = wait
				.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.cssSelector("#bathrooms"))));
		System.out.println("Seleccionando cantidad de baños");
		Select selectBanos = new Select(banos);
		selectBanos.selectByVisibleText("1 baño");

		Thread.sleep(1000);
		WebElement equipamientoBodega = wait
				.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.cssSelector("#eqp_3_1"))));
		System.out.println("Seleccionando bodega");
		if (!equipamientoBodega.isSelected())
			equipamientoBodega.click();

		Thread.sleep(1000);
		WebElement tamano = wait
				.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.cssSelector("#size"))));
		System.out.println("Ingresando tamaño");
		tamano.sendKeys("120");

		Thread.sleep(1000);
		WebElement gastoComun = wait
				.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.cssSelector("#condominio"))));
		System.out.println("Ingresando valor proximado del gasto comun");
		gastoComun.sendKeys("60000");

		Thread.sleep(1000);
		WebElement titulo = wait
				.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.cssSelector("#subject"))));
		System.out.println("Ingresando un titulo");
		titulo.sendKeys("Selenium");
		System.out.println(String.format("Titulo: %s", titulo.getAttribute("value")));

		Thread.sleep(1000);
		WebElement descripcion = wait
				.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.cssSelector("#body"))));
		System.out.println("Ingresando un titulo");
		descripcion.sendKeys("Capacitacion de Selenium WebDriver");
		System.out.println(String.format("Descripcion: %s", descripcion.getAttribute("value")));

		Thread.sleep(5000);
		driver.close();
		driver.quit();

	}

}
