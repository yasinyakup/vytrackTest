package com.yaytech.stepdefinitions;

import com.yaytech.utilities.ConfigurationReader;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Login {

    ConfigurationReader configurationReader = new ConfigurationReader();
    @When("enter {string} and {string}")
    public void enter_and(String string, String string2) {
        System.out.println(configurationReader.getValue("url"));
    }

    @When("click the login button")
    public void click_the_login_button() {
        System.out.println(configurationReader.getValue("username"));
    }
    @Then("the user should login and display {string}")
    public void the_user_should_login_and_display(String string) {

        System.out.println(configurationReader.getValue("password"));
    }

}
