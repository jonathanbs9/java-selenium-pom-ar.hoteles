package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class HotelesHomePage extends BasePage {
    private WebDriver driver;

    @FindBy(how = How.XPATH, using = "//button[contains(text(),'Iniciar sesión')]")
    WebElement iniciarSesionMenuButton;

    @FindBy(how = How.XPATH, using = "//button[@type='button'][@class='uitk-button uitk-button-medium uitk-button-has-text uitk-button-tertiary uitk-menu-trigger']")
    WebElement usuarioMenuButton;

    @FindBy(how = How.XPATH, using = " //a[contains(text(),'Iniciar sesión')]")
    WebElement iniciarsesionModalButton;

    @FindBy(how = How.XPATH, using = "//a[contains(text(),'Registrate, ¡es gratis!')]")
    WebElement registrarseButton;

    @FindBy(how = How.ID, using = "location-field-destination")
    WebElement destinoTextBox;

    @FindBy(how = How.XPATH, using = "//button[@type='button'][@aria-label='Destino']")
    WebElement destinoFakeButton;

    @FindBy(how =How.ID, using = "d1-btn")
    WebElement checkInDatePicker;

    //@FindBy(how = How.XPATH, using = "//button[@type='button'][@class='uitk-button uitk-button-medium uitk-button-only-icon uitk-layout-flex-item uitk-button-paging'][@xpath='2']")
    //@FindBy(how = How.XPATH, using = "//body/div[@id='app-blossom-flex-ui']/div[@id='app-layer-manager']/div[@id='app-layer-base']/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/form[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/button[2]")
    @FindBy(how = How.XPATH, using = "//*[@id=\"wizard-hotel-pwa-v2-1\"]/div[1]/div[2]/div/div/div[1]/div/div[2]/div/div[2]/div[1]/button[2]")
    WebElement siguienteBoton;

    @FindBy(how = How.XPATH, using = "//*[@id=\"wizard-hotel-pwa-v2-1\"]/div[1]/div[2]/div/div/div[1]/div/div[2]/div/div[2]/div[2]/div[2]/table/tbody/tr[3]/td[6]/button")
    WebElement numeroDiaDesdeBoton;

    @FindBy(how = How.XPATH, using = "//*[@id=\"wizard-hotel-pwa-v2-1\"]/div[1]/div[2]/div/div/div[1]/div/div[2]/div/div[2]/div[2]/div[2]/table/tbody/tr[4]/td[2]/button")
    WebElement numeroDiaHastaBoton;

    @FindBy(how = How.XPATH, using = "//button[@type='button'][@class='uitk-button uitk-button-medium uitk-button-has-text uitk-button-primary uitk-layout-flex-item uitk-layout-flex-item-flex-shrink-0 dialog-done']")
    WebElement listoDatePickerBoton;

    @FindBy(how = How.ID, using = "d2-btn")
    WebElement checkOutDatePicker;

    @FindBy(how = How.XPATH, using = "//button[@data-testid='travelers-field-trigger']")
    WebElement huespedesMenu;

    @FindBy(how = How.XPATH, using = "//button[@class='uitk-layout-flex-item uitk-step-input-touch-target'][@xpath='2']")
    WebElement agregarAdultosButton;

    @FindBy(how = How.XPATH, using = "//button[@class='uitk-layout-flex-item uitk-step-input-touch-target'][@xpath='1']")
    WebElement restarAdultosButton;

    @FindBy(how = How.XPATH, using = "//button[@type='submit']")
    WebElement buscarBoton;

    @FindBy(how = How.ID, using = "location-field-destination-input-error")
    WebElement mensajeDestinoAlerta;

    @FindBy(how = How.XPATH , using = "//h3[@class='uitk-error-summary-heading']")
    WebElement mensajeAlertaHeading;

    @FindBy(how = How.XPATH, using = "//*[@id=\"gc-custom-header-nav-bar-acct-menu\"]/div/div[1]/div[1]/div/h2")
    WebElement saludoUserText;

    @FindBy(how = How.XPATH, using = "//*[@id=\"gc-custom-header-nav-bar-acct-menu\"]/div/div[1]/div[1]/div/h3")
    WebElement emailUsertText;

    @FindBy(how = How.XPATH, using = "//div[contains(text(),'Cerrar sesión')]")
    WebElement cerrarSesionButton;

    @FindBy(how = How.XPATH, using = "//span[contains(text(),'Iniciar sesión')]")
    WebElement iniciarSesionBetaButton;

    @FindBy(how = How.XPATH, using = "//*[@id=\"header-full\"]/header/nav[1]/div/ul/li[3]/div/label")
    WebElement automationLabel;

    @FindBy(how = How.ID, using = "itinerary")
    WebElement misViajesMenu;

    public HotelesHomePage(WebDriver driver){

        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickIniciarSesionMenu() throws InterruptedException {
        Thread.sleep(2000);
        clickElement(iniciarSesionMenuButton);
        System.out.println("HomePage - Iniciar Sesión Clickeado");
    }

    public void clickIniciarSesionModal() throws InterruptedException {
        Thread.sleep(2000);
        clickElement(iniciarsesionModalButton);
        System.out.println("HomePage - Iniciar Sesión (Modal) Clickeado");
    }

    public void clickRegistrarseModal() throws InterruptedException {
        Thread.sleep(2000);
        clickElement(registrarseButton);
        System.out.println("HomePage (Modal)- Registrarse Clickeado");
    }

    public String getTitulo(){
        return this.driver.getTitle();
    }

    public void clickElement(WebElement element){
        element.click();
    }

    public void ingresarDestino(String destino) throws InterruptedException {
        destinoFakeButton.click();
        completarCampoTexto(destinoTextBox, destino);
    }

    public void presionarFlechaAbajoYEnter(){
        destinoTextBox.sendKeys(Keys.ARROW_DOWN);
        destinoTextBox.sendKeys(Keys.ENTER);
    }

    public void ingresarFecha() throws InterruptedException {

        checkInDatePicker.click();
        Thread.sleep(1000);
        siguienteBoton.click();
        // 17 de Junio de 2022 al 20 de Junio de 2022
        numeroDiaDesdeBoton.click();
        numeroDiaHastaBoton.click();
        listoDatePickerBoton.click();

    }

    public void clickBuscar(){
        clickearElemento(buscarBoton);
    }

    public String getMensajeAlertaDestino(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("location-field-destination-input-error")));

        //System.out.println("Mensaje alerta destino no ingresado: "+ mensajeDestinoAlerta.getText());
        return mensajeDestinoAlerta.getText();
    }

    public String getMensajeAlertaHeading(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h3[@class='uitk-error-summary-heading']")));

        //System.out.println("Mensaje alerta Heading: "+ mensajeAlertaHeading.getText());
        return mensajeAlertaHeading.getText();
    }

    public void clickUsuarioMenu(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@type='button'][@class='uitk-button uitk-button-medium uitk-button-has-text uitk-button-tertiary uitk-menu-trigger']")));

        usuarioMenuButton.click();
    }

    public String getSaludoUser(){
        System.out.println("Saludo usuario: " +saludoUserText.getText());
        return saludoUserText.getText();
    }

    public String getEmailUserText(){
        System.out.println("Email usuario: " +emailUsertText.getText());
        return emailUsertText.getText();
    }

    public void clickCerrarSesionMenu(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Cerrar sesión')]")));
        cerrarSesionButton.click();
    }

    public String  getIniciarSesionTexto(){
        return iniciarSesionMenuButton.getText();
    }

    public String getIniciarSesionBetaTexto(){
        return iniciarSesionBetaButton.getText();
    }

    public String getAutomationTexto() {
        return automationLabel.getText();
    }

    public Boolean getBotonBuscarHabilitado() {
        return isElementoHabilitado(buscarBoton);
    }

    public void clickMisViajesMenu(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("itinerary")));
        clickearElemento(misViajesMenu);
    }

}
