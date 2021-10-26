package SwagLabs;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class SwagLabsSortingByTest extends SwagSettings {

    @Test
    public void sortingBy() {
        WebElement body = driver.findElement(By.tagName("body"));
        body.findElement(By.id("login-button")).click();
        body.findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/div[2]/span/select/option[3]")).click();
        String sortingBy = body.findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/div[2]/span/span")).getText();

        Assert.assertEquals("PRICE (LOW TO HIGH)", sortingBy);
    }
}