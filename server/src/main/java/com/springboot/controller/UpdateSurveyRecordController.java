package com.springboot.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.springboot.dao.ActivityLogDO;
import com.springboot.dao.FamilyNamesDO;
import com.springboot.dao.ScientificNamesDO;
import com.springboot.dao.SurveyRecordsDO;
import com.springboot.dao.UserInfoDO;
import com.springboot.enums.ApiReturnStatusCode;
import com.springboot.responseFormat.ReturnTransferFormat;
import com.springboot.service.GetCommonAndScientificNameService;
import com.springboot.service.GetSurveyRecordService;
import com.springboot.service.GetUserLoginService;
import com.springboot.service.InsertActivityLogService;

@Controller
public class UpdateSurveyRecordController {
	
	@Autowired
	GetSurveyRecordService getSurveyRecordService;
	
	@Autowired
	GetCommonAndScientificNameService getCommonAndScientificNameService;
	
	@Autowired
	GetUserLoginService getUserLoginService;
	
	@Autowired
	InsertActivityLogService insertActivityLogService;
	
	@Autowired
	ReturnTransferFormat returnTransferFormat;
	
	@CrossOrigin(origins = "*", maxAge = 3600)
	@RequestMapping(value ="/updateSurveyRecord", method = RequestMethod.POST)
	@ResponseBody
	public String updateSurveyRecordById(@RequestParam String data) {
		try {
			
			System.out.println(data);
			
			JSONObject json = JSONObject.parseObject(data);
			
			System.out.println(json);
			
			DateFormat fmt =new SimpleDateFormat("yyyy-MM-dd");
			
			if(json == null) {
				
				System.out.println("the json param is null");
				return returnTransferFormat.respondTransferFormat(
						ApiReturnStatusCode.INVALID_REQUEST.code(), 
						ApiReturnStatusCode.INVALID_REQUEST.msg(), 
						ApiReturnStatusCode.INVALID_REQUEST.zhMsg(),
						new ArrayList<>());	
			}
			
			int treeId = json.getIntValue("tree_type_id");
			List<ScientificNamesDO> scientificNamesDOList = getCommonAndScientificNameService.getCommonAndScientificNameByTreeId(treeId);
			
			if(scientificNamesDOList.size() == 0) {
				return returnTransferFormat.respondTransferFormat(
						ApiReturnStatusCode.INVALID_TREE_ID_NOT_FOUND.code(), 
						ApiReturnStatusCode.INVALID_TREE_ID_NOT_FOUND.msg(), 
						ApiReturnStatusCode.INVALID_TREE_ID_NOT_FOUND.zhMsg(),
						new ArrayList<>());	
			}
			
			int familyNameId = scientificNamesDOList.get(0).getFamily();			
			List<FamilyNamesDO> familyNamesDOList = getCommonAndScientificNameService.getFamilyNameById(familyNameId);
			
			//獲取upload img
			List<String> uploadImgList = new ArrayList<>();
			JSONArray jsonImgArray = json.getJSONArray("file");
			for(int i = 0; i < jsonImgArray.size(); i++) {
				uploadImgList.add(jsonImgArray.getJSONObject(i).getString("name"));
			}
			
			//這裏解析json裏的内容,然後更新
			SurveyRecordsDO surveyRecordsDO = new SurveyRecordsDO();
			surveyRecordsDO.setAmenityValue(json.getIntValue("amenity_value"));
			surveyRecordsDO.setChineseName(scientificNamesDOList.get(0).getCommonChiName());
			surveyRecordsDO.setComments(json.getString("comments"));
			surveyRecordsDO.setCommonName(scientificNamesDOList.get(0).getCommonName());
			surveyRecordsDO.setCrownSpread(json.getBigDecimal("crown"));
			surveyRecordsDO.setDangerousTree(json.getIntValue("dangerous_tree"));
			surveyRecordsDO.setDistrict(json.getString("district"));
			surveyRecordsDO.setFamily(familyNamesDOList.get(0).getFamilyName());
			surveyRecordsDO.setHealth(json.getIntValue("health"));
			//this is unuse
			surveyRecordsDO.setHealthTag("");
			surveyRecordsDO.setHeight(json.getBigDecimal("height"));
			surveyRecordsDO.setLatitude(json.getString("lat"));
			surveyRecordsDO.setLocation(json.getString("location"));
			surveyRecordsDO.setLongtitude(json.getString("long"));
			surveyRecordsDO.setNativeExotic(scientificNamesDOList.get(0).getNativeExotic());
			surveyRecordsDO.setNextInspectionDate(fmt.parse(json.getString("next_inspection_date")));
			surveyRecordsDO.setRecommendation(json.getString("recommendation"));
			surveyRecordsDO.setResponsibleDept(json.getString("responsible_dept"));
			surveyRecordsDO.setScientificName(scientificNamesDOList.get(0).getScientificName());
			surveyRecordsDO.setStatus(1);
			surveyRecordsDO.setStemCircumference(json.getBigDecimal("stem_circumference"));
			surveyRecordsDO.setTcmpId(json.getString("tcmp_id"));
			//this is the tree tag
			surveyRecordsDO.setTreeType(json.getString("tree_tag"));
			surveyRecordsDO.setUpdateTime(new Date());
			surveyRecordsDO.setUploadImg(uploadImgList.toString());
			surveyRecordsDO.setUserId(json.getIntValue("user_id"));
			surveyRecordsDO.setId(json.getIntValue("id"));
			getSurveyRecordService.updateSurveyRecordById(surveyRecordsDO);
			
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
	
	@CrossOrigin(origins = "*", maxAge = 3600)
	@PutMapping("/acceptSurveyRecord")
	@ResponseBody
	public String updateSurveyRecord(int surveyRecordId, int userId, int roleId) {
		try {
			
			/**
			 * user ==>1 moderator ==>3 admin ==>4
			 * */
			if(roleId <= 3) {
				System.out.println("role is invalid");
				return returnTransferFormat.respondTransferFormat(
						ApiReturnStatusCode.INVALID_REQUEST.code(), 
						ApiReturnStatusCode.INVALID_REQUEST.msg(), 
						ApiReturnStatusCode.INVALID_REQUEST.zhMsg(),
						new ArrayList<>());	
			}
			getSurveyRecordService.acceptSurveyRecordById(surveyRecordId);
			
			List<UserInfoDO> userList = getUserLoginService.getUserRoleByUserId(userId);
			
			ActivityLogDO activityLogDO = new ActivityLogDO();
			activityLogDO.setUserId(userId);
			activityLogDO.setUserName(userList.get(0).getUserName());
			activityLogDO.setActivityLog("accept survey record");
			insertActivityLogService.insertActivityLog(activityLogDO);
			return returnTransferFormat.respondTransferFormat(
					ApiReturnStatusCode.REQUEST_SUCCESS.code(), 
					ApiReturnStatusCode.REQUEST_SUCCESS.msg(), 
					ApiReturnStatusCode.REQUEST_SUCCESS.zhMsg(),
					new ArrayList<>());	
		
		}catch(Exception e) {
			
			return returnTransferFormat.respondTransferFormat(
					ApiReturnStatusCode.INVALID_REQUEST.code(), 
					ApiReturnStatusCode.INVALID_REQUEST.msg(), 
					ApiReturnStatusCode.INVALID_REQUEST.zhMsg(),
					new ArrayList<>());	
		}
	}

}
