package pages;

import base.CommonAPI;
import org.openqa.selenium.By;

public class BestSellersPage extends CommonAPI {
    By bestseller = By.xpath("//a[text()='Best Sellers']");
    By category = By.xpath("//div[@id='zg_left_col1']//div/h3");

    public By getBestseller() {
        return bestseller;
    }

    public void clickOnBestSeller(By locator){
        driver.findElement(locator).click();
    }

}
