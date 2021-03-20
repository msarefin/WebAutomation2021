package pages;

import base.CommonAPI;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class HomePage extends CommonAPI {

    @FindBy(how = How.CSS, using = "select")
    public WebElement department;
    @FindBy(how = How.CSS, using = "select>option")
    public List<WebElement> departmentList;
    @FindBy(how = How.CSS, using = "input#twotabsearchtextbox.nav-input.nav-progressive-attribute")
    public WebElement searchTextArea;
    @FindBy(how = How.CSS, using = "input#nav-search-submit-button.nav-input.nav-progressive-attribute")
    public WebElement searchButton ;

    public void navigateToURL(String url) {
        driver.manage().deleteAllCookies();
        driver.get(url);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    public void ClickOnDepartment(WebElement department) {
        Actions ac = new Actions(driver);
        ac.moveToElement(department).click().build().perform();
    }

    public void SelectDepartment(WebElement dept) {
        System.out.println(dept.getText());
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
