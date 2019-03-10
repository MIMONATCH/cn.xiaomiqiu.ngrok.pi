package com.cqjtu.edu.service;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.cqjtu.edu.db.Databaseconnect;

public class SaveKeyandContentService {

	public static void saveMsg(String key, String string) {
		// TODO Auto-generated method stub
		try {
			String  sql  =  "insert into c_tables(ckey,content) values (?,?)";
			Connection con = Databaseconnect.getCon();
			PreparedStatement  pst = con.prepareStatement(sql);
			pst.setString(1, key);
			pst.setString(2,string);
			int i  = pst.executeUpdate();
			pst.close();
			Databaseconnect.closeCon(con);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
