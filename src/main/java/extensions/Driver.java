package extensions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Driver {

    private static WebDriver driver;

    public static WebDriver get(){
        if (driver==null){
            init();
        }
        return driver;
    }

    public static void init(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    public static void quit() {
        if(driver !=null){
            driver.quit();
            driver = null;
        }
    }
}
