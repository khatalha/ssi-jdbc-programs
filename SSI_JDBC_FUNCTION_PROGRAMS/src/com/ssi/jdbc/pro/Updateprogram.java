package com.ssi.jdbc.pro;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.ssi.jdbc.programs.DBUtil;

public class Updateprogram {
	
public void updateFun(int eno, String ename,double esal, String eadd) throws SQLException {
		
		Connection con = DBUtil.getConnection();
		if(con != null) {
			System.out.println("Connection is taken");
			
		}
		//Scanner sc = new Scanner(System.in);
		
		
		
//		System.out.println("Enter the increment salary");
//		double increment = sc.nextDouble();
		
//		System.out.println("Enter the salary");
//		double decrement = sc.nextDouble();
//		
		String qurey = String.format("update employee set ename=? , esal=? , eadd=? where eno=?");
		PreparedStatement pst = con.prepareStatement(qurey);
		
		pst.setString(1,ename);
		pst.setDouble(2, esal);
		pst.setString(3, eadd);
		pst.setInt(4, eno);
		
		pst.executeUpdate();
		System.out.println("row Updated");
		
		
		
		try {
			con.close();
			
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}

	public static void main(String[] args) throws SQLException {
		Updateprogram up= new Updateprogram();
		up.updateFun(10, "TK", 10000, "Mumbai");
	}

}
