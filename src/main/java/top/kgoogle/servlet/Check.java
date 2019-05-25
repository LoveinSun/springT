package top.kgoogle.servlet;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.WebApplicationContext;
import top.kgoogle.dao.userDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Writer;
@WebServlet(name = "Check",urlPatterns = "/Check")
public class Check extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("utf-8");
        int key=Integer.valueOf(request.getParameter("key"));
        ApplicationContext applicationContext=(ApplicationContext)this.getServletContext().getAttribute(WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE);
        userDao userdao = (userDao)applicationContext.getBean("userDao");
        int a = userdao.login(request.getParameter("name"), request.getParameter("pwd"),Integer.valueOf(request.getParameter("key")));
        if(a>0&&key==1){
            request.getSession().setAttribute("judge",1);
            response.sendRedirect("./check/norManage.jsp?");
        }else if(a>0&&key==0){
            request.getSession().setAttribute("judge",1);
            response.sendRedirect("./check/manManage.jsp?");
        }else{
            response.setContentType("text/html; charset=utf-8");
            Writer writer = response.getWriter();
            writer.write("用户名或密码错误,点击<a href=\"index.jsp\">这里</a>进行跳转");
            writer.close();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
