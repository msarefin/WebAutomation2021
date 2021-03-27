package search;

import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.BestSellersPage;
import pages.ProductPage;

public class BestSellers {
    BestSellersPage bestSellersPage = new BestSellersPage();
    ProductPage productPage = new ProductPage();
    @DataProvider(name = "ProductUnderCategroy")
    public Object[] productUnderCategroy(){
        return bestSellersPage.ElementList(bestSellersPage.getCategory());
    }

    @Test(dataProvider = "ProductUnderCategroy")
    public void shoppingFromBestSellers(By products){
        bestSellersPage.clickOnBestSeller(bestSellersPage.getBestseller());
        bestSellersPage.clickOnProductUnderCategory(products);
        productPage.clickOnAddToCart(productPage.getAddToCartButton());
        productPage.goBack();
    }
}
