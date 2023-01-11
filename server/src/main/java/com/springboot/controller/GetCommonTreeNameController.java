package com.springboot.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.springboot.dao.FamilyNamesDO;
import com.springboot.dao.ScientificNamesDO;
import com.springboot.dao.TreeTagDO;
import com.springboot.enums.ApiReturnStatusCode;
import com.springboot.responseFormat.ReturnTransferFormat;
import com.springboot.service.GetCommonAndScientificNameService;

/**
 * @author leo
 * @date 31/12/2022
 * get the common tree name list
 * get the tag list
 * */

@Controller
public class GetCommonTreeNameController {
	
	@Autowired
	GetCommonAndScientificNameService getCommonAndScientificNameService;
	
	@Autowired
	ReturnTransferFormat returnTransferFormat;

	//return the common tree list
	@CrossOrigin(origins = "*", maxAge = 3600)
	@GetMapping("/getCommonAndScientificNameList")
	@ResponseBody
	public String getCommonAndScientificNameList() {
		
		try {
			
			List<ScientificNamesDO> commonAndScientificNameList= getCommonAndScientificNameService.getCommonAndScientificName();
			
			for(ScientificNamesDO scientificNamesDO : commonAndScientificNameList) {
				scientificNamesDO.setValue(
						scientificNamesDO.getCommonName() + " ("+ scientificNamesDO.getCommonChiName()+")"
						);
			}
			
			System.out.println(commonAndScientificNameList);
				
			return returnTransferFormat.respondTransferFormat(
					ApiReturnStatusCode.REQUEST_SUCCESS.code(), 
					ApiReturnStatusCode.REQUEST_SUCCESS.msg(), 
					ApiReturnStatusCode.REQUEST_SUCCESS.zhMsg(),
					commonAndScientificNameList);	
		
		}catch(Exception e) {
			
			return returnTransferFormat.respondTransferFormat(
					ApiReturnStatusCode.INVALID_REQUEST.code(), 
					ApiReturnStatusCode.INVALID_REQUEST.msg(), 
					ApiReturnStatusCode.INVALID_REQUEST.zhMsg(),
					new ArrayList<>());	
		}
	}
	
	//return tree tags list
	@CrossOrigin(origins = "*", maxAge = 3600)
	@GetMapping("/getTreeTagList")
	@ResponseBody
	public String getTagList() {
		
		try {
			
			List<TreeTagDO> tagList= getCommonAndScientificNameService.getTagList();
				
			return returnTransferFormat.respondTransferFormat(
					ApiReturnStatusCode.REQUEST_SUCCESS.code(), 
					ApiReturnStatusCode.REQUEST_SUCCESS.msg(), 
					ApiReturnStatusCode.REQUEST_SUCCESS.zhMsg(),
					tagList);	
		
		}catch(Exception e) {
			
			return returnTransferFormat.respondTransferFormat(
					ApiReturnStatusCode.INVALID_REQUEST.code(), 
					ApiReturnStatusCode.INVALID_REQUEST.msg(), 
					ApiReturnStatusCode.INVALID_REQUEST.zhMsg(),
					new ArrayList<>());	
		}
	}
	
	@CrossOrigin(origins = "*", maxAge = 3600)
	@GetMapping("/getAllMasterTreeTableList")
	@ResponseBody
	public String getAllMasterTreeTableList() {
		
		try {
			
			List<ScientificNamesDO> masterTreeTableList = getCommonAndScientificNameService.getAllTreeMasterTableList();
				
			return returnTransferFormat.respondTransferFormat(
					ApiReturnStatusCode.REQUEST_SUCCESS.code(), 
					ApiReturnStatusCode.REQUEST_SUCCESS.msg(), 
					ApiReturnStatusCode.REQUEST_SUCCESS.zhMsg(),
					masterTreeTableList);	
		
		}catch(Exception e) {
			
			return returnTransferFormat.respondTransferFormat(
					ApiReturnStatusCode.INVALID_REQUEST.code(), 
					ApiReturnStatusCode.INVALID_REQUEST.msg(), 
					ApiReturnStatusCode.INVALID_REQUEST.zhMsg(),
					new ArrayList<>());	
		}
	}
	
	@CrossOrigin(origins = "*", maxAge = 3600)
	@GetMapping("/getAllFamilyList")
	@ResponseBody
	public String getAllFamilyList() {
		
		try {
			
			List<FamilyNamesDO> familyList = getCommonAndScientificNameService.getAllFamilyNameList();
				
			return returnTransferFormat.respondTransferFormat(
					ApiReturnStatusCode.REQUEST_SUCCESS.code(), 
					ApiReturnStatusCode.REQUEST_SUCCESS.msg(), 
					ApiReturnStatusCode.REQUEST_SUCCESS.zhMsg(),
					familyList);	
		
		}catch(Exception e) {
			
			return returnTransferFormat.respondTransferFormat(
					ApiReturnStatusCode.INVALID_REQUEST.code(), 
					ApiReturnStatusCode.INVALID_REQUEST.msg(), 
					ApiReturnStatusCode.INVALID_REQUEST.zhMsg(),
					new ArrayList<>());	
		}
	}
	
	
}
