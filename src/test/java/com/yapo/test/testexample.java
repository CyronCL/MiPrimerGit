package com.yapo.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.yapo.config.BaseConfig;
import com.yapo.dataprovider.IntegratedDataProvider;
import com.yapo.entities.Busqueda;
import com.yapo.page.Buscar;


public class testexample extends BaseConfig {

	@Test(dataProvider = "buscar", dataProviderClass = IntegratedDataProvider.class, description = "Escribir en google")
	public void ExtractorSVNexcel(Busqueda cont) {

		Buscar buscador = new Buscar(driver);
		Assert.assertTrue(buscador.ingresarTexto(cont.getContenido()), "No logree escribir");
		Assert.assertTrue(buscador.btnBuscar(), "No logree buscar");

	}
}
