package top.kgoogle.servlet;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.WebApplicationContext;
import top.kgoogle.dao.userDao;
import top.kgoogle.data.choose;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Writer;

@WebServlet(name = "deleteChoose" ,urlPatterns = "/check/deleteChoose")
public class deleteChoose extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        int bookID = Integer.valueOf(request.getParameter("bookID"));
        int userId = Integer.valueOf(request.getParameter("userID"));
        choose c ;
        ApplicationContext applicationContext = (ApplicationContext)this.getServletContext().getAttribute(WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE);
        userDao ud = (userDao)applicationContext.getBean("userDao");
        DetachedCriteria detachedCriteria = DetachedCriteria.forClass(choose.class);
        detachedCriteria.add(Restrictions.eq("userID",userId));
        detachedCriteria.add(Restrictions.eq("bookID",bookID));
        if(ud.getHibernateTemplate().findByCriteria(detachedCriteria).size()>0) {
            c = (choose) ud.getHibernateTemplate().findByCriteria(detachedCriteria).get(0);
            ud.delete(c);
            response.setContentType("text/html; charset=utf-8");
            Writer writer = response.getWriter();
            writer.write("删除成功~,点击<a href=\"/check/norManage.jsp\">这里</a>进行跳转");
            writer.close();
        }else{
            response.setContentType("text/html; charset=utf-8");
            Writer writer = response.getWriter();
            writer.write("查无此记录~,点击<a href=\"/check/norManage.jsp\">这里</a>进行跳转");
            writer.close();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
