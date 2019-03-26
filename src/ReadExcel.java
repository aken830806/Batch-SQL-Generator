import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel {//需全部轉成文字
	public static void main (String[] args) throws SQLException{
//		ReadExcel.load(new File("C:\\Users\\FCU_SELAB\\Desktop\\123.xlsx"));
	}
	public static List<String> load(File excel) {
		try {
			List<String> list = new ArrayList<>();
			int ctr = 0;
			FileInputStream fis = new FileInputStream(excel);
			XSSFWorkbook book = new XSSFWorkbook(fis); 
			XSSFSheet sheet = book.getSheetAt(0);

			Iterator<Row> itr = sheet.iterator();
			
			// Iterating over Excel file in Java
			while (itr.hasNext()) {
				Row row = itr.next();
				// Iterating over each column of Excel file
				Iterator<Cell> cellIterator = row.cellIterator(); 
				while (cellIterator.hasNext()) {

				 Cell cell = cellIterator.next();
//				 System.out.println(cell.getCellType());
				 if(!cell.getStringCellValue().equals(""))//略過空白儲存格
					 list.add(cell.getStringCellValue());
//				 System.out.print(list.get(ctr)); 
				 ctr = ctr + 1;
				}
//				System.out.println("");
			}
			book.close();
			return list;
		}catch (FileNotFoundException fe) {
			fe.printStackTrace();
			} catch (IOException ie) {
				ie.printStackTrace(); 
				}
		return null;
	}
}