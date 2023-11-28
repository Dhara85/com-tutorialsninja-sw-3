package myaccounts;
/**
 * 1. Create the class MyAccountsTest
 * 1.1 create method with name "selectMyAccountOptions" it has one parameter name "option" of type string
 * 1.2 This method should click on the options whatever name is passed as parameter.
 * (Hint: Handle List of Element and Select options)
 * Write the following test
 * 1. Test name verifyUserShouldNavigateToRegisterPageSuccessfully()
 * 1.1 Click on My Account Link.
 * 1.2 Call the method “selectMyAccountOptions” method and pass the parameter“Register”
 * 1.3 Verify the text “Register Account”.
 * 2. Test name verifyUserShouldNavigateToLoginPageSuccessfully()
 * 2.1 Click on My Account Link.
 * 2.2 Call the method “selectMyAccountOptions” method and pass the parameter“Login”
 * 2.3 Verify the text “Returning Customer”.
 * 3. Test name verifyThatUserRegisterAccountSuccessfully()
 * 3.1 Click on My Account Link.
 * 3.2 Call the method “selectMyAccountOptions” method and pass the parameter“Register”
 * 3.3 Enter First Name
 * 3.4 Enter Last Name
 * 3.5 Enter Email
 * 3.6 Enter Telephone
 * 3.7 Enter Password
 * 3.8 Enter Password Confirm
 * 3.9 Select Subscribe Yes radio button
 * 3.10 Click on Privacy Policy check box
 * 3.11 Click on Continue button
 * 3.12 Verify the message “Your Account Has Been Created!”
 * 3.13 Click on Continue button
 * 3.14 Click on My Account Link.
 * 3.15 Call the method “selectMyAccountOptions” method and pass the parameter“Logout”
 * 3.16 Verify the text “Account Logout”
 * 3.17 Click on Continue button
 * 4. Test name verifyThatUserShouldLoginAndLogoutSuccessfully()
 * 4.1 Click on My Account Link.
 * 4.2 Call the method “selectMyAccountOptions” method and pass the parameter“Login”
 * 4.3 Enter Email address
 * 4.4 Enter Last Name
 * 4.5 Enter Password
 * 4.6 Click on Login button
 * 4.7 Verify text “My Account”
 * 4.8 Click on My Account Link.
 * 4.9 Call the method “selectMyAccountOptions” method and pass the parameter“Logout”
 * 4.10 Verify the text “Account Logout”
 * 4.11 Click on Continue button
 */

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

public class MyAccountsTest extends Utility {
    String baseUrl = "http://tutorialsninja.com/demo/index.php";

