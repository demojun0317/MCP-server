package com.lcry.demo;

import com.lcry.demo.test.ApiKeyTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author lcry
 */
@SpringBootApplication
public class JavaMcpDemoApplication implements CommandLineRunner {

    @Autowired
    private ApiKeyTest apiKeyTest;

    public static void main(String[] args) {
        SpringApplication.run(JavaMcpDemoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        // 启动时测试API密钥
//        System.out.println("🔍 正在测试OpenWeatherMap API密钥...");
//        apiKeyTest.testApiKey();
        System.out.println("🚀 应用启动完成！");
    }
}
