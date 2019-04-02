package com.yapo.test;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.yapo.config.BaseConfig;
import com.yapo.dataprovider.IntegratedDataProvider;
import com.yapo.entities.DatosFormulario;
import com.yapo.page.Formulario;
import com.yapo.page.HomeYapo;

public class Caso_de_Prueba extends BaseConfig{
	@Test(description = "Completar formulario")
	public void testFormulario() {

		SoftAssert soft = new SoftAssert();
		HomeYapo aviso = new HomeYapo(driver);
		Formulario formulario = new Formulario(driver);
		Assert.assertTrue(aviso.clickPublicarAviso(), "NO logre ingresar a publicar aviso");
		soft.assertTrue(formulario.clickSeleccionandoCategoria("Vendo"), "NO agrege Categoria");
		soft.assertTrue(formulario.seleccionandotipoInmueble("Casa"), "NO agrege tipoInmueble");
		soft.assertTrue(formulario.seleccionandodormitorios("1 dormitorio"), "NO agrege dormitorios");
		soft.assertTrue(formulario.seleccionandobanos("1 baño"), "NO agrege andobanos");
		soft.assertTrue(formulario.continuarflujo(), "NO agrege flujo");
		soft.assertAll();
	}
}
