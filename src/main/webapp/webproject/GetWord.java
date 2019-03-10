package webproject;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cqjtu.edu.service.BuildImgService;
import com.cqjtu.edu.service.GetDataService;
import com.kennycason.kumo.WordFrequency;
import com.kennycason.kumo.nlp.FrequencyAnalyzer;
import com.kennycason.kumo.nlp.tokenizers.ChineseWordTokenizer;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class GetWord extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String urlPath = req.getParameter("urlpath");
		List<String> datas = GetDataService.getDataFromUrl(urlPath);
		Map<String, Integer> maps = BuildImgService.getEcharts(datas);

		//sort?
		//get keys and values of maps
		Set<String> set = new HashSet<String>();
		set = maps.keySet();
		
//		Set<String> sortset = new TreeSet<String>(new Comparator<String>() {
//			@Override
//			public int compare(String o1, String o2) {
//				// TODO Auto-generated method stub
//				return o2.compareTo(o1);
//			}
//		});
//		sortset.addAll(set);
		
//		List<Integer> li = new ArrayList<Integer>();
//		
//		for(String str:set) {
//			Integer i = maps.get(str);
//			li.add(i);
//		}
		
		Collection<Integer> coll = maps.values();
		
		//change type
		List<String> ls = GetDataService.getDatafromSet(set);
		List<Integer> li = GetDataService.getDataFromCollectio(coll);
		
		JSONArray jsay = new JSONArray();
		JSONObject jsob = new JSONObject();
		jsob.put("keys", ls);
		//jsay.add(jsob);
		jsob.put("values", li);
		//jsay.add(jsob);
		
		//reutrn data
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=UTF-8"); //防止页面出现中文乱码，要放在PrintWriter前面
		PrintWriter pwt = resp.getWriter();
		pwt.print(jsob);
		pwt.flush();
		pwt.close();
		
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, resp);
	}
	
}
