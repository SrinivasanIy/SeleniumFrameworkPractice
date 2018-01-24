package config;

import java.io.File;
import java.io.FileInputStream;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class ReadfromExcelnstoreusingList 
{
	Workbook work=null;
	File file;
	/*XSSFWorkbook xlsxworkbook;
	HSSFWorkbook xlsworkbook;*/
    Sheet sheet;
    Row row;
    Cell cell;
	int rowcount=0; 
	int colcount=0;
	//List list=new List[][];
	
	public void readexcel(String filename, String filepath, String sheetname)
	{
	
		//String filename="Application.xlsx";
	  try
	 {
		int index=filename.indexOf(".");
		String fileextension=filename.substring(index+1);
		System.out.println("File extension is: "+fileextension);	
		
		file=new File(filepath+"\\"+filename);
		
		FileInputStream fileinput=new FileInputStream(file);
		//fileinput.read();
		
		if(fileextension.equalsIgnoreCase("xlsx"))
		{
			work= new XSSFWorkbook(fileinput);
	       // sheet=work.getSheetAt(0);
		}
		else if(fileextension.equalsIgnoreCase("xls"))
		{
			work=new HSSFWorkbook(fileinput);		
		}
		else
		{
			System.out.println("This isnt excel. Provide proper data");			
		}
		
		sheet=work.getSheet(sheetname);
		rowcount=sheet.getLastRowNum();
		row=sheet.getRow(0);
		colcount=row.getLastCellNum();
		
		for(int i=1;i<=rowcount;i++)
		{	
		  System.out.println("Row"+i+":");	
		  for(int j=0;j<colcount;j++)
		  {
			row=sheet.getRow(i);
			cell=row.getCell(j);
			System.out.println(sheet.getRow(0).getCell(j)+": "+cell.toString());			 
		  }
		  System.out.println("\n");
		}	
		
	  }
	  catch(Exception e)
	  {
		System.out.println("Exception caught: "+e);		
	  }	
	  
	}
	
	
	public void writeexcel()
	{
		
	}

	public String getdatafromexcel(String sheetname, int rownumber,int colnumber)
	{
		String str=null;		
		return str;
		
		
		
	}
	
}
