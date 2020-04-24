package utils;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

public class ExcelDataProvider {

    @Test(dataProvider = "getData")
    public void testingDataProvider(String username, String password){
        System.out.println(username+"|"+password);
    }

    @DataProvider
    public Object[][] getData() throws IOException {
        Object data[][] = testData("users",System.getProperty("user.dir")+"/spreads/data.xlsx");
        return data;
    }
    public Object[][] testData(String sheetName, String excelPath) throws IOException {
        ExcelUtils excelUtils = new ExcelUtils(sheetName,excelPath);
        int rowCount = excelUtils.getRowCount();
        int columnCount = excelUtils.getColumnCount();

        Object data[][] = new Object[rowCount-1][columnCount];

        for (int i =1; i<rowCount; i++){
            for (int j = 0; j<columnCount; j++){
                String cellData = excelUtils.getCellData(i,j);
                data[i-1][j]=cellData;
            }
        }

        return data;

    }

}
