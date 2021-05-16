package spring5_mybatis_study.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import spring5_mybatis_study.dto.Course;
import spring5_mybatis_study.dto.Tutor;
import spring5_mybatis_study.mapper.CourseMapper;
import spring5_mybatis_study.mapper.TutorMapper;

@Service
public class TutorAndCourseService {
	@Autowired
	private TutorMapper tMapper;
	
	@Autowired
	private CourseMapper cMapper;
	
	// 외래키 조건때문에 순서는 insert랑 delete 다름
	@Transactional
	public void trJoinTutorAndCourse(Tutor tutor, Course course) {
		int res = tMapper.insertTutor(tutor);
		res += cMapper.insertCourse(course);
		if(res != 2) throw new RuntimeException();
	}
	
	@Transactional
	public void trRemoveTutorAndCourse(int tutorId, int courseId) {
		int res = cMapper.deleteCourse(courseId);
		res += tMapper.deleteTutor(tutorId);
		if(res != 2) throw new RuntimeException();
	}
}
