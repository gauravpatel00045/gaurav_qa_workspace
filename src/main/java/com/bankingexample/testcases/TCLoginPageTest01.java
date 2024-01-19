package com.bankingexample.testcases;

import com.bankingexample.pageobject.LoginPage;
import com.bankingexample.utilities.Constants;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;


public class TCLoginPageTest01 extends BaseClass {

    LoginPage loginPage;

    @Test
    public void loginTest() {
        logger.info("home page Loading...");
        wait.until(ExpectedConditions.titleIs(Constants.HOME_PAGE_TITLE));
        logger.info("home page loaded");
        String actualPageTitle = driver.getTitle();
        logger.info("page title: " + actualPageTitle);

        loginPage = new LoginPage(driver);

        loginPage.enterUserId(USER_NAME);
        logger.info("username entered");

        loginPage.enterPassword(PASSWORD);
        logger.info("password entered");

        loginPage.clickLogin();
        logger.info("login button clicked");

        if (isLoggedIn()) {
            Assert.assertTrue(true);
        }
        Assert.assertTrue(false);
    }

    public boolean isLoggedIn() {

        return driver.getTitle().equalsIgnoreCase(Constants.BANK_MANAGER_HOME_PAGE_TITLE);
    }

}
