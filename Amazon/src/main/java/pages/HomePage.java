package pages;

import base.CommonAPI;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class HomePage extends CommonAPI {
    public List<WebElement> departmentList = ListOfWebElements("cssSelector", "select.nav-search-dropdown>option");
    public WebElement searchTextArea = singleElement("cssSelector", "input#twotabsearchtextbox.nav-input.nav-progressive-attribute");
    public WebElement searchButton = singleElement("cssSelector", "input#nav-search-submit-button.nav-input.nav-progressive-attribute");

    public void ClickOnDepartment(WebElement dept) {
        dept.click();
    }

    public void ClickOnSearchTextArea(WebElement searchTextArea) {
        searchTextArea.click();
    }

    public void EnterKeywordIntoSearchTextArea(WebElement searchbar, String keyword) {
        searchbar.sendKeys(keyword);
    }

    public void ClickOnSearchButton(WebElement searchButton) {
        searchButton.click();
    }

}
