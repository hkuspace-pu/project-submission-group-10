package com.springboot.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;

import com.springboot.dao.ScientificNamesDO;

@Mapper
public interface UpdateMasterTreeTableMapper {

	@Update("update scientific_names set " + 
			"scientific_name = #{scientificName}, " + 
			"scientific_chi_name = #{scientificChiName}, " + 
			"family = #{family}, " + 
			"create_time = #{createTime}, " + 
			"status = #{status}, " + 
			"common_name = #{commonName}, " + 
			"common_chi_name = #{commonChiName}, " + 
			"img_url = #{imgUrl}, " + 
			"short_desc = #{shortDesc}, " + 
			"long_desc = #{longDesc}, " + 
			"native_exotic = #{nativeExotic}, " + 
			"short_chi_desc = #{shortChiDesc}, " + 
			"long_chi_desc = #{longChiDesc} where id the #{id}")
	boolean updateMasterTreeTableById(ScientificNamesDO scientificNamesDO );
	
	@Insert("insert into scientific_names (" + 
			"scientific_name, " + 
			"scientific_chi_name, " + 
			"family, " + 
			"status, " + 
			"common_name, " + 
			"common_chi_name, " + 
			"img_url, " + 
			"short_desc, " + 
			"long_desc, " + 
			"native_exotic, " + 
			"short_chi_desc, " + 
			"long_chi_desc " + 
			"values( "
			+ "#{scientificName}, "
			+ "#{scientificChiName}, "
			+ "#{family}, "
			+ "#{status}, "
			+ "#{commonName}, "
			+ "#{commonChiName}, "
			+ "#{imgUrl}, "
			+ "#{shortDesc}, "
			+ "#{longDesc}, "
			+ "#{nativeExotic}, "
			+ "#{shortChiDesc}, "
			+ "#{longChiDesc}"
			+ ")")
	boolean insertMasterTreeTable(ScientificNamesDO scientificNamesDO);
	
}
