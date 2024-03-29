package spring5_mybatis_study.resulthandler;

import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.ResultContext;
import org.apache.ibatis.session.ResultHandler;

import spring5_mybatis_study.dto.Student;

public class StudentResultHandler implements ResultHandler<Student> {

	private Map<Integer, String> map = new HashMap<Integer, String>();
	
	public StudentResultHandler(Map<Integer, String> map) {
		this.map = map;
	}
	
	@Override
	public void handleResult(ResultContext<? extends Student> resultContext) {
		Student student = resultContext.getResultObject(); // List의 student 하나씩 꺼내오는 것
		map.put(student.getStudId(), student.getName());
	}

}
