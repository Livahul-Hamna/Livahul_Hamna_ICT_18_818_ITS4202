
package com.actitime.qa.stepdefinitions;
import com.actitime.qa.entities.UserData;
import com.actitime.qa.pages.HomePage;
import com.actitime.qa.pages.UsersPage;
import com.actitime.qa.util.UserUtill;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static com.actitime.qa.base.TestBase.driver;
import static com.actitime.qa.base.TestBase.initialization;
public class CreateUserStepDefinitions {
    UsersPage usersPage;
    HomePage homePage;

    @Given("^Existing user in the Actitime home page$")
    public void user_in_the_Actitime_Home_Page() throws Throwable {
        initialization();
    }

    @When("^User click on users tab$")
    public void User_click_on_users_section() throws Throwable {
        homePage.clickOnUsersLink();
    }

    @Then("^User click on add new user button$")
    public void user_click_on_add_new_user_button() throws Throwable {
        usersPage.clickOnAddNewUserButton();
    }

    @Then("^Fill in necessary data$")
    public void user_insert_user_data() throws Throwable {
        UserData userCredential = UserUtill.getUserData();
        usersPage.enterUserData(userCredential);
    }

    @Then("^Click on save button$")
    public void user_click_on_save_button() throws Throwable {
        usersPage.clickOnSaveButton();
    }

    @Then("^User should be added successfully$")
    public void user_should_be_added_successfully() throws Throwable {
        driver.quit();
}
}
