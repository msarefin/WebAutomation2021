package pages;

import base.CommonAPI;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.By;

public class BestSellersPage extends CommonAPI {
    By bestseller = By.xpath("//a[text()='Best Sellers']");
    By category = By.xpath("//div[@class='p13n-sc-truncate-desktop-type2 p13n-sc-truncated']");
    public By getCategory() {
        return category;
    }

    public By getBestseller() {
        return bestseller;
    }

    public void clickOnBestSeller(By locator) {
        test.log(LogStatus.INFO, convertToString(new Object(){}.getClass().getEnclosingMethod().getName()));
        clickOnElement(locator);
    }

    public void clickOnProductUnderCategory(String locator) {
        test.log(LogStatus.INFO, convertToString(new Object(){}.getClass().getEnclosingMethod().getName()));
        clickOnElement(By.xpath(locator));
    }

}
