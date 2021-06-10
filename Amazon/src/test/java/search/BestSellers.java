package search;

import base.CommonAPI;
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

//        product = driver.findElement(By.xpath(products)).getText();

//        test = extent.startTest("Shopping from BestSellers - " );
//        test.assignCategory("Functional Testing");
//        test.assignCategory("Just a Demo:");
        String url = driver.getCurrentUrl();
        bestSellersPage.clickOnBestSeller(bestSellersPage.getBestseller());
        bestSellersPage.clickOnProductUnderCategory(products);
        productPage.clickOnAddToCart(productPage.getAddToCartButton());
        productPage.goToURL(url);
//        test.log(LogStatus.INFO, "Navigated to " + url, "This should take you back to Best Seller Page!");

    }
}
