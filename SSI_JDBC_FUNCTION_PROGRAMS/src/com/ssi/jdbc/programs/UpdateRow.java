package com.ssi.jdbc.programs;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;


public class UpdateRow {
	
	public void updateFun(double increment,double decrement) throws SQLException {
		
		Connection con = DBUtil.getConnection();
		if(con != null) {
			System.out.println("Connection is taken");
			
		}
		Scanner sc = new Scanner(System.in);
		
		Statement st = (Statement) con.createStatement();
		
//		System.out.println("Enter the increment salary");
//		double increment = sc.nextDouble();
		
//		System.out.println("Enter the salary");
//		double decrement = sc.nextDouble();
//		
		String qurey = String.format("update employee set esal=esal+%f where esal=%f",increment,decrement);
		
		int up= st.executeUpdate(qurey);
		
		System.out.println("row effected"+ up);
		
		
		
		try {
			con.close();
			
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}

	public static void main(String[] args) throws SQLException {
		UpdateRow up= new UpdateRow();
		up.updateFun(500, 5000);
	}
}
