package com.ssi.jdbc.programs;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class FatchByid {
	public void fatch(int eno) throws SQLException {
		
		Connection con = DBUtil.getConnection();
		if(con!=null) {
			System.out.println("connection is taken");
			
		}
		
		Statement st = con.createStatement();
		
		String data= String.format("select * from employee where eno=%d",eno);
		
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
		FatchByid fid= new FatchByid();
		fid.fatch(1);
	}
}
