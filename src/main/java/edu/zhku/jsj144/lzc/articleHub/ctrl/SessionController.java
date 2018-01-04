package edu.zhku.jsj144.lzc.articleHub.ctrl;

import static org.springframework.web.bind.annotation.RequestMethod.DELETE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;
import java.io.IOException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import edu.zhku.jsj144.lzc.articleHub.pojo.EchoMessage;
import edu.zhku.jsj144.lzc.articleHub.service.SessionService;

@Controller
public class SessionController {
	@Autowired
	private SessionService service;

	@RequestMapping(path = "/session/user/uid/{uid}", method = GET)
	@ResponseBody
	public EchoMessage getData(HttpServletRequest req) throws IOException {
		EchoMessage message = new EchoMessage("OK");
		message.setData(req.getSession().getAttribute("uid"));
		return message;
	}

	@RequestMapping(path = "/session/user/uid/{uid}", method = DELETE)
	@ResponseBody
	public EchoMessage deleteData(HttpServletRequest req) throws IOException {
		req.getSession().setAttribute("uid", null);
		EchoMessage message = new EchoMessage("OK");
		return message;
	}

	@RequestMapping(path = "/session/user", method = POST)
	@ResponseBody
	public EchoMessage insertData(@RequestBody Map<String, String> dataMap, HttpServletRequest req)
			throws IOException {
		dataMap.put("_type", "user");
		req.getSession().setAttribute("uid", service.verify(dataMap).get("uid"));
		EchoMessage message = new EchoMessage("OK");
		return message;
	}
}
