import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class TestCase5 {

    @Test
    public void testCase5(){

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://demoqa.com/select-menu");

        WebElement selectValueInput = driver.findElement(By.id("react-select-2-input"));
        selectValueInput.sendKeys("Group 2, option 1", Keys.ENTER);

        WebElement selectOneInput = driver.findElement(By.id("react-select-3-input"));
        selectOneInput.sendKeys("Prof.", Keys.ENTER);

        List<WebElement> values = driver.findElements(By.xpath("//div[@class=' css-1uccc91-singleValue']"));
        for(WebElement value : values){
            Assert.assertTrue(value.getText().equals("Group 2, option 1")||value.getText().equals("Prof."));
        }
    }
}
