import com.beust.ah.A;
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

public class TestCase2 {

    @Test

    public void TestCase2(){
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
        BrowserUtils.selectBy(dropBox,"lohi", "value");

        List<WebElement> ListOfProducts = driver.findElements(By.xpath("//div[@class='inventory_item_price']"));

        List<Integer> actual = new ArrayList<>();
        List<Integer> expected = new ArrayList<>();

        for(int i = 0; i < ListOfProducts.size(); i++){
            int temp = Integer.parseInt(ListOfProducts.get(i).getText().replace("$","").replace(".",""));
            actual.add(temp);
            expected.add(temp);
        }
        Collections.sort(expected);
        Assert.assertEquals(actual,expected);
    }
}
