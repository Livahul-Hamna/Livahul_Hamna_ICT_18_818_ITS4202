package com.actitime.qa.pages;

import com.actitime.qa.base.TestBase;
import com.actitime.qa.entities.UserData;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UsersPage extends TestBase  {
    @FindBy(xpath = "//div[text()='New User']")
    private WebElement newUserButton;
    @FindBy(xpath = "//input[@id='createUserPanel_firstNameField']")
    private WebElement firstNameTxt;

    @FindBy(xpath = "//input[@id='createUserPanel_lastNameField']")
    private WebElement lastNameTxt;

    @FindBy(xpath = "//input[@id='createUserPanel_emailField']")
    private WebElement emailTxt;

    @FindBy(xpath = "//div[text()='Save & Send Invitation']")
    private WebElement saveBtn;

    @FindBy(xpath = "//div[@class='closeLink']/span[text()='Close']")
    private WebElement closeBtn;

    public UsersPage() {
        PageFactory.initElements(driver, this);
    }

    public void clickOnAddNewUserButton() {
        newUserButton.click();
        WebDriverWait wait = new WebDriverWait(driver, 15);
        firstNameTxt = wait.until(ExpectedConditions.elementToBeClickable(firstNameTxt));
        lastNameTxt = wait.until(ExpectedConditions.elementToBeClickable(lastNameTxt));
        emailTxt = wait.until(ExpectedConditions.elementToBeClickable(emailTxt));
        saveBtn = wait.until(ExpectedConditions.elementToBeClickable(saveBtn));
    }

    public void enterUserData(UserData userData) {
        firstNameTxt.sendKeys(userData.getFirstName());
        lastNameTxt.sendKeys(userData.getLastName());
        emailTxt.sendKeys(userData.getEmail());
    }

    public void clickOnSaveButton() {
        saveBtn.click();
        WebDriverWait wait = new WebDriverWait(driver, 15);
        closeBtn = wait.until(ExpectedConditions.elementToBeClickable(closeBtn));
    }

    public void clickOnCloseButton() {
        closeBtn.click();
}
}
