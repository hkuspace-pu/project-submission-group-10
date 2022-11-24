package com.springboot.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.springboot.dao.UserInfoDO;
import com.springboot.enums.ApiReturnStatusCode;
import com.springboot.responseFormat.ReturnTransferFormat;
import com.springboot.service.GetUserLoginService;
import com.springboot.utils.TokenKey;

/**
 * @author leo
 * 用戶登錄API
 * */
@Controller
public class UserLoginController {

	@Autowired
	ReturnTransferFormat returnTransferFormat;
	
	@Autowired
	GetUserLoginService getUserLoginService;
	/**
	 * 用戶 login
	 * @param username
	 * @param md5加密 password
	 * @param token
	 * 
	 * @return [userName: "", status: true]
	 * */
	@PostMapping("/login")
	@ResponseBody
	public String getLogin(String username, String password, String token) {
		
		try {
		
			String tokenKey = TokenKey.TOKEN_KEY;
			List<HashMap<String, Object>> returnList = new ArrayList<>();
			List<UserInfoDO> userInfoList = new ArrayList<UserInfoDO>();
			
			if(
					username != null && 
					!username.equals("") && 
					password != null && 
					!password.equals("") && 
					token.equals(tokenKey)) {
				
				userInfoList = getUserLoginService.getUserLoginService(username, password);
				
				if(userInfoList.size() > 0) {
					
					HashMap<String, Object> map1 = new HashMap<String, Object>();
					HashMap<String, Object> map2 = new HashMap<String, Object>();
					map1.put("userName", userInfoList.get(0).getUserName());
					map2.put("status", true);
					returnList.add(map1);
					returnList.add(map2);
					
					return returnTransferFormat.respondTransferFormat(
							ApiReturnStatusCode.REQUEST_SUCCESS.code(), 
							ApiReturnStatusCode.REQUEST_SUCCESS.msg(), 
							ApiReturnStatusCode.REQUEST_SUCCESS.zhMsg(),
							returnList);	
				}
				
			}
			
			return returnTransferFormat.respondTransferFormat(
					ApiReturnStatusCode.INVALID_REQUEST.code(), 
					ApiReturnStatusCode.INVALID_REQUEST.msg(), 
					ApiReturnStatusCode.INVALID_REQUEST.zhMsg(),
					new ArrayList<>());	
			
		}catch(Exception e) {
			System.out.println(e);
			return returnTransferFormat.respondTransferFormat(
					ApiReturnStatusCode.REQUEST_FAIL.code(), 
					ApiReturnStatusCode.REQUEST_FAIL.msg(), 
					ApiReturnStatusCode.REQUEST_FAIL.zhMsg(),
					new ArrayList<>());	
		}
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
