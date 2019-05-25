package top.kgoogle.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(filterName = "CheckL")
public class CheckL implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request=(HttpServletRequest)req;
        HttpServletResponse response=(HttpServletResponse)resp;
        try{
            int a = (int)request.getSession().getAttribute("judge");
            System.out.println(a);
            if(a==1){
                chain.doFilter(req, resp);
            }else{
                response.sendRedirect("../index.jsp");
            }
        }catch (Exception e){
            response.sendRedirect("../index.jsp");
            System.out.println("过滤器捕获异常");
            e.printStackTrace();
        }
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
