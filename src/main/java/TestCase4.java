import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class TestCase4 {

    public Integer fromStringToInt(String value){

        String temp = "";
        for(int i = 0; i < value.length(); i++) {
            if(Character.isDigit(value.charAt(i))){
                temp += value.charAt(i);
            }
        }
        int i = Integer.parseInt(temp);
        return i;
    }

    @Test
    public void TestCase4(){

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

        WebElement firstHighestPricedItemAdd = driver.findElement(By.id("add-to-cart-sauce-labs-fleece-jacket"));
        firstHighestPricedItemAdd.click();

        WebElement secondHighestPricedItemAdd = driver.findElement(By.id("add-to-cart-sauce-labs-backpack"));
        secondHighestPricedItemAdd.click();

        WebElement cart = driver.findElement(By.xpath("//a[@class='shopping_cart_link']"));
        cart.click();
        List<WebElement> itemsInCartPrices = driver.findElements(By.xpath("//div[@class='inventory_item_price']"));
        int totalWithoutTaxExpected = 0;
        for(int i = 0; i < itemsInCartPrices.size(); i++){
            totalWithoutTaxExpected += fromStringToInt(itemsInCartPrices.get(i).getText());
        }

        WebElement checkOutButton = driver.findElement(By.id("checkout"));
        checkOutButton.click();

        WebElement firstName = driver.findElement(By.id("first-name"));
        firstName.sendKeys("Bob");

        WebElement lastName = driver.findElement(By.id("last-name"));
        lastName.sendKeys("Smith");

        WebElement zipCode = driver.findElement(By.id("postal-code"));
        zipCode.sendKeys("60000");

        WebElement continueButton = driver.findElement(By.id("continue"));
        continueButton.click();

        WebElement totalWithoutTax = driver.findElement(By.xpath("//div[@class='summary_subtotal_label']"));
        int totalWithoutTaxActual = fromStringToInt(totalWithoutTax.getText());
        Assert.assertEquals(totalWithoutTaxActual,totalWithoutTaxExpected);

        WebElement taxAmount = driver.findElement(By.xpath("//div[@class='summary_tax_label']"));
        int tax = fromStringToInt(taxAmount.getText());

        WebElement totalWithTax = driver.findElement(By.xpath("//div[@class='summary_total_label']"));
        int totalWithTaxActual = fromStringToInt(totalWithTax.getText());
        int totalWithTaxExpected = totalWithoutTaxExpected + tax;

        Assert.assertEquals(totalWithTaxActual, totalWithTaxExpected);

        Assert.assertTrue(driver.getCurrentUrl().contains("checkout"));

        WebElement finishButton = driver.findElement(By.xpath("//button[@id='finish']"));
        finishButton.click();

        WebElement message = driver.findElement(By.tagName("h2"));
        Assert.assertEquals(message.getText().trim(), "THANK YOU FOR YOUR ORDER");
    }
}
