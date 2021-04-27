import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;


public class LogInTest extends BaseTest {
    @Test
    public void logIn() {
        driver.get("http://the-internet.herokuapp.com/login");
        WebElement userName = driver.findElement(By.id("username"));
        userName.sendKeys("tomsmith");
        assertEquals(userName.getAttribute("value"), "tomsmith", "username are not equals");
        driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");
        userName.submit();

        String massage = driver.findElement(By.id("flash")).getText();
        assertEquals(massage, "You logged into a secure area!\n"+"×", "no login");

    }
}
