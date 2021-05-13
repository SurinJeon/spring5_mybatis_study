package spring5_mybatis_study.mapper;

import java.util.ArrayList;
import java.util.Arrays;
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
		map.put("name", "%JAVA%"); // courseName으로 검색

		List<Course> list = mapper.selectCoursesByCondition(map);
		Assert.assertNotNull(list);
		list.stream().forEach(c -> log.debug(c.toString()));

	}

	@Test
	public void test03SelectCoursesByCondition() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");

		GregorianCalendar cal = new GregorianCalendar(2013, 1, 1);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("startDate", cal.getTime()); // startDate로 검색

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
		Assert.assertNotNull(list);
		list.stream().forEach(c -> log.debug(c.toString()));

		map.put("courseName", "%JAVA%");
		list = mapper.selectWhereCourses(map);
		Assert.assertNotNull(list);
		list.stream().forEach(c -> log.debug(c.toString()));

		map.clear();
		map.put("endDate", new Date());
		list = mapper.selectWhereCourses(map);
		Assert.assertNotNull(list);
		list.stream().forEach(c -> log.debug(c.toString()));

	}

	@Test
	public void test06SelectTrimCourses() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");

		Map<String, Object> map = new HashMap<String, Object>();

		List<Course> list = mapper.selectTrimCourses(map);
		Assert.assertNotNull(list);
		list.stream().forEach(c -> log.debug(c.toString()));

		map.put("tutorId", 1);
		list = mapper.selectTrimCourses(map);
		Assert.assertNotNull(list);
		list.stream().forEach(c -> log.debug(c.toString()));

		map.clear();
		map.put("courseName", "%JAVA%");
		list = mapper.selectTrimCourses(map);
		Assert.assertNotNull(list);
		list.stream().forEach(c -> log.debug(c.toString()));

		map.clear();
		map.put("tutorId", 1);
		list = mapper.selectTrimCourses(map);
		Assert.assertNotNull(list);
		list.stream().forEach(c -> log.debug(c.toString()));

	}

	@Test
	public void test07SelectCoursesForeachByTutors() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");

		List<Integer> tutorIds = new ArrayList<Integer>();
		tutorIds.add(1);
		tutorIds.add(2);

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("tutorIds", tutorIds);

		List<Course> list = mapper.selectCoursesForeachByTutors(map);
		Assert.assertNotNull(list);
		list.stream().forEach(c -> log.debug(c.toString()));
	}

	// @Test
	public void test08InsertCourses() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");

		List<Course> tutors = new ArrayList<Course>();
		tutors.add(new Course(4, "mysql", "database", new Date(), new Date(), 3));
		tutors.add(new Course(5, "mysql", "database", new Date(), new Date(), 3));
		tutors.add(new Course(6, "mariaDb", "database", new Date(), new Date(), 4));

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("tutors", tutors);

		int res = mapper.insertCourses(map);
		Assert.assertEquals(3, res);

	}

	// @Test
	public void test10DeleteCourses() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");

		List<Integer> courseIds = Arrays.asList(4, 5, 6);

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("courseIds", courseIds);

		int res = mapper.deleteCourses(map);
		Assert.assertEquals(3, res);

	}

	@Test
	public void test09UpdateSetCourse() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");

		Course course = new Course();
		course.setCourseId(4);
		course.setName("JAVASCRIPT");
		course.setDescription("FrontEnd");
		course.setEndDate(new Date());
		course.setStartDate(new Date());
		course.setTutorId(4);

		int res = mapper.updateSetCourse(course);
		Assert.assertSame(1, res);
	}

}
