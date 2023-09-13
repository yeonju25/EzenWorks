package com.ezen.main;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.ezen.dao.DataDAO;
import com.ezen.dao.SeoulHotelVO;

public class SeoulMain {

	public static void main(String[] args) {
		
		SeoulMain sm = new SeoulMain();
//		sm.SeoulHotel();
		sm.SeoulNature();
	}
	
	public void SeoulHotel() {
		
		DataDAO dao = new DataDAO();
		
		try {
			
			int k = 1;
			for(int i=1; i<=48; i++) {
				//jsoup에 있는 Document 써야함
				Document doc = Jsoup.connect("https://korean.visitseoul.net/hotels?curPage="+i).get();
				Elements poster =  doc.select("ul.article-list li.item div.thumb img");
				Elements link = doc.select("ul.article-list li.item a");
				Elements title = doc.select("ul.article-list li.item div.infor-element span.title");
				Elements score = doc.select("ul.article-list li.item div.infor-element span.trip-ico span.trip-text");
				
				for(int j=0; j<poster.size(); j++) {
					try {
						System.out.println("번호 : " + k);
//						System.out.println("title : " + title.get(j).text());
//						System.out.println("poster : " + poster.get(j).attr("src"));
//						System.out.println("link : " + link.get(j).attr("href"));
//						System.out.println("score : " + score.get(j).text());
						
						//호텔 클릭했을때 나오는 상세페이지
						Document doc2 = Jsoup.connect("https://korean.visitseoul.net"+link.get(j).attr("href")).get();
//						System.out.println(doc2);
						
						// 호텔 주소
						Element address = doc2.select("div.addaress-element dl dd").get(0); 
//						System.out.println("주소 : " + address.text()); 
						// 호텔 내부 사진 이미지
						Elements images = doc2.select("div.wide-slide div.item");
						
						String simg = "";
						for(int m=0; m<images.size(); m++) {
							String temp = images.get(m).attr("style");
							
							temp = temp.substring(temp.indexOf("(")+1, temp.lastIndexOf(")"));
							simg += temp+"^";
						}
						
						simg = simg.substring(0, simg.lastIndexOf("^"));
						
						System.out.println("------------------------------");
						
						SeoulHotelVO vo = new SeoulHotelVO();
						vo.setNo(k);
						vo.setName(title.get(j).text());
						vo.setAddress(address.text());
						vo.setPoster(poster.get(j).attr("src"));
//						vo.setScore(score.get(j).text()); // HotelVO에 스코어 String 타입일때						
						
						int num = Integer.parseInt(score.get(j).text().substring(0, score.get(j).text().indexOf(" ")));
						vo.setScore(num);						
						vo.setImages(simg);
						
						dao.seoulHotelInsert(vo);
						k++;
						
					}catch(Exception e) {
						e.printStackTrace();
					}
				}
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void SeoulNature() {
		DataDAO dao = new DataDAO();
		
		try {
			int k = 1;
			for(int i=1; i<=1; i++) {
				Document doc = Jsoup.connect("https://korean.visitseoul.net/nature?curPage="+i).get();
				Elements poster = doc.select("ul.article-list li.item div.thumb");
				Elements title = doc.select("ul.article-list li.item div.infor-element span.title");
//				System.out.println(poster +"///"+title);
				Elements description = doc.select("ul.article-list li.item div.infor-element span.small-text");
//				System.out.println(description.text());
				Elements link = doc.select("ul.article-list li.item a");
//				System.out.println(link.get(i).attr("href"));	///nature/한강/KOP015060
				
				for(int j=0; j<poster.size(); j++) {
					try {
						System.out.println("번호:" +k);
						
						//상세페이지
						Document doc2 = Jsoup.connect("https://korean.visitseoul.net"+link.get(j).attr("href")).get();
						
						// 전화번호
						Elements tel = doc2.select("div.detial-cont-element div.detail-map-infor dl dd");
//						System.out.println(tel);
	
						// 주소
						Elements address = doc2.select("div.detail-map-wrap div.detail-map-infor dl dd");
						System.out.println(address.text());
						
						
						
						
						
						
					}catch(Exception e) {
						e.printStackTrace();
					}
				}
					
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
	}
}