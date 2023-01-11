package com.springboot.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.dao.ScientificNamesDO;
import com.springboot.mapper.UpdateMasterTreeTableMapper;
import com.springboot.service.UpdateMasterTreeTableService;

@Service
public class UpdateMasterTreeTableServiceImpl implements UpdateMasterTreeTableService{
	
	@Autowired
	UpdateMasterTreeTableMapper updateMasterTreeTableMapper;

	@Override
	public boolean updateMasterTreeTableById(ScientificNamesDO scientificNamesDO ) {
		return updateMasterTreeTableMapper.updateMasterTreeTableById(scientificNamesDO);
	}

	@Override
	public boolean insertMasterTreeTable(ScientificNamesDO scientificNamesDO) {
		return updateMasterTreeTableMapper.insertMasterTreeTable(scientificNamesDO);
	}

}
