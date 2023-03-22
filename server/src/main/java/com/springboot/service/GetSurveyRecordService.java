package com.springboot.service;

import java.util.List;

import com.springboot.dao.SurveyRecordsDO;

public interface GetSurveyRecordService {

	List<SurveyRecordsDO> getSurveyRecordByUserId(int userId);
	
	List<SurveyRecordsDO> getAllSurveyRecord();
 	
	boolean insertSurveyRecord(SurveyRecordsDO surveyRecordsDO);
	
	boolean updateSurveyRecordById(SurveyRecordsDO surveyRecordsDO);
	
}
