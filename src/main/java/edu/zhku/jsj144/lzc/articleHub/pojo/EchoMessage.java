package edu.zhku.jsj144.lzc.articleHub.pojo;

public class EchoMessage {
	private String message = null;
	private Object data = null;

	public EchoMessage(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

}
