package spring5_mybatis_study.mapper;

import java.util.List;
import java.util.Map;

import spring5_mybatis_study.dto.Course;

public interface CourseMapper {
	List<Course> selectCoursesByCondition(Map<String, Object> map);
}
