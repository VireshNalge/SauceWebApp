package ddt;

import java.io.FileInputStream;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadDataFromMultiplRows {

	public static void main(String[] args) throws Throwable {
		 FileInputStream fis1 = new FileInputStream("./src/test/resources/Testdata.xlsx");
         Workbook wb = WorkbookFactory.create(fis1);
         Sheet sheet = wb.getSheet("Cart");
        int rowcount = sheet.getLastRowNum();
         
         for(int i=1;i<=rowcount;i++)
         {
        	 String prodname = sheet.getRow(i).getCell(0).getStringCellValue();
        	 String range = sheet.getRow(i).getCell(1).getStringCellValue();
        	 System.out.println(prodname+"--------"+range);

	}

}
}
