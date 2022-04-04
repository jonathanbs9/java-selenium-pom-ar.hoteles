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

public class IniciarSesionPage {
    private WebDriver driver;

    @FindBy(how = How.ID, using = "loginFormEmailInput")
    WebElement emailInput;

    @FindBy(how = How.ID, using = "loginFormPasswordInput")
    WebElement passwordInput;

    @FindBy(how = How.ID, using = "loginFormRememberMeCheck")
    WebElement mantenerSesionCheckBox;

    @FindBy(how = How.ID, using = "loginFormSubmitButton")
    WebElement iniciarSesionButton;

    @FindBy(how = How.XPATH, using = "//h3[contains(text(),'El correo electrónico o la contraseña son incorrec')]")
    WebElement mensajeAlerta;

    @FindBy(how = How.ID, using = "loginFormEmailInput-error")
    WebElement mensajeAlertaEmail;

    public IniciarSesionPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void completarFormulario(String email, String password) {
        emailInput.clear();
        emailInput.sendKeys(email);

        passwordInput.clear();
        passwordInput.sendKeys(password);
    }

    public void clickIniciarSesion() {
        iniciarSesionButton.click();
    }

    public String getMensajeAlerta() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h3[contains(text(),'El correo electrónico o la contraseña son incorrec')]")));

        return mensajeAlerta.getText();
    }

    public String getMensajeAlertaEmailFormatoInvalido() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("loginFormEmailInput-error")));

        return mensajeAlertaEmail.getText();
    }

    public Boolean isSubmitButtonDisabled(){
        return iniciarSesionButton.isEnabled();
    }

    public boolean isBotonHabilitado() {
        return iniciarSesionButton.isEnabled();
    }

    public boolean isBotonMostrado(){
        return iniciarSesionButton.isDisplayed();
    }
}
