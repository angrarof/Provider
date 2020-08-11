package tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utils.ExcelDataProvider;

import java.lang.reflect.Method;

public class DataProviderTest {

    @DataProvider
    public Object[][] getData(Method m){
        Object[][] data = null;
        if(m.getName().equalsIgnoreCase("getCredentials")){
            data = new Object[][]{
                    {"Angel", "Aguilara"},
                    {"Aguuilar", "Martin"}
            };
        }else{
            data = new Object[][]{
                    {"ANGELLLLl"},
                    {"DOOOOOS"}
            };
        }

        return data;
    }

    @Test(dataProvider = "getData", dataProviderClass = ExcelDataProvider.class, enabled = true)
    public void printUsers(String username, String pass){
        System.out.println(username+" "+pass);
    }

    @Test(dataProvider = "getData", enabled = true)
    public void getName(String name){
        System.out.println(name);
    }

    @Test(dataProvider = "getData", enabled = true)
    public void getCredentials(String username, String pass){
        System.out.println(username+" "+pass);
    }

}
