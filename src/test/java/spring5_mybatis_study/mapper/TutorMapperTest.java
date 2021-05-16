package spring5_mybatis_study.mapper;

import java.util.List;

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
import spring5_mybatis_study.dto.Address;
import spring5_mybatis_study.dto.Course;
import spring5_mybatis_study.dto.PhoneNumber;
import spring5_mybatis_study.dto.Tutor;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ContextRoot.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TutorMapperTest {

	private static final Log log = LogFactory.getLog(TutorMapperTest.class); // log 찍기위한 설정
	
	@Autowired
	private TutorMapper mapper;
	
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
	public void test01SelectTutorByTutorId() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		
		Tutor findTutor = new Tutor();
		findTutor.setTutorId(1);
		
		Tutor tutor = mapper.selectTutorByTutorId(findTutor);
		Assert.assertEquals(tutor.getTutorId(), findTutor.getTutorId());
		
		log.trace(tutor.getTutorId() + " : " + tutor.getName());
		List<Course> list = tutor.getCourses();
		Assert.assertNotNull(list);
		list.stream().forEach(t->log.debug(t.toString()));
		
	}
	
	@Test
	public void test02InsertTutorAndDeleteTutor() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		
		Address address = new Address();
		address.setAddrId(2);
		PhoneNumber phone = new PhoneNumber("010-2222-2222");
		Tutor tutor = new Tutor(5, "mskim", "net94@naver.com", phone, address);
		int res = mapper.insertTutor(tutor); // tutor 추가함
		
		Tutor findTutor = mapper.selectTutorById(tutor);
		log.debug(findTutor.toString());
		
		res += mapper.deleteTutor(tutor.getTutorId());
		
		Assert.assertEquals(2, res);
	}

}
