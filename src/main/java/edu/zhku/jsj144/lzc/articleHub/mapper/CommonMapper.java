package edu.zhku.jsj144.lzc.articleHub.mapper;

import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface CommonMapper {

	Object getData(@Param("params")Map<String, ?> dataMap);

	void deleteData(@Param("params")Map<String, ?> dataMap);

	void insertData(@Param("params")Map<String, ?> dataMap);

	void updateData(@Param("params")Map<String, ?> dataMap);

}
