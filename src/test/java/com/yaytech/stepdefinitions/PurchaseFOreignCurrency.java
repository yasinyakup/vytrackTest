package com.yaytech.stepdefinitions;

import com.yaytech.pages.PayBillsPage;
import com.yaytech.utilities.BrowserUtils;
import com.yaytech.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.stream.Collectors;

public class PurchaseFOreignCurrency {
    private PayBillsPage payBillsPage;

    @Given("the user accesses the Purchase foreign currency cash tab")
    public void the_user_accesses_the_purchase_foreign_currency_cash_tab() {

        payBillsPage = new PayBillsPage();
        payBillsPage.payBill.click();
        payBillsPage.purchaseCurrencySubTab.click();
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);
        wait.until(ExpectedConditions.visibilityOf(payBillsPage.currencyTypeDropDown));
    }


    @Then("following currencies should be available")
    public void following_currencies_should_be_available(List<String> currencies) {
        payBillsPage = new PayBillsPage();
        List<String> actualCurrencies =
                BrowserUtils.getSelectWebElement(payBillsPage.currencyTypeDropDown).getOptions()
                .stream().map(WebElement::getText).collect(Collectors.toList());

        Assert.assertTrue(actualCurrencies.containsAll(currencies));
    }


    @When("user tries to calculate cost without selecting a currency")
    public void user_tries_to_calculate_cost_without_selecting_a_currency() {

        payBillsPage = new PayBillsPage();
        payBillsPage.amountInputBox.sendKeys("200");
        payBillsPage.usdRadioButton.click();

        payBillsPage.calculatedCostButton.click();
    }
    @Then("error message should be displayed")
    public void error_message_should_be_displayed() {
        Alert alert = Driver.getDriver().switchTo().alert();
       Assert.assertEquals("Please, ensure that you have filled all the required fields with valid values.",
               alert.getText());
       alert.accept();
       Driver.getDriver().switchTo().defaultContent();
        System.out.println("yasin");
    }


    @When("user tries to calculate cost without entering a value")
    public void user_tries_to_calculate_cost_without_entering_a_value() {
        payBillsPage = new PayBillsPage();
        BrowserUtils.getSelectWebElement(payBillsPage.currencyTypeDropDown).selectByIndex(5);
        payBillsPage.usdRadioButton.click();

        payBillsPage.calculatedCostButton.click();
    }

}
