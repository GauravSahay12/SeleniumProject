package Package.MavenTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataDriven {

	public static void main(String[] args) throws IOException {
		
		//For File reading
		FileInputStream Fis=new FileInputStream("C:\\Users\\SahaY\\eclipse-workspace\\MavenTest\\src\\test\\java\\Package\\MavenTest\\MyExcel.xlsx");
		//this accepts argument from FileinputStream
		XSSFWorkbook workbook =new XSSFWorkbook(Fis);
		
		//Count nos of sheet
		int sheetCount = workbook.getNumberOfSheets();
	System.out.println(sheetCount);
	
	//String SheetNameByIndex = workbook.getSheetName(0);
	//System.out.println(SheetNameByIndex);
	
	for (int i=0;i<sheetCount;i++)
	{
		//System.out.println(workbook.getSheetName(i));
		if(workbook.getSheetName(i).equalsIgnoreCase("Recon"))
		{
			System.out.println("Recon sheet found");
			XSSFSheet sheet=workbook.getSheet("Recon");
			//Access to sheet we got
			//System.out.println(sheet.getCTWorksheet());
			
			//Access to row
			Iterator<Row> rows= sheet.iterator();
			Row first =rows.next();
			Iterator<Cell> cell =first.cellIterator();
			
			//Extract first value of row
			//Cell Value =cell.next();
			//System.out.println(Value);
			//exctract entire value of row
			
			int k=0;
					int column = 0;
			while(cell.hasNext())
			{
				Cell Rowvalue=cell.next();
				System.out.print(Rowvalue);
				System.out.println("  ");
				if(Rowvalue.getStringCellValue().equalsIgnoreCase("Testcases"))
				{
					column=k;
					System.out.println("Desired column found");
					break;
				}
				k++;
			}
			System.out.println(column);
			
			   
			
			while(rows.hasNext())
			{
			Row r = rows.next();
			//Cell cells=r.getCell(0);
			//System.out.println(cells);
			
			
				if(r.getCell(column).getStringCellValue().equalsIgnoreCase("Add"))
				{
					
					System.out.println("Desired item found");
					Iterator<Cell> cv=	r.cellIterator();
				//	ArrayList<String> a= new ArrayList<String>();
					while (cv.hasNext())
					{
						Cell c=cv.next();
						String ab =c.getStringCellValue();
					    System.out.println(ab);
						
					}
					
				
				}
				
			
				
			}
		}
	}
	}
}
		
	
