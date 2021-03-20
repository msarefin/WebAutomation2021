package pages;

import base.CommonAPI;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class HomePage extends CommonAPI {
    public WebElement department = singleElement("cssSelector", "select.nav-search-dropdown");
    public List<WebElement> departmentList = ListOfWebElements("cssSelector", "select.nav-search-dropdown>option");
    public WebElement searchTextArea = singleElement("cssSelector", "input#twotabsearchtextbox.nav-input.nav-progressive-attribute");
    public WebElement searchButton = singleElement("cssSelector", "input#nav-search-submit-button.nav-input.nav-progressive-attribute");

    public void navigateToURL(String url) {
        driver.get(url);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    public void ClickOnDepartment(WebElement department) {
        Actions ac = new Actions(driver);
        ac.moveToElement(department).click().build().perform();
    }

    public void SelectDepartment(WebElement dept){
       dept.click();
    }

    public void EnterKeywordIntoSearchTextArea(WebElement searchbar, String keyword) {
        searchbar.click();
        searchbar.clear();
        searchbar.sendKeys(keyword);
    }

    public void ClickOnSearchButton(WebElement searchButton) {
        searchButton.click();
    }

}
