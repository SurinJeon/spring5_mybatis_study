package spring5_mybatis_study.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.ResultContext;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import spring5_mybatis_study.dto.Student;
import spring5_mybatis_study.resulthandler.StudentResultHandler;
import spring5_mybatis_study.service.StudentService;

@Service // ComponentScan을 위해 추가함
public class StudentServiceImpl implements StudentService {
	
	private final String namespace = "spring5_mybatis_study.mapper.StudentMapper"; // StudentMapper.xml에 있는거 똑같이 가져와야됨
	
	@Autowired
	private SqlSession sqlSession; // 우리가 작성한 ContextSqlSession임
	
	@Override
	public Map<Integer, String> selectStudentForMap(int studId) {
		// ResultHandler 사용할 것
		Map<Integer, String> map = new HashMap<Integer, String>();
		StudentResultHandler resultHandler = new StudentResultHandler(map);
		
		// mybatis에서 map을 바로 return하는 기능이 없음 << 그래서 어거지로 list로 뱉는걸 handler에서 낚아챈 다음 map으로 바꾸기
		// list<Student> -> handler(list의 한 요소마다 계속 handler를 들렀다 감) -> Map<Integer, Student> map
									// StudentMapper.xml에 있는 selectStudentForMap을 가져오겠단 뜻
		sqlSession.select(namespace + ".selectStudentForMap", studId, resultHandler); // << resultHandler (마지막 parameter)때문에 handleResult() 콜백됨(자동콜백임)
		
		return map; // 번호와 이름을 가진 객체를 return
	}

	@Override
	public Map<Integer, Student> selectStudentForMap2(int studId) {
		Map<Integer, Student> map = new HashMap<Integer, Student>();
		ResultHandler<Student> handler = new ResultHandler<Student>() { // 한 군데에서만 쓰인다면 annoymous interface 쓰면 됨

			@Override
			public void handleResult(ResultContext<? extends Student> resultContext) {
				Student student = resultContext.getResultObject();
				map.put(student.getStudId(), student);
			}
		};
		
		sqlSession.select(namespace + ".selectStudentForMap", studId, handler);
		
		return map;
	}

	@Override
	public Map<Integer, Student> selectStudentForMap3() {
		Map<Integer, Student> map = new HashMap<Integer, Student>();
		ResultHandler<Student> handler = new ResultHandler<Student>() { // 한 군데에서만 쓰인다면 annoymous interface 쓰면 됨

			@Override
			public void handleResult(ResultContext<? extends Student> resultContext) {
				Student student = resultContext.getResultObject();
				map.put(student.getStudId(), student);
			}
		};
		
		sqlSession.select(namespace + ".selectStudentForMap", handler);
		return map;
	}

}
