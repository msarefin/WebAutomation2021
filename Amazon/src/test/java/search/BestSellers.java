package search;

import base.CommonAPI;
import com.relevantcodes.extentreports.LogStatus;
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
        extentTest.assignCategory("QA");
        extentTest.log(LogStatus.PASS,"The Test Passed");
        String url = driver.getCurrentUrl();
        bestSellersPage.clickOnBestSeller(bestSellersPage.getBestseller());
        bestSellersPage.clickOnProductUnderCategory(products);
        productPage.clickOnAddToCart(productPage.getAddToCartButton());
        productPage.goToURL(url);
    }
}
