package spring5_mybatis_study.mapper;

import static org.junit.Assert.fail;

import java.util.List;

import org.apache.ibatis.logging.Log;
import org.apache.ibatis.logging.LogFactory;
import org.junit.After;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import spring5_mybatis_study.config.ContextRoot;
import spring5_mybatis_study.dto.CourseStat;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ContextRoot.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CourseStatMapperTest {

	private static final Log log = LogFactory.getLog(CourseStatMapperTest.class); // log 찍기위한 설정
	
	@Autowired
	private CourseStatMapper mapper;

	@After
	public void tearDown() throws Exception {
		System.out.println();
	}

	@Test
	public void testGetCourseCountByTutor() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		
		CourseStat stat = mapper.getCourseCountByTutor(1);
		Assert.assertNotNull(stat);
		
		log.debug(stat.toString());
	}

	@Test
	public void testGetCourseCount() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		
		List<CourseStat> list = mapper.getCourseCount();
		Assert.assertNotNull(list);
		
		list.forEach(c -> log.debug(c.toString()));
	}

}
