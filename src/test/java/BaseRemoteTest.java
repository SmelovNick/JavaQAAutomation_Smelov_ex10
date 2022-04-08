import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class BaseRemoteTest {
    private WebDriver driver;

    @BeforeEach
    void setup() throws MalformedURLException {
        ChromeOptions options = new ChromeOptions(); //для селениум 4
        //DesiredCapabilities abilities = DesiredCapabilities.chrome(); //для селениум 3
        driver = new RemoteWebDriver(new URL("http://172.25.32.1:4444"), options);
    }

    @Test
    void testTest(){
        driver.navigate().to("http://saucedemo.com");
        driver.findElement(By.id("user-name")).clear();
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.name("password")).clear();
        driver.findElement(By.name("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
        assertTrue(driver.findElement(By.id("inventory_container")).isDisplayed());
    }

    @AfterEach
    void teardown(){
        driver.quit();
    }
}
