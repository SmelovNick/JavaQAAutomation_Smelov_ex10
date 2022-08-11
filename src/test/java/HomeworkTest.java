import config.Config;
import extensions.Driver;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import models.users.UserCredentials;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pages.InventoryListPage;
import pages.Pages;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

//Продолжаем тестировать saucedemo.com
//Придумать и запрограммировать 5 различных тест-кейсов
//Использовать поиск элементов по локаторам CSS или Xpath (можно и те и другие), не допускается использование методов By.id() или By.name()
@Epic("New user role")
@Feature("Login")
@Story("Correct login")
public class HomeworkTest extends WebTests{

    @Test
    void loginTest(){
        InventoryListPage inventoryListPage = new InventoryListPage();
        boolean isInventoryContainerDisplayed = inventoryListPage.isInventoryContainerDisplayed();
        assertTrue(isInventoryContainerDisplayed, "Не найден элемент subheader");
    }

    @Test
    void allItemsMustHaveAddToCartButtonTest(){
        InventoryListPage inventoryListPage = new InventoryListPage();
        int itemsCount = inventoryListPage.getInventoryItemCount();
        int buttonsCount = inventoryListPage.getAddToCartButtonCount();
        assertEquals(itemsCount, buttonsCount, "Number of AddToCart button doesn't equal to Number of items");
    }

//    @Test
//    void addItemToCartTest(){
//        InventoryListPage inventoryListPage = new InventoryListPage();
//        inventoryListPage.clickOnFirstAddToCartButton();
//        WebElement removeButton = inventoryListPage.removeButtonForFirstItem();
//        WebElement addedItem = inventoryListPage.shoppingCartLink();
//        assertTrue(removeButton!=null && addedItem !=null);
//    }
//
//    @Test
//    void openBurgerMenuTest(){
//
//        driver.findElement(By.xpath("//div[@class='primary_header']//div[@class='bm-burger-button']/button[@id='react-burger-menu-btn']")).click();
//        String burgerMenuAttribute = driver.findElement(By.xpath("//div[@class='primary_header']//div[@class='bm-menu-wrap']")).getAttribute("aria-hidden");
//        assertTrue(burgerMenuAttribute.equals("false"));
//    }

//    @Test
//    void itemAddedToCartListTest(){
//        driver.findElements(By.xpath("//div[@class='inventory_item']//button[starts-with(@data-test, 'add-to-cart-')]")).get(0).click();
//        driver.findElement(By.xpath("//div[@class='shopping_cart_container']/a[@class='shopping_cart_link']")).click();
//        List<WebElement> cartItems = driver.findElement(By.xpath("//div[@class='cart_list']")).findElements(By.xpath("//div[@class='cart_item']"));
//        assertTrue(cartItems.size()>0);
//    }

    @AfterEach
    void teardown(){
        Driver.quit();
    }
}
