import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class HerokuAppTest {
    @Test
    public void test() {
        // WebDriver diver = new RemoteWebDriver(new URL("ip"), null);
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox");
        //options.addArguments("--headless"); без вэб интерфейса
        options.addArguments("--start-maximized");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        // driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS); (find elemet)
        driver.get("https://www.tut.by/");
        driver.close();
    }
}
