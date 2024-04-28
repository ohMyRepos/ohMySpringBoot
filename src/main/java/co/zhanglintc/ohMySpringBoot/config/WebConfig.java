package co.zhanglintc.ohMySpringBoot.config;

import co.zhanglintc.ohMySpringBoot.interceptors.DemoInterceptor1;
import co.zhanglintc.ohMySpringBoot.interceptors.DemoInterceptor2;
import co.zhanglintc.ohMySpringBoot.interceptors.DemoInterceptor3;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Autowired
    private DemoInterceptor1 demoInterceptor1;
    @Autowired
    private DemoInterceptor2 demoInterceptor2;
    @Autowired
    private DemoInterceptor3 demoInterceptor3;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(demoInterceptor1)
                .addPathPatterns("/**");

        registry.addInterceptor(demoInterceptor2)
                .addPathPatterns("/**");

        registry.addInterceptor(demoInterceptor3)
                .addPathPatterns("/**");
    }
}
