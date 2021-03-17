package search;

import base.CommonAPI;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.HomePage;

public class AmazonSearch extends CommonAPI {
    HomePage AmazonHomePage = new HomePage();

    @Parameters ("keyword")
    @Test()
    public void AmazonSearchByDepartment(@Optional("apple")String Keyword){
        for(WebElement dept :AmazonHomePage.departmentList){
            AmazonHomePage.ClickOnDepartment(dept);
            AmazonHomePage.ClickOnSearchTextArea(AmazonHomePage.searchTextArea);
            AmazonHomePage.EnterKeywordIntoSearchTextArea(AmazonHomePage.searchTextArea, Keyword);
            AmazonHomePage.ClickOnSearchButton(AmazonHomePage.searchButton);
        }
    }
}
