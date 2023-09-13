package com.ezen.prj;

import java.util.List;

public class MainClass {
	public static void main(String[] args) {
		TestDAO tDao = TestDAO.getInstance();
		
		List<TestVO> list = tDao.selectAllTest();
		
		for(TestVO vo : list) {
			System.out.println(vo);
		}
		
		TestVO vo = new TestVO();
		vo.setName("김허허");
		vo.setPhone("010-2222-1234");
		vo.setAddress("수원시 팔달구");
	
		int result = tDao.insertTest(vo);
		
		if(result == 1) {
			System.out.println("Insert 성공");
		}else {
			System.out.println("Insert 실패");
		}
		
	}
}

