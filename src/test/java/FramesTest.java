import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class FramesTest extends BaseTest {
    @Test
    public void iframeTest() {
        driver.get("http://the-internet.herokuapp.com/iframe");
        WebElement frame = driver.findElement(By.id("mce_0_ifr"));
        driver.switchTo().frame(frame);
        assertEquals(driver.findElement(By.cssSelector(".mce-content-body  > p")).getText(), "Your content goes here.",
                "Text doesn't equals");
    }
}
