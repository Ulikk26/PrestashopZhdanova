package tests;

import io.qameta.allure.*;
import org.testng.annotations.Test;
import tests.Base.BaseTest;
import static org.testng.Assert.assertEquals;


public class ProductTest extends BaseTest {

    String category = "Women";
    String product = "Blouse";
    String product2 = "Faded Short Sleeve T-shirts";
    String product3 = "Printed Dress";

    @Epic("Cart module of an online store" )
    @Feature("Adding  products to the cart")
    @Severity(SeverityLevel.CRITICAL)
    @Owner("Julia Zhdanova")
    @Test(testName = "Checking the added product in the cart", description = "Checking the added product in the cart")
    @Description("Checking the added product in the cart")
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

    @Epic("Cart module of an online store" )
    @Feature("Adding products to the cart")
    @Severity(SeverityLevel.CRITICAL)
    @Owner("Julia Zhdanova")
    @Test(testName = "Checking the price of the added product", description = "Checking the price of the added product")
    @Description("Checking the price of the added product")
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

    @Epic("Cart module of an online store" )
    @Feature("Adding products to the cart")
    @Severity(SeverityLevel.CRITICAL)
    @Owner("Julia Zhdanova")
    @Test(testName = "Checking the count of products in the cart", description = "Checking the count of products in the cart")
    @Description("Checking the count of products in the cart")
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