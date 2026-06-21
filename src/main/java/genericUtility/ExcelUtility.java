package genericUtility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility {
	public String toReadDataFromExcel(String sheetname,int rowno,int cellno) throws Throwable {
		FileInputStream fis1 = new FileInputStream("./src/test/resources/Testdata.xlsx");
        Workbook wb = WorkbookFactory.create(fis1);
        String data = wb.getSheet(sheetname).getRow(rowno).getCell(cellno).getStringCellValue();
        return data;
	}
	
	// Method to get last row number
		public int getLastRowNumber(String sheetname) throws Throwable {

			FileInputStream fis = new FileInputStream("./src/test/resources/Testdata.xlsx");
			Workbook wb = WorkbookFactory.create(fis);
			Sheet sh = wb.getSheet(sheetname);
			int lastRow = sh.getLastRowNum();
			System.out.println(lastRow);
			return lastRow;
		}

}
