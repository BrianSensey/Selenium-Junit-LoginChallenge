package Definitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Hooks {
    public static WebDriver driver;
    public static String BrowserConfig="Chrome";

    @Before
    public static void setUp(){
        switch (BrowserConfig)
        {
            case "Chrome"://v90.0.4430.212
                System.setProperty("webdriver.chrome.driver","src/test/resources/driver/chromedriver.exe");
                driver = new ChromeDriver();
                driver.manage().window().maximize();
                break;
            case "Firefox"://v88.0.1 (x64)
                System.setProperty("webdriver.gecko.driver","src/test/resources/driver/firefoxdriver.exe");
                driver = new FirefoxDriver();
                driver.manage().window().maximize();
                break;
            case "Edge"://90.0.818.62 (x64)
                System.setProperty("webdriver.edge.driver","src/test/resources/driver/java .exe");
                driver = new EdgeDriver();
                driver.manage().window().maximize();
                break;
            //default:
            //    throw new NotSupportedException($"{BrowserConfig} is not a supported browser");
        }

    }

    @After
    public static void tearDown(Scenario scenario){
        if (scenario.isFailed()){
            byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot,"image/png","Failed");
        }
        driver.manage().deleteAllCookies();
        driver.close();
        driver.quit();
    }

    public static WebDriver getDriver(){
        return driver;
    }

}
