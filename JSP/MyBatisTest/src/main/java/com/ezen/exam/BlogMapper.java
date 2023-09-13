package com.ezen.exam;

import java.util.List;

public interface BlogMapper {

	public List<TestVO> selectAllList();
	
	public int insertTest(TestVO vo);
	
	public int updateTest(TestVO vo);
	
	public int deleteTest(int id);
	

}
