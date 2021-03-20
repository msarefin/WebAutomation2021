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
        HomePage amazonSearch = PageFactory.initElements(driver,HomePage.class);
        WebElement [] deptList = new WebElement[amazonSearch.departmentList.size()];
        int c = 0;
        for(WebElement e : driver.findElements(By.cssSelector("select>option"))){
            deptList[c++] = e;
        }
        for (int i = 0; i < driver.findElements(By.cssSelector("select>option")).size(); i++) {
            amazonSearch.ClickOnDepartment(driver.findElement(By.cssSelector("select")));
            amazonSearch.SelectDepartment(deptList[i]);
            amazonSearch.EnterKeywordIntoSearchTextArea(amazonSearch.searchTextArea, "apple");
            amazonSearch.ClickOnSearchButton(amazonSearch.searchButton);
            amazonSearch.navigateToURL(url);
            c=0;
            for(WebElement e : driver.findElements(By.cssSelector("select>option"))){
                deptList[c++] = e;
            }


        }

    }
}
