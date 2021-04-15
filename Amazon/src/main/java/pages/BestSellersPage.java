package pages;

import base.CommonAPI;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

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
        clickOnElement(locator);
    }

    public void clickOnProductUnderCategory(String locator) {
        clickOnElement(By.xpath(locator));
    }

}