    @Before
    public void setUp(){
        openBrowser(baseUrl);
    }
    public void selectMyAccountOptions(String Option) {
        // This method should click on the options whatever name is  passed as parameter
        if(Option == "Register") {
            //Find Desktop tab, hover and click on "Show All Desktops"
            clickOnElement(By.xpath("//span[contains(text(),'My Account')]"));
            clickOnElement(By.xpath("//a[contains(text(),'Register')]"));
            //Get title
            String title = driver.getTitle();
            //validate page navigation by assert title
            Assert.assertEquals("title not matched: ", "Register Account", title);
        } else if(Option == "Login") {
            //Find Desktop tab, hover and click on "Show All Desktops"
            clickOnElement(By.xpath("//span[contains(text(),'My Account')]"));
            clickOnElement(By.xpath("//a[contains(text(),'Login')]"));
            String text= getTextElement(By.xpath("//h2[contains(text(),'Returning Customer')]"));
            Assert.assertEquals("title not matched","Returning Customer",text);

        } else {
            System.out.println("Please enter valid name or check entry");
        }
    }
    @Test
    public void verifyUserShouldNavigateToRegisterPageSuccessfully(){
    //1.2 Call the method “selectMyAccountOptions” method and pass the parameter“Register”
        selectMyAccountOptions("Register");
        //1.3 Verify the text “Register Account”
        String actualText = getTextElement(By.xpath("//h2[contains(text(),'Returning Customer')]"));
        Assert.assertEquals("Invalid text", "Returning Customer",actualText);

    }
    @Test
    public void verifyUserShouldNavigateToLoginPageSuccessfully(){
     // 2.2 Call the method “selectMyAccountOptions” method and pass the parameter“Login”
        selectMyAccountOptions("Login");
        //2.3 Verify the text “Returning Customer”
        String actualText = getTextElement(By.xpath("//h2[contains(text(),'Returning Customer')]"));
        Assert.assertEquals("Invalid text", "Returning Customer", actualText);
    }
    @Test
    public void verifyThatUserRegisterAccountSuccessfully(){
        //3.2 Call the method “selectMyAccountOptions” method and pass the parameter “Register”
        selectMyAccountOptions("Register");
        //3.3 Enter First Name
        sendTextToElement(By.id("input-firstname"),"David");
        // 3.4 Enter Last Name
        sendTextToElement(By.id("input-lastname"),"Smith");
        // 3.5 Enter Email
        sendTextToElement(By.id("input-email"),"tswift1542@hotmail.com");

        // 3.6 Enter Telephone
        sendTextToElement(By.id("input-telephone"),"07956254654");
        // 3.7 Enter Password
        sendTextToElement(By.id("input-password"),"9851345615@dp");

        // 3.8 Enter Password Confirm
        sendTextToElement(By.id("input-confirm"),"9851345615@dp");
        // 3.9 Select Subscribe Yes radio button
        clickOnElement(By.xpath("//label[text()='Yes']"));
        //3.10 Click on Privacy Policy check box
        clickOnElement(By.xpath("//input[@name='agree']"));
        // 3.11 Click on Continue button
        clickOnElement(By.xpath("//input[@value='Continue']"));
        // 3.12 Verify the message “Your Account Has Been Created!”
        String actualText =getTextElement(By.xpath("//div[@id='content']/h1"));
        Assert.assertEquals("Your Account Has Been Created!", actualText);
        // 3.13 Click on Continue button
        clickOnElement(By.xpath("//a[contains(text(),'Continue')]"));

        // 3.14 Click on My Account Link.
        clickOnElement(By.xpath("//span[text()='My Account']"));
        // 3.15 Call the method “selectMyAccountOptions” method and pass the parameter“Logout”
        clickOnElement(By.xpath("//ul[@class='dropdown-menu dropdown-menu-right']/li[5]"));
        // 3.16 Verify the text “Account Logout”
        String actualText1 =getTextElement(By.xpath("//h1[normalize-space()='Account Logout']"));
        Assert.assertEquals("Invalid text", "Account Logout", actualText1);
        // 3.17 Click on Continue button
        clickOnElement(By.xpath("//a[contains(text(),'Continue')]"));

    }
    @Test
    public void verifyThatUserShouldLoginAndLogoutSuccessfully(){
        // 4.2 Call the method “selectMyAccountOptions” method and pass the parameter“Login”
        selectMyAccountOptions("Login");

        // 4.3 Enter Email address
        sendTextToElement(By.id("input-email"),"tswift1542@hotmail.com");

        // 4.4 Enter Last Name
        sendTextToElement(By.id("input-lastname"),"Smith");

        // 4.5 Enter Password
        sendTextToElement(By.id("input-password"),"9851345615@dp");

        // 4.6 Click on Login button
        clickOnElement(By.xpath("//input[@value='Login']"));

        // 4.7 Verify text “My Account”
        String actualText = getTextElement(By.xpath("//h2[contains(text(),'My Account')]"));
        Assert.assertEquals("Invalid text", "My Account", actualText);

        // 4.8 Click on My Account Link.
        clickOnElement(By.xpath("//span[text()='My Account']"));

        // 4.9 Call the method “selectMyAccountOptions” method and pass the parameter“Logout”
        clickOnElement(By.xpath("//ul[@class='dropdown-menu dropdown-menu-right']/li[5]"));

        // 4.10 Verify the text “Account Logout”
        String actualLogoutText = getTextElement(By.xpath("//h1[contains(text(),'Account Logout')]"));
        Assert.assertEquals("Invalid text", "Account Logout", actualLogoutText);

        // 4.11 Click on Continue button
        clickOnElement(By.xpath("//a[contains(text(),'Continue')]"));
    }
    @After
    public void tearDown(){
        closeBrowser();
    }

}
