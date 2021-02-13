package com.yaytech.stepdefinitions;

import com.yaytech.pages.AccountActivity;
import com.yaytech.pages.AccountSummaryPage;
import com.yaytech.utilities.BrowserUtils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.support.ui.Select;

public class AccountSummaryToAccountActivity {
    private AccountSummaryPage accountSummaryPage;
    private AccountActivity accountActivity;


    @Given("the user is logged in")
    public void the_user_is_logged_in() {

    }


    @When("the user clicks on {string} link on the Account Summary page")
    public void the_user_clicks_on_link_on_the_account_summary_page(String link) {
        accountSummaryPage = new AccountSummaryPage();
        accountSummaryPage.accountSummary.click();
        BrowserUtils.findfirstAncorbytext(link).click();
    }

    @Then("the Account Activity page should be displayed")
    public void the_account_activity_page_should_be_displayed() {
        accountActivity = new  AccountActivity();
        //Assert.assertTrue(accountActivity.accountActivity.isSelected());
        Assert.assertTrue(accountActivity.accountTypePanel.isDisplayed());

    }

    @Then("Account drop down should have {string} selected")
    public void account_drop_down_should_have_selected(String option) {
       accountActivity = new AccountActivity();
      Select accountType=BrowserUtils.getSelectWebElement(accountActivity.accountTypeDropDown);
      Assert.assertEquals(option, BrowserUtils.getSelected(accountType).getText());
    }




}
