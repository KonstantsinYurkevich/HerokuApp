import org.openqa.selenium.By;
import org.testng.annotations.Test;

import java.io.File;

public class UploadTest extends BaseTest{
    @Test
    public void uploadFile() {
        driver.get("http://the-internet.herokuapp.com/upload");
        File file = new File("src/test/resources/test.txt");
        driver.findElement(By.id("file-upload")).sendKeys(file.getAbsolutePath());
        driver.findElement(By.id("file-submit")).click();
    }
}
