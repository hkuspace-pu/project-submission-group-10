package com.springboot.service;

import java.util.List;

import com.springboot.dao.FamilyNamesDO;
import com.springboot.dao.ScientificNamesDO;
import com.springboot.dao.TreeTagDO;

public interface GetCommonAndScientificNameService {

	List<ScientificNamesDO> getCommonAndScientificName();
	
	List<ScientificNamesDO> getCommonAndScientificNameByTreeId(int treeId);
	
	List<ScientificNamesDO> getAllTreeMasterTableList();
	
	List<FamilyNamesDO> getFamilyNameById(int familyNameId);
	
	List<FamilyNamesDO> getAllFamilyNameList();
	
	List<TreeTagDO> getTagList();
	
}
