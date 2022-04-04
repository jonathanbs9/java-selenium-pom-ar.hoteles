package org.example.tests;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;


public class BaseTest2 {
    private WebDriver driver;

        @BeforeSuite
        public void Initialize() {
            System.setProperty("webdriver.chrome.driver", "D:\\Proyectos\\java-selenium-pom-ar.hoteles\\src\\main\\resources\\chromedriver.exe");
            driver = new ChromeDriver();
            driver.manage().window().maximize();

            driver.get("https://ar.hoteles.com/");
        }

        @AfterSuite
        public void TearDown() {
            if (null != driver){
                driver.close();
                driver.quit();
            }
        }

        public WebDriver getDriver(){
            return driver;
        }


}
