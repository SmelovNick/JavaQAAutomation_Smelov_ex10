package pages;

import config.Config;
import extensions.Driver;
import extensions.Element;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage{

    private Element usernameInput = new Element(How.XPATH, "//input[contains(@class, 'form_input') and @data-test='username']");
    private Element passwordInput = new Element(How.XPATH, "//input[contains(@class, 'form_input') and @data-test='password']");
    private Element submitButton = new Element(How.XPATH, "//input[contains(@class, 'submit-button')]");


    public LoginPage(){
        URL += "";
    }


    public LoginPage open(){
        Driver.get().navigate().to(URL);
        return this;
    }

    @Step("Fill username input with value {s}")
    public LoginPage fillUsernameInput(String s){
        usernameInput.sendKeys(s);
        return this;
    }

    @Step("Fill password input with value {0}")
    public LoginPage fillPasswordInput(String s){
        passwordInput.sendKeys(s);
        return this;
    }

    @Step("Click login button")
    public InventoryListPage clickLoginButton(){
        submitButton.click();
        return new InventoryListPage();
    }

    public InventoryListPage loginUser(String username, String password) {
        return fillUsernameInput(username)
                .fillPasswordInput(password)
                .clickLoginButton();
    }
}
