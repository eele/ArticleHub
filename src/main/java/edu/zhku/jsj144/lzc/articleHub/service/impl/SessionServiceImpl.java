package edu.zhku.jsj144.lzc.articleHub.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import edu.zhku.jsj144.lzc.articleHub.mapper.CommonMapper;
import edu.zhku.jsj144.lzc.articleHub.service.SessionService;

@Component
public class SessionServiceImpl implements SessionService {
	@Autowired
	private CommonMapper mapper;

	@SuppressWarnings("unchecked")
	@Override
	public Map<String, String> verify(Map<String, String> dataMap) {
		// TODO Auto-generated method stub
		Map<String, String> retMap = null;
		List<Object> ret = mapper.getData(dataMap);
		if (ret.size() == 0) {
			throw new IllegalStateException("NOUSER");
		} else {
			if (!((Map<String, String>) ret.get(0)).get("password").equals(dataMap.get("password"))) {
				throw new IllegalStateException("PWDERR");
			} else {
				retMap = (Map<String, String>) ret.get(0);
			}
		}
		return retMap;
	}

}
