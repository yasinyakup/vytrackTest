package com.yaytech.stepdefinitions;

import com.yaytech.pages.PayBillsPage;
import com.yaytech.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Map;

public class AddNewPayee {

    private PayBillsPage payBillsPage;

    @Given("Add New Payee tab")
    public void add_new_payee_tab() {

        payBillsPage = new PayBillsPage();
        payBillsPage.payBill.click();
        payBillsPage.addNewPayeeSubTab.click();
    }


    @Given("creates new payee using following information")
    public void creates_new_payee_using_following_information(Map<String,String> contact) {
        payBillsPage = new PayBillsPage();
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);
        wait.until(ExpectedConditions.visibilityOf(payBillsPage.payeeNameInputBox));
        payBillsPage.payeeNameInputBox.sendKeys(contact.get("Payee Name"));
        payBillsPage.payeeAddressTextArea.sendKeys(contact.get("Payee Address"));
        payBillsPage.accountInputBox.sendKeys(contact.get("Account"));
        payBillsPage.payeeDetailsInputBox.sendKeys(contact.get("Payee Details"));

        payBillsPage.addButton.click();

    }



    @Then("message {string} should be displayed")
    public void message_should_be_displayed(String alert) {

        payBillsPage = new PayBillsPage();
        Assert.assertEquals(alert, payBillsPage.alertText.getText());
    }

}
