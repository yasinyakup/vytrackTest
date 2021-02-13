package com.yaytech.pages;

import com.yaytech.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import javax.swing.text.html.CSS;

public class MainPage {

    public MainPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(css = "#signin_button")
    public WebElement signInButton;

    @FindBy(css = ".alert.alert-error")
    public WebElement errorMessage;

    @FindBy(css = "#homeMenu strong")
    public WebElement homeMenu;

    @FindBy(css = "#onlineBankingMenu strong")
    public WebElement onlineBankingMenu;

    @FindBy(css = "#feedback strong")
    public WebElement feedbackMenu;

    public void clickSignIn(){
        signInButton.click();
    }




}
