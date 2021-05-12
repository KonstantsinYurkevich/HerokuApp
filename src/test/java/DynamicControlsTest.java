import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class DynamicControlsTest extends BaseTest {
    @Test
    public void dynamicControls() {
        driver.get("http://the-internet.herokuapp.com/dynamic_controls");
        assertTrue(isCheckboxIsDisplayed(), "Checkbox doesn't exist");
        Actions actions = new Actions(driver);
        actions
                .click(driver.findElement(By.cssSelector("[type='checkbox']")))
                .click(driver.findElement(By.cssSelector("[onclick='swapCheckbox()']")))
                .build()
                .perform();
        assertEquals(waitLoad.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("p#message"))).
                getText(), "It's gone!", "It's gone doesn't find");
        assertFalse(isCheckboxIsDisplayed(), "Checkbox exists");
        assertFalse(InputEnabled(), "input enabled");
        actions
                .click(driver.findElement(By.cssSelector("[onclick='swapInput()']")))
                .build()
                .perform();
        assertEquals(waitLoad.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("p#message"))).
                getText(), "It's enabled!", "It's gone doesn't find");
        assertTrue(InputEnabled(), "input disabled");

    }
}
