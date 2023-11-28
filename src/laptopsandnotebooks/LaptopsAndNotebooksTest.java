package laptopsandnotebooks;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utility;

import java.util.List;

/**
 * Write the following test
 * 1. Test name verifyProductsPriceDisplayHighToLowSuccessfully()
 * 1.1 Mouse hover on Laptops & Notebooks Tab.and click
 * 1.2 Click on “Show All Laptops & Notebooks”
 * 1.3 Select Sort By "Price (High > Low)"
 * 1.4 Verify the Product price will arrange in High to Low order.
 * 2. Test name verifyThatUserPlaceOrderSuccessfully()
 * 2.1 Mouse hover on Laptops & Notebooks Tab and click
 * 2.2 Click on “Show All Laptops & Notebooks”
 * 2.3 Select Sort By "Price (High > Low)"
 * 2.4 Select Product “MacBook”
 * 2.5 Verify the text “MacBook”
 * 2.6 Click on ‘Add To Cart’ button
 * 2.7 Verify the message “Success: You have added MacBook to your shopping cart!”
 * 2.8 Click on link “shopping cart” display into success message
 * 2.9 Verify the text "Shopping Cart"
 * 2.10 Verify the Product name "MacBook"
 * 2.11 Change Quantity "2"
 * 2.12 Click on “Update” Tab
 * 2.13 Verify the message “Success: You have modified your shopping cart!”
 * 2.14 Verify the Total £737.45
 * 2.15 Click on “Checkout” button
 * 2.16 Verify the text “Checkout”
 * 2.17 Verify the Text “New Customer”
 * 2.18 Click on “Guest Checkout” radio button
 * 2.19 Click on “Continue” tab
 * 2.20 Fill the mandatory fields
 * 2.21 Click on “Continue” Button
 * 2.22 Add Comments About your order into text area
 * 2.23 Check the Terms & Conditions check box
 * 2.24 Click on “Continue” button
 * 2.25 Verify the message “Warning: Payment method required!”
 */
public class LaptopsAndNotebooksTest extends Utility {

    String baseUrl = "http://tutorialsninja.com/demo/index.php";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void verifyProductsPriceDisplayHighToLowSuccessfully() {
    //1.1 Mouse hover on Laptops & Notebooks Tab.and click
        mouseHoverElementAndClick(By.xpath("//a[normalize-space()='Laptops & Notebooks']"));
    //1.2 Click on “Show All Laptops & Notebooks”
        clickOnElement(By.xpath("//a[contains(text(),'Show AllLaptops & Notebooks')]"));
    //1.3 Select Sort By "Price (High > Low)"
        selectByVisibleTextFromDropDown(By.id("input-sort"), "Price (High > Low)");
    //1.4 Verify the Product price will arrange in High to Low order
        List<WebElement> productPrices = driver.findElements(By.xpath("//div[@class='row']//p//span"));
        for (WebElement productPrice : productPrices) {
            String actualPrice = productPrice.getText();
        }

        Assert.assertEquals("Invalid text", "");
    }

