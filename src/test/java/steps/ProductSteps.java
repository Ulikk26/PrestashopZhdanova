package steps;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.testng.Assert;
import pages.*;

import static com.codeborne.selenide.Selenide.sleep;

@Log4j2
public class ProductSteps {
    HeaderPage headerPage =new HeaderPage();
    ProductsPage productsPage = new ProductsPage();
    ProductInformationPage productInformationPage =new ProductInformationPage();
    ProductAddedModal productAddedModal =new ProductAddedModal();
    ShoppingCartSummaryPage shoppingCartSummaryPage =new ShoppingCartSummaryPage();


//    @Step ("Click the 'Add to cart")
//    public void clickAddToCart (String product){
//        log.info("Click add to cart");
//        productsPage.clickByProduct(product)
//                .isPageOpened()
//                .clickByAddToCart();
//    }

    @Step("Open the 'Product card' page")
    public void openProductCard(String category, String product) {
        headerPage.clickCategory(category);
        productsPage.clickByProduct(product);
    }


    @Step ("Open product added modal")
        public void openProductAddedModal (String product){
        log.info("Opening product added modal , product '{}'",product);
        productInformationPage.clickByAddToCart();
        productAddedModal.isPageOpened();
        String messageText = productAddedModal.getMessage();
        Assert.assertEquals(messageText,"Product successfully added to your shopping cart","Message is not displayed");
    }

    @Step("Click the Proceed To Checkout")
    public void clickByProceedCheckout () {
        log.info("Click by Proceed To Checkout");
        productAddedModal.clickByProceedToCheckout();
        shoppingCartSummaryPage.isPageOpened();
    }

    @Step("Click the 'Add to cart' via hover over")
    public void clickAddToCardViaHoverOver(String product) {
        log.info("Click the 'Add to cart' via hover over");
        productsPage.hoverOverByProduct(product)
                .clickAddToCart(product);
        sleep(2000);
    }

    @Step("Click the close button")
    public void clickCloseButton() {
        productAddedModal.clickCloseButton()
                .isPageOpened();
    }
}
