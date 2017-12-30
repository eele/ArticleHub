package edu.zhku.jsj144.lzc.articleHub.exception;

import java.io.IOException;
import java.sql.SQLException;

import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import edu.zhku.jsj144.lzc.articleHub.pojo.EchoMessage;

@ControllerAdvice
public class CtrlExceptionHandler {

	@ExceptionHandler(IOException.class)
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	@ResponseBody
	public EchoMessage handleIOException(IOException ex) {
		ex.printStackTrace();
        return new EchoMessage("IOERROR");
	}
	
	@ExceptionHandler({SQLException.class, DataAccessException.class})
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	@ResponseBody
	public EchoMessage handleDBException(SQLException ex1, DataAccessException ex2) {
		ex1.printStackTrace();
		ex2.printStackTrace();
        return new EchoMessage("DBERROR");
	}
	
	@ExceptionHandler(Exception.class)
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	@ResponseBody
	public EchoMessage handleAllException(Exception ex) {
		ex.printStackTrace();
        return new EchoMessage("SYSERROR");
	}
}
