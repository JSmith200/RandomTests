package SwagLabs;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class SwagLabsCartCountTest extends SwagSettings {

    @Test
    public void cartCount() {
        WebElement body = driver.findElement(By.tagName("body"));
        body.findElement(By.id("login-button")).click();
        body.findElement(By.id("add-to-cart-test.allthethings()-t-shirt-(red)")).click();
        String cartCount = body.findElement(By.xpath("//*[@id=\"shopping_cart_container\"]/a/span")).getText();

        Assert.assertEquals("1", cartCount);
    }
}