package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage{

    @FindBy(how = How.XPATH, using = "//input[contains(@class, 'form_input') and @data-test='username']")
    private WebElement usernameInput;
    //driver.findElement(By.xpath("//input[contains(@class, 'form_input') and @data-test='username']")).sendKeys("standard_user");

    @FindBy(how = How.XPATH, using = "//input[contains(@class, 'form_input') and @data-test='password']")
    private WebElement passwordInput;
    //driver.findElement(By.xpath("//input[contains(@class, 'form_input') and @data-test='password']")).sendKeys("secret_sauce");

    @FindBy(how = How.XPATH, using = "//input[contains(@class, 'submit-button')]")
    private WebElement submitButton;
    //driver.findElement(By.xpath("//input[contains(@class, 'submit-button')]")).click();

    public LoginPage(WebDriver driver){
        super(driver);
        URL += "";
        PageFactory.initElements(driver, this);
    }

    public void open(){
        driver.navigate().to(URL);
    }

    public void fillUsernameInput(String s){
        usernameInput.sendKeys(s);
    }

    public void fillPasswordInput(String s){
        passwordInput.sendKeys(s);
    }

    public void clickLoginButton(){
        submitButton.click();
    }
}
