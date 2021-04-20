package search;

import base.CommonAPI;
import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.BestSellersPage;
import pages.ProductPage;

public class BestSellers extends CommonAPI {
    BestSellersPage bestSellersPage = new BestSellersPage();
    ProductPage productPage = new ProductPage();

    @DataProvider(name = "ProductUnderCategries")
    public Object[] productUnderCategroy() {
        bestSellersPage.clickOnBestSeller(bestSellersPage.getBestseller());
        return bestSellersPage.ElementListXpath(bestSellersPage.getCategory());
    }


    @Test(dataProvider = "ProductUnderCategries")
    public void shoppingFromBestSellers(String products) {
        extentTest = extentReports.startTest("Best Seller");
        String url = driver.getCurrentUrl();
        bestSellersPage.clickOnBestSeller(bestSellersPage.getBestseller());
        bestSellersPage.clickOnProductUnderCategory(products);
        productPage.clickOnAddToCart(productPage.getAddToCartButton());
        productPage.goToURL(url);
    }
}
