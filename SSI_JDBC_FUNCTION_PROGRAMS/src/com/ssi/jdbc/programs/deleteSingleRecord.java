package com.ssi.jdbc.programs;


import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;


public class deleteSingleRecord {

	public static void main(String[] args) throws SQLException {
		
		Connection con = DBUtil.getConnection();
		if(con!=null) {
			System.out.println("Conn is taken");
		}
		
		Statement st = con.createStatement();
		
		String dl="delete from employee where ename='barkat' ";
		
		int dt= st.executeUpdate(dl);
		
		System.out.println("rows deleted"+dt);
		
		try {
			con.close();
		}
		catch(Exception e) {
			System.out.println(e);
		}

	}

}
