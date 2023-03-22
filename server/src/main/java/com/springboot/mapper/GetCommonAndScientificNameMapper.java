package com.springboot.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.springboot.dao.FamilyNamesDO;
import com.springboot.dao.ScientificNamesDO;
import com.springboot.dao.TreeTagDO;

@Mapper
public interface GetCommonAndScientificNameMapper {

	@Select("select "
			+ "sn.id, "
			+ "sn.scientific_name, "
			+ "sn.scientific_chi_name, "
			+ "sn.common_name, "
			+ "sn.common_chi_name, "
			+ "fn.family_name as family_name, "
			+ "sn.family, "
			+ "sn.status,"
			+ "sn.img_url, "
			+ "sn.short_desc, "
			+ "sn.long_desc, "
			+ "sn.short_chi_desc, "
			+ "sn.long_chi_desc, "
			+ "sn.native_exotic "
			+ "from scientific_names sn, family_names fn where fn.id = sn.family")
	List<ScientificNamesDO> getCommonAndScientificName();
	
	@Select("select * from scientific_names")
	List<ScientificNamesDO> getAllTreeMasterTableList();
	
	@Select("select * from tree_tag")
	List<TreeTagDO> getTagList();
	
	@Select("select * from scientific_names where id = #{treeId}")
	List<ScientificNamesDO> getCommonAndScientificNameByTreeId(@Param("treeId")int treeId);
	
	@Select("select family_name from family_names where id = #{familyNameId}")
	List<FamilyNamesDO> getFamilyNameById(@Param("familyNameId")int familyNameId);
	
	@Select("select * from family_names")
	List<FamilyNamesDO> getAllFamilyNameList();
	
}
