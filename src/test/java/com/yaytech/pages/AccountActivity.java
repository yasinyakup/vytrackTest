package com.yaytech.pages;

import com.yaytech.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class AccountActivity extends BasePage{
    public AccountActivity() {
        PageFactory.initElements(Driver.getDriver(), this);
    }
//show transaction sub tab and included elements
    @FindBy(xpath = "(//*[@id='tabs']//li)[1]")
    public WebElement showTransactionsSubTab;

    @FindBy(id = "aa_accountId")
    public WebElement accountTypeDropDown;

    @FindBy(className = "controls")
    public WebElement accountTypePanel;


    //find transaction sub tab and included elements

    @FindBy(xpath= "(//*[@id='tabs']//li)[2]")
    public WebElement findTransactionsSubTab;

    @FindBy(id = "aa_description")
    public WebElement descriptionInputBox;

    @FindBy(id = "aa_fromDate")
    public WebElement fromDate;

    @FindBy(id = "aa_toDate")
    public WebElement toDate;

    @FindBy(id = "aa_fromAmount")
    public WebElement fromAmount;

    @FindBy(id = "aa_toAmount")
    public WebElement toAmount;

    @FindBy(id = "aa_type")
    public WebElement typeDropDown;

    @FindBy(xpath = "//*[.='Find']")
    public WebElement findButton;

    //table elements here

    @FindBy(xpath = "//*[@id='filtered_transactions_for_account']/table")
    public WebElement transactionTable;

    @FindBy(xpath = "//*[@id='filtered_transactions_for_account']/table/tbody/tr/td[1]")
    public List<WebElement> dateColumn;

    @FindBy(xpath = "//*[@id='filtered_transactions_for_account']/table/tbody/tr/td[2]")
    public List<WebElement> descriptionColumn;

    @FindBy(xpath = "//*[@id='filtered_transactions_for_account']/table/tbody/tr/td[3]")
    public List<WebElement> depositColumn;

    @FindBy(xpath = "//*[@id='filtered_transactions_for_account']/table/tbody/tr/td[4]")
    public List<WebElement> withdrawalColumn;


}
