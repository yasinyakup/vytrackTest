package com.yaytech.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.sql.DriverManager;

public class Driver {
    private static WebDriver driver;
    private static final ConfigurationReader configurationReader= new ConfigurationReader();;
    private static final String BROWSER = System.getProperty("browser")!=null?
            System.getProperty("browser"):
            configurationReader.getValue("browser");;


    public static WebDriver getDriver(){

        if(driver == null) {
            switch (BROWSER) {
                case "chrome": {
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    break;
                }
                case "ie": {
                    WebDriverManager.iedriver().setup();
                    driver = new InternetExplorerDriver();
                    break;
                }
                case "firefox": {
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    break;
                }
                case "safari": {
                    WebDriverManager.edgedriver().setup();
                    driver = new EdgeDriver();
                    break;
                }
            }
        }
        return driver;
    }

    public static void closeAll(){
        if (driver != null){
            driver.quit();
            driver = null;
        }

    }
}
