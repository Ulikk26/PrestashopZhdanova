package tests;

import io.qameta.allure.*;
import org.testng.annotations.Test;
import tests.base.BaseTest;

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
        productSteps.openProductCard(category, product2);
        productSteps.openProductAddedModal(product2);
        productAddedModal.clickByProceedToCheckout();
        String productIntoCart = shoppingCartSummaryPage.getNameOfProductIntoCart(product2);
        assertEquals(productIntoCart,
                product2,
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
    @Test(testName = "Checking the deleted product from cart", description = "Checking the deleted product from cart")
    @Description("Checking the deleted product from cart")
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
                "The count does not match the expected result");
    }

    @Epic("Cart module of an online store")
    @Feature("Deleting the product from the cart")
    @Severity(SeverityLevel.CRITICAL)
    @Owner("Julia Zhdanova")
    @Test(testName = "Checking that the product deleted from the cart", description = "Checking that the product deleted from the cart")
    @Description("Checking that the product deleted from the cart")
    public void checkDeletedProduct() {
        signInSteps.enterCredention(email, password);
        productSteps.openProductCard(category, product);
        productSteps.openProductAddedModal(product);
        productAddedModal.clickByProceedToCheckout();
        productSteps.deleteProduct(product);
        String emptyCartMassage = shoppingCartSummaryPage.getEmptyCartMessage();
        assertEquals(emptyCartMassage,
                "Your shopping cart is empty.",
                "The message does not match the expected result");
    }
}