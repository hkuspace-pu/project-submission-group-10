package com.springboot.controller;

import java.util.ArrayList;
import java.util.Base64;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.ResponseBody;

import com.springboot.common.JwtUtil;
import com.springboot.dao.UserInfoDO;
import com.springboot.enums.ApiReturnStatusCode;
import com.springboot.responseFormat.ReturnTransferFormat;
import com.springboot.service.GetUserLoginService;

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
	 * @return [userName: "", role: 1, status: 200]
	 * */
	@CrossOrigin(origins = "*", maxAge = 3600)
	@PostMapping("/login")
	@ResponseBody
	public String getLogin(@RequestHeader("Authorization") String authorization, HttpServletResponse response) {
		
		try {
			
			if(authorization == null) {
				return returnTransferFormat.respondTransferFormat(
						ApiReturnStatusCode.INVALID_REQUEST.code(), 
						ApiReturnStatusCode.INVALID_REQUEST.msg(), 
						ApiReturnStatusCode.INVALID_REQUEST.zhMsg(),
						new ArrayList<>());	
			}
				
			byte[] decodedBytes = Base64.getDecoder().decode(authorization);
			String decodedString = new String(decodedBytes);
			System.out.println(decodedString);
			String[] decodeList = decodedString.split(":");
			String username = decodeList[0];
			String password = decodeList[1];
			List<HashMap<String, Object>> returnList = new ArrayList<>();
			List<UserInfoDO> userInfoList = new ArrayList<UserInfoDO>();
			
			if(
					username != null && 
					!username.equals("") && 
					password != null && 
					!password.equals("")) {
				
				userInfoList = getUserLoginService.getUserLoginService(username, password);
				String token = JwtUtil.createToken(userInfoList.get(0));
				Cookie tokenCookie = new Cookie("accessToken", token);
				//得到token后需要把token放到header set cookie然后返回
				response.addCookie(tokenCookie);
				
				if(userInfoList.size() > 0) {
					
					HashMap<String, Object> map1 = new HashMap<String, Object>();
					HashMap<String, Object> map2 = new HashMap<String, Object>();
					HashMap<String, Object> map3 = new HashMap<String, Object>();
					HashMap<String, Object> map4 = new HashMap<String, Object>();
					map1.put("userName", userInfoList.get(0).getUserName());
					map2.put("status", true);
					map3.put("role", userInfoList.get(0).getRole());
					map4.put("ava", userInfoList.get(0).getImg());
					returnList.add(map1);
					returnList.add(map2);
					returnList.add(map3);
					returnList.add(map4);
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
