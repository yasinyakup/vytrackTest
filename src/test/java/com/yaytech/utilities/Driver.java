package com.yaytech.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.sql.DriverManager;

public class Driver {
    private static WebDriver driver;
    private static final ConfigurationReader configurationReader= new ConfigurationReader();;
    private static final String BROWSER = System.getProperty("browser")!=null?
            System.getProperty("browser"):
            configurationReader.getValue("browser");;

      private static InheritableThreadLocal<WebDriver> parallelDriver = new InheritableThreadLocal<>();

    public static WebDriver getDriver(){


        if(driver == null) {
            switch (BROWSER) {
                case "chrome" -> {
                    WebDriverManager.chromedriver().setup();
                    parallelDriver.set(new ChromeDriver());
                }
                case "ie" -> {
                    WebDriverManager.iedriver().setup();
                    parallelDriver.set(new InternetExplorerDriver());
                }
                case "firefox" -> {
                    WebDriverManager.firefoxdriver().setup();
                    parallelDriver.set(new FirefoxDriver());
                }
                case "safari" -> {
                    WebDriverManager.edgedriver().setup();
                    parallelDriver.set(new SafariDriver());
                }
            }
        }
        return parallelDriver.get();

    }

    public static void closeAll(){
        if (driver != null){
            driver.quit();
            driver = null;
        }

    }
}
