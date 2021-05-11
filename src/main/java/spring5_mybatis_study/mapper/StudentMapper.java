package spring5_mybatis_study.mapper;

import java.util.List;
import java.util.Map;

import spring5_mybatis_study.dto.Student;

public interface StudentMapper {
	// select
	Student selectStudentById(Student student);
	Student selectStudentByIdWithResultMap(Student student);
	List<Student> selectStudentByAll();
	/* Result - HashMap */
	List<Map<String, Object>> selectStudentByAllForHashMap();
	
	
	// insert
	int insertStudent(Student student);
	
	// delete
	int deleteStudent(int id);
	
	// update
	int updateStudent(Student student);
	
	
}
