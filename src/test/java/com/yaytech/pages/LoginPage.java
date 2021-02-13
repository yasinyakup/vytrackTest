package com.yaytech.pages;

import com.yaytech.utilities.ConfigurationReader;
import com.yaytech.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    private ConfigurationReader configurationReader;
    public LoginPage() {
        PageFactory.initElements(Driver.getDriver(),this);
        configurationReader = new ConfigurationReader();
    }

    @FindBy(id = "user_login")
    public WebElement userNameInput;

    @FindBy(id = "user_password")
    public WebElement passwordInput;

    @FindBy(id = "user_remember_me")
    public WebElement rememberMe;

    @FindBy(name = "submit")
    public WebElement submit;

    @FindBy(linkText = "Forgot your password ?")
    public WebElement forgetPassword;

    public void login(String username, String password){
        userNameInput.sendKeys(username);
        passwordInput.sendKeys(password);
        submit.click();
    }


}
