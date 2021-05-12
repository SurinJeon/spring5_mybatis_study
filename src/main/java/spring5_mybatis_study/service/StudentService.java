package spring5_mybatis_study.service;

import java.util.Map;

import spring5_mybatis_study.dto.Student;

public interface StudentService {
	// 이건 handler를 이용하는 방법들임
	Map<Integer, String> selectStudentForMap(int studId); // 아이디를 집어넣으면 그에 해당하는 이름 나옴
	Map<Integer, Student> selectStudentForMap2(int studId); // 아이디 집어넣으면 그에 해당하는 객체 나옴
	
	Map<Integer, Student> selectStudentForMap3();
}
