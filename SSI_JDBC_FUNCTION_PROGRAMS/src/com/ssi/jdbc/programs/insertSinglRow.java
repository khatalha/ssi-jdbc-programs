package com.ssi.jdbc.programs;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;



public class insertSinglRow {
	
	public void  addRow(int eno,String ename, double esal, String eadd) throws SQLException {
		Connection con = DBUtil.getConnection();
		if(con != null) {
			System.out.println("Connection is taken");
			
		}
		
		Statement st = (Statement) con.createStatement();
		
		String qurey = String.format("insert into employee values(%d,'%s',%f,'%s')", eno,ename,esal,eadd);
		
		int add= st.executeUpdate(qurey);
		
		System.out.println("row inserted"+ add);
		
		
		
		try {
			con.close();
			
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}
		
	public static void main(String[] args) throws SQLException {
		insertSinglRow inr = new insertSinglRow();
		inr.addRow(4, "Usman", 50, "hyd");
	}	
}


