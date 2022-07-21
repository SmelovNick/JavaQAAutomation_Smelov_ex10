import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.InventoryListPage;
import pages.LoginPage;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

//Продолжаем тестировать saucedemo.com
//Придумать и запрограммировать 5 различных тест-кейсов
//Использовать поиск элементов по локаторам CSS или Xpath (можно и те и другие), не допускается использование методов By.id() или By.name()

public class HomeworkTest extends WebTests{
    private WebDriver driver;

    @BeforeEach
    void setup() {
        driver = new ChromeDriver();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.open();
        loginPage.loginUser("standard_user", "secret_sauce");

//        driver.navigate().to("http://saucedemo.com");
//        driver.findElement(By.xpath("//input[contains(@class, 'form_input') and @data-test='username']")).clear();
//        driver.findElement(By.xpath("//input[contains(@class, 'form_input') and @data-test='username']")).sendKeys("standard_user");
//        driver.findElement(By.xpath("//input[contains(@class, 'form_input') and @data-test='password']")).clear();
//        driver.findElement(By.xpath("//input[contains(@class, 'form_input') and @data-test='password']")).sendKeys("secret_sauce");
//        driver.findElement(By.xpath("//input[contains(@class, 'submit-button')]")).click();
    }

    @Test
    void loginTest(){
        assertTrue(driver.findElement(By.xpath("//div[@id='inventory_container']")).isDisplayed(), "Не найден элемент subheader");
    }

    @Test
    void allItemsMustHaveAddToCartButtonTest(){
        InventoryListPage inventoryListPage = new InventoryListPage(driver);
        int itemsCount = inventoryListPage.getInventoryItemCount();
        int buttonsCount = driver.findElements(By.xpath("//div[@class='inventory_item']//button[starts-with(@data-test, 'add-to-cart-')]")).size();
        assertEquals(itemsCount, buttonsCount, "Number of AddToCart button doesn't equal to Number of items");
    }

    @Test
    void addItemToCartTest(){
        driver.findElements(By.xpath("//div[@class='inventory_item']//button[starts-with(@data-test, 'add-to-cart-')]")).get(0).click();
        WebElement removeButton = driver.findElements(By.xpath("//div[@class='inventory_item']")).get(0).findElement(By.xpath("//button[starts-with(@data-test, 'add-to-cart-')]"));
        WebElement addedItem = driver.findElement(By.xpath("//div[@class='shopping_cart_container']/a[@class='shopping_cart_link']"));
        assertTrue(removeButton!=null && addedItem !=null);
    }

    @Test
    void openBurgerMenuTest(){
        driver.findElement(By.xpath("//div[@class='primary_header']//div[@class='bm-burger-button']/button[@id='react-burger-menu-btn']")).click();
        String burgerMenuAttribute = driver.findElement(By.xpath("//div[@class='primary_header']//div[@class='bm-menu-wrap']")).getAttribute("aria-hidden");
        assertTrue(burgerMenuAttribute.equals("false"));
    }

    @Test
    void itemAddedToCartListTest(){
        driver.findElements(By.xpath("//div[@class='inventory_item']//button[starts-with(@data-test, 'add-to-cart-')]")).get(0).click();
        driver.findElement(By.xpath("//div[@class='shopping_cart_container']/a[@class='shopping_cart_link']")).click();
        List<WebElement> cartItems = driver.findElement(By.xpath("//div[@class='cart_list']")).findElements(By.xpath("//div[@class='cart_item']"));
        assertTrue(cartItems.size()>0);
    }

    @AfterEach
    void teardown(){
        driver.quit();
    }
}
