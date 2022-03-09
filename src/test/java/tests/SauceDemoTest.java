package tests;

import base.SeleniumBase;
import org.testng.annotations.Test;
import pages.SauceDemoPage;

public class SauceDemoTest extends SeleniumBase {
    SauceDemoPage sauceDemoPage;

    @Test(priority = 0)
    public void sauceDemoLoginTest() {
        sauceDemoPage = new SauceDemoPage(SeleniumBase.driver);
        sauceDemoPage.login();
    }

    @Test(priority = 1)
    public void productsPageTest() {
        sauceDemoPage = new SauceDemoPage(SeleniumBase.driver);
        sauceDemoPage.check(sauceDemoPage.getProducts(), "PRODUCTS");
        sauceDemoPage.selection(sauceDemoPage.getPrice(), 2);
        sauceDemoPage.checkProduct();
        sauceDemoPage.click(sauceDemoPage.getAddToCart());
        sauceDemoPage.click(sauceDemoPage.getCartBtn());
    }

    @Test(priority = 2)
    public void cartTest() {
        sauceDemoPage = new SauceDemoPage(SeleniumBase.driver);
        sauceDemoPage.checkItem(sauceDemoPage.getItem());
        sauceDemoPage.click(sauceDemoPage.getCheckOut());
        sauceDemoPage.fillForm("Tatev", "Tadevosyan", "2305");
        sauceDemoPage.click(sauceDemoPage.getContinueBtn());
        sauceDemoPage.check(sauceDemoPage.getTotal(), "Total: $53.99");
        sauceDemoPage.click(sauceDemoPage.getFinishBtn());
        sauceDemoPage.check(sauceDemoPage.getMessage(), "THANK YOU FOR YOUR ORDER");
        sauceDemoPage.click(sauceDemoPage.getBackToHomeBtn());
    }
}


