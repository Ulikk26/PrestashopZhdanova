package tests;

import io.qameta.allure.Description;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;


public class ProductTest extends BaseTest {

    String category = "Women";
    String product = "Blouse";
    String product2 = "Faded Short Sleeve T-shirts";
    String product3 = "Printed Dress";

    @Test(testName = "Checking added product to cart", description = "Checking added product to cart")
    @Description("Checking added product to cart")
    public void checkAddedProductToCart() {
        signInSteps.enterCredention(email, password);
        productSteps.openProductCard(category, product);
        productSteps.openProductAddedModal(product);
        productAddedModal.clickByProceedToCheckout();
        String productIntoCart = shoppingCartSummaryPage.getNameOfProductIntoCart(product);
        assertEquals(productIntoCart,
                product,
                "Name of product is not into cart page");
    }

    @Test(testName = "Checking the price of added product", description = "Checking the price of added product")
    @Description("Checking the price of added product")
    public void checkPriceAddedProduct() {
        signInSteps.enterCredention(email, password);
        productSteps.openProductCard(category, product);
        productSteps.openProductAddedModal(product);
        productAddedModal.clickByProceedToCheckout();
        String priceOfProduct = shoppingCartSummaryPage.getPriceOfProductIntoCart(product);
        assertEquals(priceOfProduct,
                "32,40 ₴",
                "The price does not meet the expected outcome");
    }

    @Test(testName = "Checking count of products into cart", description = "Checking count of products into cart")
    @Description("Checking count of products into cart")
    public void checkCountOfProducts() {
        signInSteps.enterCredention(email, password);
        headerPage.clickCategory(category);
        productSteps.clickAddToCardViaHoverOver(product);
        productSteps.clickCloseButton();
        productSteps.clickAddToCardViaHoverOver(product2);
        productSteps.clickCloseButton();
        productSteps.clickAddToCardViaHoverOver(product3);
        productSteps.clickByProceedCheckout();
        int countOfProduct = shoppingCartSummaryPage.checkCountOfProducts();
        assertEquals(countOfProduct,
                3,
                "The count does not meet the expected outcome");
    }


}