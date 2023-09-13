package com.ezen.mybatis;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MainClass {
	
	public static void main(String[] args) {
		
		String resource = "com/ezen/mybatis/mybatis-config.xml";
							// 세션 생성 위해 내가 접속하고자하는 url, id, pass 필요함, 그게 resource 안에 있는것
		InputStream inputStream = null;
		SqlSession session = null;
		
		try {
			inputStream = Resources.getResourceAsStream(resource);
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);			
			System.out.println("sqlSessionFactory : " + sqlSessionFactory);

			session = sqlSessionFactory.openSession();
			System.out.println("session : " + session);
		
			BlogMapper mapper = session.getMapper(BlogMapper.class);
			// BlogMapper에 가서 메소드만 다 긁어온 것 
			System.out.println("mapper : " + mapper);
			
//			TestVO vo = mapper.selectOne(3);
//			System.out.println(vo);
			
		
//			TestVO vo = new TestVO();
//			vo.setName("김니니");
//			vo.setPhone("010-1111-1234");
//			vo.setAddress("수원시 어딘가");
//			vo.setId(1);
//			mapper.updateTest(vo);

			mapper.deleteTest(3);
			session.commit();
		
			List<TestVO> list = mapper.selectAllList();
			for(TestVO vo2 : list)
				System.out.println(vo2);
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
