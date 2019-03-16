package webproject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.cqjtu.edu.service.Fileservice;
import com.cqjtu.edu.service.IKwordsfreq;
import com.cqjtu.edu.service.SaveKeyandContentService;

@MultipartConfig
public class Unloadcontrol extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.setCharacterEncoding("utf-8");
		String key = req.getParameter("skey");
		Part pt = req.getPart("filename");
		//文件的上下文都被封装到part对象中
		//req.getPart 单个   
		InputStream  in = pt.getInputStream();
		InputStreamReader  ir   = new InputStreamReader(in);
		BufferedReader  bf = new BufferedReader(ir);
		//System.out.println(key);
		//System.out.println(bf.readLine());
		//1.读取文件的内容
		
	    //2.存入关键字和内容到数据库中
		
		//1.
		StringBuffer strbuf = Fileservice.readfile(in);
		//2.
		SaveKeyandContentService.saveMsg(key, strbuf.toString());
		//IK分词
		//System.out.println("str.toString的结果："+strbuf.toString());
		Map<String, Integer> map = IKwordsfreq.segment(strbuf.toString());
		System.out.println(map);
		
		//同步数据的传递
		req.setAttribute("msg","录入成功");
		req.getRequestDispatcher("/iframejsp/b.jsp").forward(req, resp);//这里的jsp时临时引入的一个文件
	}
}
