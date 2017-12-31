package edu.zhku.jsj144.lzc.articleHub.ctrl;

import static org.springframework.web.bind.annotation.RequestMethod.DELETE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;
import static org.springframework.web.bind.annotation.RequestMethod.PUT;

import java.io.IOException;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import edu.zhku.jsj144.lzc.articleHub.pojo.EchoMessage;
import edu.zhku.jsj144.lzc.articleHub.service.CommonService;

@Controller
public class CommonController {
	@Autowired
	private CommonService service;

	@RequestMapping(path = "/{type}/{field}/{value}", method = GET)
	@ResponseBody
	public EchoMessage getData(@RequestParam Map<String, String> dataMap, @PathVariable String type, @PathVariable String field,
			@PathVariable String value) throws IOException {
		dataMap.put("_type", type);
		dataMap.put(field, value);
		Object retDataObj = service.getData(dataMap);
		EchoMessage message = new EchoMessage("OK");
		message.setData(retDataObj);
		return message;
	}

	@RequestMapping(path = "/{type}/{field}/{value}", method = DELETE)
	@ResponseBody
	public EchoMessage deleteData(@RequestParam Map<String, String> dataMap, @PathVariable String type, @PathVariable String field,
			@PathVariable String value) throws IOException {
		dataMap.put("_type", type);
		dataMap.put(field, value);
		service.deleteData(dataMap);
		EchoMessage message = new EchoMessage("OK");
		return message;
	}

	@RequestMapping(path = "/{type}", method = POST)
	@ResponseBody
	public EchoMessage insertData(@RequestBody Map<String, String> dataMap, @PathVariable String type)
			throws IOException {
		dataMap.put("_type", type);
		service.insertData(dataMap);
		EchoMessage message = new EchoMessage("OK");
		return message;
	}

	@RequestMapping(path = "/{type}/{field}/{value}", method = PUT)
	@ResponseBody
	public EchoMessage updateData(@RequestBody Map<String, String> dataMap, @PathVariable String type,
			@PathVariable String field, @PathVariable String value) throws IOException {
		dataMap.put("_type", type);
		dataMap.put("_field", field);
		dataMap.put("_value", value);
		service.updateData(dataMap);
		EchoMessage message = new EchoMessage("OK");
		return message;
	}
}
