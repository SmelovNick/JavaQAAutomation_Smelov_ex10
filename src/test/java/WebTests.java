import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.BeforeAll;

public class WebTests {
    private static boolean isConfigured=false;
    @BeforeAll
    static synchronized void globalSetup(){
        if(!isConfigured){
            WebDriverManager.chromedriver().setup();
            isConfigured = true;
        }
    }
}
