package webproject;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cqjtu.edu.db.DatabaseOper;
import com.cqjtu.edu.db.Databaseconnect;
import com.cqjtu.edu.service.*;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.JSONArray;

public class MyclassAsync extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req,resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// 1.接收具体的网址
		String urlPath = req.getParameter("urlPath");
		//String index = req.getParameter("id");
		String chartdata = req.getParameter("chartsdata");
		JSONObject jsob = new JSONObject();
		JSONArray jsay = new JSONArray();
		jsob.put("url", urlPath);
		//jsob.put("index",index);
		jsob.put("chartdata", chartdata);
		jsay.add(jsob);
		System.out.println(jsob);
		System.out.println(jsay);
		
		
		//int id = Integer.parseInt(req.getParameter("id"));
		//通过servlet你可以拿项目的绝对路径
		String filePath = req.getSession().getServletContext().getRealPath("/img/");
		// 2.分析网址的数据装在一个容器中 （服务）
		List<String> datas = GetDataService.getDataFromUrl(urlPath);
		// 3.将容器中的数据放入词云生成库中生成图片（服务）
		String addr = BuildImgService.bulidImg(datas, filePath);
		//4.把地址存入数据库中(服务)
		SimpleDateFormat myFmt = new SimpleDateFormat("yyyy-MM-dd");
		//Boolean  flag = ImgUrlService.saveMsg(id,urlPath,myFmt.format(System.currentTimeMillis()), addr);
		Boolean  flag = ImgUrlService.saveMsg(urlPath,myFmt.format(System.currentTimeMillis()), addr);
		//5.从数据库中获取图片的地址
		String  imgAddr = ImgUrlService.getImgPath();
//		//6 将地址送回到发起请求的页面
		PrintWriter  pw = resp.getWriter();
		//将分词的结果返回
		//pw.write(jsay.toString());
		//将词云生成的图片的路径返回
		pw.write(imgAddr);
		pw.flush();
		pw.close();
		
		
		
		
	}
	
}
