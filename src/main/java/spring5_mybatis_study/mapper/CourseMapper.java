package spring5_mybatis_study.mapper;

import java.util.List;
import java.util.Map;

import spring5_mybatis_study.dto.Course;

public interface CourseMapper {
	// if문
	List<Course> selectCoursesByCondition(Map<String, Object> map);
	
	// choose문
	List<Course> selectCaseCourses(Map<String, Object> map); 
	
	// where문
	List<Course> selectWhereCourses(Map<String, Object> map);
}
