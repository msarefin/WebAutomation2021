package pages;

import base.CommonAPI;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

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
        Actions ac = new Actions(driver);
        ac.moveToElement(singleElement(locator)).click().build().perform();
    }

    static Object[][] arr;

    public static String[][] depratmentListAndKeyword(By locator) {
        driver.findElement(By.cssSelector("select")).click();
        List<WebElement> departments = driver.findElements(locator);
        String[][] dept = new String[departments.size()][2];
        for (int i = 0; i < dept.length; i++) {
            dept[i][0] = "apple";
            dept[i][1] = ("//*[contains(text(),'" + departments.get(i).getText().trim() + "')]");
        }
        return dept;
    }
    public static String[] departmentList(By locator){
        driver.findElement(By.cssSelector("Select")).click();
        List<WebElement> departments = driver.findElements(locator);
        String [] dept = new String[departments.size()];
        for(int i = 0; i< dept.length; i++){
            dept[i] = ("//*[contains(text(),'" + departments.get(i).getText().trim() + "')]");
        }
        return dept;
    }

    public void chooseADepartment(By locator) {
        driver.findElement(locator).click();
    }

    public void enterKeywordIntoSearchField(By locator, String keyword) {
        WebElement element = singleElement(locator);
        element.click();
        element.clear();
        element.sendKeys(keyword);

    }

    public void clickOnSearchButton(By locator) {
        singleElement(locator).click();
    }



}
