package spring5_mybatis_study.mapper;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.logging.Log;
import org.apache.ibatis.logging.LogFactory;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import spring5_mybatis_study.config.ContextRoot;
import spring5_mybatis_study.dto.Course;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ContextRoot.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CourseMapperTest {

	private static final Log log = LogFactory.getLog(StudentMapperTest.class); // log 찍기위한 설정
	
	@Autowired
	private CourseMapper mapper;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test01SelectCoursesByCondition() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()"); 
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("tutorId", 1); // tutor로 검색
		
		List<Course> list = mapper.selectCoursesByCondition(map);
		Assert.assertNotNull(list);
		list.stream().forEach(c -> log.debug(c.toString()));
		
	}
	
	@Test
	public void test02SelectCoursesByCondition() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()"); 
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("name", "%JAVA%");
		
		List<Course> list = mapper.selectCoursesByCondition(map);
		Assert.assertNotNull(list);
		list.stream().forEach(c -> log.debug(c.toString()));
		
	}
	
	@Test
	public void test03SelectCoursesByCondition() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()"); 
		
		GregorianCalendar cal = new GregorianCalendar(2013, 1, 1);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("startDate", cal.getTime()); 
		
		List<Course> list = mapper.selectCoursesByCondition(map);
		Assert.assertNotNull(list);
		list.stream().forEach(c -> log.debug(c.toString()));
		
	}

	@Test
	public void test04SelectCaseCourses() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()"); 
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("searchBy", "Tutor");
		map.put("tutorId", 1);
		
		List<Course> list = mapper.selectCaseCourses(map);
		Assert.assertNotNull(list);
		list.stream().forEach(c -> log.debug(c.toString()));
		
		map.replace("searchBy", "CourseName");
		map.remove("tutorId");
		map.put("courseName", "%JAVA%");
		list = mapper.selectCaseCourses(map);
		
		Assert.assertNotNull(list);
		list.stream().forEach(c -> log.debug(c.toString()));
	
	}
	
	@Test
	public void test05SelectWhereCourses() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()"); 
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		List<Course> list = mapper.selectWhereCourses(map);
		Assert.assertNotNull(list);
		list.stream().forEach(c -> log.debug(c.toString()));
		
		map.put("tutorId", 1);
		list = mapper.selectWhereCourses(map);
		list.stream().forEach(c -> log.debug(c.toString()));
		
		map.put("courseName", "%JAVA%");
		list = mapper.selectWhereCourses(map);
		list.stream().forEach(c -> log.debug(c.toString()));
		
		map.clear();
		map.put("endDate", new Date());
		list = mapper.selectWhereCourses(map);
		list.stream().forEach(c -> log.debug(c.toString()));
	
	}

}





























