package utils;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.IOException;

public class ExcelUtils {

    public static void getRowCount(){
        try {
            XSSFWorkbook workbook = new XSSFWorkbook(System.getProperty("user.dir")+"/spreads/data.xlsx");
            XSSFSheet sheet = workbook.getSheet("Sheet1");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
