package com.ssi.jdbc.programs;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class SelectAllRows  {
	
	public void AllRows() throws SQLException {
		
		Connection con = DBUtil.getConnection();
		if(con!=null) {
			System.out.println("connection is taken");
			
		}
		
		Statement st = con.createStatement();
		
		String data= "select * from employee";
		
		ResultSet rs = null;
		try {
			rs = st.executeQuery(data);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		boolean flag= false;
		while(rs.next()) {
			
			flag= true;
			System.out.println(rs.getInt(1));
			System.out.println(rs.getString(2));
			System.out.println(rs.getDouble(3));
			System.out.println(rs.getString(4));
			System.out.println("---------------------");
		}
		
		if(flag==false) {
			System.out.println("no match recored found");
		}
		
		try {
			con.close();
		}
		catch(Exception e) {
			System.out.println(e);
		}
		

	}
	

	public static void main(String[] args) throws SQLException {
		SelectAllRows ar = new SelectAllRows();
		ar.AllRows();

	}

}
