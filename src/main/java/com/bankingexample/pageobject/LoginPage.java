package com.bankingexample.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Banking project
 * Login Page
 *
 * @see <a href="https://www.demo.guru99.com/V4/index.php"> Guru99 Bank Home Page </a>
 */
public class LoginPage {

    private WebDriver driver;

    @FindBy(name = "uid")
    private WebElement userId;

    @FindBy(name = "password")
    private WebElement password;

    @FindBy(name = "btnLogin")
    private WebElement btnLogin;

    @FindBy(name = "btnReset")
    private WebElement btnReset;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void enterUserId(String userInput) {
        userId.sendKeys(userInput);
    }

    public void enterPassword(String userInput) {
        password.sendKeys(userInput);
    }

    public void clickLogin() {
        btnLogin.click();
    }

    public void clickReset() {
        btnReset.click();
    }

    public void getPageTitle() {
        System.out.println(driver.getTitle());
    }


}
