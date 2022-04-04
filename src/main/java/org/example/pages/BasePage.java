package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {

    public boolean isElementoHabilitado(WebElement element){
        return element.isEnabled();
    }

    public boolean isElementoMostrado(WebElement element){
        return element.isDisplayed();
    }

    public void clickearElemento(WebElement element){
        element.click();
    }

    public String obtenerTextoElemento(WebElement element){
        return element.getText();
    }

    public void completarCampoTexto(WebElement element, String texto){
        element.clear();
        element.sendKeys(texto);
    }
}