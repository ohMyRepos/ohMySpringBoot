package co.zhanglintc.ohMySpringBoot.filters;

import org.springframework.stereotype.Component;

import javax.servlet.*;
import java.io.IOException;

@Component
public class DemoFilter3 implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("DemoFilter3 init");
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("DemoFilter3 doFilter");
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
        System.out.println("DemoFilter3 destroy");
        Filter.super.destroy();
    }
}
