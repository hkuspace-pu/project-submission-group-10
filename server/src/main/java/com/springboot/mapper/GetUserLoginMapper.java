package com.springboot.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.springboot.dao.UserInfoDO;

@Mapper
public interface GetUserLoginMapper {

	@Select("select * from user_info where user_name = #{username} and password = #{password} and status = 1")
	List<UserInfoDO> getUserLoginService(@Param("username")String username,@Param("password") String password);
	
	@Select("select * from user_info where id = #{userId}")
	List<UserInfoDO> getUserRoleIdByUserId(@Param("userId") int userId);
}
