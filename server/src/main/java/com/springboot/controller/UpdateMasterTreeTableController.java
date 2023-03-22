package com.springboot.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.springboot.dao.ScientificNamesDO;
import com.springboot.enums.ApiReturnStatusCode;
import com.springboot.responseFormat.ReturnTransferFormat;
import com.springboot.service.UpdateMasterTreeTableService;

@Controller
public class UpdateMasterTreeTableController {

	
	@Autowired
	ReturnTransferFormat returnTransferFormat;
	
	@Autowired
	UpdateMasterTreeTableService updateMasterTreeTableService;
	/**
	 * update master tree table param
	 * {
	 * 	"id": 1,
	 * 	"scientific_name" : "scientific name",
	 * 	"scientific_chi_name" : "中文科学名",
	 * 	"family" : 1,
	 * 	"status" : 1,
	 * 	"common_name" : "commnon name",
	 *  "common_chi_name" : "common chi name",
	 *  "img_url" : "http://img.com",
	 *  "short_desc" : "short description",
	 *  "long_desc" : "long description",
	 *  "native_exotic" : 1,
	 *  "short_chi_desc" : "这是短中文介绍",
	 *  "long_chi_desc" : "这是长中文介绍",
	 *  "create_time" : "2023-01-10"
	 * }
	 * 
	 * PS: native_exotic 1 ==> native 2 ==> exotic
	 * */
	@CrossOrigin(origins = "*", maxAge = 3600)
	@RequestMapping(value ="/updateMasterTreeTableById", method = RequestMethod.POST)
	@ResponseBody
	public String updateMasterTreeById(@RequestParam String data) {
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
			
			ScientificNamesDO scientificNamesDO = new ScientificNamesDO();
			scientificNamesDO.setCommonChiName(json.getString("common_chi_name"));
			scientificNamesDO.setCommonName(json.getString("common_name"));
			scientificNamesDO.setCreateTime(fmt.parse(json.getString("create_time")));
			scientificNamesDO.setFamily(json.getIntValue("family"));
			scientificNamesDO.setId(json.getIntValue("id"));
			scientificNamesDO.setImgUrl(json.getString("img_url"));
			scientificNamesDO.setLongChiDesc(json.getString("long_chi_desc"));
			scientificNamesDO.setLongDesc(json.getString("long_desc"));
			scientificNamesDO.setNativeExotic(json.getIntValue("native_exotic"));
			scientificNamesDO.setScientificChiName(json.getString("scientific_chi_name"));
			scientificNamesDO.setScientificName(json.getString("scientific_name"));
			scientificNamesDO.setShortChiDesc(json.getString("short_chi_desc"));
			scientificNamesDO.setShortDesc(json.getString("short_desc"));
			scientificNamesDO.setStatus(json.getIntValue("status"));
			
			boolean updateRes = updateMasterTreeTableService.updateMasterTreeTableById(scientificNamesDO);
			
			if(!updateRes) {
				System.out.println("update fail");
				return returnTransferFormat.respondTransferFormat(
						ApiReturnStatusCode.INVALID_REQUEST.code(), 
						ApiReturnStatusCode.INVALID_REQUEST.msg(), 
						ApiReturnStatusCode.INVALID_REQUEST.zhMsg(),
						new ArrayList<>());	
			}
			
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
	 * insert master tree table param
	 * {
	 * 	"scientific_name" : "scientific name",
	 * 	"scientific_chi_name" : "中文科学名",
	 * 	"family" : 1,
	 * 	"status" : 1,
	 * 	"common_name" : "commnon name",
	 *  "common_chi_name" : "common chi name",
	 *  "img_url" : "http://img.com",
	 *  "short_desc" : "short description",
	 *  "long_desc" : "long description",
	 *  "native_exotic" : 1,
	 *  "short_chi_desc" : "这是短中文介绍",
	 *  "long_chi_desc" : "这是长中文介绍"
	 * }
	 * 
	 * PS: native_exotic 1 ==> native 2 ==> exotic
	 * */
	@CrossOrigin(origins = "*", maxAge = 3600)
	@RequestMapping(value ="/insertMasterTreeTable", method = RequestMethod.POST)
	@ResponseBody
	public String insertMasterTree(@RequestParam String data) {
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
			
			ScientificNamesDO scientificNamesDO = new ScientificNamesDO();
			scientificNamesDO.setCommonChiName(json.getString("common_chi_name"));
			scientificNamesDO.setCommonName(json.getString("common_name"));
			scientificNamesDO.setFamily(json.getIntValue("family"));
			scientificNamesDO.setImgUrl(json.getString("img_url"));
			scientificNamesDO.setLongChiDesc(json.getString("long_chi_desc"));
			scientificNamesDO.setLongDesc(json.getString("long_desc"));
			scientificNamesDO.setNativeExotic(json.getIntValue("native_exotic"));
			scientificNamesDO.setScientificChiName(json.getString("scientific_chi_name"));
			scientificNamesDO.setScientificName(json.getString("scientific_name"));
			scientificNamesDO.setShortChiDesc(json.getString("short_chi_desc"));
			scientificNamesDO.setShortDesc(json.getString("short_desc"));
			scientificNamesDO.setStatus(json.getIntValue("status"));
			
			boolean insertRes = updateMasterTreeTableService.insertMasterTreeTable(scientificNamesDO);
			
			if(!insertRes) {
				System.out.println("insert fail");
				return returnTransferFormat.respondTransferFormat(
						ApiReturnStatusCode.INVALID_REQUEST.code(), 
						ApiReturnStatusCode.INVALID_REQUEST.msg(), 
						ApiReturnStatusCode.INVALID_REQUEST.zhMsg(),
						new ArrayList<>());	
			}
			
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
	
	
}


