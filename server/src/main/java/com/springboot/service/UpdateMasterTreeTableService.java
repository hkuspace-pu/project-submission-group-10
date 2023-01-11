package com.springboot.service;

import com.springboot.dao.ScientificNamesDO;

public interface UpdateMasterTreeTableService {

	boolean updateMasterTreeTableById(ScientificNamesDO scientificNamesDO);
	
	boolean insertMasterTreeTable(ScientificNamesDO scientificNamesDO);
	
}
