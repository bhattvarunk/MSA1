package com.helloselenium.tests.android;

import com.helloselenium.BaseTest;
import com.helloselenium.constant.PathConstants;
import com.helloselenium.utils.ExcelUtility;
import com.helloselenium.utils.JSONReader;
import com.helloselenium.utils.TestUtils;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.lang.reflect.Method;


public class LoginTests extends BaseTest {
    ExcelUtility data;
    JSONReader jsonReader;
    String sheet = "testData";
    TestUtils utils = new TestUtils();

    @BeforeClass
    public void beforeClass() throws Exception {
        data = new ExcelUtility(System.getProperty("user.dir") + File.separator + PathConstants.testData);
        jsonReader = new JSONReader(PathConstants.jsonPath);
//        closeApp();
//        launchApp();
    }

    @BeforeMethod
    public void beforeMethod(Method m) {
        utils.log().info("\n" + "****** starting test:" + m.getName() + "******" + "\n");
    }

    @Test
    public void invalidPassword() {
        loginScreenAndroid.enterUserName(data.getCellData(sheet, "User Name", 2));
        loginScreenAndroid.enterPassword(data.getCellData(sheet, "Password", 2));
        loginScreenAndroid.pressLoginBtn();

        String actualErrTxt = loginScreenAndroid.getErrTxt();
        String expectedErrTxt = getStrings().get("err_invalid_username_or_password");

        Assert.assertEquals(actualErrTxt, expectedErrTxt);
    }

    @Test
    public void successfulLogin() {
        loginScreenAndroid.enterUserName(jsonReader.getValue("validUser", "username"));
        loginScreenAndroid.enterPassword(jsonReader.getValue("validUser", "password"));
        loginScreenAndroid.pressLoginBtn();
        Assert.assertTrue(productsScreenAndroid.verifyProductPage());
    }
}
