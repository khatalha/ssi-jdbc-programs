package com.ssi.jdbc.pro;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.ssi.jdbc.programs.DBUtil;

public class insertrow {
	
	public void  addRow(int eno,String ename, double esal, String eadd) throws SQLException {
		Connection con = DBUtil.getConnection();
		if(con != null) {
			System.out.println("Connection is taken");
			
		}
		
		String query = "insert into employee values(?,?,?,?)";
		PreparedStatement pst = con.prepareStatement(query);
		
//		Scanner sc = new Scanner(System.in);
		
//		while(true) {
//			System.out.println("Enter Employee number");
//			int eno = sc.nextInt();
//			
//			System.out.println("Enter Employee name");
//			String ename = sc.next();
//			
//			System.out.println("Enter Employee salary");
//			double esal = sc.nextDouble();
//			
//			System.out.println("Enter Employee address");
//			String eadd = sc.next();
			
			pst.setInt(1, eno);
			pst.setString(2,ename);
			pst.setDouble(3, esal);
			pst.setString(4, eadd);
			pst.executeUpdate();
			System.out.println("row inserted");
			
			try {
				con.close();
				
			}
			catch(Exception e) {
				System.out.println(e);
			}
			
			
		}
	public static void main(String[] args) throws SQLException {
		insertrow ins = new insertrow();
		ins.addRow(17, "khan", 30, "hyd");
	}
}
