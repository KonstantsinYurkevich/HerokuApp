import org.languagetool.JLanguageTool;
import org.languagetool.language.BritishEnglish;
import org.languagetool.rules.RuleMatch;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;


public class TypoTest extends BaseTest{
    @Test
    public void typoSpellcheckingTest() throws IOException {
        driver.get("http://the-internet.herokuapp.com/typos");
        JLanguageTool langTool =  new JLanguageTool(new BritishEnglish());
        String textFromPage = driver.findElement(By.xpath("(((//div[2])//div[1])//div[1])//p[2]")).getText();
        List<RuleMatch> matches = langTool.check(textFromPage);
        for (RuleMatch match : matches) {
            match.getFromPos();
            match.getToPos();
            match.getMessage();
            match.getSuggestedReplacements();
            String test = String.valueOf(match.getSuggestedReplacements());
            Assert.assertEquals(test, "", "There is mistake in text");
        }

    }
}
