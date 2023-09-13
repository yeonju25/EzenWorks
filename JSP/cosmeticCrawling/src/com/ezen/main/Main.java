package com.ezen.main;

import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import com.ezen.dao.ProductDAO;
import com.ezen.dao.ProductVO;




public class Main {

	public static void main(String[] args) {
		Main m = new Main();
//		List<ProductVO> list = m.Product();
//		System.out.println(list.toString());
		m.Product();
	}
	


	public List<ProductVO> fruit() {
		List<ProductVO> list = new ArrayList<ProductVO>();
		try {
			int k = 1;
			for(int i=1; i<=1; i++) {
				Document doc = Jsoup.connect("https://eloasis.co.kr/category/%EC%A0%84%EC%B2%B4%EC%83%81%ED%92%88/56/").get();
				Elements images = doc.select("li.title");
				System.out.println(images.text());

			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return list;
		
	}		

	public List<ProductVO> Product() {
		List<ProductVO> list = new ArrayList<ProductVO>();
		try {
			int k = 1;
			for(int i=1; i<=1; i++) {
				Document doc = Jsoup.connect("http://www.theskinfood.com/shop/shopbrand.html?type=P&xcode=019&sort=&page="+i).get();
				Elements images = doc.select("img.MS_prod_img_l");
				Elements name = doc.select("span.goods_name");
				Elements price = doc.select("span.sale_price");
				Elements link = doc.select("ul.goodsDisplayTextWrap li a");
				
				
				
				for(int j=0; j<images.size(); j++) {
					try {
//						System.out.println("번호 : " + k);
//						System.out.println("images : "	+ images.get(j).attr("src"));
//						System.out.println("name : " + name.get(j).text());
//						System.out.println("price : " + price.get(j).text());
						
						//System.out.println(link.get(j).attr("href"));
						Document doc2 = Jsoup.connect("http://www.theskinfood.com"+link.get(j).attr("href")).get();
						
					
						
						Elements im = doc.select("img.goods_thumbs-img");
//						Elements tag = doc.select("span.product-info__item-content--tag a href");
//						System.out.println(tag.text());
						System.out.println(link.get(j).attr("href"));
						
						
						
						
						
						k++;
						
					}catch(Exception e) {
						e.printStackTrace();
					}
				}
			}
		}catch(Exception e) {
		e.printStackTrace();
		}
		return list;

}		
	
}
