package com.ezen.exam;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MainClass {
	
	public static void main(String[] args) {
		String resource = "com/ezen/exam/mybatis-config.xml";
		InputStream inputStream = null;
		SqlSessionFactory sqlSessionFactory = null;
		SqlSession session = null;
		
		try {
			inputStream = Resources.getResourceAsStream(resource);
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			System.out.println("sqlse : " + sqlSessionFactory);
			
			session = sqlSessionFactory.openSession();
			System.out.println("session : " + session);
			
			BlogMapper mapper = session.getMapper(BlogMapper.class);
			System.out.println("mapper :" + mapper);
			
			// select
//			List<TestVO> list = new ArrayList<>();
//			list = mapper.selectAllList();
//			for(TestVO vo : list)
//				System.out.println(vo);
			
			// insert
//			TestVO vo1 = new TestVO();
//			vo1.setName("김미미");
//			vo1.setPhone("010-1234-5555");
//			vo1.setAddress("수원시 어딘가");
//			int result = mapper.insertTest(vo1);
//			session.commit();
//			if(result == 1)
//				System.out.println("저장");
			
			// update
//			TestVO vo2 = new TestVO();
//			vo2.setName("김모모");
//			vo2.setPhone("010-1234-5555");
//			vo2.setAddress("수원시");
//			vo2.setId(2);
//			int result = mapper.updateTest(vo2);
//			session.commit();
//			if(result == 1)
//				System.out.println("업데이트");
			
			// delete
			int result = mapper.deleteTest(4);
			session.commit();
			if(result == 1)
				System.out.println("삭제");
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}
