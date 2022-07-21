package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class InventoryListPage extends BasePage{

    private WebDriver driver;

    @FindBy(how = How.XPATH, using = "//div[@class='primary_header']//div[@class='bm-burger-button']/button[@id='react-burger-menu-btn']")
    private WebElement burgerMenuButton;
    //driver.findElement(By.xpath("//div[@class='primary_header']//div[@class='bm-burger-button']/button[@id='react-burger-menu-btn']")).click();

    @FindBy(how = How.XPATH, using = "//div[contains(@class, 'inventory_list')]")
    private WebElement inventoryList;

    @FindBy(how = How.XPATH, using = "//div[@class='inventory_item']//button[starts-with(@data-test, 'add-to-cart-')]")
    private List<WebElement> addToCartButton;


    public InventoryListPage(WebDriver driver) {
        super(driver);
        URL += "/inventory.html";
        PageFactory.initElements(driver, this);
    }

    public void clickBurgerMenuButton(){
        burgerMenuButton.click();
    }

    private List<WebElement> getInventoryItems(){
        return inventoryList.findElements(By.xpath("./div[contains(@class, 'inventory_item')]"));
    }

    public int getAddToCartButtonCount(){
        return addToCartButton.size();
    }

    public int getInventoryItemCount() {
        return getInventoryItems().size();
    }
}
