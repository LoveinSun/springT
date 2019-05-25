package top.kgoogle.servlet;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.WebApplicationContext;
import top.kgoogle.dao.userDao;
import top.kgoogle.data.book;
import top.kgoogle.data.choose;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Writer;

@WebServlet(name = "addBook",urlPatterns = "/check/addBook")
public class addBook extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String bookName =  request.getParameter("bookName");
        int authorID = Integer.valueOf(request.getParameter("authorID"));
        book book = new book(bookName,authorID);
        ApplicationContext applicationContext=(ApplicationContext) this.getServletContext().getAttribute(WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE);
        userDao ud = (userDao) applicationContext.getBean("userDao");
        ud.save(book);
        response.setContentType("text/html; charset=utf-8");
        Writer writer = response.getWriter();
        writer.write("添加成功~,点击<a href=\"/check/manManage.jsp\">这里</a>进行跳转");
        writer.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
