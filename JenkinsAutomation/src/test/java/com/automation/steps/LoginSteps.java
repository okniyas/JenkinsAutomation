package com.automation.steps;

import com.automation.pages.LoginPage;
import com.automation.utils.ConfigReader;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class LoginSteps {
    LoginPage loginPage = new LoginPage();

    @Given("user opens the website")
    public void user_opens_the_website() {
        loginPage.openWebsite();
    }

    @Then("verify user is on login page")
    public void verify_user_is_on_login_page() {
        Assert.assertTrue(loginPage.isLoginPageDisplayed());
    }

    @When("user enters username {string} and password {string}")
    public void user_enters_username_and_password(String usernameKey, String passwordKey) {
        loginPage.doLogin(ConfigReader.getConfigValue(usernameKey), ConfigReader.getConfigValue(passwordKey));
    }

    @And("click on submit button")
    public void clickOnSubmitButton() {
        loginPage.clickOnSubmitBtn();
    }

    @Then("verify user is on home page")
    public void verifyUserIsOnHomePage() {
        Assert.assertTrue(loginPage.verifyOnHomePage());
    }

    @When("user click on New Item from side bar")
    public void userClickOnNewItemFromSideBar() {
        loginPage.userClickOnNewItem();

    }

    @And("automatically generate item name")
    public void automaticallyGenerateItemName() {
        loginPage.automaticallyGenerateItemName();

    }

    @And("click on freestyle project")
    public void clickOnFreestyleProject() {
        loginPage.clickOnFreestyleProject();
    }

    @And("click on ok button")
    public void clickOnOkButton() {
        loginPage.clickOnOkButton();
    }

    @Then("verify user is on configuration page")
    public void verifyUserIsOnConfigurationPage() {
        Assert.assertTrue(loginPage.verifyUserIsOnConfigurationPage());
    }

    @When("user select git from source code management")
    public void userSelectGitFromSourceCodeManagement() throws InterruptedException {
        loginPage.userSelectGitFromSourceCodeManagement();

    }

    @And("enter the git repository URL")
    public void enterTheGitRepositoryURL() throws InterruptedException {
        loginPage.enterTheGitRepositoryURL();
    }

    @And("click on Add build step")
    public void clickOnAddBuildStep() throws InterruptedException {
        loginPage.clickOnAddBuildStep();

    }

    @And("select Invoke top-level Maven targets")
    public void selectInvokeTopLevelMavenTargets() {
        loginPage.selectInvokeTopLevelMavenTargets();

    }

    @And("enter the {string} command")
    public void enterTheCommand(String command) {
        loginPage.enterMavenCommand(command);
    }

    @And("click on add post-build action")
    public void clickOnAddPostBuildAction() {
        loginPage.clickOnAddPostBuildAction();

    }

    @And("select cucumber reports")
    public void selectCucumberReports() throws InterruptedException {
        loginPage.selectCucumberReports();

    }

    @And("click on save")
    public void clickOnSave() {
        loginPage.clickOnSave();
    }

    @Then("verify user is logged out successfully")
    public void verifyUserIsLoggedOutSuccessfully() {
        loginPage.verifyUserIsLoggedOutSuccessfully();
    }
}
