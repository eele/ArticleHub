package edu.zhku.jsj144.lzc.articleHub.service;

import java.util.Map;

public interface CommonService {

	Object getData(Map<String, ?> dataMap);

	void deleteData(Map<String, ?> dataMap);

	void insertData(Map<String, ?> dataMap);

	void updateData(Map<String, ?> dataMap);

}
