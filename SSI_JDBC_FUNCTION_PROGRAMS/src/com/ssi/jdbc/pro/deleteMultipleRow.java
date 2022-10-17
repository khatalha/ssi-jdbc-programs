package com.ssi.jdbc.pro;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.ssi.jdbc.programs.DBUtil;

public class deleteMultipleRow {
	
	public void deletefun(int eno) throws SQLException {
		Connection con = DBUtil.getConnection();
		if(con!=null) {
			System.out.println("Conn is taken");
		}
	
		String dl=String.format("delete from employee where eno=? ");
		PreparedStatement pst = con.prepareStatement(dl);
		
		pst.setInt(1, eno);
		
		int dt= pst.executeUpdate();
		
		System.out.println("rows deleted"+dt);
		
		try { 
			con.close();
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}

	public static void main(String[] args) throws SQLException {
		
		deleteMultipleRow mdl= new deleteMultipleRow();
		mdl.deletefun(4);
		
		
		
		


	}

}
