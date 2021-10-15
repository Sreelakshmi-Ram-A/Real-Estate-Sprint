package com.appname.pages;

import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class REUserRegisterXML {

	public FileInputStream fis = null;
    public XSSFWorkbook workbook = null;
    public XSSFSheet sheet = null;
    public XSSFRow row = null;
    public XSSFCell cell = null;
 
    public REUserRegisterXML(String xlFilePath) throws Exception
    {
        fis = new FileInputStream(xlFilePath);
        workbook = new XSSFWorkbook(fis);
        fis.close();
    }
    	
 // returns number of  rows in a sheet
    public int getRowCount(String sheetName)
    {
     int index = workbook.getSheetIndex(sheetName);
     if(index==-1)
      return 0;
     else
     {
     sheet = workbook.getSheetAt(index);
     int number=sheet.getLastRowNum()+1;
     return number;
     }
    
    }
    public int getColumnCount(String sheetName)
    {
     // check if sheet exists
     if(!isSheetExist(sheetName))
      return -1;
    
     sheet = workbook.getSheet(sheetName);
     row = sheet.getRow(0);
    
     if(row==null)
      return -1;
    
     return row.getLastCellNum();
    }
           // find whether sheets exists
    public boolean isSheetExist(String sheetName)
    {
     int index = workbook.getSheetIndex(sheetName);
     if(index==-1){
      index=workbook.getSheetIndex(sheetName.toUpperCase());
       if(index==-1)
        return false;
       else
        return true;
     }
     else
      return true;
    }
       
    public String getCellData(String sheetName,int colNum,int rowNum)
    {
        try
        {
            sheet = workbook.getSheet(sheetName);
            row = sheet.getRow(rowNum);
            cell = row.getCell(colNum);
                return cell.getStringCellValue();
            }
        catch(Exception e)
        {
            e.printStackTrace();
            return "row "+rowNum+" or column "+colNum +" does not exist  in Excel";
        }
    }
}
