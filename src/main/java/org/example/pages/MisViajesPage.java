package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MisViajesPage extends BasePage{
    private WebDriver driver;

    @FindBy(how = How.LINK_TEXT , using = "Iniciar sesión o crear una cuenta")
    WebElement iniciarSesionBoton;

    @FindBy(how = How.XPATH, using = "//span[@class='is-visually-hidden']")
    WebElement textoReservaSpan;

    @FindBy(how = How.XPATH, using = "//h3[@class='uitk-heading-5']")
    WebElement mensajeViajeProgramadoH3;

    @FindBy(how = How.XPATH, using = "//a[@class='uitk-button uitk-button-medium uitk-button-fullWidth uitk-button-has-text uitk-button-primary']")
    WebElement planearViajeBoton;

    @FindBy(how = How.XPATH, using = "//div[@id='no-results']")
    WebElement mensajeReservasDiv;

    public MisViajesPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String obtenerTextoBotonIniciarSesion(){
        return obtenerTextoElemento(iniciarSesionBoton);
    }

    public String obtenerTextoReservaSpan(){
        return obtenerTextoElemento(textoReservaSpan);
    }

    public String obtenerMensajeAlertaNoViajeProgramado(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h3[@class='uitk-heading-5']")));
        return obtenerTextoElemento(mensajeViajeProgramadoH3);
    }

    public String obtenerTextoBotonPlanearViaje(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class='uitk-button uitk-button-medium uitk-button-fullWidth uitk-button-has-text uitk-button-primary']")));
        return obtenerTextoElemento(planearViajeBoton);
    }

    public String obtenerMensajeReservas(){
        return obtenerTextoElemento(mensajeReservasDiv);
    }
}
