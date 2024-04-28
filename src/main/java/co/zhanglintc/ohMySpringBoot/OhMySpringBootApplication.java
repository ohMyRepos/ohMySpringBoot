package co.zhanglintc.ohMySpringBoot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan
public class OhMySpringBootApplication {

    public static void main(String[] args) {
        SpringApplication.run(OhMySpringBootApplication.class, args);
    }

}
