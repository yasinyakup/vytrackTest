package com.yaytech.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.sql.DriverManager;

public class Driver {
    private WebDriver driver;
    private final String BROWSER;
    private final ConfigurationReader configurationReader;

    public Driver() {
        configurationReader = new ConfigurationReader();
        BROWSER = configurationReader.getValue("browser");
    }

    public WebDriver getDriver(){

        switch (BROWSER){
            case "chrome"->{
                WebDriverManager.chromedriver().setup();
                driver=new ChromeDriver();
            }
            case "ie"    -> {
                WebDriverManager.iedriver().setup();
                driver = new InternetExplorerDriver();
            }
            case "firefox"-> {
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
            }
            case "safari" -> {
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
            }
        }
        return this.driver;
    }
}
