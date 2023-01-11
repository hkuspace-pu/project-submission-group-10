package com.springboot.dao;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;


/**
 * “user_id”: 1,
		"tree_type_id" : 3,  
		"location": "18 Old Peak Road",
		  "district": "Western",
		  "tcmp_id": "234234234",
		  "responsible_dept": "Higwhway Dept",
		  "survey_date": "2021-01-01",
		  "height": "25",
		  "crown": "25",
		  "stem_circumference": "25",
		   "lat": "08080808",
		   "long": "089808080",
		   "health": 5,
		  "recommendation": "Retain",
		  "amenity_value": 3,
		  "next_inspection_date": "2022-02-04",
		  "file": [
		    {
		      "name": "WhatsApp Image 2022-12-25 at 11.45.25 AM.jpeg",
		      "file": "[object File]"
		    },
		    {
		      "name": "WhatsApp Image 2022-12-25 at 12.30.39 PM.jpeg",
		      "file": "[object File]"
		    }
		  ],
		  "tree_tag": [
		    "Old & valuable",
		    "Stone wall"
		  ],
		  "dangerous_tree": 0,
		  "comments": "This tree is cool!"
		}
 * */
@Data
public class InsertSurveyDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@JsonProperty("user_id")
	private int userId;
	@JsonProperty("tree_type_id")
	private int treeTypeId;
	@JsonProperty("location")
	private String location;
	@JsonProperty("district")
	private String district;
	@JsonProperty("tcmp_id")
	private String tcmpId;
	@JsonProperty("responsible_dept")
	private String responsibleDept;
	@JsonProperty("survey_date")
	private String surveyDate;
	@JsonProperty("height")
	private String height;
	@JsonProperty("crown")
	private String crown;
	@JsonProperty("stem_circumference")
	private String stemCircumference;
	@JsonProperty("lat")
	private String lat;
	@JsonProperty("long")
	private String longtitude;
	@JsonProperty("health")
	private int health;
	@JsonProperty("recommendation")
	private String recommendation;
	@JsonProperty("amenity_value")
	private int amenityValue;
	@JsonProperty("next_inspection_date")
	private String nextInspectionDate;
	@JsonProperty("file")
	private List<Object> file;
	@JsonProperty("tree_tag")
	private List<Object> treeTag;
	@JsonProperty("dangerous_tree")
	private int dangerousTree;
	@JsonProperty("comments")
	private String comments;
}
