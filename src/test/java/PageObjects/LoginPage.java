package PageObjects;

import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
    private WebDriver driver;
    private WebDriver firefoxDriver;
    private WebDriverWait wait;

    //Variables and Locators
    @FindBy(id = "login-button") private WebElement lnk_login;
    @FindBy(id = "user-name") private WebElement lnk_username;
    @FindBy(id = "password") private WebElement lnk_password;
    @FindBy(xpath = "//h3") private WebElement txt_alertMessage;

    //Constructor
    public LoginPage(WebDriver d) {
        driver = d;
        wait = new WebDriverWait(driver,30);
        PageFactory.initElements(driver,this);
    }

    //Methods
    public  void ClickLogin(){
        lnk_login.click();
    }

    public  void pressEnter(){
        lnk_login.sendKeys(Keys.ENTER);
    }

    public  void EnterUsername(String userName){
        lnk_username.sendKeys(userName);
    }

    public  void EnterPassword(String password){
        lnk_password.sendKeys(password);
    }

    public  void VerifyUserRequiredMessage(String userRequiredMessage){
        wait.until(ExpectedConditions.visibilityOf(txt_alertMessage));
        Assert.assertEquals(txt_alertMessage.getText(),userRequiredMessage);
    }

    public  void VerifyPasswordRequiredMessage(String passwordRequiredMessage){
        wait.until(ExpectedConditions.visibilityOf(txt_alertMessage));
        Assert.assertEquals(txt_alertMessage.getText(),passwordRequiredMessage);
    }

    public  void VerifyUnregisteredUserMessage(String unregisteredUserMessage){
        wait.until(ExpectedConditions.visibilityOf(txt_alertMessage));
        Assert.assertEquals(txt_alertMessage.getText(),unregisteredUserMessage);
    }
}
