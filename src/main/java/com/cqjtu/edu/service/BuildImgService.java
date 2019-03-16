package com.cqjtu.edu.service;

import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.kennycason.kumo.CollisionMode;
import com.kennycason.kumo.WordCloud;
import com.kennycason.kumo.WordFrequency;
import com.kennycason.kumo.bg.CircleBackground;
import com.kennycason.kumo.font.KumoFont;
import com.kennycason.kumo.font.scale.SqrtFontScalar;
import com.kennycason.kumo.nlp.FrequencyAnalyzer;
import com.kennycason.kumo.nlp.tokenizers.ChineseWordTokenizer;
import com.kennycason.kumo.palette.LinearGradientColorPalette;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.JSONArray;

public class BuildImgService {
	/**
	 * 利用词云来生成图片
	 * @param content
	 * @param filePath
	 * @return  对应的图片的路径
	 */

	public static String bulidImg(List<String> content, String filePath) {
		// 建立词频分析器，设置词频，以及词语最短长度，此处的参数配置视情况而定即可
		FrequencyAnalyzer frequencyAnalyzer = new FrequencyAnalyzer();
		frequencyAnalyzer.setWordFrequenciesToReturn(600);
		frequencyAnalyzer.setMinWordLength(2);
		// 引入中文解析器
		frequencyAnalyzer.setWordTokenizer(new ChineseWordTokenizer());
		// 指定文本文件路径，生成词频集合
		final List<WordFrequency> wordFrequencyList = frequencyAnalyzer.load(content);
		// for (WordFrequency wordFrequency : wordFrequencyList) {
		// System.out.println(wordFrequency.getWord()+":"+wordFrequency.getFrequency());
		// }
		// 设置图片分辨率
		Dimension dimension = new Dimension(550, 550);
		// 此处的设置采用内置常量即可，生成词云对象
		WordCloud wordCloud = new WordCloud(dimension, CollisionMode.PIXEL_PERFECT);
		// 设置边界及字体
		wordCloud.setPadding(2);
		java.awt.Font font = new java.awt.Font("STSong-Light", 2, 20);
		// 设置词云显示的三种颜色，越靠前设置表示词频越高的词语的颜色
		wordCloud.setColorPalette(new LinearGradientColorPalette(Color.ORANGE, Color.BLUE, Color.YELLOW, 30, 30));
		wordCloud.setKumoFont(new KumoFont(font));
		// 设置背景色
		wordCloud.setBackgroundColor(new Color(0,0,0));
		// 设置背景图片
		// wordCloud.setBackground(new
		// PixelBoundryBackground("E:\\爬虫/google.jpg"));
		// 设置背景图层为圆形
		wordCloud.setBackground(new CircleBackground(255));
		wordCloud.setFontScalar(new SqrtFontScalar(6, 22));
		// 生成词云
		wordCloud.build(wordFrequencyList);
		String timeString = Calendar.getInstance().getTimeInMillis() + ".jpg";
		wordCloud.writeToFile(filePath + timeString);
		return "/webproject/img/" + timeString;
	}
	
	public static Map<String,Integer> getEcharts(List<String> content){
		//new maps to save key:value
		Map<String, Integer> maps = new HashMap<String, Integer>();
		
		FrequencyAnalyzer frequencyAnalyzer = new FrequencyAnalyzer();
		frequencyAnalyzer.setWordFrequenciesToReturn(600);
		frequencyAnalyzer.setMinWordLength(2);
		frequencyAnalyzer.setWordTokenizer(new ChineseWordTokenizer());
		
		//wordFrequency.getWord() Key
		//wordFrequency.getFrequency() value
		final List<WordFrequency> wordFrequencyList = frequencyAnalyzer.load(content);
		 for (WordFrequency wordFrequency : wordFrequencyList) {
			 //System.out.println(wordFrequency.getWord()+":"+wordFrequency.getFrequency());
			 maps.put(wordFrequency.getWord(), wordFrequency.getFrequency());
		 }
		return maps;
	}

}
