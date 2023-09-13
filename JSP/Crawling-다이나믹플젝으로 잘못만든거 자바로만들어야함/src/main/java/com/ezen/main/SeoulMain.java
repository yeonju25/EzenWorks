package com.ezen.main;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class SeoulMain {

	public static void main(String[] args) {
		
		SeoulMain sm = new SeoulMain();
		sm.SeoulHotel();
		
	}
	
	public void SeoulHotel() {
		
		try {
			
			int k = 1;
			for(int i=1; i<48; i++) {
				//jsoup에 있는 Document 써야함
				Document doc = Jsoup.connect("https://korean.visitseoul.net/hotels?curPage="+i).get();
				System.out.println(doc);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
