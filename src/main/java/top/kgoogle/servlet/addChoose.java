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

@WebServlet(name = "addChoose",urlPatterns = "/check/addChoose")
public class addChoose extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        int userID =  Integer.valueOf(request.getParameter("userID"));
        int bookID =  Integer.valueOf(request.getParameter("bookID"));
        String begin = request.getParameter("begin");
        String end =  request.getParameter("end");
        choose ch = new choose(bookID,userID,begin,end);
        response.setHeader("Content-type", "text/html;charset=UTF-8");//告知浏览器编码方式;
        ApplicationContext applicationContext=(ApplicationContext) this.getServletContext().getAttribute(WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE);
        userDao ud = (userDao) applicationContext.getBean("userDao");
        DetachedCriteria dc = DetachedCriteria.forClass(choose.class);
        dc.add(Restrictions.eq("bookID",bookID));
        response.setContentType("text/html; charset=utf-8");
        if(ud.getHibernateTemplate().findByCriteria(dc).size()>0){
            Writer writer = response.getWriter();
            writer.write("此书已被借阅，添加记录失败~,点击<a href=\"/check/norManage.jsp\">这里</a>进行跳转");
            writer.close();
        }
        ud.save(ch);
        Writer writer = response.getWriter();
        writer.write("添加成功~,点击<a href=\"/check/norManage.jsp\">这里</a>进行跳转");
        writer.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
