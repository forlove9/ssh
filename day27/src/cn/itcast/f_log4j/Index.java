package cn.itcast.f_log4j;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class Index extends HttpServlet {
	
	
	Log log =  LogFactory.getLog(Index.class);

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			log.info("����servlet");
			int i = 1/0;
			log.info("����servlet����");
		} catch (Exception e) {
			log.error("�����쳣��",e);
		}

	}

}
