package top.kgoogle.servlet;

import org.hibernate.HibernateException;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.WebApplicationContext;
import top.kgoogle.dao.userDao;
import top.kgoogle.data.user;
import top.kgoogle.utils.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Writer;
import java.sql.ResultSet;
import java.sql.SQLException;


@WebServlet(name = "register" ,urlPatterns = "/register")
public class register extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String sql = "select count(*) from user where name = ?";
		Object []arg = {request.getParameter("uname")};
		ResultSet rs =  DButil.select(sql,arg);
		int f = 0;
		try {
			if(rs!=null) {
				rs.next();
				f = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if(f>0){
			request.getRequestDispatcher("index.jsp").forward(request,response);
		}else{
			try {
				user user  = new user(request.getParameter("uname"),request.getParameter("upwd"),1);
				ApplicationContext applicationContext=(ApplicationContext)this.getServletContext().getAttribute(WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE);
				userDao userdao = (userDao)applicationContext.getBean("userDao");
				userdao.save(user);
				response.setContentType("text/html; charset=utf-8");
				Writer writer = response.getWriter();
				writer.write("注册成功~,点击<a href=\"/check/norManage.jsp\">这里</a>进行跳转");
				writer.close();
			} catch (HibernateException e) {
				Writer writer = response.getWriter();
				writer.write("注册失败，重名~,点击<a href=\"/check/norManage.jsp\">这里</a>进行跳转");
				writer.close();
				e.printStackTrace();
			}
		}
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request,response);
    }
}
