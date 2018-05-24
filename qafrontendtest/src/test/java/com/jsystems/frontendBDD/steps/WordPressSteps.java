package com.jsystems.frontendBDD.steps;

import com.jsystems.frontendBDD.Configuration;
import com.jsystems.frontendBDD.pages.LoginPage;
import com.jsystems.frontendBDD.pages.MainLoginPage;
import com.jsystems.frontendBDD.pages.MainPage;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.junit.Assert.assertTrue;

public class WordPressSteps extends BaseSteps{

    public WordPressSteps(StepsConfig config) {

        super(config);
        try {
            driver = config.setUp();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(config.id);
        }
    }

    MainPage mainPage;
    LoginPage loginPage;
    MainLoginPage mainLoginPage;

    @Given("^User is on wordpress website \"([^\"]*)\"$")
    public void userIsOnWordpressWebsite(String website) {
        driver.get(website); //driver.get("https://wordpress.com/")

        mainPage = new MainPage(driver);
        mainPage.isContentPresent();

    }

    @When("^User clicks to login$")
    public void userClicksToLogin() {
        mainPage.loginButton.click();

    }

    @Then("^User is on first login page$")
    public void userIsOnFirstLoginPage()  {
        loginPage = new LoginPage(driver);
        assertTrue(loginPage.loginHeader.isDisplayed());
    }

    @When("^User enter email and press Continue$")
    public void userEnterEmailAndPressContinue(){
        loginPage.emailFields.sendKeys(Configuration.WORDPRESS_EMAIL);
        loginPage.continueButton.click();
    }

    @Then("^User is on second page password$")
    public void userIsOnSecondPagePassword()  {
        loginPage.waitForVisibilityOfElement(loginPage.submitButton, 15);

    }

    @When("^User enter password and press LogIn$")
    public void userEnterPasswordAndPressLogIn() {
        loginPage.passwordFields.sendKeys(Configuration.WORDPRESS_PASSWORD);
        loginPage.submitButton.click();
    }

    @Then("^User is on main login page$")
    public void userIsOnMainLoginPage()  {
        mainLoginPage = new MainLoginPage(driver);
        assertTrue(mainLoginPage.avatar.isDisplayed());
    }

    @When("^User press avatar$")
    public void userPressAvatar() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Then("^User is personal page$")
    public void userIsPersonalPage() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @When("^User click notification link$")
    public void userClickNotificationLink() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Then("^Notification page is displayed$")
    public void notificationPageIsDisplayed() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @When("^User press checkbox$")
    public void userPressCheckbox() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Then("^Checkbox is unselected$")
    public void checkboxIsUnselected() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }
}
