package org.example.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class RegistrarsePage extends BasePage{
    private WebDriver driver;

    @FindBy(how = How.XPATH, using = "//h1[@class='uitk-heading-3 uitk-flex-item']")
    WebElement crearCuentaTitulo;

    @FindBy(how = How.NAME, using = "email")
    WebElement emailInput;

    @FindBy(how = How.NAME, using = "firstName")
    WebElement nombreInput;

    @FindBy(how = How.NAME, using = "lastName")
    WebElement apellidoInput;

    @FindBy(how = How.NAME, using = "password")
    WebElement passwordInput;

    @FindBy(how = How.NAME, using = "rememberMe")
    WebElement mantenerSesionCheckBox;

    @FindBy(how = How.ID, using = "signupFormSubmitButton")
    WebElement continuarButton;

    @FindBy(how = How.XPATH, using = "//li[@class='uitk-typelist-item uitk-typelist-item-bullet-unordered uitk-typelist-item-size-1']")
    WebElement requerimientoCaracteresPassword;

    public RegistrarsePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void completeRegisterForm(String email, String nombre, String apellido, String password){
        completarCampo(emailInput, email);
        completarCampo(nombreInput, nombre);
        completarCampo(apellidoInput, apellido);
        completarCampo(passwordInput, password);

    }

    public void clickElement(WebElement element){
        element.click();
    }

    public void completarCampo(WebElement element, String texto){
        element.clear();
        element.sendKeys(texto);
    }

    public void clickContinuarButton(){
        clickElement(continuarButton);
    }

    public Boolean isContinuarButtonDisabled(){
        return isElementoHabilitado(continuarButton);
    }

    public Boolean isContinuarButtonMostrado(){
        return isElementoMostrado(continuarButton);
    }

    public String obtenerRequerimientoCaracteres(){
        return requerimientoCaracteresPassword.getText();
    }


}
