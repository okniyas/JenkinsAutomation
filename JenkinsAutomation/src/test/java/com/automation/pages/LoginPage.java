package com.automation.pages;

import com.automation.utils.ConfigReader;
import com.automation.utils.UniqueNameGenerator;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{
    @FindBy(id = "j_username")
    WebElement usernameInput;

    @FindBy(id = "j_password")
    WebElement passwordInput;

    @FindBy(xpath = "//button[@name='Submit']")
    WebElement signInBtn;

    @FindBy(xpath = "//a[@href='/logout']")
    WebElement logOutDisplayInHomePage;

    @FindBy(xpath = "(//div[@id='tasks']//span)[1]")
    WebElement newItemClick;
    
    @FindBy(id = "name")
    WebElement itemNameInput;

    @FindBy(xpath =  "(//div[@id='j-add-item-type-standalone-projects']//li)[1]")
    WebElement freeStyleClick;

    @FindBy(id = "ok-button")
    WebElement clickOkBtn;

    @FindBy(xpath = "//h1")
    WebElement configureText;

    @FindBy(xpath = "//input[@id='radio-block-2']")
    WebElement selectGitRadioBtn;

    @FindBy(xpath = "(//div[text()='Repository URL']/following-sibling::div)[1]/input")
    WebElement repositoryURLInput;

    @FindBy(xpath = "//button[@type='button' and @suffix='builder']")
    WebElement clickOnAddBuild;

    @FindBy(xpath = "(//div[contains(@class, 'jenkins-dropdown')]/button)[5]")
    WebElement clickOnInvokeTopLevelMavenTargets;

    @FindBy(xpath = "//button[@type='button' and @suffix='publisher']")
    WebElement clickOnAddPostBuildAction;

    @FindBy(xpath = "(//div[contains(@class, 'jenkins-dropdown')]/button)[4]")
    WebElement clickOnCucumberReports;

    @FindBy(xpath = "//button[@name='Submit']")
    WebElement saveBtn;

    @FindBy(xpath = "//input[@id='textarea._.targets']")
    WebElement enterMavenCommandText;


    public void openWebsite() {
        driver.get("http://localhost:8080/login");
    }

    public void doLogin(String username, String password) {
        usernameInput.sendKeys(username);
        passwordInput.sendKeys(password);
//        signInBtn.click();
    }

    public boolean isLoginPageDisplayed() {
        return isDisplay(usernameInput) && isDisplay(passwordInput);
    }

    public void clickOnSubmitBtn() {
        signInBtn.click();
    }

    public boolean verifyOnHomePage() {
        return isDisplay(logOutDisplayInHomePage);
    }

    public void userClickOnNewItem() {
        newItemClick.click();
    }

    public void automaticallyGenerateItemName() {
        itemNameInput.sendKeys(UniqueNameGenerator.getUniqueName());
//        itemNameInput.sendKeys(ConfigReader.getConfigValue("item.name"));
    }

    public void clickOnFreestyleProject() {
        freeStyleClick.click();

    }

    public void clickOnOkButton() {
        clickOkBtn.click();
    }

    public boolean verifyUserIsOnConfigurationPage() {
        return isDisplay(configureText);
    }

    public void userSelectGitFromSourceCodeManagement() throws InterruptedException {
        Thread.sleep(3000);
//        selectGitRadioBtn.click();

        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
        javascriptExecutor.executeScript("arguments[0].click();",selectGitRadioBtn);
    }

    public void enterTheGitRepositoryURL() throws InterruptedException {
        Thread.sleep(3000);
        repositoryURLInput.sendKeys(ConfigReader.getConfigValue("repository.url"));


//        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
//        javascriptExecutor.executeScript("arguments[0].click();", repositoryURLInput.sendKeys(ConfigReader.getConfigValue("repository.url")));
    }

    public void clickOnAddBuildStep() throws InterruptedException {
        Thread.sleep(3000);
//        clickOnAddBuild.click();
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
        javascriptExecutor.executeScript("arguments[0].click();",clickOnAddBuild);
    }

    public void selectInvokeTopLevelMavenTargets() {
        clickOnInvokeTopLevelMavenTargets.click();
    }

    public void clickOnAddPostBuildAction() {
//        clickOnAddPostBuildAction.click();
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
        javascriptExecutor.executeScript("arguments[0].click();",clickOnAddPostBuildAction);
    }


    public void selectCucumberReports() throws InterruptedException {
//        WebElement frameFilter = driver.findElement(By.xpath("//div[@role='tooltip']"));
//        driver.switchTo().frame(frameFilter);
        Thread.sleep(2000);
        clickOnCucumberReports.click();
    }

    public void clickOnSave() {
        saveBtn.click();
    }

    public void enterMavenCommand(String command) {
        enterMavenCommandText.sendKeys(command);
    }

    public void verifyUserIsLoggedOutSuccessfully() {
        logOutDisplayInHomePage.click();
    }
}
