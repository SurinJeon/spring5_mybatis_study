package spring5_mybatis_study.mapper;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

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
import spring5_mybatis_study.dto.UserPic;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ContextRoot.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class UserPicMapperTest {

	private static final Log log = LogFactory.getLog(UserPicMapperTest.class);
	
	@Autowired
	private UserPicMapper mapper;
	
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
	public void test01InsertUserPic() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		
		UserPic userPic = new UserPic();
		userPic.setId(2);
		userPic.setName("고민시");
		userPic.setBio("추추가");
		userPic.setPic(getPicFile());
		
		int res = mapper.insertUserPic(userPic);
		Assert.assertSame(1, res);
	}

	private byte[] getPicFile() {
		byte[] pic = null;
										// user.dir은 package까지 접근하는 것임 그 뒤에 세부 폴더 들어감
		File file = new File(System.getProperty("user.dir") + "\\img\\고민시.jpg");
//		System.out.println(file.getPath()); debugging
		
		try (InputStream is = new FileInputStream(file);){
			pic = new byte[is.available()]; // is.available()은 is가 읽어온만큼 공간을 할당함
			is.read(pic); // 이미지 읽어온 바이트 배열을 pic로 넣어줌
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return pic;
	}

	@Test
	public void test02GetUserPic() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		
		UserPic userPic = mapper.getUserPic(2);
		if(userPic.getPic() != null) {
			File file = getPicFile(userPic);
			log.debug("file Path " + file.getAbsolutePath());
		}
		
		Assert.assertNotNull(userPic);
		
	}

	private File getPicFile(UserPic userPic) { // 위의 getPicFile()과 다른 것은 1. parameter, 2. return type
		// UserPic table의 image file을 project folder/pics 경로에 load할 것
		File pics = new File(System.getProperty("user.dir") + "\\pics\\");
		if(!pics.exists()) {
			pics.mkdir(); // 없으면 일단 폴더를 만들어라
		}
		
		File file = new File(pics, userPic.getName() + ".jpg"); // user의 이름으로 이미지 불러옴 (확장자는 상황에 맞게 바꿔줘야됨)
		try(FileOutputStream fos = new FileOutputStream(file)){
			fos.write(userPic.getPic());
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return file;
	}

	@Test
	public void test03DeleteUserPic() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		
		int res = mapper.deleteUserPic(2);
		Assert.assertEquals(1, res);
	}

}
