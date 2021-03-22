package pages;

import base.CommonAPI;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;


public class HomePage extends CommonAPI {

    By departmentSelectionButton = By.cssSelector("select");
    By singleDepartment = By.cssSelector("select>option");
    By searchTextBox = By.cssSelector("input#twotabsearchtextbox.nav-input.nav-progressive-attribute");
    By searchButton = By.cssSelector("input#nav-search-submit-button.nav-input.nav-progressive-attribute");


    public By getDepartmentSelectionButton() {
        return departmentSelectionButton;
    }

    public By getSingleDepartment() {
        return singleDepartment;
    }

    public By getSearchTextBox() {
        return searchTextBox;
    }

    public By getSearchButton() {
        return searchButton;
    }


    public void clickOnDepartmentButton(By locator) {
        singleElement(locator).click();
    }

    public void chooseADepartment(By locator) {
        List<WebElement> departmentsList = listOfWebElements(locator);
        int n = 0;
        while (n < departmentsList.size()) {
            departmentsList.get(n).click();
            n++;
        }
    }

    public void enterKeywordIntoSearchField(By locator, String keyword) {
        WebElement element  = singleElement(locator);
        element.click();
        element.sendKeys(keyword);

    }

    public void clickOnSearchButton(By locator) {
        singleElement(locator).click();
    }

}
