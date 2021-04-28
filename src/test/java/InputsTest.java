import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class InputsTest extends BaseTest{
    @Test
    public void inputShouldAcceptArrowUp() {
        driver.get("http://the-internet.herokuapp.com/inputs");
        WebElement input = driver.findElement(By.tagName("input"));
        input.sendKeys(Keys.ARROW_UP);
        String inputValue = input.getAttribute("value");
        assertEquals(inputValue, "1", "Arrow up doesn't work");
        input.sendKeys(Keys.ARROW_UP);
        input.sendKeys(Keys.ARROW_UP);
        input.sendKeys(Keys.ARROW_UP);
        input.sendKeys(Keys.ARROW_UP);
        String inputValue2 = input.getAttribute("value");
        assertEquals(inputValue2, "5", "Arrow up doesn't work");
        input.clear();
        input.sendKeys("123");
        input.sendKeys(Keys.ARROW_UP);
        String inputValue3 = input.getAttribute("value");
        assertEquals(inputValue3, "124", "Arrow up doesn't work");
    }
    @Test
    public void inputShouldAcceptArrowDown() {
        driver.get("http://the-internet.herokuapp.com/inputs");
        WebElement input = driver.findElement(By.tagName("input"));
        input.sendKeys(Keys.ARROW_DOWN);
        String inputValue = input.getAttribute("value");
        assertEquals(inputValue, "-1", "Arrow up doesn't work");
        input.sendKeys(Keys.ARROW_DOWN);
        input.sendKeys(Keys.ARROW_DOWN);
        input.sendKeys(Keys.ARROW_DOWN);
        String inputValue2 = input.getAttribute("value");
        assertEquals(inputValue2, "-4", "Arrow up doesn't work");
        input.clear();
        input.sendKeys("124");
        input.sendKeys(Keys.ARROW_DOWN);
        String inputValue3 = input.getAttribute("value");
        assertEquals(inputValue3, "123", "Arrow up doesn't work");
    }
    @Test
    public void canInputOrNotContainLetters() {
        driver.get("http://the-internet.herokuapp.com/inputs");
        WebElement input = driver.findElement(By.tagName("input"));
        String letters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        for (String i: letters.split("")){
            input.sendKeys(i);
            String inputValue = input.getAttribute("value");
            input.clear();
        }
    }
    @Test
    public void canInputOrNotContainSymbols() {
        driver.get("http://the-internet.herokuapp.com/inputs");
        WebElement input = driver.findElement(By.tagName("input"));
        String letters = "~!@#$%^&*()_+=-{}|][;:'/?*-.,";
        for (String i: letters.split("")){
            input.sendKeys(i);
            String inputValue = input.getAttribute("value");
            
            input.clear();
        }
    }
}
