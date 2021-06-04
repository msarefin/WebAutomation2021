package base;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.File;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class CommonAPI {

    public static WebDriver driver;
    private static final String driverLocation = "../Generic/browser-driver/ChromeDriver/chromedriver.exe";

    public static ExtentReports extent;
    public static ExtentTest test;

    public static void getLocalDriver() {
        System.setProperty("webdriver.chrome.driver", driverLocation);
        ChromeOptions options = new ChromeOptions();

        driver = new ChromeDriver();
    }

    public static void goBack(){
        driver.navigate().back();
    }

    public void goToURL(String url){
        test.log(LogStatus.INFO, convertToString(new Object(){}.getClass().getEnclosingMethod().getName())+" : "+url);
        driver.navigate().to(url);
    }

    @Parameters("url")
    @BeforeClass
    public void setUp(@Optional("https://www.amazon.com/") String url) {
        getLocalDriver();
        driver.manage().deleteAllCookies();
        driver.get(url);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @BeforeTest
    public void Reports(){
        extent = new ExtentReports(System.getProperty("user.dir")+"/Reports/ExtentReports/ExtentReport.html",true);
        extent.addSystemInfo("Host Name", "Local Host");
        extent.addSystemInfo("Environment", "QA");
        extent.addSystemInfo("User Name","Arefin");
        extent.loadConfig(new File(System.getProperty("user.dir")+"/extent-config.xml"));

    }

    @BeforeMethod
    public void extentReportStart(){
        test = extent.startTest("Shopping from BestSellers");
        test.assignCategory("Functional Testing");

        test.assignAuthor("MSA", "Sunny");
    }

    @Parameters({"url"})
    @AfterMethod
    public void navigateBackToHomePage(@Optional("https://www.amazon.com/") String url, ITestResult result){
        if (result.getStatus() == ITestResult.FAILURE) {
            test.log(LogStatus.FAIL, "Test was Failed!!"+result.getThrowable());
        } else if (result.getStatus() == ITestResult.SKIP) {
            test.log(LogStatus.SKIP, "Test was Skipped " + result.getThrowable());
        } else {
            test.log(LogStatus.PASS, "Test Passed!!");
        }
        driver.navigate().to(url);

    }

    @AfterTest
    public void closeExt(){
        extent.flush();

    }

    @AfterSuite
    public void teardown() {
        driver.manage().deleteAllCookies();
        driver.close();
        driver.quit();
    //        extent.close();
    }

    public String convertToString(String st){
        String splitString= null;
        splitString = StringUtils.join(StringUtils.splitByCharacterTypeCamelCase(st),' ');
        return splitString;
    }

    public void clickOnElement(By locator){
        singleElement(locator).click();

    }

    public void clickOnElement(WebElement locator){
        locator.click();
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

    public static String[] ElementListContainsTextXpath(By locator){
       List<WebElement> departments = driver.findElements(locator);
        String [] dept = new String[departments.size()];
        for(int i = 0; i< dept.length; i++){
            dept[i] = departments.get(i).getText();
        }
        return dept;
    }

    public static String[] ElementListXpath(By locator){
        List<WebElement> departments = driver.findElements(locator);
        String [] dept = new String[departments.size()];
        for(int i = 0; i< dept.length; i++){
            dept[i] = ("//*[contains(text(),'" + departments.get(i).getText().trim() + "')]");
        }
        return dept;
    }

    public static String[][] ElementListContainsTextXpath(By locator, String keyword) {
        List<WebElement> departments = driver.findElements(locator);
        String[][] dept = new String[departments.size()][2];
        for (int i = 0; i < dept.length; i++) {
            dept[i][0] = keyword;
            dept[i][1] = ("//*[contains(text(),'" + departments.get(i).getText().trim() + "')]");
        }
        return dept;
    }
    

}
