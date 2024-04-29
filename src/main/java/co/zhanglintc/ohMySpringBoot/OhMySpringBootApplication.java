package co.zhanglintc.ohMySpringBoot;

import com.ctrip.framework.apollo.spring.annotation.EnableApolloConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan
@EnableApolloConfig
public class OhMySpringBootApplication {

    public static void main(String[] args) {
        SpringApplication.run(OhMySpringBootApplication.class, args);
    }

}
