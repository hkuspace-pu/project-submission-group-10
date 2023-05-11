package com.springboot.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.springboot.dao.UserInfoDO;

@Mapper
public interface GetUserLoginMapper {

	@Select("select * from user_info where user_name = #{username} and password = #{password} and status = 1")
	List<UserInfoDO> getUserLoginService(@Param("username")String username,@Param("password") String password);
	
	@Select("select * from user_info where id = #{userId}")
	List<UserInfoDO> getUserRoleIdByUserId(@Param("userId") int userId);
	
	@Select("select * from user_info where status = 1")
	List<UserInfoDO> getAllUser();
	
	@Update("update user_info set "
			+ "user_name = #{userName}, "
			+ "phone_number = #{phoneNumber}, "
			+ "email = #{email}, "
			+ "role = #{role} "
			+ "where id = #{id}")
	boolean editUserInfo(UserInfoDO userInfoDO);
	
	@Insert("insert into user_info("
			+ "user_name, "
			+ "phone_number, "
			+ "email, "
			+ "password, "
			+ "role, "
			+ "full_name, "
			+ "status, "
			+ "point "
			+ ") values("
			+ "#{userName}, "
			+ "#{phoneNumber}, "
			+ "#{email}, "
			+ "#{password}, "
			+ "#{role}, "
			+ "#{fullName}, "
			+ "#{status}, "
			+ "#{point})")
	boolean createUserInfo(UserInfoDO userInfoDO);
	
	@Update("update user_info set status = 0 where id = #{userId}")
	boolean delUserInfo(@Param("userId")int userId);
}
