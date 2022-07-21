package pages;

import org.openqa.selenium.WebDriver;

public class BasePage {
    protected String URL = "https://saucedemo.com";
    protected WebDriver driver;

    BasePage(WebDriver driver){
        this.driver = driver;
    }
}
