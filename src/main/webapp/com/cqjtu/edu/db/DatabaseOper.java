package com.cqjtu.edu.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DatabaseOper {
	//增加数据
	public void insertdata(String s) {
		Connection con = Databaseconnect.getCon();
		String sql = "insert into testtable values(?)";
		try {
			//System.out.println("insert:"+s);
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, s);
			pst.executeUpdate();
			pst.close();
			con.close();
		}catch(Exception e) {
			
		}
	}
	
	//删除数据
	public void deletedata(String s) {
		Connection con = Databaseconnect.getCon();
		String sql = "delete * from testtable where testname=?";
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, s);
			pst.executeUpdate();
			pst.close();
			con.close();
		}catch(Exception e) {
			
		}
	}
	
	//更新数据
	public void updatedata(String s, String info) {
		Connection con = Databaseconnect.getCon();
		String sql = "update testtable set testname=? where testname=?";
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, s);
			pst.setString(2, info);
			pst.executeUpdate();
			pst.close();
			con.close();
		}catch(Exception e) {
			
		}
	}
	
	//查询数据
	public String selectdata() {
		Connection con = Databaseconnect.getCon();
		String sql = "select * from testtable";
		String s = null;
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			ResultSet r = pst.executeQuery();
			r.next();
			s = r.getString("testname");
			//System.out.println("select:"+s);
			pst.close();
			con.close();
		}catch(Exception e) {
			
		}
		return s;
	} 
	
}
