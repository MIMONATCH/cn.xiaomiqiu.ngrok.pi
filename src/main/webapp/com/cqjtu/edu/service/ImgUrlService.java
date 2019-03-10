package com.cqjtu.edu.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.cqjtu.edu.db.*;

public class ImgUrlService {
	  /**
	   * 将图片的地址存入到数据库中
	   * @param url  分析的网址
	   * @param time  时间
	   * @param imgPath  图片的路径
	   * @return  是否成功
	   */
	  public  static boolean saveMsg(String url,String time,String imgPath){
		  
		  boolean flag = false;
		  try {
			String  sql  =  "insert into x_tables(xurl,xtime,xpath) values (?,?,?)";
			Connection  con = Databaseconnect.getCon();
			PreparedStatement  pst = con.prepareStatement(sql);
			pst.setString(1, url);
			pst.setString(2,time);
			pst.setString(3, imgPath);
			int i  = pst.executeUpdate();
			if(i>0){
				flag = true;
			}
			pst.close();
			Databaseconnect.closeCon(con);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  
		  
		  
		  return flag;
	  }
	  
		/**
		 * 从数据库中获取图片的地址
		 * @return
		 */
	  public static  String  getImgPath(){
		   String s = "";
		   try {
				String  sql  =  "select xpath from x_tables ORDER BY xid  desc  LIMIT 1";
				Connection  con = Databaseconnect.getCon();
				PreparedStatement  pst = con.prepareStatement(sql);
				ResultSet rs = pst.executeQuery();
				if (rs.next()) {
					s  = rs.getString("xpath");
				}
				pst.close();
				Databaseconnect.closeCon(con);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		   
		   return s ;
	  }
}

