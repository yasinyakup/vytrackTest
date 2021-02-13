package com.yaytech.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public abstract class BasePage {


    @FindBy(xpath = "//*[@id='settingsBox']/ul/li[1]/a")
    public WebElement searchMenu;

    @FindBy(xpath = "//*[@id='settingsBox']/ul/li[2]/a")
    public WebElement settingsMenu;

    @FindBy(xpath = "//*[@id='settingsBox']/ul/li[3]/a")
    public WebElement profileMenu;

    @FindBy(css = "#account_summary_tab>a")
    public WebElement accountSummary;

    @FindBy(css = "#account_activity_tab>a")
    public WebElement accountActivity;

    @FindBy(css = "#transfer_funds_tab>a")
    public WebElement transferFunds;

    @FindBy(css = "#pay_bills_tab>a")
    public WebElement payBill;

    @FindBy(css = "#money_map_tab>a")
    public WebElement moneyMap;

    @FindBy(css = "#online_statements_tab>a")
    public WebElement outlineStatement;
}
