package com.springboot.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.springboot.dao.SurveyRecordsDO;

@Mapper
public interface GetSurveyRecordMapper {

	@Select("select * from survey_records where user_id = #{userId}")
	List<SurveyRecordsDO> getSurveyRecordByUserId(@Param("userId")int userId);
	
	@Select("select * from survey_records")
	List<SurveyRecordsDO> getAllSurveyRecord();
	
	@Insert("insert into survey_records("
			+ "user_id, "
			+ "common_name, "
			+ "chinese_name, "
			+ "health, "
			+ "height, "
			+ "location, "
			+ "district, "
			+ "tree_type, "
			+ "scientific_name, "
			+ "family, "
			+ "tcmp_id, "
			+ "responsible_dept, "
			+ "native_exotic, "
			+ "crown_spread, "
			+ "latitude, "
			+ "longtitude, "
			+ "health_tag, "
			+ "update_time, "
			+ "status, "
			+ "upload_img, "
			+ "role_type, "
			+ "dangerous_tree, "
			+ "stem_circumference, "
			+ "recommendation, "
			+ "amenity_value, "
			+ "next_inspection_date, "
			+ "comments"
			+ ") values("
			+ "#{userId}, "
			+ "#{commonName}, "
			+ "#{chineseName}, "
			+ "#{health}, "
			+ "#{height}, "
			+ "#{location}, "
			+ "#{district}, "
			+ "#{treeType}, "
			+ "#{scientificName}, "
			+ "#{family}, "
			+ "#{tcmpId}, "
			+ "#{responsibleDept}, "
			+ "#{nativeExotic}, "
			+ "#{crownSpread}, "
			+ "#{latitude}, "
			+ "#{longtitude}, "
			+ "#{healthTag}, "
			+ "#{updateTime}, "
			+ "#{status}, "
			+ "#{uploadImg}, "
			+ "#{roleType}, "
			+ "#{dangerousTree}, "
			+ "#{stemCircumference}, "
			+ "#{recommendation}, "
			+ "#{amenityValue}, "
			+ "#{nextInspectionDate}, "
			+ "#{comments}"
			+ ")")
	boolean insertSurveyRecord(SurveyRecordsDO surveyRecordsDO);
	
	@Update("update survey_records set "
			+ "common_name = #{commonName}, "
			+ "chinese_name = #{chineseName}, "
			+ "health = #{health}, "
			+ "location = #{location}, "
			+ "district = #{district}, "
			+ "tree_type = #{treeType}, "
			+ "scientific_name = #{scientificName}, "
			+ "family = #{family}, "
			+ "tcmp_id = #{tcmpId}, "
			+ "responsible_dept = #{responsibleDept}, "
			+ "native_exotic = #{nativeExotic}, "
			+ "crown_spread = #{crownSpread}, "
			+ "latitude = #{latitude}, "
			+ "longtitude = #{longtitude}, "
			+ "health_tag = #{health_tag}, "
			+ "update_time = #{updateTime}, "
			+ "status = #{status}, "
			+ "upload_img = #{uploadImg}, "
			+ "dangerous_tree = #{dangerousTree}, "
			+ "stem_circumference = #{stemCircumference}, "
			+ "recommendation = #{recommendation}, "
			+ "amenity_value = #{amenityValue}, "
			+ "next_inspection_date = #{nextInspectionDate}, "
			+ "comments = #{comments} where id = #{id}")
	boolean updateSurveyRecordById(SurveyRecordsDO surveyRecordsDO);
	
	@Update("update survey_records set status = 9 where id = #{id}")
	boolean acceptSurveyRecordById(@Param("id")int id);
	
}


