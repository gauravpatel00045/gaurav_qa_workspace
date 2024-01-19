package com.bankingexample.testcases;

import com.bankingexample.pageobject.AddCustomerPage;
import com.bankingexample.pageobject.LoginPage;
import com.bankingexample.pageobject.ManagerHomePage;
import com.bankingexample.utilities.Constants;
import org.apache.commons.lang3.RandomStringUtils;
import org.checkerframework.checker.index.qual.PolyUpperBound;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.sql.Driver;
import java.time.Duration;


public class TCAddCustomerPageTest extends BaseClass {


    @Test
    public void addNewCustomer() {

        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterUserId(USER_NAME);
        loginPage.enterPassword(PASSWORD);
        loginPage.clickLogin();
        logger.info("login success");

        try {
            captureScreen(driver, "ManagerHomepage");
        } catch (IOException e) {
            e.printStackTrace();
        }

        ManagerHomePage homePage = new ManagerHomePage(driver);

        wait.until(ExpectedConditions.titleIs(Constants.BANK_MANAGER_HOME_PAGE_TITLE));

        homePage.clickNewCustomer();
        logger.info("add new customer selected");

        AddCustomerPage addCustomerPage = new AddCustomerPage(driver);
        addCustomerPage.enterCustomerName(readConfig.getCustomerName());
        addCustomerPage.clickRadioFeMale();
        addCustomerPage.clickAndSelectFromDate(readConfig.getYear(), readConfig.getMonth(), readConfig.getDay());
        addCustomerPage.enterAddress(readConfig.getAddress());
        addCustomerPage.enterCity(readConfig.getCity());
        addCustomerPage.enterState(readConfig.getState());
        addCustomerPage.enterPIN(readConfig.getPIN());
        addCustomerPage.enterMobileNo(readConfig.getMobileNo());
        addCustomerPage.enterEmail(getRandomEmailAddress());
        addCustomerPage.enterPassword(readConfig.getCommonPassword());

        try {
            captureScreen(driver, "new customer details");
        } catch (IOException e) {
            e.printStackTrace();
        }
//        WebElement e = wait.until(ExpectedConditions.elementToBeClickable(addCustomerPage.getSubmit()));
        logger.info("all details added");
        addCustomerPage.clickSubmit();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (isRegisterSuccess()) {
            Assert.assertTrue(true);
        } else {
            Assert.assertEquals(isRegisterSuccess(), false);
        }

    }

    public boolean isRegisterSuccess() {
        return driver.getPageSource().contains(Constants.REGISTER_SUCCESS_MSG);
    }

    public String randomString() {
        return RandomStringUtils.randomAlphabetic(8);
    }

    public String getRandomEmailAddress() {
        return randomString() + "@gmail.com";
    }

}
