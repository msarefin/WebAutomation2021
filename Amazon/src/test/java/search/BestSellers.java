package search;

import org.testng.annotations.Test;
import pages.BestSellersPage;

public class BestSellers {

    @Test
    public void shoppingFromBestSellers(){
        BestSellersPage bestSellersPage = new BestSellersPage();

        bestSellersPage.clickOnBestSeller(bestSellersPage.getBestseller());
    }
}
