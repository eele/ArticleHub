package edu.zhku.jsj144.lzc.articleHub.service.plugin;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.Map;

import org.springframework.stereotype.Component;

@Component
public class ArticleHandler {
	
	public void writeArticleToFile(String aid, String content) throws IOException {
		File article = new File("c:/article/" + aid);
		OutputStream fos = new FileOutputStream(article);
		fos.write(content.getBytes());
		fos.write('\n');
		fos.close();
	}

	public void readArticleFromFile(String aid, Map<String, String> dataMap) throws IOException {
		File article = new File("c:/article/" + aid);
		InputStream fis = new FileInputStream(article);
		BufferedReader bf = new BufferedReader(new InputStreamReader(fis));
		String content = bf.readLine();
		dataMap.put("_content", content);
		fis.close();
		bf.close();
	}
}
