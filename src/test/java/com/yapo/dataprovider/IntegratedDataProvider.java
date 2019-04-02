package com.yapo.dataprovider;

import org.testng.annotations.DataProvider;

import com.google.gson.Gson;
import com.yapo.dataprovider.FileDataProvider;
import com.yapo.entities.Busqueda;
import com.yapo.entities.DatosFormulario;

public class IntegratedDataProvider {

	@DataProvider
	public static Object[][] buscar() {
		Gson gson = new Gson();
		Busqueda cont = gson.fromJson(FileDataProvider.asString(String.format("./resource/Busqueda.json")),
				Busqueda.class);

		return new Object[][] { { cont } };
	}
	@DataProvider
	public static Object[][] formulario() {
		Gson gson = new Gson();
		DatosFormulario datosFormulario = gson.fromJson(FileDataProvider.asString(String.format("./resource/Formulario.json")),
				DatosFormulario.class);

		return new Object[][] { { datosFormulario } };
	}
	
}
