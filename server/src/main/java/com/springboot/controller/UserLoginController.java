package com.springboot.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.springboot.enums.ApiReturnStatusCode;
import com.springboot.responseFormat.ReturnTransferFormat;

/**
 * @author leo
 * 用戶登錄API
 * */
@Controller
public class UserLoginController {

	@Autowired
	ReturnTransferFormat returnTransferFormat;
	/**
	 * 用戶 login
	 * @param username
	 * @param md5加密 password
	 * @param token
	 * */
	@PostMapping("/login")
	@ResponseBody
	public String getLogin(String username, String password, String token) {
		return returnTransferFormat.respondTransferFormat(
				ApiReturnStatusCode.INVALID_REQUEST.code(), 
				ApiReturnStatusCode.INVALID_REQUEST.msg(), 
				ApiReturnStatusCode.INVALID_REQUEST.zhMsg(),
				new ArrayList<>());	
	}
	
	/**
	 * 創建用戶
	 * @param username
	 * @param md5加密 password
	 * @param token
	 * @param email
	 * @param phoneNumber
	 * */
	@PostMapping("/createUser")
	@ResponseBody
	public String createUser(
			String username, 
			String password, 
			String token, 
			String email, 
			String phoneNumber) {
		return returnTransferFormat.respondTransferFormat(
				ApiReturnStatusCode.INVALID_REQUEST.code(), 
				ApiReturnStatusCode.INVALID_REQUEST.msg(), 
				ApiReturnStatusCode.INVALID_REQUEST.zhMsg(),
				new ArrayList<>());	
	}
	
	/**
	 * 忘記密碼
	 * @param token
	 * @param email
	 * @param phoneNumber
	 * */
	@PostMapping("/forgetPassword")
	@ResponseBody
	public String forgetPassword( 
			String token, 
			String email, 
			String phoneNumber) {
		return returnTransferFormat.respondTransferFormat(
				ApiReturnStatusCode.INVALID_REQUEST.code(), 
				ApiReturnStatusCode.INVALID_REQUEST.msg(), 
				ApiReturnStatusCode.INVALID_REQUEST.zhMsg(),
				new ArrayList<>());	
	}
	
}
