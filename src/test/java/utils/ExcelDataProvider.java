package utils;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.lang.reflect.Method;

public class ExcelDataProvider {

    @Test(dataProvider = "getData")
    public void printUsers(String username, String password){
        System.out.println(username+"|"+password);
    }

    @Test(dataProvider = "getData")
    public void printAnother(String d1, String d2, String d3){
        System.out.println(d1+" "+d2+" "+d3);
    }

    @DataProvider
    public Object[][] getData(Method m) throws IOException {
        Object[][] data;
        String sheet = null;
        if (m.getName().equalsIgnoreCase("printAnother")){
            sheet = "another";
        }else if(m.getName().equalsIgnoreCase("printUsers")){
            sheet = "users";
        }
        data=createData(sheet,System.getProperty("user.dir")+"/spreads/data.xlsx");
        return data;
    }
    public Object[][] createData(String sheetName, String excelPath) throws IOException {
        ExcelUtils excelUtils = new ExcelUtils(sheetName,excelPath);
        int rowCount = excelUtils.getRowCount();
        int columnCount = excelUtils.getColumnCount();

        Object data[][] = new Object[rowCount-1][columnCount];

        for (int i =1; i<rowCount; i++){
            for (int j = 0; j<columnCount; j++){
                data[i-1][j]=excelUtils.getCellData(i,j);
            }
        }

        return data;

    }

}
