package com.springboot.dao;

import java.math.BigDecimal;
import java.util.Date;

import lombok.Data;

@Data
public class SurveyRecordsDO {

	private int id;
	private int userId;
	private String commonName;
	private String chineseName;
	private int health;
	private BigDecimal height;
	private String location;
	private String district;
	//may be array
	private String treeType;
	private String scientificName;
	private String family;
	private String tcmpId;
	private String responsibleDept;
	private int nativeExotic;
	private BigDecimal crownSpread;
	private String latitude;
	private String longtitude;
	private String healthTag;
	private Date createTime;
	private Date updateTime;
	private int status;
	private int roleType;
	//may be array
	private String uploadImg;
	private int dangerousTree;
	private BigDecimal stemCircumference;
	private String recommendation;
	private int amenityValue;
	private Date nextInspectionDate;
	private String comments;
	
	
}
