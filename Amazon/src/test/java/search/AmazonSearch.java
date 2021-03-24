package search;

import base.CommonAPI;
import org.openqa.selenium.*;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Optional;
import org.testng.annotations.Test;
import pages.HomePage;

public class AmazonSearch extends CommonAPI {
    HomePage amazonSearch = new HomePage();

    @DataProvider(name = "SearchEveryDepartmentWithKeyword")
    public Object[][] KeywordSearchByDepRtment() {
        return amazonSearch.ElementList(amazonSearch.getSingleDepartment(), "apple");
    }

    @Test(dataProvider = "SearchEveryDepartmentWithKeyword")
    public void AmazonKeywordSearchByDepartment(@Optional("apple") String Keyword, String xpath) {
        Reporter.log("Test performed on Department "+xpath);
        amazonSearch.clickOnDepartmentButton(amazonSearch.getDepartmentSelectionButton());
        amazonSearch.chooseADepartment(By.xpath(xpath));
        amazonSearch.enterKeywordIntoSearchField(amazonSearch.getSearchTextBox(), "apple");
        amazonSearch.clickOnSearchButton(amazonSearch.getSearchButton());
    }

    @DataProvider(name = "SearchEveryDepartment")
    public Object[] SearchByDepartmentOnly(){
        return amazonSearch.ElementList(amazonSearch.getSingleDepartment());
    }


    @Test(dataProvider = "SearchEveryDepartment")
    public void AmazonSearchByDepartmentNoKeyword(String xpath){
        Reporter.log("Test performed on Department "+xpath);
        amazonSearch.clickOnDepartmentButton(amazonSearch.getDepartmentSelectionButton());
        amazonSearch.chooseADepartment(By.xpath(xpath));
        amazonSearch.clickOnSearchButton(amazonSearch.getSearchButton());
    }

}
