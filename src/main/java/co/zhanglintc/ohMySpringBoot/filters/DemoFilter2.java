package co.zhanglintc.ohMySpringBoot.filters;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter(urlPatterns = "/*", filterName = "z")
public class DemoFilter2 implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("DemoFilter2 init");
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("DemoFilter2 doFilter");
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
        System.out.println("DemoFilter2 destroy");
        Filter.super.destroy();
    }
}
