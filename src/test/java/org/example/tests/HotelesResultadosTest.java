package org.example.tests;

import org.example.pages.HotelesHomePage;
import org.example.pages.HotelesResultadosPage;
import org.junit.Assert;
import org.junit.Test;

public class HotelesResultadosTest extends BaseTest{
    private  static String TITULO_PAGINA = "Resultados de tu búsqueda de hotel";

    @Test
    public void TestCaseTituloCoincide(){
        HotelesResultadosPage hotelesResultadosPage = new HotelesResultadosPage(driver);
        Assert.assertTrue(hotelesResultadosPage.getTitulo().contains(TITULO_PAGINA));
    }


}
