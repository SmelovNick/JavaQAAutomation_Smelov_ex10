import config.Config;
import io.github.bonigarcia.wdm.WebDriverManager;
import models.users.UserCredentials;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import pages.Pages;

public class WebTests {
    UserCredentials user;
    private static boolean isConfigured=false;
    @BeforeAll
    static synchronized void globalSetup(){
        if(!isConfigured){
            WebDriverManager.chromedriver().setup();
            isConfigured = true;
        }
    }
    @BeforeEach
    void setup() {
        user = new UserCredentials();
        user.setUsername(Config.correctUsername);
        user.setPassword(Config.correctPassword);
        Pages.loginPage
                .open()
                .loginUser(user.getUsername(), user.getPassword());
    }
}
