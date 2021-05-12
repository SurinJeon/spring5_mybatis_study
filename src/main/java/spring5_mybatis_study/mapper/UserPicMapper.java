package spring5_mybatis_study.mapper;

import spring5_mybatis_study.dto.UserPic;

public interface UserPicMapper {
	// insert
	int insertUserPic(UserPic userPic);
	
	// select
	UserPic getUserPic(int id);
	
	// delete
	int deleteUserPic(int id);
}
