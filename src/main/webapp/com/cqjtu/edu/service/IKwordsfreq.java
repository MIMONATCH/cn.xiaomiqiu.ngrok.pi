package com.cqjtu.edu.service;

import java.io.IOException;
import java.io.StringReader;
import java.util.HashMap;
import java.util.Map;

import org.wltea.analyzer.core.IKSegmenter;
import org.wltea.analyzer.core.Lexeme;

public class IKwordsfreq {
	
	public  static Map segment(String text) throws IOException {
	        Map<String,Integer> map = new HashMap<String,Integer>();
	        StringReader re = new StringReader(text);
	        //关键代码
	        IKSegmenter ik = new IKSegmenter(re, true);//true 使用smart分词，false使用最小颗粒分词
	        Lexeme lex; 
	        while ((lex = ik.next()) != null) 
	        		{ 
	        		if(lex.getLexemeText().length()>1)
	        			{ 
	        			if(map.containsKey(lex.getLexemeText()))
	        			{ 
	        				map.put(lex.getLexemeText(),map.get(lex.getLexemeText())+1); 
	        			}else
	        			{ 
	        				map.put(lex.getLexemeText(),1); } 
	        			} 
	        		}
	        return map; 
        }
}
