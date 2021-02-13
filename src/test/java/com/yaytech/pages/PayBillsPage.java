package com.yaytech.pages;

import com.yaytech.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PayBillsPage extends BasePage {

    public PayBillsPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(id = "alert_content")
    public WebElement alertText;

     //Pay Saved payee sub tab and included form elements
    @FindBy(xpath = "(//*[@id='tabs']/ul/li)[1]")
    public WebElement paySavedPayeeSUbTab;

   //add all elements
    


    //Add New payee sub tab and included form elements
    @FindBy(xpath = "(//*[@id='tabs']/ul/li)[2]")
    public WebElement addNewPayeeSubTab;

    @FindBy(id = "np_new_payee_name")
    public WebElement payeeNameInputBox;

    @FindBy(id = "np_new_payee_address")
    public WebElement payeeAddressTextArea;

    @FindBy(id = "np_new_payee_account")
    public WebElement accountInputBox;

    @FindBy(id = "np_new_payee_details")
    public WebElement payeeDetailsInputBox;

    @FindBy(id = "add_new_payee")
    public WebElement addButton;


    //Purchase Foreign Currency sub tab and included form elements
    @FindBy(xpath = "(//*[@id='tabs']/ul/li)[3]")
    public WebElement purchaseCurrencySubTab;

    @FindBy(id = "pc_currency")
    public WebElement currencyTypeDropDown;

    @FindBy(id = "pc_amount")
    public WebElement amountInputBox;

    @FindBy(xpath = "(//*[@class='radio inline'])[2]")
    public WebElement usdRadioButton;

    @FindBy(xpath = "(//*[@class='radio inline'])[3]")
    public WebElement selectedRadioButton;

    @FindBy(id = "pc_calculate_costs")
    public WebElement calculatedCostButton;

    @FindBy(id = "purchase_cash")
    public WebElement purchaseButton;


}


