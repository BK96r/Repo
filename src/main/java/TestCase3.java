import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;
import java.util.SortedMap;

public class TestCase3 {

    @Test
    public void TestCase3(){

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://www.saucedemo.com/");

        WebElement username = driver.findElement(By.id("user-name"));
        username.sendKeys("standard_user");

        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("secret_sauce");

        WebElement loginButton = driver.findElement(By.id("login-button"));
        loginButton.click();

        WebElement firstCheaperItemAddToCart = driver.findElement(By.id("add-to-cart-sauce-labs-onesie"));
        firstCheaperItemAddToCart.click();

        WebElement secondCheaperItemAddToCart = driver.findElement(By.id("add-to-cart-sauce-labs-bike-light"));
        secondCheaperItemAddToCart.click();
        String firstCheaperProduct = driver.findElement(By.xpath("//div[.='Sauce Labs Onesie']")).getText();
        String secondCheaperProduct = driver.findElement(By.xpath("//div[.='Sauce Labs Bike Light']")).getText();

        WebElement cart = driver.findElement(By.xpath("//a[@class='shopping_cart_link']"));
        cart.click();

        List<WebElement> itemsInCart = driver.findElements(By.xpath("//div[@class='cart_item_label']"));
        for(WebElement itemInCart : itemsInCart){
            Assert.assertTrue(itemInCart.getText().contains(firstCheaperProduct)||itemInCart.getText().contains(secondCheaperProduct));
        }
    }
}
