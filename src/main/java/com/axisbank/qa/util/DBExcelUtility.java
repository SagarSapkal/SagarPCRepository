package com.axisbank.qa.util;

import java.util.HashMap;

import com.axisbank.qa.base.BaseClass;
import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;
import com.codoid.products.fillo.Recordset;

public class DBExcelUtility extends BaseClass {

	
	
	public static HashMap<String,String> FilloReadExcelData(String DataSheetpath,String Sheetname,String TestCaseid) throws FilloException {
		 
		 HashMap<String,String> hm=new HashMap<String,String>();
		Fillo fillo = new Fillo();
		 
		Connection connection=fillo.getConnection(DataSheetpath);
		Recordset rs = connection.executeQuery("select * from "+Sheetname).where("TestCaseID="+TestCaseid);
		int ColumnCount=rs.getFieldNames().size();
		
		while( rs.next()){
			  
			for(int i = 0;i<=ColumnCount-1;i++) {
			
				String ColumnName = rs.getFieldNames().get(i);
				String ColumnData = rs.getField(ColumnName);
				hm.put(ColumnName, ColumnData);
						
		    }				 
		}
		rs.close();
		connection.close();
		 return hm; 
		 
		 
		} 
	
}
