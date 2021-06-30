package com.helloselenium.tests;

import com.helloselenium.utils.ExcelUtility;
import org.testng.annotations.Test;


public class TestData {

    String sheetName = "testData";

    @Test
    public void test() {

        ExcelUtility data = new ExcelUtility(System.getProperty("user.dir") + "/src/test/resources/data/TestData.xlsx");
        //String d = data.getCellData("AddCustomField", "Field Title", 1);
        System.out.println(data.getCellData(sheetName, "User Name", 2));
    }

}
