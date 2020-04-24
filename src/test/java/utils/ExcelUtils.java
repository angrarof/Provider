package utils;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.IOException;

public class ExcelUtils {

    private static XSSFWorkbook workbook;
    private static XSSFSheet sheet;

    public ExcelUtils(String sheetName, String excelPath) throws IOException {
        workbook = new XSSFWorkbook(excelPath);
        sheet = workbook.getSheet(sheetName);
    }

    public int getRowCount() throws IOException {
        int rowCount = sheet.getPhysicalNumberOfRows();
        return rowCount;
    }

    public int getColumnCount() throws IOException {
        int columnCount = sheet.getRow(0).getPhysicalNumberOfCells();
        return columnCount;
    }

    public String getCellData(int row, int column) throws IOException {
        String cellData = sheet.getRow(row).getCell(column).getStringCellValue();
        return cellData;
    }

}
