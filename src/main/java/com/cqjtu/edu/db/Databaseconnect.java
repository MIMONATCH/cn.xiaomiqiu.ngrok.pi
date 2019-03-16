package com.cqjtu.edu.db;

import java.sql.*;

public class Databaseconnect {
	//璁剧疆鏁版嵁搴撹繛鎺ョ殑DBurl,name,passwd
	public static String DBUrl = "jdbc:mysql://localhost:3306/webproject";
	public static String user = "root";
	public static String passwd = "ufo8232293";
	//mysql楂樼増鏈殑椹卞姩
	public static String drivername = "com.mysql.cj.jdbc.Driver";
	//mysql浣庣増鏈殑椹卞姩鍚�
	public static String driver = "org.gjt.mm.mysql.Driver";
	
	public static Connection getCon() {
		Connection con = null;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(DBUrl, user, passwd);
			System.out.println("鏁版嵁搴撹繛鎺ユ垚鍔�");
		}catch(Exception e) {
			System.out.println("鏁版嵁搴撹繛鎺ュけ璐�");
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
