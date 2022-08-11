package extensions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class Element {
    private By by;

    public Element(How how, String locator) {
        switch (how){
            case ID: this.by = By.id(locator); break;
            case NAME: this.by = By.name(locator); break;
            case CSS: this.by = By.cssSelector(locator); break;
            case XPATH: this.by = By.xpath(locator); break;
            default: this.by = By.linkText(locator); break;
        }
    }

    public void sendKeys(String s) {
        Driver.get().findElement(by).sendKeys(s);
    }

    public void click() {
        Driver.get().findElement(by).click();
    }

    public List<WebElement> findElements(By by){
        WebDriverWait wait = new WebDriverWait(Driver.get(), Duration.ofSeconds(10));
        return  wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(by));
    }

    public WebElement get(){
        WebDriverWait wait = new WebDriverWait(Driver.get(), Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }
}
