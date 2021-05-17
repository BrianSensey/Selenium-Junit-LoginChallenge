package PageObjects;

import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.List;

public class MainPage {
    private WebDriver driver;
    private WebDriverWait wait;
    private String currentUrl;

    //Variables and Locators
    //Header
    @FindBy(id = "shopping_cart_container") private WebElement img_shoppingCart;
    @FindBy(className = "bm-burger-button") private WebElement img_leftShoppingMenu;
    @FindBy(className = "app_logo") private WebElement img_shoppingLogo;
    @FindBy(xpath = "//div[1]/div[2]/span") private WebElement lbl_products;
    @FindBy(className = "peek") private WebElement img_robot;
    @FindBy(className = "product_sort_container") private WebElement img_shoppingFilters;
    @FindBy(className = "error404_maintance") private WebElement img_error404;

    //Middle
    @FindBy(className = "inventory_item") private List<WebElement> lst_products;
    @FindBy(xpath = "//div[1]/a/img") private List<WebElement> lst_imageProducts;

    //Footer
    @FindBy(className = "footer_robot") private WebElement img_robotFooter;
    @FindBy(className = "social") private WebElement lnk_socialMedia;
    @FindBy(className = "footer_copy") private WebElement lbl_rightsReserved;

    //Constructor
    public MainPage(WebDriver d) {
        driver = d;
        wait = new WebDriverWait(driver,30);
        PageFactory.initElements(driver,this);
    }
    //Methods
    public  void VerifyURL(){
        currentUrl = driver.getCurrentUrl();
        Assert.assertEquals(currentUrl, "https://www.saucedemo.com/inventory.html" );
    }

    public  void VerifyErrorURL(){
        currentUrl = driver.getCurrentUrl();
        Assert.assertEquals(currentUrl, "https://www.saucedemo.com/maintenance.html" );
    }

    public  void ScrollDown(){
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("window.scrollBy(0,200)");
    }

    public  void VerifyNumberProducts(){
        wait.until(ExpectedConditions.visibilityOfAllElements(lst_products));
        Assert.assertTrue(lst_products.size() == 6);
    }

    public  void DownloadImages(){
        String src;
        BufferedImage bufferedImage;
        File outputfile;
        Integer countF = 1;
        wait.until(ExpectedConditions.visibilityOfAllElements(lst_imageProducts));
        for(WebElement e : lst_imageProducts) {
            try {
            src = e.getAttribute("src");
            bufferedImage = ImageIO.read(new URL(src));
            ImageIO.write(bufferedImage,"jpg",new File("images/"+countF + ".jpg"));
            countF++;
            } catch (IOException f) {
                f.printStackTrace();
            }
        }
    }
/*
    public  void VerifyImages(){
        BufferedImage img1 = ImageIO.read(new File("images/1.jpg"));
        BufferedImage img2 = ImageIO.read(new File("images/2.jpg"));
        //BufferedImage img3 = ImageIO.read(new File("C:/img/picA.jpg"));
        //BufferedImage img4 = ImageIO.read(new File("C:/img/picB.jpg"));
        //BufferedImage img5 = ImageIO.read(new File("C:/img/picB.jpg"));
        //BufferedImage img6 = ImageIO.read(new File("C:/img/picB.jpg"));

        boolean bufferedImagesEqual (BufferedImage img1, BufferedImage img2) {
            if (img1.getWidth() == img2.getWidth() && img1.getHeight() == img2.getHeight()) {
                for (int x = 0; x < img1.getWidth(); x++) {
                    for (int y = 0; y < img1.getHeight(); y++) {
                        if (img1.getRGB(x, y) != img2.getRGB(x, y)){
                            return false;
                        }
                    }
                }
            } else {
                return false;
            }
            return true;
        }
        System.out.println(bufferedImagesEqual);
        Assert.assertTrue(bufferedImagesEqual);
    }
*/
    public  void VerifyShoppingCartIcon(){
        wait.until(ExpectedConditions.visibilityOf(img_shoppingCart));
        Assert.assertTrue(img_shoppingCart.isDisplayed());
    }

    public  void VerifyLeftShoppingMenu(){
        wait.until(ExpectedConditions.visibilityOf(img_leftShoppingMenu));
        Assert.assertTrue(img_leftShoppingMenu.isDisplayed());
    }

    public  void VerifyShoppingLogo(){
        wait.until(ExpectedConditions.visibilityOf(img_shoppingLogo));
        Assert.assertTrue(img_shoppingLogo.isDisplayed());
    }

    public  void VerifyProductsText(){
        wait.until(ExpectedConditions.visibilityOf(lbl_products));
        Assert.assertEquals(lbl_products.getText(),"PRODUCTS");
    }

    public  void VerifyRobotImage(){
        wait.until(ExpectedConditions.visibilityOf(img_robot));
        Assert.assertTrue(img_robot.isDisplayed());
    }

    public  void VerifyShoppingFilters(){
        wait.until(ExpectedConditions.visibilityOf(img_shoppingFilters));
        Assert.assertTrue(img_shoppingFilters.isDisplayed());
    }

    public  void VerifyError404Font(){
        wait.until(ExpectedConditions.visibilityOf(img_error404));
        Assert.assertTrue(img_error404.isDisplayed());
    }

    public  void VerifyRightImageFooter(){
        wait.until(ExpectedConditions.visibilityOf(img_robotFooter));
        Assert.assertTrue(img_robotFooter.isDisplayed());
    }

    public  void VerifySocialMediaSection(){
        wait.until(ExpectedConditions.visibilityOf(lnk_socialMedia));
        Assert.assertTrue(lnk_socialMedia.isDisplayed());
    }

    public  void VerifyRightsReservedText(){
        wait.until(ExpectedConditions.visibilityOf(lbl_rightsReserved));
        Assert.assertEquals(lbl_rightsReserved.getText(),"© 2021 Sauce Labs. All Rights Reserved. Terms of Service | Privacy Policy");
    }


}
