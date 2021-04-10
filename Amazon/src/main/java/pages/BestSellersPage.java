package pages;

import base.CommonAPI;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class BestSellersPage extends CommonAPI {
    By bestseller = By.xpath("//a[text()='Best Sellers']");
    By category = By.cssSelector(".a-section.a-spacing-mini");
    public By getCategory() {
        return category;
    }

    public By getBestseller() {
        return bestseller;
    }

    public void clickOnBestSeller(By locator) {
        clickOnElement(locator);
    }

    public void clickOnProductUnderCategory(By locator) {
        clickOnElement(locator);
    }

}
