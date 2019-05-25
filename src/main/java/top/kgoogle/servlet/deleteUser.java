package top.kgoogle.servlet;

import org.hibernate.Criteria;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.hibernate.internal.CriteriaImpl;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.context.WebApplicationContext;
import top.kgoogle.dao.userDao;
import top.kgoogle.data.user;
import top.kgoogle.utils.DButil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Writer;
import java.util.List;

@WebServlet(name = "deleteUser",urlPatterns = "/check/deleteUser")
public class deleteUser extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String a =  request.getParameter("uName");
        response.setHeader("Content-type", "text/html;charset=UTF-8");//告知浏览器编码方式;
        ApplicationContext applicationContext=(ApplicationContext) this.getServletContext().getAttribute(WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE);
        userDao ud = (userDao) applicationContext.getBean("userDao");
        user ut = new user();
        ut.setName(a);
        ut.setLevel(1);
        DetachedCriteria criteria = DetachedCriteria.forClass(user.class);
        criteria.add(Restrictions.eq("name",a));
        int id  = 0;
        try {
            List<?> l = ud.getHibernateTemplate().findByCriteria(criteria);
            ut =(user)l.get(0);
            id = ut.id;
        }catch (Exception e){
            id =0;
            e.printStackTrace();
        }
        if(id>0) {
            ud.delete(ut);
            response.setContentType("text/html; charset=utf-8");
            Writer writer = response.getWriter();
            writer.write("删除成功~,点击<a href=\"/check/manManage.jsp\">这里</a>进行跳转");
            writer.close();
        }else{
            response.setContentType("text/html; charset=utf-8");
            Writer writer = response.getWriter();
            writer.write("查无此人~,点击<a href=\"/check/manManage.jsp\">这里</a>进行跳转");
            writer.close();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
