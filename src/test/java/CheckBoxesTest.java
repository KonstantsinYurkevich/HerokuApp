import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class CheckBoxesTest extends BaseTest {
    @Test
    public void checkAndUncheckCheckboxes() {
        driver.get("http://the-internet.herokuapp.com/checkboxes");
        List<WebElement> elem;
        elem = driver.findElements(By.cssSelector(("[type=checkbox]")));
        assertFalse(elem.get(0).isSelected(), "first checkbox checked");
        elem.get(0).click();
        assertTrue(elem.get(0).isSelected(), "first checkbox wasn't checked");
        assertTrue(elem.get(1).isSelected(), "Second checkbox unchecked");
        elem.get(1).click();
        assertFalse(elem.get(1).isSelected(), "Second checkbox wasn't unchecked");
    }

}
