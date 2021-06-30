package com.helloselenium.screens.android;

import com.helloselenium.BaseTest;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;

public class
LoginScreenAndroid extends BaseTest {

    private MobileElement usernameTxtFld = (MobileElement) getDriver().findElement(MobileBy.AccessibilityId("test-Username"));
    private MobileElement passwordTxtFld = (MobileElement) getDriver().findElement(MobileBy.AccessibilityId("test-Password"));
    private MobileElement loginBtn = (MobileElement) getDriver().findElement(MobileBy.AndroidUIAutomator("text(\"LOGIN\")"));

    public LoginScreenAndroid enterUserName(String username) {
        clear(usernameTxtFld);
        sendKeys(usernameTxtFld, username, "login with " + username);
        return this;
    }

    public LoginScreenAndroid enterPassword(String password) {
        clear(passwordTxtFld);
        sendKeys(passwordTxtFld, password, "password is " + password);
        return this;
    }

    public LoginScreenAndroid pressLoginBtn() {
        click(loginBtn, "press login button");
        return this;
    }

    public LoginScreenAndroid login(String username, String password) {
        enterUserName(username);
        enterPassword(password);
        return pressLoginBtn();
    }

    public String getErrTxt() {
        MobileElement errTxt = (MobileElement) getDriver().findElement(MobileBy.xpath("//android.view.ViewGroup[@content-desc=\"test-Error message\"]/android.widget.TextView"));
        String err = getText(errTxt, "error text is - ");
        return err;
    }

}
