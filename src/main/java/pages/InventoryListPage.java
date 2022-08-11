package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;

public class InventoryListPage extends BasePage{

    @FindBy(how = How.XPATH, using = "//div[@class='primary_header']//div[@class='bm-burger-button']/button[@id='react-burger-menu-btn']")
    private WebElement burgerMenuButton;
    //driver.findElement(By.xpath("//div[@class='primary_header']//div[@class='bm-burger-button']/button[@id='react-burger-menu-btn']")).click();

    @FindBy(how = How.XPATH, using = "//div[contains(@class, 'inventory_list')]")
    private WebElement inventoryList;

    @FindBy(how = How.XPATH, using = "//div[@id='inventory_container']")
    private WebElement inventoryContainer;

    @FindBy(how = How.XPATH, using = "//div[@class='shopping_cart_container']/a[@class='shopping_cart_link']")
    private WebElement shoppingCartLink;

    public InventoryListPage() {
        URL += "/inventory.html";
    }

    public void clickBurgerMenuButton(){
        burgerMenuButton.click();
    }

    private List<WebElement> getInventoryItems(){
        return inventoryList.findElements(By.xpath("./div[contains(@class, 'inventory_item')]"));
    }

    private List<WebElement> getAddToCartButtons(){
        return inventoryList.findElements(By.xpath("//div[@class='inventory_item']//button[starts-with(@data-test, 'add-to-cart-')]"));
    }

    public int getInventoryItemCount() {
        return getInventoryItems().size();
    }

    public int getAddToCartButtonCount(){
        return getAddToCartButtons().size();
    }

    public boolean isInventoryContainerDisplayed(){
        return inventoryList.isDisplayed();
    }

    public void clickOnFirstAddToCartButton(){
        getAddToCartButtons().get(0).click();
    }

    public WebElement removeButtonForFirstItem() {
        return getInventoryItems().get(0).findElement(By.xpath("//button[starts-with(@data-test, 'add-to-cart-')]"));
    }

    public WebElement shoppingCartLink(){
        return shoppingCartLink;
    }
}
