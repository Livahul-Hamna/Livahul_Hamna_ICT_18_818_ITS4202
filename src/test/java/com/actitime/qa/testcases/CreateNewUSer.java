package com.actitime.qa.testcases;
import com.actitime.qa.entities.UserData;
import com.actitime.qa.pages.HomePage;
import com.actitime.qa.pages.LoginPage;
import com.actitime.qa.pages.UsersPage;
import com.actitime.qa.util.UserUtill;
import com.opencsv.exceptions.CsvValidationException;
import org.junit.AfterClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;


import java.io.IOException;

import static com.actitime.qa.base.TestBase.*;

public class CreateNewUSer {
    private static LoginPage loginPage;
    private static HomePage homePage;
    private static UsersPage usersPage;

    public CreateNewUSer() {
        super();
    }

    @BeforeSuite
    public void setup() {
        initialization();
        loginPage = new LoginPage();
        homePage = loginPage.loging(properties.getProperty("username"), properties.getProperty("password"));
        usersPage = homePage.clickOnUsersLink();
    }

    @Test(priority = 1)
    public void openNewUserPanel() {
        usersPage.clickOnAddNewUserButton();
    }

    @Test(priority = 2, dependsOnMethods = {"openNewUserPanel"})
    public void fillUserData() throws CsvValidationException, IOException {
        UserData userData =  UserUtill.getUserData();
        usersPage.enterUserData(userData);
    }

    @Test(priority = 3, dependsOnMethods = {"fillUserData"})
    public void createNewUser() {
        usersPage.clickOnSaveButton();
    }

    @Test(priority = 4, dependsOnMethods = {"createNewUser"})
    public void closeNewUserPanel() {
        usersPage.clickOnCloseButton();
    }

    @AfterClass
    public static void tearDown() {
        driver.quit();
}
}