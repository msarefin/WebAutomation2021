package base;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class CommonAPI {

    public WebDriver driver;

    @BeforeMethod
    public void setUp() {
        getLocalDriver();
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
    }

    public void getLocalDriver() {
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/browser-driver/chromedriver.exe");
        driver = new ChromeDriver();
    }

    public WebElement singleElement(String locatorType, String locator) {
        switch (locatorType) {
            case "id":
                return driver.findElement(By.id(locator));
            case "className":
                return driver.findElement(By.className(locator));
            default:
                throw new NoSuchElementException(locator);
        }
    }

    @AfterMethod
    public void teardown() {
        driver.manage().deleteAllCookies();
        driver.close();
    }
}
