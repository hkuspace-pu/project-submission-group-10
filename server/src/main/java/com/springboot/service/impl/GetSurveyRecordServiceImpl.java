package com.springboot.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.dao.SurveyRecordsDO;
import com.springboot.mapper.GetSurveyRecordMapper;
import com.springboot.service.GetSurveyRecordService;

@Service
public class GetSurveyRecordServiceImpl implements GetSurveyRecordService{
	
	@Autowired
	GetSurveyRecordMapper getSurveyRecordMapper;

	@Override
	public List<SurveyRecordsDO> getSurveyRecordByUserId(int userId) {
		return getSurveyRecordMapper.getSurveyRecordByUserId(userId);
	}

	@Override
	public boolean insertSurveyRecord(SurveyRecordsDO surveyRecordsDO) {		
		return getSurveyRecordMapper.insertSurveyRecord(surveyRecordsDO);
	}

	@Override
	public List<SurveyRecordsDO> getAllSurveyRecord() {
		return getSurveyRecordMapper.getAllSurveyRecord();
	}

	@Override
	public boolean updateSurveyRecordById(SurveyRecordsDO surveyRecordsDO) {
		return getSurveyRecordMapper.updateSurveyRecordById(surveyRecordsDO);
	}

}