    @Test
    public void verifyThatUserPlaceOrderSuccessfully() throws InterruptedException {
    //2.1 Mouse hover on Laptops & Notebooks Tab and click
        mouseHoverElementAndClick(By.xpath("//a[normalize-space()='Laptops & Notebooks']"));
    //2.2 Click on “Show All Laptops & Notebooks”
        clickOnElement(By.xpath("//a[contains(text(),'Show AllLaptops & Notebooks')]"));
    //2.3 Select Sort By "Price (High > Low)"
        selectByVisibleTextFromDropDown(By.id("input-sort"), "Price (High > Low)");
    //2.4 Select Product “MacBook”
        clickOnElement(By.xpath("//a[contains(text(),'MacBook Pro')]"));
    //2.5 Verify the text “MacBook”
        String actualText = getTextElement(By.xpath("//h1[contains(text(),'MacBook Pro')]"));
        Assert.assertEquals("Invalid text", "MacBook Pro", actualText);
    //2.6 Click on ‘Add To Cart’ button
        clickOnElement(By.id("button-cart"));
    //2.7 Verify the message “Success: You have added MacBook to your shopping cart!”
        String actualMessage = getTextElement(By.xpath("//div[@class='alert alert-success alert-dismissible']"));
        Assert.assertEquals("Invalid message", "Success: You have added MacBook Pro to your shopping cart!\n" +
                "×", actualMessage);
    //2.8 Click on link “shopping cart” display into success message
        clickOnElement(By.xpath("//a[contains(text(),'shopping cart')]"));
    //2.9 Verify the text "Shopping Cart"
        String actualTextTitle = getTextElement(By.xpath("//h1[contains(text(),'Shopping Cart')]"));
        Assert.assertEquals("Invalid text of the title", "Shopping Cart  (0.00kg)", actualTextTitle);
    //2.10 Verify the Product name "MacBook"
        String actualProductName = getTextElement(By.xpath("//small[contains(text(),'Reward Points: 800')]//preceding-sibling::a"));
        Assert.assertEquals("Invalid name", "MacBook Pro", actualProductName);
    //2.11 Change Quantity "2"

        driver.findElement(By.xpath("//div[@class='input-group btn-block']/child::input")).clear();
        sendTextToElement(By.xpath("//div[@class='input-group btn-block']/child::input"), "2");
    //2.12 Click on “Update” Tab
        clickOnElement(By.xpath("//button[@type='submit']"));
    //2.13 Verify the message “Success: You have modified your shopping cart!”
        String actualModificationMsg = getTextElement(By.xpath("//div[@class='alert alert-success alert-dismissible']"));
        Assert.assertEquals("Invalid modification message", "Success: You have modified your shopping cart!\n" +
                "×", actualModificationMsg);
    //2.14 Verify the Total £737.45
        String actualPrice = getTextElement(By.xpath("//td[contains(text(),'$2,000.00')]//following-sibling::td"));
        Assert.assertEquals("Invalid price", "$4,000.00", actualPrice);
    //2.15 Click on “Checkout” button
        clickOnElement(By.xpath("//a[@class='btn btn-primary']"));
    //2.16 Verify the text “Checkout”
        String checkoutText = getTextElement(By.xpath("//h1[text()='Checkout']"));
        Assert.assertEquals("Invalid text", "Checkout", checkoutText);
    //2.17 Verify the Text “New Customer”

        String actualNewCustomerTitle = getTextElement(By.xpath("//div[@class='col-sm-6']/parent::div/child::div[1]/h2"));
        Assert.assertEquals("Invalid text", "New Customer", actualNewCustomerTitle);
    //2.18 Click on “Guest Checkout” radio button
        clickOnElement(By.xpath("//input[@value='guest']"));
    //2.19 Click on “Continue” tab
        clickOnElement(By.id("button-account"));
    //2.20 Fill the mandatory fields
        sendTextToElement(By.id("input-payment-firstname"), "David");
        sendTextToElement(By.id("input-payment-lastname"), "Smith");
        sendTextToElement(By.id("input-payment-email"), "tswift1542@hotmail.com");
        sendTextToElement(By.id("input-payment-telephone"), "07435626624");
        sendTextToElement(By.id("input-payment-address-1"), "61, Olive Apartments");
        sendTextToElement(By.id("input-payment-city"), "Vadodara");
        sendTextToElement(By.id("input-payment-postcode"), "393002");
        selectByVisibleTextFromDropDown(By.id("input-payment-country"), "India");
        selectByVisibleTextFromDropDown(By.id("input-payment-zone"), "Gujarat");
    //2.21 Click on “Continue” Button
        clickOnElement(By.id("button-guest"));

    //2.22 Add Comments About your order into text area
        clickOnElement(By.xpath("//textarea[@name='comment']"));
        sendTextToElement(By.xpath("//textarea[@name='comment']"), "Please deliver it at the reception at delivery counter");
    //2.23 Check the Terms & Conditions check box
        clickOnElement(By.id("button-shipping-method"));
        clickOnElement(By.xpath("//a[@class='agree']/following-sibling::input[1]"));
    //2.24 Click on “Continue” button
        clickOnElement(By.xpath("//input[@id='button-payment-method']"));
    //2.25 Verify the message “Warning: Payment method required!”
        clickOnElement(By.id("button-confirm"));
        clickOnElement(By.xpath("//a[text()='Continue']"));
    }

    @After
    public void tearDown() {
        closeBrowser();
    }

}
