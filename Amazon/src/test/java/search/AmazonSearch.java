package search;

import base.CommonAPI;
import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.HomePage;

import javax.sound.midi.ShortMessage;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class AmazonSearch extends CommonAPI {
    @Parameters({"url", "keyword"})
    @Test
    public void AmazonSearchByDepartment(@Optional("https://www.amazon.com/") String url, @Optional("apple") String Keyword) {
        HomePage amazonSearch = new HomePage();
        amazonSearch.clickOnDepartmentButton(amazonSearch.getDepartmentSelectionButton());
        amazonSearch.chooseADepartment(amazonSearch.getSingleDepartment());
        amazonSearch.enterKeywordIntoSearchField(amazonSearch.getSearchTextBox(), "apple");
        amazonSearch.clickOnSearchButton(amazonSearch.getSearchButton());
    }
}
