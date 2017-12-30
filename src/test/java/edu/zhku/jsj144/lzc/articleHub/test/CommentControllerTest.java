package edu.zhku.jsj144.lzc.articleHub.test;

import java.io.UnsupportedEncodingException;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import edu.zhku.jsj144.lzc.articleHub.ctrl.CommonController;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring-mybatis.xml",
	"classpath:web-servlet.xml", 
	"classpath:application-context.xml"})
public class CommentControllerTest {
	@Autowired
	CommonController ctrl = null;
	MockMvc mockMvc;
	
	@Before
	public void setUp() throws Exception {
		mockMvc = MockMvcBuilders.standaloneSetup(ctrl).build();
	}
	
	@Test
	public void testGetData() throws UnsupportedEncodingException, Exception {
		System.out.println(mockMvc.perform(MockMvcRequestBuilders.get("/user/username/%?_pb=1&_ps=2"))
				.andReturn()
				.getResponse()
				.getContentAsString());
	}

	@Test
	public void testDeleteData() throws UnsupportedEncodingException, Exception {
		System.out.println(mockMvc.perform(MockMvcRequestBuilders.delete("/user/username/qwetext"))
				.andReturn()
				.getResponse()
				.getContentAsString());
	}

	@Test
	public void testInsertData() throws UnsupportedEncodingException, Exception {
		System.out.println(mockMvc.perform(MockMvcRequestBuilders
				.post("/user?uid=1231&portraitURL=qwe&username=qwetext&password=qwetext&email=qwetext&desc=qwetext"))
				.andReturn()
				.getResponse()
				.getContentAsString());
	}
	
	@Test
	public void testUpdateData() throws UnsupportedEncodingException, Exception {
		System.out.println(mockMvc.perform(MockMvcRequestBuilders
				.put("/user/username/qwetext?uid=123qwe&portraitURL=qwe&username=qwetext&password=123&email=qwetext&desc=qwetext"))
				.andReturn()
				.getResponse()
				.getContentAsString());
	}

}
