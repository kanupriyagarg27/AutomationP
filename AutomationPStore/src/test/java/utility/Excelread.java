package utility;

import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excelread {

	 static FileInputStream fis;
	static XSSFWorkbook wb;
	
	
	public Excelread() {
		System.out.println("i am in constructor");
		try {
			fis = new FileInputStream("./testdata/exceltestdata.xlsx");
			wb = new XSSFWorkbook(fis);

		} catch (Exception e) {
			System.out.println("File not found " + e.getMessage());
		}
	}
	public static void main(String[] args) {
		Excelread obj = new Excelread();
		int rows = GetRowsCount(0);
		int cols = GetColsCount(0,0);
		 getanydata(rows,cols);
		
	}

	public static void getdata() {
		
		try {
			wb = new XSSFWorkbook("./testdata/exceltestdata.xlsx");
		} catch (IOException e) {
			System.out.println("File not found, now system message: " + e.getMessage());
		}
		int totalRows = wb.getSheetAt(0).getLastRowNum() + 1;
		System.out.println("total number of rows are " + totalRows);
		int totalcols = wb.getSheetAt(0).getRow(0).getLastCellNum();
		System.out.println("total number of columns are " + totalcols);

		for (int i = 0; i < totalRows; i++) {
			for (int j = 0; j < totalcols; j++) {

				String celldatavalue = wb.getSheetAt(0).getRow(i).getCell(j).getStringCellValue();
				System.out.print(celldatavalue + "\t\t");
			}
			System.out.println("");
		}
	}
	
	public static int  GetRowsCount(int SheetNumber) {
	 int totalRows=wb.getSheetAt(SheetNumber).getLastRowNum()+1;
	 System.out.println("total number of rows are "+ totalRows);
	return totalRows;
	
	}
	
	public  static int GetColsCount(int SheetNumber,int RowNum) {
		int totalcols= wb.getSheetAt(SheetNumber).getRow(RowNum).getLastCellNum();
		System.out.println("total number of columns are " + totalcols);
				return totalcols;

	}
	
	public static  String GetCellData( int RowNum, int CellNum) {
		String celldata =wb.getSheetAt(0).getRow(RowNum).getCell(CellNum).getStringCellValue();
		System.out.println("celldata is "+ celldata);
		
		return celldata ;
	}
	
	public static String  getanydata(int rows , int cols) {
		
		String celldatavalue=null;
		for (int i=0; i<rows; i++) {
			for (int j =0;j<cols; j++) {
		
		celldatavalue = wb.getSheetAt(0).getRow(i).getCell(j).getStringCellValue();
		System.out.print(celldatavalue +"\t\t");
		
			}
			System.out.println("");
				}
		return celldatavalue;
		
		
}}
