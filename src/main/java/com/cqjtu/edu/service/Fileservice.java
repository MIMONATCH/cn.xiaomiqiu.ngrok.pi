package com.cqjtu.edu.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Fileservice {

	public static StringBuffer readfile(InputStream in) {
		String s;
		InputStreamReader  r = new InputStreamReader(in);
		BufferedReader  bf = new BufferedReader(r);
		 StringBuffer sb = new StringBuffer();
	        try {
				while((s=bf.readLine()) != null){
				    sb.append(s);
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        
	    return sb;
	}
	
}
