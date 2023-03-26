import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class TestCase1 {

    @Test
    public void TestCase1(){
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

        WebElement dropBox = driver.findElement(By.xpath("//select[@class='product_sort_container']"));
        BrowserUtils.selectBy(dropBox,"za", "value");

        List<WebElement> ListOfProducts = driver.findElements(By.xpath("//div[@class='inventory_item_desc']"));

        List<String> actual = new ArrayList<>();
        List<String> expected = new ArrayList<>();
        for(int i = 0; i < ListOfProducts.size(); i++){
            actual.add(ListOfProducts.get(i).getText());
            expected.add(ListOfProducts.get(i).getText());
        }
        Collections.sort(expected);
        Collections.reverse(expected);
        Assert.assertEquals(actual,expected);
    }
}
