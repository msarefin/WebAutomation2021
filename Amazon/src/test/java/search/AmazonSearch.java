package search;

import base.CommonAPI;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.HomePage;

import javax.sound.midi.ShortMessage;
import java.util.ArrayList;
import java.util.List;

public class AmazonSearch extends CommonAPI {
    @Parameters({"url", "keyword"})
    @Test()
    public void AmazonSearchByDepartment(@Optional("https://www.amazon.com/") String url, @Optional("apple") String Keyword) {
        HomePage amazonSearch = new HomePage();
        List<String> deptList = new ArrayList<>();

        for (WebElement e: amazonSearch.departmentList){
            amazonSearch.ClickOnDepartment(amazonSearch.department);
            amazonSearch.SelectDepartment(e);
            System.out.println(e.getText().trim());
            amazonSearch.EnterKeywordIntoSearchTextArea(amazonSearch.searchTextArea, "apple");
            amazonSearch.ClickOnSearchButton(amazonSearch.searchButton);
            
        }




    }
}
