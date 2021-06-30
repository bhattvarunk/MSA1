package com.helloselenium.screens.ios;

import com.helloselenium.BaseTest;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;

public class LoginScreenIOS extends BaseTest {

    private MobileElement usernameTxtFld = (MobileElement) getDriver().findElement(MobileBy.id("test-Username"));
    private MobileElement passwordTxtFld = (MobileElement) getDriver().findElement(MobileBy.id("test-Password"));
    private MobileElement loginBtn = (MobileElement) getDriver().findElement(MobileBy.id("test-LOGIN"));

    public LoginScreenIOS enterUserName(String username) {
        clear(usernameTxtFld);
        sendKeys(usernameTxtFld, username, "login with " + username);
        return this;
    }

    public LoginScreenIOS enterPassword(String password) {
        clear(passwordTxtFld);
        sendKeys(passwordTxtFld, password, "password is " + password);
        return this;
    }

    public ProductsScreenIOS pressLoginBtn() {
        click(loginBtn, "press login button");
        return new ProductsScreenIOS();
    }

    public ProductsScreenIOS login(String username, String password) {
        enterUserName(username);
        enterPassword(password);
        return pressLoginBtn();
    }

    public String getErrTxt() {
        MobileElement errTxt = (MobileElement) getDriver().findElement(MobileBy.xpath("//XCUIElementTypeOther[@name=\"test-Error message\"]/child::XCUIElementTypeStaticText"));
        String err = getText(errTxt, "error text is - ");
        return err;
    }

}
