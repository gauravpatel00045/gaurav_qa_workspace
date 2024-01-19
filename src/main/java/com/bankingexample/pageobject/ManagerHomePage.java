package com.bankingexample.pageobject;

import com.bankingexample.testcases.BaseClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Banking project
 * Manager Home Page
 *
 * @see <a href="https://www.demo.guru99.com/V4/manager/Managerhomepage.php"> Guru99 Bank Manager Home Page </a>
 */
public class ManagerHomePage {

    private WebDriver driver;

    @FindBy(xpath = "//a[@href='addcustomerpage.php']")
    private WebElement newCustomer;

    @FindBy(xpath = "//a[href='EditCustomer.php']")
    private WebElement editCustomer;

    @FindBy(xpath = "//a[href='DeleteCustomerInput.php']")
    private WebElement deleteCustomer;

    @FindBy(xpath = "//a[@href='addAccount.php']")
    private WebElement addAccount;

    @FindBy(xpath = "//a[@href='editAccount.php']")
    private WebElement editAccount;

    @FindBy(xpath = "//a[href='deleteAccountInput.php']")
    private WebElement deleteAccountInput;

    @FindBy(xpath = "//a[href='DepositInput.php']")
    private WebElement depositInput;

    @FindBy(xpath = "//a[href='WithdrawalInput.php']")
    private WebElement withdrawalInput;

    @FindBy(xpath = "//a[href='FundTransInput.php']")
    private WebElement fundTransInput;

    @FindBy(xpath = "//a[href='PasswordInput.php']")
    private WebElement changePasswordInput;

    @FindBy(xpath = "//a[@href='BalEnqInput.php']")
    private WebElement balEnqInput;

    @FindBy(xpath = "//a[href='MiniStatementInput.php']")
    private WebElement miniStatement;

    @FindBy(xpath = "//a[@href='CustomisedStatementInput.php']")
    private WebElement customisedStatement;

    @FindBy(xpath = "//a[contains(text(),'Log out')]")
    WebElement logOut;

    public ManagerHomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickNewCustomer() {
        newCustomer.click();
    }

    public void clickEditCustomer() {
        editCustomer.click();
    }

    public void clickDeleteCustomer() {
        deleteCustomer.click();
    }

    public void clickAddAccount() {
        addAccount.click();
    }

    public void clickEditAccount() {
        editAccount.click();
    }

    public void clickDeleteAccount() {
        deleteAccountInput.click();
    }

    public void clickDeposit() {
        depositInput.click();
    }

    public void clickFundTrans() {
        fundTransInput.click();
    }

    public void clickChangePassword() {
        changePasswordInput.click();
    }

    public void clickBalanceInquiry() {
        balEnqInput.click();
    }

    public void clickMiniStatement() {
        miniStatement.click();
    }

    public void clickCustomisedStatement() {
        customisedStatement.click();
    }

    public void clickLogOut() {
        logOut.click();
    }
}
