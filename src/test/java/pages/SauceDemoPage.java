package pages;

import base.SeleniumBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.List;

public class SauceDemoPage extends SeleniumBase {
    WebDriver driver;

    @FindBy(css = "[id ='login_credentials']")
    WebElement userName;

    @FindBy(css = "[class ='login_password']")
    WebElement password;

    @FindBy(id = "user-name")
    WebElement userNameInput;

    @FindBy(id = "password")
    WebElement passwordInput;

    @FindBy(id = "login-button")
    WebElement loginBtn;

    @FindBy(css = "span[class ='title']")
    WebElement products;

    @FindBy(css = "[class = 'product_sort_container']")
    WebElement price;

    @FindBy(css = "[class='inventory_item_price']")
    List<WebElement> prod;

    @FindBy(id = "add-to-cart-sauce-labs-fleece-jacket")
    WebElement addToCart;

    @FindBy(id = "shopping_cart_container")
    WebElement cartBtn;

    @FindBy(id = "item_5_title_link")
    WebElement item;

    @FindBy(id = "checkout")
    WebElement checkOut;

    @FindBy(id = "first-name")
    WebElement firstName;

    @FindBy(id = "last-name")
    WebElement lastName;

    @FindBy(id = "postal-code")
    WebElement postalCode;

    @FindBy(id = "continue")
    WebElement continueBtn;

    @FindBy(css = "[class='summary_total_label']")
    WebElement total;

    @FindBy(id = "finish")
    WebElement finishBtn;

    @FindBy(css = "h2[class='complete-header']")
    WebElement message;

    @FindBy(id = "back-to-products")
    WebElement backToHomeBtn;

    public WebElement getBackToHomeBtn() {
        return backToHomeBtn;
    }

    public WebElement getMessage() {
        return message;
    }

    public WebElement getFinishBtn() {
        return finishBtn;
    }

    public WebElement getTotal() {
        return total;
    }

    public WebElement getContinueBtn() {
        return continueBtn;
    }

    public WebElement getCheckOut() {
        return checkOut;
    }

    public WebElement getItem() {
        return item;
    }

    public WebElement getCartBtn() {
        return cartBtn;
    }

    public WebElement getAddToCart() {
        return addToCart;
    }

    public WebElement getProducts() {
        return products;
    }

    public WebElement getPrice() {
        return price;
    }

    public SauceDemoPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    public void login() {
        String str = userName.getText();
        String[] username = str.split("\n");
        userNameInput.sendKeys(username[1]);

        String str1 = password.getText();
        String[] pass = str1.split("\n");
        passwordInput.sendKeys(pass[1]);

        loginBtn.click();
    }

    public void check(WebElement elem, String str) {
        Assert.assertEquals(elem.getText(), str, "Error!");
    }

    public void click(WebElement elem) {
        elem.click();
    }

    public void selection(WebElement elem, int index) {
        Select select = new Select(elem);
        select.selectByIndex(index);
    }

    public void checkProduct() {
        for (WebElement elem : prod) {
            System.out.print(elem.getText() + " ");
        }
    }

    public void checkItem(WebElement elem) {
        elem.isDisplayed();
    }

    public void fillForm(String firstName, String lastName, String postalCode) {
        this.firstName.sendKeys(firstName);
        this.lastName.sendKeys(lastName);
        this.postalCode.sendKeys(postalCode);
    }

}
