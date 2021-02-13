package com.yaytech.stepdefinitions;

import com.yaytech.pages.AccountSummaryPage;
import com.yaytech.pages.LoginPage;
import com.yaytech.pages.MainPage;
import com.yaytech.utilities.BrowserUtils;
import com.yaytech.utilities.ConfigurationReader;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class Login {

    private MainPage mainPage;
    ConfigurationReader configurationReader = new ConfigurationReader();

    @Given("the user is on the login page")
    public void the_user_is_on_the_login_page() {
        this.mainPage = new MainPage();
        System.out.println("this is main page");
         mainPage.signInButton.click();
    }


    @When("enter {string} and {string} and click submit")
    public void enter_and(String username, String password) {

        BrowserUtils.wait(3);
        LoginPage loginPage = new LoginPage();
        loginPage.login(username,password);
    }

    @Then("the user should login and display {string}")
    public void the_user_should_login_and_display(String username) {

        AccountSummaryPage accountSummaryPage = new AccountSummaryPage();
        Assert.assertEquals(username, accountSummaryPage.profileMenu.getText());

    }

    @Then("the main page should display {string}")
    public void the_main_page_should_display(String errormessage) {
       this.mainPage = new MainPage();
       Assert.assertTrue(mainPage.errorMessage.isDisplayed());
       Assert.assertEquals(errormessage, mainPage.errorMessage.getText());
    }

}
