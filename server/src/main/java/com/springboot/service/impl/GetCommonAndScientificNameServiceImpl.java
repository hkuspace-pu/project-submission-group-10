package com.springboot.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.dao.FamilyNamesDO;
import com.springboot.dao.ScientificNamesDO;
import com.springboot.dao.TreeTagDO;
import com.springboot.mapper.GetCommonAndScientificNameMapper;
import com.springboot.service.GetCommonAndScientificNameService;

@Service
public class GetCommonAndScientificNameServiceImpl implements GetCommonAndScientificNameService{
	
	@Autowired
	GetCommonAndScientificNameMapper getCommonAndScientificNameMapper;

	@Override
	public List<ScientificNamesDO> getCommonAndScientificName() {
		return getCommonAndScientificNameMapper.getCommonAndScientificName();
	}

	@Override
	public List<TreeTagDO> getTagList() {
		return getCommonAndScientificNameMapper.getTagList();
	}

	@Override
	public List<ScientificNamesDO> getCommonAndScientificNameByTreeId(int treeId) {
		return getCommonAndScientificNameMapper.getCommonAndScientificNameByTreeId(treeId);
	}

	@Override
	public List<FamilyNamesDO> getFamilyNameById(int familyNameId) {
		return getCommonAndScientificNameMapper.getFamilyNameById(familyNameId);
	}

	@Override
	public List<ScientificNamesDO> getAllTreeMasterTableList() {
		return getCommonAndScientificNameMapper.getAllTreeMasterTableList();
	}

	@Override
	public List<FamilyNamesDO> getAllFamilyNameList() {
		return getCommonAndScientificNameMapper.getAllFamilyNameList();
	}

}
