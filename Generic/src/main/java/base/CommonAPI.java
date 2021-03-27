package base;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.*;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class CommonAPI {

    public static WebDriver driver;
    private static final String driverLocation = "../Generic/browser-driver/chromedriver.exe";


    public static void getLocalDriver() {
        System.setProperty("webdriver.chrome.driver", driverLocation);
        driver = new ChromeDriver();
    }

    public static void goBack(){
        driver.navigate().back();
    }

    @Parameters("url")
    @BeforeSuite
    public void setUp(@Optional("https://www.amazon.com/") String url) {
        getLocalDriver();
        driver.manage().deleteAllCookies();
        driver.get(url);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    public void clickOnElement(By locator){
        singleElement(locator).click();
    }

    public void selectFromSelectionList(WebElement element, String text) {
        Select select = new Select(element);
        select.selectByValue(text);
    }

    public static List<WebElement> listOfWebElements(By locator) {
        List<WebElement> elements = driver.findElements(locator);
        return elements;
    }

    public static List<WebElement> ListOfWebElements(String locatorType, String locator) {
        switch (locatorType) {
            case "id":
                return driver.findElements(By.id(locator));
            case "className":
                return driver.findElements(By.className(locator));
            case "cssSelector":
                return driver.findElements(By.cssSelector(locator));
            case "linkText":
                return driver.findElements(By.linkText(locator));
            case "partialLinkText":
                return driver.findElements(By.partialLinkText(locator));
            case "name":
                return driver.findElements(By.name(locator));
            case "tagName":
                return driver.findElements(By.tagName(locator));
            case "xpath":
                return driver.findElements(By.xpath(locator));
            default:
                throw new NoSuchElementException(locator);
        }
    }

    public static WebElement singleElement(By locator) {
        WebElement element = driver.findElement(locator);
        return element;
    }

    public static WebElement singleElement(String locatorType, String locator) {
        switch (locatorType) {
            case "id":
                return driver.findElement(By.id(locator));
            case "className":
                return driver.findElement(By.className(locator));
            case "cssSelector":
                return driver.findElement(By.cssSelector(locator));
            case "linkText":
                return driver.findElement(By.linkText(locator));
            case "partialLinkText":
                return driver.findElement(By.partialLinkText(locator));
            case "name":
                return driver.findElement(By.name(locator));
            case "tagName":
                return driver.findElement(By.tagName(locator));
            case "xpath":
                return driver.findElement(By.xpath(locator));
            default:
                throw new NoSuchElementException(locator);
        }
    }

    public static String[] ElementList(By locator){
        driver.findElement(By.cssSelector("Select")).click();
        List<WebElement> departments = driver.findElements(locator);
        String [] dept = new String[departments.size()];
        for(int i = 0; i< dept.length; i++){
            dept[i] = ("//*[contains(text(),'" + departments.get(i).getText().trim() + "')]");
        }
        return dept;
    }

    public static String[][] ElementList(By locator, String keyword) {
        driver.findElement(By.cssSelector("select")).click();
        List<WebElement> departments = driver.findElements(locator);
        String[][] dept = new String[departments.size()][2];
        for (int i = 0; i < dept.length; i++) {
            dept[i][0] = keyword;
            dept[i][1] = ("//*[contains(text(),'" + departments.get(i).getText().trim() + "')]");
        }
        return dept;
    }
    
    @Parameters({"url"})
    @AfterMethod
    public void navigateBackToHomePage(@Optional("https://www.amazon.com/") String url ){
        driver.navigate().to(url);
    }

    @AfterSuite
    public void teardown() {
        driver.manage().deleteAllCookies();
        driver.close();
        driver.quit();
    }
}
