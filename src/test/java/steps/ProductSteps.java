package steps;

import io.qameta.allure.Step;

import lombok.extern.log4j.Log4j2;
import org.testng.Assert;
import pages.*;

@Log4j2
public class ProductSteps {
    HeaderPage headerPage =new HeaderPage();
    ProductsPage productsPage = new ProductsPage();
    ProductInformationPage productInformationPage =new ProductInformationPage();
    ProductAddedModal productAddedModal =new ProductAddedModal();
    ShoppingCartSummaryPage shoppingCartSummaryPage =new ShoppingCartSummaryPage();

    @Step ("Open product added modal")
        public void openProductAddedModal (String category,String product){
        log.info("Opening product added modal catrgory '{}', product '{}'", category,product);
        headerPage.clickCategory(category);
        productsPage.clickByProduct(product);
        productInformationPage.isPageOpened();
        productInformationPage.clickByAddToCart();
        productAddedModal.isPageOpened();
        String messageText = productAddedModal.getmessage();
        Assert.assertEquals(messageText,"Product successfully added to your shopping cart","Message is not displayed");
    }

    @Step("Add the product to the cart")
    public void addProductToCart (String category,String product) {
        log.info("Adding the product to the cart");
        openProductAddedModal(category,product);
        productAddedModal.clickByProceedToCheckout();
        shoppingCartSummaryPage.isPageOpened();
        boolean productIntoCart =shoppingCartSummaryPage.checkNameOfProductIntoCart(product);
        Assert.assertTrue(productIntoCart);
    }
}
