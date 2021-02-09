package com.pages;

import com.qa.factory.Driver;
import com.qa.util.ConfigurationReader;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {


    @FindBy(xpath="//input[@id='user']")
    WebElement emailId;

    @FindBy(xpath="//input[@id='password']")
    WebElement password;

    @FindBy(xpath="//input[@id='submit-form']")
    WebElement loginBtn;

    @FindBy(xpath="//a[normalize-space()='Forgot password?']")
    WebElement forgotPwdLink;

   @FindBy (xpath = "//form//p[@class='warning wrongPasswordMsg']")
   WebElement message;

    //Initializing the Page Objects:
    public LoginPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }




    // 3. page actions: features(behavior) of the page the form of methods:

    public String getLoginPageTitle() {
        return Driver.getDriver().getTitle();
    }
    public String getMessage(){
        return  message.getText();
    }

    public boolean isForgotPwdLinkExist() {
        return forgotPwdLink.isDisplayed();
    }

    public void enterUserName(String username) {
        emailId.sendKeys(username);
    }

    public void enterPassword(String pwd) {
        password.sendKeys(pwd);
    }

    public void clickOnLogin() {
       loginBtn.click();
    }
    public void enterWrongUserName(String username ) {
        emailId.sendKeys(username);
    }
    public void enterWrongPassword(String pass ) {
        password.sendKeys(pass);
    }


    public HomePage doLogin(String un, String pwd) {
        System.out.println("login with: " + un + " and " + pwd);
        emailId.sendKeys(un);
        password.sendKeys(pwd);
        loginBtn.click();
        return new HomePage();
    }
}
