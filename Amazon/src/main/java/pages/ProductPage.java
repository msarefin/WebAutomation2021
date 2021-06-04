package pages;

import base.CommonAPI;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.By;

public class ProductPage extends CommonAPI {

    public By getAddToCartButton() {
        return addToCartButton;
    }

    By addToCartButton = By.cssSelector("input#add-to-cart-button.a-button-input");

    public void clickOnAddToCart(By locator){
        test.log(LogStatus.INFO, convertToString(new Object(){}.getClass().getEnclosingMethod().getName()));
        clickOnElement(locator);
    }
}
