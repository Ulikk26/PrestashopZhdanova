package tests;

import jdk.jfr.Description;
import org.testng.annotations.Test;

public class CartOfProductTests extends BaseTests{

    @Test(testName = "Verifying added product to cart", description = "Verifying added product to cart")
    @Description("Verifying added product to cart")
    public void checkAddedProductToCart() {
        signInSteps.login(email, password);
        productSteps.addProductToCart("Women","Blouse");
    }
}