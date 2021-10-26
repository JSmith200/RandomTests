package SwagLabs;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class SwagSettings {

    public ChromeDriver driver;

    @Before
    public void setUp() {
        System.out.println("test start");
        System.setProperty("webdriver.chrome.driver", "/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com");
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
    }
    @After
    public void close() {
        driver.quit();
        System.out.println("test close");
    }
}