package top.kgoogle.servlet;

import top.kgoogle.utils.DButil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Writer;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Types;

@WebServlet(name = "count",urlPatterns = "/check/count")
public class count extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        Connection con = DButil.getConnection();
        CallableStatement cstmt=null;
        int c =-1;
        try {
            cstmt = con.prepareCall("{call count1(?)}");
            cstmt.registerOutParameter(1, Types.INTEGER);
            cstmt.execute();
            c = cstmt.getInt(1);
            cstmt.close();
            con.close();
        }catch (Exception e){

        }
        response.setContentType("text/html; charset=utf-8");
        Writer writer = response.getWriter();
        String sq = "共有"+c+"人~,点击<a href=\"/check/manManage.jsp\">这里</a>进行跳转";
        writer.write(sq);
        writer.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
