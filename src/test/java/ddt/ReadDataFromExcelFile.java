package ddt;

import java.io.FileInputStream;


import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadDataFromExcelFile {

	public static void main(String[] args) throws Throwable {
        FileInputStream fis1 = new FileInputStream("./src/test/resources/Testdata.xlsx");
         Workbook wb = WorkbookFactory.create(fis1);
         Sheet sheet = wb.getSheet("Products");
         Row row = sheet.getRow(4);
         String prodname = row.getCell(3).getStringCellValue();
         System.out.println(prodname);
         
         
        

	}

}
