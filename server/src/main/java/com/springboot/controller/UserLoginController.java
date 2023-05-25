package com.springboot.controller;

import java.util.ArrayList;
import java.util.Base64;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.crypto.hash.SimpleHash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.ResponseBody;

import com.springboot.common.CalculateUserPoint;
import com.springboot.common.JwtUtil;
import com.springboot.dao.ActivityLogDO;
import com.springboot.dao.UserInfoDO;
import com.springboot.enums.ApiReturnStatusCode;
import com.springboot.responseFormat.ReturnTransferFormat;
import com.springboot.service.GetUserLoginService;
import com.springboot.service.InsertActivityLogService;
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
	
	@Autowired
	InsertActivityLogService insertActivityLogService;
	
	@Autowired
	CalculateUserPoint calculateUserPoint;
	/**
	 * 用戶 login
	 * @param username
	 * @param md5加密 password
	 * @param token
	 * 
	 * @return [userName: "", role: 1, status: 200]
	 * Authorization:leo@qq.com:123456
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
			//sha256 hashing the password
			password = new SimpleHash("SHA-256", password, TokenKey.SALT, 1024).toString();	
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
				System.out.println(tokenCookie);
				
				if(userInfoList.size() > 0) {
					
					HashMap<String, Object> map1 = new HashMap<String, Object>();
					map1.put("userName", userInfoList.get(0).getUserName());
					map1.put("status", true);
					map1.put("role", userInfoList.get(0).getRole());
					map1.put("ava", userInfoList.get(0).getImg());
					map1.put("phoneNumber", userInfoList.get(0).getPhoneNumber());
					map1.put("email", userInfoList.get(0).getEmail());
					map1.put("point", userInfoList.get(0).getPoint());
					map1.put("userId", userInfoList.get(0).getId());
					map1.put("createTime", userInfoList.get(0).getCreateTime());
					map1.put("fullName", userInfoList.get(0).getFullName());
					returnList.add(map1);
					
					ActivityLogDO activityLogDO = new ActivityLogDO();
					activityLogDO.setUserId(userInfoList.get(0).getId());
					activityLogDO.setUserName(userInfoList.get(0).getUserName());
					activityLogDO.setActivityLog("login");
					insertActivityLogService.insertActivityLog(activityLogDO);
					
					calculateUserPoint.calculateProcess(userInfoList.get(0).getId());
					
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
			String fullname,
			String password,  
			String email, 
			String phoneNumber, 
			int role) {
		
		try {
			
			String hashPassword = new SimpleHash("SHA-256", password, TokenKey.SALT, 1024).toString();
			
			UserInfoDO userInfoDO = new UserInfoDO();
			userInfoDO.setUserName(username);
			userInfoDO.setFullName(fullname);
			userInfoDO.setPassword(hashPassword);
			userInfoDO.setEmail(email);
			userInfoDO.setPhoneNumber(phoneNumber);
			userInfoDO.setRole(role);
			userInfoDO.setStatus(1);
			userInfoDO.setPoint(10);
			
			getUserLoginService.createUserInfo(userInfoDO);
			
			ActivityLogDO activityLogDO = new ActivityLogDO();
			activityLogDO.setId(0);
			activityLogDO.setUserName(username);
			activityLogDO.setActivityLog("create user");
			insertActivityLogService.insertActivityLog(activityLogDO);
			
			return returnTransferFormat.respondTransferFormat(
					ApiReturnStatusCode.REQUEST_SUCCESS.code(), 
					ApiReturnStatusCode.REQUEST_SUCCESS.msg(), 
					ApiReturnStatusCode.REQUEST_SUCCESS.zhMsg(),
					new ArrayList<>());	
		
		}catch(Exception e) {
			
			e.printStackTrace();
			return returnTransferFormat.respondTransferFormat(
					ApiReturnStatusCode.INVALID_REQUEST.code(), 
					ApiReturnStatusCode.INVALID_REQUEST.msg(), 
					ApiReturnStatusCode.INVALID_REQUEST.zhMsg(),
					new ArrayList<>());	
		}
		
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
			String email, 
			String phoneNumber) {
		return returnTransferFormat.respondTransferFormat(
				ApiReturnStatusCode.INVALID_REQUEST.code(), 
				ApiReturnStatusCode.INVALID_REQUEST.msg(), 
				ApiReturnStatusCode.INVALID_REQUEST.zhMsg(),
				new ArrayList<>());	
	}
	
	@PostMapping("/getAllUser")
	@ResponseBody
	public String getAllUser(int roleId) {
		
		try {
		
			if(roleId < 4) {
				return returnTransferFormat.respondTransferFormat(
						ApiReturnStatusCode.INVALID_REQUEST.code(), 
						ApiReturnStatusCode.INVALID_REQUEST.msg(), 
						ApiReturnStatusCode.INVALID_REQUEST.zhMsg(),
						new ArrayList<>());	
			}
			
			List<UserInfoDO> userList = getUserLoginService.getAllUser();
			
			return returnTransferFormat.respondTransferFormat(
					ApiReturnStatusCode.REQUEST_SUCCESS.code(), 
					ApiReturnStatusCode.REQUEST_SUCCESS.msg(), 
					ApiReturnStatusCode.REQUEST_SUCCESS.zhMsg(),
					userList);
		
		}catch(Exception e) {
			
			e.printStackTrace();
		
			return returnTransferFormat.respondTransferFormat(
					ApiReturnStatusCode.INVALID_REQUEST.code(), 
					ApiReturnStatusCode.INVALID_REQUEST.msg(), 
					ApiReturnStatusCode.INVALID_REQUEST.zhMsg(),
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
	@PutMapping("/editUser")
	@ResponseBody
	public String editUser(
			int userId,
			String username, 
			String phoneNumber, 
			String email, 
			int role) {
		
		try {
		
			UserInfoDO userInfoDO = new UserInfoDO();
			
			userInfoDO.setId(userId);
			userInfoDO.setEmail(email);
			userInfoDO.setUserName(username);
			userInfoDO.setPhoneNumber(phoneNumber);
			userInfoDO.setRole(role);
			
			getUserLoginService.editUserInfo(userInfoDO);
			
			ActivityLogDO activityLogDO = new ActivityLogDO();
			activityLogDO.setUserId(userId);
			activityLogDO.setUserName(username);
			activityLogDO.setActivityLog("create user");
			insertActivityLogService.insertActivityLog(activityLogDO);
			
			return returnTransferFormat.respondTransferFormat(
					ApiReturnStatusCode.REQUEST_SUCCESS.code(), 
					ApiReturnStatusCode.REQUEST_SUCCESS.msg(), 
					ApiReturnStatusCode.REQUEST_SUCCESS.zhMsg(),
					new ArrayList<>());
		
		}catch(Exception e) {
			
			e.printStackTrace();
			return returnTransferFormat.respondTransferFormat(
					ApiReturnStatusCode.INVALID_REQUEST.code(), 
					ApiReturnStatusCode.INVALID_REQUEST.msg(), 
					ApiReturnStatusCode.INVALID_REQUEST.zhMsg(),
					new ArrayList<>());	
		}
		
	}
	
	@DeleteMapping("/delUser")
	@ResponseBody
	public String delUser(int userId) {
		
		try {
			
			getUserLoginService.delUserInfo(userId);
			
			List<UserInfoDO> userList = getUserLoginService.getUserRoleByUserId(userId);
			
			ActivityLogDO activityLogDO = new ActivityLogDO();
			activityLogDO.setUserId(userId);
			activityLogDO.setUserName(userList.get(0).getUserName());
			activityLogDO.setActivityLog("delete user");
			insertActivityLogService.insertActivityLog(activityLogDO);
			
			return returnTransferFormat.respondTransferFormat(
					ApiReturnStatusCode.REQUEST_SUCCESS.code(), 
					ApiReturnStatusCode.REQUEST_SUCCESS.msg(), 
					ApiReturnStatusCode.REQUEST_SUCCESS.zhMsg(),
					new ArrayList<>());	
		
		}catch(Exception e) {
			
			e.printStackTrace();
			return returnTransferFormat.respondTransferFormat(
					ApiReturnStatusCode.INVALID_REQUEST.code(), 
					ApiReturnStatusCode.INVALID_REQUEST.msg(), 
					ApiReturnStatusCode.INVALID_REQUEST.zhMsg(),
					new ArrayList<>());	
		}
	}
	
	@PostMapping("/getUserProfileById")
	@ResponseBody
	public String getUserProfileById(int userId) {
		
		try {
						
			List<UserInfoDO> userInfoList = getUserLoginService.getUserRoleByUserId(userId);
			List<HashMap<String, Object>> returnList = new ArrayList<>();
			
			HashMap<String, Object> map1 = new HashMap<String, Object>();
			map1.put("userName", userInfoList.get(0).getUserName());
			map1.put("status", true);
			map1.put("role", userInfoList.get(0).getRole());
			map1.put("ava", userInfoList.get(0).getImg());
			map1.put("phoneNumber", userInfoList.get(0).getPhoneNumber());
			map1.put("email", userInfoList.get(0).getEmail());
			map1.put("point", userInfoList.get(0).getPoint());
			map1.put("userId", userInfoList.get(0).getId());
			returnList.add(map1);
			
			//计算该用户的point
			

			
			return returnTransferFormat.respondTransferFormat(
					ApiReturnStatusCode.REQUEST_SUCCESS.code(), 
					ApiReturnStatusCode.REQUEST_SUCCESS.msg(), 
					ApiReturnStatusCode.REQUEST_SUCCESS.zhMsg(),
					returnList);	
		
		}catch(Exception e) {
			
			e.printStackTrace();
			return returnTransferFormat.respondTransferFormat(
					ApiReturnStatusCode.INVALID_REQUEST.code(), 
					ApiReturnStatusCode.INVALID_REQUEST.msg(), 
					ApiReturnStatusCode.INVALID_REQUEST.zhMsg(),
					new ArrayList<>());	
		}
	}
	
}
