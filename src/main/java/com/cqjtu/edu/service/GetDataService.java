package com.cqjtu.edu.service;


import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class GetDataService {
	/**
	 * 通过url 获取对应a标签的数据  存放在集合中
	 * @param url  对应需要分析的网址
	 * @return  返回对应的数据
	 */
	
	public static List<String> getDataFromUrl(String url){
		List<String>  s = new ArrayList<String>();
 		try {
			Document  doc = Jsoup.connect(url).get();
			Elements  els = doc.select("a");
			for (Element e : els) {
				s.add(e.text());
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return s;
	}
	
	public static List<String> getDatafromSet(Set<String> s){
		List<String> ls = new ArrayList<String>();
		for(String str:s) {
			ls.add(str);
		}
		return ls; 
	}
	
	public static List<Integer> getDataFromCollectio(Collection<Integer> co){
		List<Integer> ls = new ArrayList<Integer>();
		for(Integer str:co) {
			ls.add(str);
		}
		return ls;
	}
	
}
