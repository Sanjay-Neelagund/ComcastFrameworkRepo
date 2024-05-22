package Com.Comcast.generic.fileutility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility {

	public String getDataFromExcel(String SheetName,int rowNum,int celNum) throws Throwable {
		FileInputStream fis=new FileInputStream("./src/test/resources/TestScriptData.xlsx");
		Workbook wb= WorkbookFactory.create(fis);
		String data= wb.getSheet(SheetName).getRow(rowNum).getCell(celNum).getStringCellValue();
		wb.close();
		return data;
	}

	public int getRowCount(String SheetName) throws Throwable {
		FileInputStream fis=new FileInputStream("./src/test/resources/TestScriptData.xlsx");
		Workbook wb= WorkbookFactory.create(fis);
		int rowCount=wb.getSheet(SheetName).getLastRowNum();
		wb.close();
		return rowCount;
	}
	public void setDataIntoExcel(String SheetName,int rowNum,int celNum, String data) throws Throwable {
		FileInputStream fis=new FileInputStream("./src/test/resources/TestScriptData.xlsx");
		Workbook wb= WorkbookFactory.create(fis);
		wb.getSheet(SheetName).getRow(rowNum).createCell(celNum).setCellValue(data);
		FileOutputStream fos=new FileOutputStream("./src/test/resources/TestScriptData.xlsx");
		wb.write(fos);
		wb.close();
		
	}
}
