package spring5_mybatis_study.mapper;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

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
import spring5_mybatis_study.dto.Gender;
import spring5_mybatis_study.dto.PhoneNumber;
import spring5_mybatis_study.dto.Student;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ContextRoot.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class StudentMapperTest {

	private static final Log log = LogFactory.getLog(StudentMapperTest.class); // log 찍기위한 설정
	
	@Autowired
	private StudentMapper mapper; // Autowired 했기 때문에 어쩌고저쩌고.getInstance()하던거 안 해도 됨
	
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
		System.out.println();
	}

	@Test
	public void test01SelectStudentById() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()"); // method 이름 출력문
		
		Student student = new Student();
		student.setStudId(1); // id가 1인거 찾기
		Student selectStudent = mapper.selectStudentById(student);
		
		log.debug(selectStudent.toString());
		Assert.assertNotNull(selectStudent);
	}

	@Test
	public void test02selectStudentByIdWithResultMap() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()"); // method 이름 출력문
		
		Student student = new Student();
		student.setStudId(1); // id가 1인거 찾기
		
		Student selectStudent = mapper.selectStudentByIdWithResultMap(student);
		log.debug(selectStudent.toString());
		Assert.assertNotNull(selectStudent);

	}
	
	@Test
	public void test03selectStudentByAll() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()"); // method 이름 출력문
		
		List<Student> list = mapper.selectStudentByAll();
		Assert.assertNotNull(list);
		
		list.stream().forEach(System.out::println);
		System.out.println();
		list.stream().forEach(s -> log.debug(s.toString()));

	}
	
	@Test
	public void test07selectStudentByAllForHashMap() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()"); // method 이름 출력문
		
		List<Map<String, Object>> list = mapper.selectStudentByAllForHashMap();
		
		Assert.assertNotNull(list);
		
		for(Map<String, Object> map :  list) {
			for(Entry<String, Object> e : map.entrySet()) {
				log.debug(String.format("%s -> %s", e.getKey(), e.getValue()));
			}
		}
	}
	
	@Test
	public void test08selectStudentByIdAssociation() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()"); // method 이름 출력문
		
		Student student = new Student();
		student.setStudId(1); // id가 1인거 찾기
		Student selectStudent = mapper.selectStudentByIdAssociation(student);
		
		log.debug(selectStudent.toString());
		Assert.assertNotNull(selectStudent);
	}
	
	@Test
	public void test04insertStudent() {
		Calendar newDate = GregorianCalendar.getInstance();
		newDate.set(1995, 10, 1);
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()"); // method 이름 출력문
		
		Student newStudent = new Student();
		newStudent.setStudId(3);
		newStudent.setName("Surin");
		newStudent.setEmail("jeon@test.co.kr");
		newStudent.setPhone(new PhoneNumber("123-123-1234"));
		newStudent.setDob(newDate.getTime());
		
		int res = mapper.insertStudent(newStudent);
		Assert.assertEquals(1, res);
		
	}

	@Test
	public void test05updateStudent() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()"); // method 이름 출력문

		Student upStudent = new Student();
		upStudent.setStudId(1);
		upStudent.setName("Timothy");
		upStudent.setEmail("timothy@gmail.com");
		upStudent.setPhone(new PhoneNumber("123-123-1234"));
		upStudent.setDob(new GregorianCalendar(1988, 04, 25).getTime());
		
		int res = mapper.updateStudent(upStudent);
		Assert.assertEquals(1, res);

	}

	@Test
	public void test06deleteStudent() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()"); // method 이름 출력문
		
		int res = mapper.deleteStudent(3);
		Assert.assertEquals(1, res);
		
	}
	
	@Test
	public void test09inseretEnumStudent() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()"); // method 이름 출력문
		
		Calendar newDate = GregorianCalendar.getInstance();
		newDate.set(1990, 2, 28);
		Student student = new Student();
		student.setStudId(3);
		student.setName("test");
		student.setEmail("test@test.co.kr");
		student.setDob(newDate.getTime());
		student.setPhone(new PhoneNumber("010-1234-1234"));
		student.setGender(Gender.FEMALE);
		
		int res = mapper.insertEnumStudent(student);
		Assert.assertEquals(1, res);
		
		student.setStudId(4);
		student.setName("test4");
		student.setEmail("test4@test.co.kr");
		student.setDob(newDate.getTime());
		student.setPhone(new PhoneNumber("010-1234-1234"));
		student.setGender(Gender.MALE);
		
		int res1 = mapper.insertEnumStudent(student);
		Assert.assertEquals(1, res);
		
		mapper.deleteStudent(3);
		mapper.deleteStudent(4);

	}

	@Test
	public void test10SelectStudentByMap() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		
		Map<String, String> maps = new HashMap<String, String>();
		
		maps.put("name", "Timothy");
		maps.put("email", "timothy@gmail.com");
		
		Student student = mapper.selectStudentByMap(maps);
		
		Assert.assertNotNull(student);
		log.debug(student.toString());
		
		/* 하나씩 지워보기 */
		maps.remove("email");
		student = mapper.selectStudentByMap(maps);
		log.debug(student.toString());
		
		maps.clear();
		maps.put("email", "timothy@gmail.com");
		student = mapper.selectStudentByMap(maps);
		log.debug(student.toString());
	}
	
	@Test
	public void test11selectAllStudentByMap() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		
		Map<String, String> maps = new HashMap<String, String>();
		
		maps.put("name", "Timothy");
		maps.put("email", "timothy@gmail.com");
		
		List<Student> list = mapper.selectAllStudentByMap(maps);
		
		Assert.assertNotNull(list);
		list.stream().forEach(s -> log.debug(s.toString()));
		
		/* 하나씩 지워보기 */
		maps.remove("email");
		list = mapper.selectAllStudentByMap(maps);
		list.stream().forEach(s -> log.debug(s.toString()));
		
		maps.clear();
		maps.put("email", "timothy@gmail.com");
		list = mapper.selectAllStudentByMap(maps);
		list.stream().forEach(s -> log.debug(s.toString()));
		
		maps.clear();
		list = mapper.selectAllStudentByMap(maps);
		list.stream().forEach(s -> log.debug(s.toString()));
	}
	
	@Test
	public void test11updateSetStudent() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		Student student = new Student();
		student.setStudId(1);
		student.setPhone(new PhoneNumber("654-987-3214"));
		student.setDob(new Date());
		
		int res = mapper.updateSetStudent(student);
		Assert.assertEquals(1, res);
		
		student.setPhone(new PhoneNumber("123-123-1234"));
		student.setDob(new GregorianCalendar(1988, 04, 25).getTime());
		
		res = mapper.updateSetStudent(student);
		Assert.assertEquals(1, res);
	}
}
