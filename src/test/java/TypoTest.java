import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;


public class TypoTest extends BaseTest {
    @Test
    public void typoSpellcheckingTest() {
        driver.get("http://the-internet.herokuapp.com/typos");
        String textFromPage = driver.findElement(By.xpath("(((//div[2])//div[1])//div[1])//p[2]")).getText();
        Assert.assertEquals(textFromPage, "Sometimes you'll see a typo, other times you won't.",
                "In text mistake");
    }
}
