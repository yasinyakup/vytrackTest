package com.yaytech.stepdefinitions;

import com.google.common.net.MediaType;
import com.yaytech.utilities.BrowserUtils;
import com.yaytech.utilities.ConfigurationReader;
import com.yaytech.utilities.Driver;
import io.cucumber.java.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class Hooks {
    private final ConfigurationReader configurationReader;
    private static int i = 1;
    private WebDriver driver;



    public Hooks() {
        this.configurationReader = new ConfigurationReader();
        this.driver = Driver.getDriver();
    }

    @Before
    public void init(){
        driver.get(configurationReader.getValue("url"));
        driver.manage().window().fullscreen();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    @After("@main")
    public void destruct(Scenario scenario){
        if (scenario.isFailed()){
            byte[] screenShot = ((TakesScreenshot)Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenShot, MediaType.PNG.toString(), "fail_screen"+ i++);
        }
        Driver.closeAll();
    }
}
