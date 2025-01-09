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

    @Step("Open category {category} page")
    public void openCategoryPage(String category) {
        log.info("Opening category {} page", category);
        headerPage.clickCategory(category);
    }

    @Step ("Click add to cart")
    public void clickAddToCart (String product){
        log.info("Click add to cart");
        productsPage.clickByProduct(product);
        productInformationPage.isPageOpened();
        productInformationPage.clickByAddToCart();
    }


    @Step ("Open product added modal")
        public void openProductAddedModal (String product){
        log.info("Opening product added modal , product '{}'",product);
        productsPage.clickByProduct(product);
        productInformationPage.isPageOpened();
        productInformationPage.clickByAddToCart();
        productAddedModal.isPageOpened();
        String messageText = productAddedModal.getmessage();
        Assert.assertEquals(messageText,"Product successfully added to your shopping cart","Message is not displayed");
    }

    @Step("Click by Proceed To Checkout")
    public void clickByProceedCheckout () {
        log.info("Click by Proceed To Checkout");
        productAddedModal.clickByProceedToCheckout();
        shoppingCartSummaryPage.isPageOpened();
    }

    @Step("Get name of product ")
    public boolean getNameOfProductIntoCart (String product) {
        log.info("Get name of product ");
        return shoppingCartSummaryPage.checkNameOfProductIntoCart(product);
    }


    @Step("Get the price of product")
    public String getPriceAddedProduct(String product) {
        log.info("Get the price of product");
        return shoppingCartSummaryPage.getPriceOfProductIntoCart(product);
    }

    @Step("Get count of product into cart")
    public int getCountOfProducts() {
        log.info("Getting count of product into cart");
        return shoppingCartSummaryPage.checkCountOfProducts();
    }
}
