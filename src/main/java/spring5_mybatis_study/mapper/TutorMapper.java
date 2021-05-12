package spring5_mybatis_study.mapper;

import spring5_mybatis_study.dto.Tutor;

public interface TutorMapper {
	Tutor selectTutorByTutorId(Tutor tutor);
	// parameter tutorId만 넣어도 되지만, 여기서는 일단 객체로 다 전달함
}
