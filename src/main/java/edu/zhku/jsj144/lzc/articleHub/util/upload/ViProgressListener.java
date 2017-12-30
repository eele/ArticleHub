package edu.zhku.jsj144.lzc.articleHub.util.upload;

import org.apache.commons.fileupload.ProgressListener;
import org.springframework.stereotype.Component;

@Component
public class ViProgressListener implements ProgressListener {

	@Override
	public void update(long pBytesRead, long pContentLength, int pItems) {
		// TODO Auto-generated method stub
		System.out.println("pBytesRead=" + pBytesRead 
				+ " pContentLength=" + pContentLength 
				+ " pItems=" + pItems);
	}

}
