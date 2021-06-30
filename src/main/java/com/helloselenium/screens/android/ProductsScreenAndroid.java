package com.helloselenium.screens.android;

/*import com.helloselenium.BaseScreen;*/

import com.helloselenium.screens.BaseScreen;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;

public class ProductsScreenAndroid extends BaseScreen {

    public boolean verifyProductPage() {
        MobileElement productPage = (MobileElement) getDriver().findElement(MobileBy.xpath("//android.view.ViewGroup[@content-desc=\"test-Error message\"]/android.widget.TextView"));
        return isElementVisible(productPage);
    }
}
