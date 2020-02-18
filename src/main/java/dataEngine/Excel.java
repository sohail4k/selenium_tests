package dataEngine;


import java.io.FileInputStream;
import java.io.IOException;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Row.MissingCellPolicy;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import utilities.Constants;
import utilities.Logg;

public class Excel {
	
	private static XSSFWorkbook workbook;
	private static XSSFSheet worksheet;
	private static XSSFCell cell;
	private static XSSFRow row;

	  public static void GetExcelFile(String file_loc, String file_name, String sheet_name) throws Exception
	    {
		  
		  try {
	    FileInputStream fileInputStream= new FileInputStream(file_loc+file_name); //Excel sheet file location get mentioned here
	        workbook = new XSSFWorkbook (fileInputStream); //get my workbook 
	        worksheet=workbook.getSheet(sheet_name);// get my sheet from workbook
	        //XSSFRow Row=worksheet.getRow(1);     //get my Row which start from 0
	        
		  }
		  
		  catch( Exception e) {
			  
			  throw e;
			  
			  
		  }
		  
	    }
		  
		  public static String GetCellData(int row_no,int col_no) throws Exception 
		  {
			try {
			  cell=worksheet.getRow(row_no).getCell(col_no);
			  String cell_data=cell.getStringCellValue();
			  return cell_data;
			  
		  }
			
			catch (Exception e) {
				
				return "";	
			}
			
		  }
	    
		  public static void SetCellData(String test_res,int row_no, int col_no)  throws Exception{
			  
			  try {
				  
				  row=worksheet.getRow(row_no);
				  cell=row.getCell(col_no, MissingCellPolicy.RETURN_BLANK_AS_NULL);
				  
				  if(cell==null) {
					 cell=row.createCell(col_no);
					 cell.setCellValue(test_res);
				  }
				  else 
					  cell.setCellValue(test_res);
				  
				  
			  
			  
			  FileOutputStream output_stream=new FileOutputStream(Constants.file_location+ Constants.file_name);
			  
			  workbook.write(output_stream);
			  output_stream.flush();
			  output_stream.close();
		  }
			  catch(Exception e) {
				  
				  throw e;
			  }
		  
	    
		  }
		  
		  
			
			public static int FindTCRow(String tc_name) throws Exception  {
				
				int row_no;
				int last_row = worksheet.getLastRowNum();
				Logg.info("Last Row: "+ last_row);

				
				try {
				for (row_no=0;row_no <= last_row;row_no++ ) {
				if(GetCellData(row_no,Constants.col_test_name).equalsIgnoreCase(tc_name)) 
					return row_no;
				Logg.info("ExcelCellDate:"+ GetCellData(row_no,Constants.col_test_name));
								
				}
				
				}
				
				catch (Exception e ) {
					throw e;
				}
				return -1;
			}	  
	
}
		  
