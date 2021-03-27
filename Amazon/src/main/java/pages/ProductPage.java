package pages;

import base.CommonAPI;
import org.openqa.selenium.By;

public class ProductPage extends CommonAPI {

    public By getAddToCartButton() {
        return addToCartButton;
    }

    By addToCartButton = By.cssSelector("input#add-to-cart-button.a-button-input");

    public void clickOnAddToCart(By locator){
        clickOnElement(locator);
    }
}
