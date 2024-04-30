package co.zhanglintc.ohMySpringBoot;

import com.ctrip.framework.apollo.spring.annotation.EnableApolloConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan
@EnableApolloConfig
// @EnableNacosConfig(globalProperties = @NacosProperties(serverAddr = "192.168.33.10:8848"))
// @NacosPropertySource(dataId = "ohMySpringBoot", autoRefreshed = true)
public class OhMySpringBootApplication {

    public static void main(String[] args) {
        SpringApplication.run(OhMySpringBootApplication.class, args);
    }

}
