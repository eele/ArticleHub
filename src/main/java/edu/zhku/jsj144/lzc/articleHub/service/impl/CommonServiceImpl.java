package edu.zhku.jsj144.lzc.articleHub.service.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.zhku.jsj144.lzc.articleHub.mapper.CommonMapper;
import edu.zhku.jsj144.lzc.articleHub.service.CommonService;

@Service
public class CommonServiceImpl implements CommonService {
	@Autowired
	private CommonMapper mapper;

	@Override
	public Object getData(Map<String, ?> dataMap) {
		// TODO Auto-generated method stub
		return mapper.getData(dataMap);
	}

	@Override
	public void deleteData(Map<String, ?> dataMap) {
		// TODO Auto-generated method stub
		mapper.deleteData(dataMap);
	}

	@Override
	public void insertData(Map<String, ?> dataMap) {
		// TODO Auto-generated method stub
		mapper.insertData(dataMap);
	}

	@Override
	public void updateData(Map<String, ?> dataMap) {
		// TODO Auto-generated method stub
		mapper.updateData(dataMap);
	}

}
