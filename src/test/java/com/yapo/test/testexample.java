package com.yapo.test;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import org.testng.annotations.Test;
import com.yapo.config.BaseConfig;
import com.yapo.dataprovider.IntegratedDataProvider;
import com.yapo.entities.Busqueda;

public class testexample extends BaseConfig {

	@Test(dataProvider = "buscar", dataProviderClass = IntegratedDataProvider.class, description = "Escribir en google")
	public void ExtractorSVNexcel(Busqueda cont) throws Throwable {
		driver.navigate().to("http://www.google.cl");
		Robot rob = new Robot();
		rob.keyPress(KeyEvent.VK_CONTROL);
		rob.keyPress(KeyEvent.VK_T);
		rob.keyRelease(KeyEvent.VK_CONTROL);
		rob.keyRelease(KeyEvent.VK_T);
		Thread.sleep(1000);
	    ArrayList<String> Tab = new ArrayList<String>(driver.getWindowHandles());
	    driver.switchTo().window(Tab.get(0));
	    driver.navigate().to("https://www.falabella.com/falabella-cl/");
	    Thread.sleep(5000); 
	    driver.switchTo().window(Tab.get(1));
	    driver.navigate().to("https://www.sodimac.cl/sodimac-homy/");
	    Thread.sleep(5000); 
	}
}
