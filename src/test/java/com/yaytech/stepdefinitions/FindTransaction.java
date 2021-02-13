package com.yaytech.stepdefinitions;

import com.yaytech.pages.AccountActivity;
import com.yaytech.utilities.BrowserUtils;
import com.yaytech.utilities.Driver;
import io.cucumber.java.bs.A;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

public class FindTransaction {

    private AccountActivity accountActivity;

    @Given("the user accesses the Find Transactions tab")
    public void the_user_accesses_the_find_transactions_tab() {
        Driver.getDriver().navigate().refresh();
       accountActivity = new AccountActivity();
       accountActivity.accountActivity.click();
       accountActivity.findTransactionsSubTab.click();
    }


    @When("the user enters date range from {string} to {string}")
    public void the_user_enters_date_range_from_to(String fromDateArg, String toDateArg) {

        accountActivity = new AccountActivity();
        accountActivity.fromDate.clear();
        accountActivity.fromDate.sendKeys(fromDateArg);
        accountActivity.toDate.clear();
        accountActivity.toDate.sendKeys(toDateArg);


    }
    @When("clicks search")
    public void clicks_search() {

        accountActivity.findButton.click();
    }
    @Then("results table should only show transactions dates between {string} to {string}")
    public void results_table_should_only_show_transactions_dates_between_to(String fromDateArg, String toDateArg) {


        accountActivity = new AccountActivity();

        LocalDate fromDate= LocalDate.parse(fromDateArg);
        LocalDate toDate= LocalDate.parse(toDateArg);

        List<WebElement> dates =
                accountActivity.dateColumn;


        LocalDate maxDate = dates.stream().map(date-> LocalDate.parse(date.getText())).max(LocalDate::compareTo).get();
        LocalDate minDate = dates.stream().map(date->LocalDate.parse(date.getText())).min(LocalDate::compareTo).get();
       dates.clear();
        System.out.println("---------------------");
        System.out.println(fromDate);
        System.out.println(minDate);
        System.out.println(toDate);
        System.out.println(maxDate);

        Assert.assertTrue((maxDate.isEqual(toDate)|| maxDate.isBefore(toDate))
                &&
                (minDate.isEqual(fromDate)||minDate.isAfter(fromDate)));


    }
    @Then("the results should be sorted by most recent date")
    public void the_results_should_be_sorted_by_most_recent_date() {
        accountActivity = new AccountActivity();
        List<LocalDate> dates =
                accountActivity.dateColumn
                .stream().map(data->LocalDate.parse(data.getText())).collect(Collectors.toList());
        List<LocalDate> actualDate= new ArrayList<>(dates);
        Assert.assertTrue(dates.equals(actualDate));
    }
    @Then("the results table should only not contain transactions dated {string}")
    public void the_results_table_should_only_not_contain_transactions_dated(String date) {

        accountActivity = new AccountActivity();
        List<LocalDate> dates =
                accountActivity.dateColumn
                        .stream().map(data->LocalDate.parse(data.getText())).collect(Collectors.toList());

        System.out.println(dates.contains(LocalDate.parse(date)));
        Assert.assertFalse(dates.contains(LocalDate.parse(date)));



    }

    @When("the user enters description {string}")
    public void the_user_enters_description_office(String description) {
        accountActivity = new AccountActivity();
        accountActivity.descriptionInputBox.clear();
        accountActivity.descriptionInputBox.sendKeys(description);
    }
    @Then("results table should only show descriptions containing {string}")
    public void results_table_should_only_show_descriptions_containing_office(String word) {

        accountActivity = new AccountActivity();
        boolean found = accountActivity.descriptionColumn
                .stream().allMatch(desc->desc.getText().contains(word));
        Assert.assertTrue(found);

    }
    @Then("results table should not show descriptions containing {string}")
    public void results_table_should_not_show_descriptions_containing_office(String word) {
        accountActivity = new AccountActivity();
        boolean found = accountActivity.descriptionColumn
                .stream().allMatch(desc->desc.getText().contains(word));
        Assert.assertFalse(found);
    }

    @Then("results table should show at least one result under Deposit")
    public void results_table_should_show_at_least_one_result_under_deposit() {
        accountActivity = new AccountActivity();
        List<WebElement> depoColumn =
                accountActivity.depositColumn.stream().filter(depo->depo.getText()!=""&&depo.getText()!=null)
                .collect(Collectors.toList());
        Assert.assertTrue(depoColumn.size()>=1);
    }
    @Then("results table should show at least one result under Withdrawal")
    public void results_table_should_show_at_least_one_result_under_withdrawal() {
        accountActivity = new AccountActivity();
        List<WebElement> withdrawColumn =
                accountActivity.withdrawalColumn.stream().filter(depo->depo.getText()!=""&&depo.getText()!=null)
                        .collect(Collectors.toList());
        Assert.assertTrue(withdrawColumn.size()>=1);
    }
    @When("user selects type {string}")
    public void user_selects_type_deposit(String type) {
        accountActivity = new AccountActivity();
        BrowserUtils.getSelectWebElement(accountActivity.typeDropDown)
                .selectByVisibleText(type);
        accountActivity.findButton.click();
    }
    @Then("results table should show no result under Withdrawal")
    public void results_table_should_show_no_result_under_withdrawal() {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);
        wait.until(ExpectedConditions.refreshed(ExpectedConditions.stalenessOf(accountActivity.transactionTable)));
        List<WebElement> withdrawColumn =
                    accountActivity.withdrawalColumn.stream().filter(depo -> depo.getText() != "" && depo.getText() != null)
                            .collect(Collectors.toList());
            System.out.println(withdrawColumn.size());

        Assert.assertTrue(withdrawColumn.isEmpty());
    }
    @Then("results table should show no result under Deposit")
    public void results_table_should_show_no_result_under_deposit() {
        List<WebElement> depoColumn =
                accountActivity.depositColumn.stream().filter(depo->depo.getText()!=""&&depo.getText()!=null)
                        .collect(Collectors.toList());
        Assert.assertTrue(depoColumn.isEmpty());
    }
}
