package com.yaytech.pages;

import com.yaytech.utilities.Driver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountSummaryPage extends BasePage{

    public AccountSummaryPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }


}
