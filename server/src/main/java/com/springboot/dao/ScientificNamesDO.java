package com.springboot.dao;

import java.util.Date;

import lombok.Data;

@Data
public class ScientificNamesDO {

	private int id;
	private String scientificName;
	private String scientificChiName;
	private int family;
	private Date createTime;
	private int status;
	private String commonName;
	private String commonChiName;
	private String imgUrl;
	private String shortDesc;
	private String longDesc;
	private String shortChiDesc;
	private String longChiDesc;
	private int nativeExotic;
	private String familyName;
	
	//"value": "Fig tree (无花果树)"
	private String value;
	
}
