package com.bankingexample.pageobject;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class AddCustomerPage {

    private WebDriver driver;

    @FindBy(name = "name")
    private WebElement cName;

    @FindBy(xpath = "//input[@type='radio'][@value='m']")
    private WebElement genderMale;

    @FindBy(xpath = "//input[@type='radio'][@value='f']")
    private WebElement genderFeMale;

    @FindBy(id = "dob")
    private WebElement birthdatePicker;

    @FindBy(name = "addr")
    private WebElement address;

    @FindBy(name = "city")
    private WebElement city;

    @FindBy(name = "state")
    private WebElement state;

    @FindBy(name = "pinno")
    private WebElement pin;

    @FindBy(name = "telephoneno")
    private WebElement mobileNo;

    @FindBy(name = "emailid")
    private WebElement email;

    @FindBy(name = "password")
    private WebElement password;

    @FindBy(name = "sub")
    private WebElement submit;

    @FindBy(name = "res")
    private WebElement reset;

    public AddCustomerPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void enterCustomerName(String userInput) {
        cName.sendKeys(userInput);
    }

    public void clickRadioMale() {
        genderMale.click();
    }

    public void clickRadioFeMale() {
        genderFeMale.click();
    }

    public void clickAndSelectFromDate(String year, String month, String day) {
        birthdatePicker.sendKeys(year);
        birthdatePicker.sendKeys(month);
        birthdatePicker.sendKeys(day);
    }

    public void enterAddress(String userInput) {
        address.sendKeys(userInput);
    }

    public void enterCity(String userInput) {
        city.sendKeys(userInput);
    }

    public void enterState(String userInput) {
        state.sendKeys(userInput);
    }

    public void enterPIN(String userInput) {
        pin.sendKeys(userInput);
    }

    public void enterMobileNo(String userInput) {
        mobileNo.sendKeys(userInput);
    }

    public void enterEmail(String userInput) {
        email.sendKeys(userInput);
    }

    public void enterPassword(String userInput) {
        password.sendKeys(userInput);
    }

    public void clickSubmit() {
        submit.click();
    }

    public void clickReset() {
        reset.click();
    }

    public WebElement getSubmit() {
        return submit;
    }

    public void setSubmit(WebElement submit) {
        this.submit = submit;
    }
}
