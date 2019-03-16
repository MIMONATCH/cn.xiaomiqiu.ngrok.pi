package cn.xiaomiqiu.ngrok.pi.jsoup;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class TestJsoup {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Document doc = Jsoup.connect("https://www.baidu.com/").get();
		Element element = doc.select("a").first();
		System.out.println(element);
		
	}

}
