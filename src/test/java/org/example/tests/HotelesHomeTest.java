package org.example.tests;

import org.example.pages.HotelesHomePage;
import org.junit.Test;
import org.testng.Assert;

public class HotelesHomeTest extends BaseTest  {
    private static String TITULO_HOME = "Hoteles.com - Ofertas y descuentos para reservaciones en hoteles de lujo y económicos.";

    @Test
    public void TestCaseHomeTituloCoincide(){
        HotelesHomePage hotelesHomePage = new HotelesHomePage(driver);

        Assert.assertEquals(hotelesHomePage.getTitulo(), TITULO_HOME);
    }

    @Test
    public void TestCaseBotonBuscarHabilitado(){
        HotelesHomePage hotelesHomePage = new HotelesHomePage(driver);

        Assert.assertTrue(hotelesHomePage.getBotonBuscarHabilitado());
    }


}
