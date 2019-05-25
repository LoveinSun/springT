package top.kgoogle.servlet;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.WebApplicationContext;
import top.kgoogle.dao.userDao;
import top.kgoogle.data.book;
import top.kgoogle.data.isstud;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Writer;

@WebServlet(name = "searchAuthor",urlPatterns = "/check/searchAuthor")
public class searchAuthor extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        Integer bookID = Integer.valueOf(request.getParameter("bookID"));
        book b ;
        ApplicationContext applicationContext = (ApplicationContext)this.getServletContext().getAttribute(WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE);
        userDao ud = (userDao)applicationContext.getBean("userDao");
        DetachedCriteria detachedCriteria = DetachedCriteria.forClass(book.class);
        detachedCriteria.add(Restrictions.eq("id",bookID));
        if(ud.getHibernateTemplate().findByCriteria(detachedCriteria).size()>0) {
            b = (book) ud.getHibernateTemplate().findByCriteria(detachedCriteria).get(0);
            detachedCriteria = DetachedCriteria.forClass(isstud.class);
            detachedCriteria.add(Restrictions.eq("id",b.authorID));
            isstud is = (isstud) ud.getHibernateTemplate().findByCriteria(detachedCriteria).get(0);
            String date = "<ul>" +
                    "<li>书籍名  ："+b.name+"</li><br/>" +
                    "<li>书籍id  ："+b.id+"</li><br/>" +
                    "<li>书籍作者："+is.name+"</li><br/>" +
                    "<li>作者id  :"+is.id+"</li><br/>" +
                    "</ul><br/>" +
                    "点击<a href=\"/check/norManage.jsp\">这里</a>进行跳转";
            response.setContentType("text/html; charset=utf-8");
            Writer writer = response.getWriter();
            writer.write(date);
            writer.close();
        }else{
            response.setContentType("text/html; charset=utf-8");
            Writer writer = response.getWriter();
            writer.write("查无此记录~,点击<a href=\"/check/norManage.jsp\">这里</a>进行跳转");
            writer.close();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
