package org.example.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class HotelesResultadosPage {
    private WebDriver driver;

    @FindBy(how = How.XPATH, using = "//h3[@class='uitk-heading-5 is-visually-hidden']")
    List<WebElement> listaResultados;

    public HotelesResultadosPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

    public String getTitulo(){
        return driver.getTitle();
    }

    public ArrayList<String> getListaResultados(){

        List<String> listaResultadosHoteles = new ArrayList<String>();
        for (int i=0; i< listaResultados.size(); i++){
            listaResultadosHoteles.add(listaResultados.get(i).getText());
        }
        return (ArrayList<String>) listaResultadosHoteles;
    }

    public boolean buscarHotelEnResultadosLista(String hotelABuscar){
        ArrayList<String> lista =  getListaResultados();
        System.out.println(lista);
        Stream<String> newList = lista.stream();
        boolean flag = newList.anyMatch(s -> s.equalsIgnoreCase(hotelABuscar));
        return flag;
    }

}
