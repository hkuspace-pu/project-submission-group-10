package com.springboot.dao;

import java.util.Date;

import lombok.Data;

/**
 * @author leo
 * @date 3/11/2022
 * 用戶登錄
 * */

@Data
public class UserInfoDO {

	private int id;
	private String userName;
	private String phoneNumber;
	private String email;
	private String password;
	private int status;
	private int age;
	private Date createTime;
	
}

