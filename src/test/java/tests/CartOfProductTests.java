package tests;

import jdk.jfr.Description;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CartOfProductTests extends BaseTests{

    String category="Women";
    String product ="Blouse";
    String product2 ="Dress";

    @Test(testName = "Verifying added product to cart", description = "Verifying added product to cart")
    @Description("Verifying added product to cart")
    public void checkAddedProductToCart() {
        signInSteps.login(email, password);
        productSteps.openCategoryPage(category);
        productSteps.openProductAddedModal(product);
        productSteps.clickByProceedCheckout();
        boolean productIntoCart=productSteps.getNameOfProductIntoCart(product);
        Assert.assertTrue(productIntoCart);
    }

    @Test(testName = "Verifying the price of added product", description = "Verifying the price of added product")
    @Description("Verifying the price of added product")
    public void checkPriceAddedProduct() {
        signInSteps.login(email, password);
        productSteps.openCategoryPage(category);
        productSteps.openProductAddedModal(product);
        productSteps.clickByProceedCheckout();
        String priceOfProduct= productSteps.getPriceAddedProduct(product);
        Assert.assertEquals(priceOfProduct,"27,00 ₴", "The price does not meet the expected outcome");
    }

    @Test(testName = "Verifying count product", description = "Verifying count product")
    @Description("Verifying count product")
    public void checkCountOfProduct() {
        signInSteps.login(email, password);
        productSteps.openCategoryPage(category);
        productSteps.openProductAddedModal(product);
        productSteps.clickByProceedCheckout();
        int countOfProduct= productSteps.getCountOfProducts();
        Assert.assertEquals(countOfProduct,1, "The count does not meet the expected outcome");
    }

//    @Test(testName = "Verifying count product when added 2 products", description = "Verifying count product when added 2 products")
//    @Description("Verifying count product when added 2 products")
//    public void checkCountOfProduct2() {
//        signInSteps.login(email, password);
//        productSteps.openCategoryPage(category);
//        productSteps.openProductAddedModal(product);
//        productSteps.clickByProceedCheckout();
//        productSteps.openCategoryPage(category);
//
//        int countOfProduct= productSteps.getCountOfProducts();
//        Assert.assertEquals(countOfProduct,2, "The count does not meet the expected outcome");
//    }
}