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
	@Test(description = "Completar formulario", dataProvider = "formulario",dataProviderClass = IntegratedDataProvider.class)
	public void testFormulario(DatosFormulario datosFormulario) {
		SoftAssert soft = new SoftAssert();
		HomeYapo aviso = new HomeYapo(driver);
		Formulario formulario = new Formulario(driver);
		Assert.assertTrue(aviso.clickPublicarAviso(), "NO logre ingresar a publicar aviso");
		soft.assertTrue(formulario.clickSeleccionandoCategoria(datosFormulario.getCategoria()), "NO agrege Categoria");
		soft.assertTrue(formulario.seleccionandotipoInmueble(datosFormulario.getTipo_de_inmueble()), "NO agrege tipoInmueble");
		soft.assertTrue(formulario.seleccionandodormitorios(datosFormulario.getDormitorios()), "NO agrege dormitorios");
		soft.assertTrue(formulario.seleccionandobanos(datosFormulario.getBanos()), "NO agrege andobanos");
		soft.assertTrue(formulario.continuarflujo(), "NO agrege flujo");
		soft.assertAll();
	}
}
