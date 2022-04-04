package org.example.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage2 {
    protected WebDriver driver;
    private WebDriverWait wait;

    public BasePage2(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public  String getTitlePage(){
        if (null != driver){
            return driver.getTitle();
        }
        return "";
    }
}