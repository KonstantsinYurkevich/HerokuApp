import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public abstract class BaseTest {
    WebDriver driver;
    WebDriverWait waitLoad;

    @BeforeMethod
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox");
        options.addArguments("--start-maximized");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        waitLoad = new WebDriverWait(driver, 5);
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        driver.quit();
    }

    public boolean isCheckboxIsDisplayed() {
        boolean checkboxIsDisplayed;
        try {
            driver.findElement(By.cssSelector("[type='checkbox']")).isDisplayed();
            checkboxIsDisplayed = true;
        } catch (NoSuchElementException exception) {
            checkboxIsDisplayed = false;
        }
        return checkboxIsDisplayed;
    }

    public boolean InputEnabled() {

        return driver.findElement(By.cssSelector("#input-example > input")).isEnabled();
    }

}
