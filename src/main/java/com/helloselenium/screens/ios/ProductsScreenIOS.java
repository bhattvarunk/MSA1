package com.helloselenium.screens.ios;

/*import com.helloselenium.BaseScreen;*/

import com.helloselenium.screens.BaseScreen;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;

public class ProductsScreenIOS extends BaseScreen {

    public boolean verifyProductPage() {
        MobileElement productPage = (MobileElement) getDriver().findElement(MobileBy.xpath("//XCUIElementTypeOther"));
        return isElementVisible(productPage);
    }
}
