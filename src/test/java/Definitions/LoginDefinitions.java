package Definitions;

import PageObjects.LoginPage;
import PageObjects.MainPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginDefinitions {
    LoginPage login;
    MainPage  main;
    Hooks hooks;
    //Constructor
    public LoginDefinitions() {
        login = new LoginPage(Hooks.driver);
        main = new MainPage(Hooks.driver);
    }

    @Given("The user is on login page")
    public void theUserIsLoginPage() {
        Hooks.driver.get("https://www.saucedemo.com/");
    }

    @When("The user enters the username {string} and password {string}")
    public void theUserEntersTheUsernameAndPassword(String userName, String password) {
        login.EnterUsername(userName);
        login.EnterPassword(password);
    }

    @And("The user logs in")
    public void theUserLogsIn() {
        login.ClickLogin();
    }

    @Then("The Swaglabs ecommerce is opened")
    public void theSwaglabsEcommerceIsOpened() {
        main.VerifyURL();
    }

    @And("The header is displayed")
    public void theHeaderIsDisplayed() {
        main.VerifyShoppingCartIcon();
        main.VerifyLeftShoppingMenu();
        main.VerifyShoppingLogo();
        main.VerifyProductsText();
        main.VerifyRobotImage();
        main.VerifyShoppingFilters();
    }

    @And("Six products are displayed in the middle")
    public void sixProductsAreDisplayedInTheMiddle() {
        main.ScrollDown();
        main.VerifyNumberProducts();
    }

    @And("The footer is displayed in the bottom")
    public void theFooterIsDisplayedInTheBottom() {
        main.VerifyRightImageFooter();
        main.VerifySocialMediaSection();
        main.VerifyRightsReservedText();
    }

    @And("The user press Enter")
    public void theUserPressEnter() {
        login.pressEnter();
    }

    @And("Six identical images of products are displayed in the middle")
    public void sixIdenticalImagesOfProductsAreDisplayedInTheMiddle() {
        main.ScrollDown();
        main.DownloadImages();
        //main.VerifyImages();
    }

    @When("The user enters only a valid password {string}")
    public void theUserEntersOnlyAValidPassword(String password) {
        login.EnterPassword(password);
    }

    @When("The user enters the only a valid username {string}")
    public void theUserEntersTheOnlyAValidUsername(String userName) {
        login.EnterUsername(userName);
    }

    @Then("An alert user required message is displayed {string}")
    public void anAlertUserRequiredMessageIsDisplayed(String userRequiredMessage) {
        login.VerifyUserRequiredMessage(userRequiredMessage);
    }

    @Then("An alert password required message is displayed {string}")
    public void anAlertPasswordRequiredMessageIsDisplayed(String passwordRequiredMessage) {
        login.VerifyPasswordRequiredMessage(passwordRequiredMessage);
    }

    @Then("An alert about unregistered user message is displayed {string}")
    public void anAlertAboutUnregisteredUserMessageIsDisplayed(String unregisteredUserMessage ) {
        login.VerifyUnregisteredUserMessage(unregisteredUserMessage);
    }

    @Then("An error web page is displayed")
    public void anErrorWebPageIsDisplayed() {
        main.VerifyErrorURL();
        main.VerifyError404Font();
    }

    @Given("The user is on login page in a Chrome browser")
    public void theUserIsOnLoginPageInAChromeBrowser()  {
        Hooks.driver.get("https://www.saucedemo.com/");
    }

    @And("The user is on login page in a Firefox browser")
    public void theUserIsOnLoginPageInAFirefoxBrowser()  {
        Hooks.driver.get("https://www.saucedemo.com/");
    }
}
