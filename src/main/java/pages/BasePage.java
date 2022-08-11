package pages;

import extensions.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BasePage {
    protected String URL = "https://saucedemo.com";

    BasePage(){
        PageFactory.initElements(Driver.get(), this);
    }
}
