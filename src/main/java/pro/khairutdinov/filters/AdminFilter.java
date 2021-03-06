package pro.khairutdinov.filters;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter(urlPatterns = "/admin/*")
public class AdminFilter implements Filter {
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("Фильтр запущен");
    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        filterChain.doFilter(servletRequest,servletResponse); // Пропускает фильтр
    }

    public void destroy() {

    }
}
