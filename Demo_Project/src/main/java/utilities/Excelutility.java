package utilities;

import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excelutility {
	public static String path = System.getProperty("user.dir") + "/src/test/resources/DataRead.xlsx";

	public static String excelreaddata(int rowno, int coloum) {
		String value = "";
		try {
			FileInputStream fis = new FileInputStream(path);
			XSSFWorkbook wb = new XSSFWorkbook(fis);
			XSSFSheet sheet = wb.getSheet("Sheet1");
			value = sheet.getRow(rowno).getCell(coloum).getStringCellValue();

		} catch (Exception e) {
			System.out.println("Issue in getdata" + e);
		}
		return value;
	}

}
