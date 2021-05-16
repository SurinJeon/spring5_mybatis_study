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
	
	// trim
	List<Course> selectTrimCourses(Map<String, Object> map);
	
	// select by foreach loop
	List<Course> selectCoursesForeachByTutors(Map<String, Object> map);
	
	// insert by foreach
	int insertCourses(Map<String, Object> map);
	
	// delete by foreach
	int deleteCourses(Map<String, Object> map);
	
	// update by foreach
	int updateSetCourse(Course course);
	
	// transaction
	int insertCourse(Course course);
	int deleteCourse(int courseId);
	Course selectCourseById(Course course);
}
