package search;

import base.CommonAPI;
import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.HomePage;

import javax.sound.midi.ShortMessage;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class AmazonSearch extends CommonAPI {
    HomePage amazonSearch = new HomePage();

    @DataProvider(name = "SearchEveryDepartmentWithKeyword")
    public Object[][] KeywordSearchByDepRtment() {
        return amazonSearch.depratmentListAndKeyword(amazonSearch.getSingleDepartment());
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
        return amazonSearch.departmentList(amazonSearch.getSingleDepartment());
    }


    @Test(dataProvider = "SearchEveryDepartment")
    public void AmazonSearchByDepartmentNoKeyword(String xpath){
        Reporter.log("Test performed on Department "+xpath);
        amazonSearch.clickOnDepartmentButton(amazonSearch.getDepartmentSelectionButton());
        amazonSearch.chooseADepartment(By.xpath(xpath));
        amazonSearch.clickOnSearchButton(amazonSearch.getSearchButton());
    }

}
