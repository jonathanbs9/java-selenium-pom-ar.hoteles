package org.example.tests;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;


public class BaseTest {


    public static WebDriver driver;
    public static Logger logger;
        @Before
        public void Initialize() throws IOException {
            System.setProperty("webdriver.chrome.driver", "D:\\Proyectos\\java-selenium-pom-ar.hoteles\\src\\main\\resources\\chromedriver.exe");

            driver = new ChromeDriver();

            Logger logger = Logger.getLogger("BaseTest");

            // Create a file handler object
            FileHandler handler
                    = new FileHandler("logs.txt");
            handler.setFormatter(new SimpleFormatter());
            logger.addHandler(handler);
            logger.setLevel(Level.FINE);
            logger.info("Initializing driver...");
            logger.info("Maximizing driver and getting URL...");
            logger.fine("Fine logger");
            driver.manage().window().maximize();
            driver.get("https://ar.hoteles.com/");
        }

        @After
        public void TearDown() {
            Logger logger = Logger.getLogger("BaseTest");
            logger.info("Closing driver... ");
            //driver.close();
        }
}
