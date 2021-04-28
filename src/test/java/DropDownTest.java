import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.assertTrue;

public class DropDownTest extends BaseTest {
    @Test
    public void dropdownTests() {
        driver.get("http://the-internet.herokuapp.com/dropdown");
        WebElement dropdown = driver.findElement(By.id("dropdown"));
        Select select = new Select(dropdown);
        List<WebElement> allOptions = select.getOptions();
        for (int i = 1; i < allOptions.size(); i++) {
            String textDrop = allOptions.get(i).getText();
            String option = "Option " + i;
            boolean compare;
            compare = textDrop.equals(option);
            assertTrue(compare, "Elem doesn't exist");
        }
        allOptions.get(1).click();
        assertTrue(allOptions.get(1).isSelected(), "Option 1 is not selected");
        allOptions.get(2).click();
        assertTrue(allOptions.get(2).isSelected(), "Option 2 is not selected");
    }
}
