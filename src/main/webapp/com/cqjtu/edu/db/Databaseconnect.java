package com.cqjtu.edu.db;

import java.sql.*;

public class Databaseconnect {
	//设置数据库连接的DBurl,name,passwd
	public static String DBUrl = "jdbc:mysql://localhost:3306/webproject";
	public static String user = "root";
	public static String passwd = "ufo8232293";
	//mysql高版本的驱动
	public static String drivername = "com.mysql.cj.jdbc.Driver";
	//mysql低版本的驱动名
	public static String driver = "org.gjt.mm.mysql.Driver";
	
	public static Connection getCon() {
		Connection con = null;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(DBUrl, user, passwd);
			System.out.println("数据库连接成功");
		}catch(Exception e) {
			System.out.println("数据库连接失败");
		}
		return con;
	}
	public static void closeCon(Connection conn) {
		try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
