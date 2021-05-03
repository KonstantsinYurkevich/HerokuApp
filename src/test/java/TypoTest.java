import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;


public class TypoTest extends BaseTest {
    @Test
    public void typoSpellcheckingTest() {
        driver.get("http://the-internet.herokuapp.com/typos");
        List<WebElement> allInputElements = driver.findElements(By.tagName("p"));
        String textFromPage = allInputElements.get(1).getText();
        Assert.assertEquals(textFromPage, "Sometimes you'll see a typo, other times you won't.",
                "In text mistake");
    }
}
