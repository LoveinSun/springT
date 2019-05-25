package top.kgoogle.servlet;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.WebApplicationContext;
import top.kgoogle.dao.userDao;
import top.kgoogle.dao.userDaoImp;
import top.kgoogle.data.user;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
@WebServlet(name="myServlet",urlPatterns = "/myServlet")
public class myServlet extends HttpServlet {
    @Test
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setHeader("Content-type", "text/html;charset=UTF-8");//告知浏览器编码方式;
        ApplicationContext applicationContext=(ApplicationContext) this.getServletContext().getAttribute(WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE);
        userDao u = (userDao) applicationContext.getBean("userDao");
        user ui = u.getHibernateTemplate().get(new top.kgoogle.data.user().getClass(),1);
        String a = ui.name+ui.pwd+ui.level;
        try (PrintWriter pw = response.getWriter()) {
            pw.append(a);
            response.setCharacterEncoding("UTF-8");
            pw.flush();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
