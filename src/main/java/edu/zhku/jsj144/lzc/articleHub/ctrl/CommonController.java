package edu.zhku.jsj144.lzc.articleHub.ctrl;

import static org.springframework.web.bind.annotation.RequestMethod.DELETE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;
import static org.springframework.web.bind.annotation.RequestMethod.PUT;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import edu.zhku.jsj144.lzc.articleHub.pojo.EchoMessage;
import edu.zhku.jsj144.lzc.articleHub.service.CommonService;

@Controller
public class CommonController {
	@Autowired
	private CommonService service;

	@RequestMapping(path = "/common/{type}/{field}/{value}", method = GET)
	@ResponseBody
	// @ControllerPaging(requestParam = "arg0")
	public EchoMessage getData(Map<String, String> argMap, @PathVariable String type,
			@PathVariable String field, @PathVariable String value) throws IOException {
		Map<String, Object> dataMap = new HashMap<String, Object>();
		dataMap.put(field, value);
		argMap.put("type", type);
		
		Map<String, Map<String, ?>> map = new HashMap<String, Map<String, ?>>();
		map.put("data", dataMap);
		map.put("arg", argMap);
		
		Object retDataObj = service.getData(map);
		EchoMessage message = new EchoMessage("OK");
		message.setData(retDataObj);
		return message;
	}

	@RequestMapping(path = "/common/{type}/{field}/{value}", method = DELETE)
	@ResponseBody
	public EchoMessage deleteData(Map<String, String> argMap, @PathVariable String type,
			@PathVariable String field, @PathVariable String value) throws IOException {
		Map<String, Object> dataMap = new HashMap<String, Object>();
		dataMap.put(field, value);
		argMap.put("type", type);
		
		Map<String, Map<String, ?>> map = new HashMap<String, Map<String, ?>>();
		map.put("data", dataMap);
		map.put("arg", argMap);
		
		service.deleteData(map);
		EchoMessage message = new EchoMessage("OK");
		return message;
	}

	@RequestMapping(path = "/common/{type}", method = POST)
	@ResponseBody
	public EchoMessage insertData(@RequestParam Map<String, Object> dataMap, Map<String, String> argMap,
			@PathVariable String type) throws IOException {
		argMap.put("type", type);
		
		Map<String, Map<String, ?>> map = new HashMap<String, Map<String, ?>>();
		map.put("data", dataMap);
		map.put("arg", argMap);
		
		service.insertData(map);
		EchoMessage message = new EchoMessage("OK");
		return message;
	}

	@RequestMapping(path = "/common/{type}/{field}/{value}", method = PUT)
	@ResponseBody
	public EchoMessage updateData(@RequestParam Map<String, Object> dataMap, Map<String, String> argMap,
			@PathVariable String type, @PathVariable String field, @PathVariable String value) throws IOException {
		argMap.put("field", field);
		argMap.put("value", value);
		argMap.put("type", type);
		
		Map<String, Map<String, ?>> map = new HashMap<String, Map<String, ?>>();
		map.put("data", dataMap);
		map.put("arg", argMap);
		
		service.updateData(map);
		EchoMessage message = new EchoMessage("OK");
		return message;
	}
}
