package servlet;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.sun.mail.imap.protocol.Item;

import utils.JdbcUtils;

/**
 * Servlet implementation class UploadServlet
 */
@WebServlet("/UploadServlet")
public class UploadServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			FileItemFactory factory=new DiskFileItemFactory();
			ServletFileUpload fileUpload=new ServletFileUpload(factory);
			fileUpload.setFileSizeMax(10*1024*1024);
			fileUpload.setSizeMax(50*1024*1024);
			fileUpload.setHeaderEncoding("UTF-8");
			if(fileUpload.isMultipartContent(request)){
				List<FileItem> list = fileUpload.parseRequest(request);
				for (FileItem fileItem : list) {
					if(fileItem.isFormField()){
						String fieldName = fileItem.getFieldName();
						String content = fileItem.getString();
						System.out.println(fieldName+""+content);
					}else {
						String name = fileItem.getName();
						QueryRunner qr = JdbcUtils.getQuerrRunner();
						qr.update("insert into hello(img) values(?)",name);
						request.setAttribute("name", name);
						InputStream in = fileItem.getInputStream();
						String path = getServletContext().getRealPath("/upload");
						File file=new File(path,name);						
						fileItem.write(file);
						fileItem.delete();   //删除系统产生的临时文件
						request.getRequestDispatcher("show.jsp").forward(request, response);
						
					}
				}
			}else {
				System.out.println("当前表单不是文件上传表单，处理失败！");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
