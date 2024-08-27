package co.zhanglintc.ohMySpringBoot.runner;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

/**
 * @Classname AppRunner
 * @Description
 * @Date 2024/8/27 16:56
 * @Created by zhanglintc
 */
@Component
public class AppRunner implements ApplicationRunner {
    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("MyRunner 开始执行");

        // 模拟一些初始化操作
        for (int i = 1; i <= 5; i++) {
            System.out.println("执行任务 " + i);
            Thread.sleep(100);
        }

        System.out.println("MyRunner 执行完毕");
        System.exit(0);
    }
}
