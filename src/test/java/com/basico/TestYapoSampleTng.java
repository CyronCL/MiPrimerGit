package com.basico;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import java.nio.file.Paths;
import java.util.concurrent.TimeUnit;

public class TestYapoSampleTng {
	public WebDriver driver;

	@BeforeSuite
	public void suite() {
		System.out.println("Ingresando a la suite");
	}

	@BeforeMethod
	public void config() {
		String path = Paths.get(System.getProperty("user.dir"), "./driver/chromedriver.exe").toString();
		System.setProperty("webdriver.chrome.driver", path);
		driver = new ChromeDriver();
		driver.get("http://www.yapo.cl");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().timeouts().setScriptTimeout(5, TimeUnit.SECONDS);
	}

	@Test(priority = 1)
	public void testFormulario() {

		SoftAssert soft = new SoftAssert();
		PublicarAviso aviso = new PublicarAviso();
		SeleccionandoCategoria categoria = new SeleccionandoCategoria(driver);
		Assert.assertTrue(aviso.clickPublicarAviso(), "NO logre ingresar a publicar aviso");
		soft.assertTrue(categoria.clickSeleccionandoCategoria(), "NO agrege Categoria");
		soft.assertTrue(seleccionandotipoInmueble(), "NO agrege tipoInmueble");
		soft.assertTrue(seleccionandodormitorios(), "NO agrege dormitorios");
		soft.assertTrue(seleccionandobanos(), "NO agrege andobanos");
		soft.assertTrue(continuarflujo(), "NO agrege flujo");
		soft.assertAll();
	}

	public class PublicarAviso {

		public PublicarAviso() {
			PageFactory.initElements(driver, this);
		}

		@FindBy(css = ".header-right .btn-home")
		private WebElement publicarAviso;

		public boolean clickPublicarAviso() {
			try {

				System.out.println("Ingresando a publicarAviso");
				WebDriverWait wait = new WebDriverWait(driver, 2);
				Actions action = new Actions(driver);
				// wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.cssSelector(".header-right
				// .btn-home")))).click();
				wait.until(ExpectedConditions.elementToBeClickable(publicarAviso));
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

	public class SeleccionandoCategoria extends TestYapoSampleTng {

		public SeleccionandoCategoria(WebDriver driver) {
			this.driver = driver;
			PageFactory.initElements(driver, this);
		}

		@FindBy(css = "#category_group")
		private WebElement categoria;

		public boolean clickSeleccionandoCategoria() {
			try {
				WebDriverWait wait = new WebDriverWait(driver, 60);
				wait.until(ExpectedConditions.elementToBeClickable(categoria));
				System.out.println("Seleccionando categoria");
				Select selectCategoria = new Select(categoria);
				selectCategoria.selectByVisibleText("Vendo");
				return true;
			} catch (Exception e) {
				e.printStackTrace();
				return false;
			}
		}
	}

	public boolean seleccionandotipoInmueble() {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 60);
			WebElement tipoInmueble = wait
					.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.cssSelector("#estate_type"))));
			System.out.println("Seleccionando tipo de inmueble");
			Select selectTipoInmueble = new Select(tipoInmueble);
			selectTipoInmueble.selectByVisibleText("Casa");
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean seleccionandodormitorios() {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 60);
			WebElement dormitorios = wait
					.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.cssSelector("#rooms"))));
			System.out.println("Seleccionando cantidad de dormitorios");
			Select selectDormitorios = new Select(dormitorios);
			selectDormitorios.selectByVisibleText("1 dormitorio");
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean seleccionandobanos() {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 60);
			WebElement banos = wait
					.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.cssSelector("#bathrooms"))));
			System.out.println("Seleccionando cantidad de baños");
			Select selectBanos = new Select(banos);
			selectBanos.selectByVisibleText("1 baño");
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

	@AfterMethod()
	public void cierre() {
		driver.close();
		driver.quit();
	}

	@AfterSuite
	public void cierreSuite() {
		System.out.println("termine la suite");
	}
}
