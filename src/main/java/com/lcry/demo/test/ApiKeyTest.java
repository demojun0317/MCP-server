package com.lcry.demo.test;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;

/**
 * API密钥测试类
 */
@Component
public class ApiKeyTest {

    @Value("${weather.api.key}")
    private String apiKey;

    public void testApiKey() {
        // 检查API密钥是否为demo
        if ("demo".equals(apiKey) || apiKey == null || apiKey.trim().isEmpty()) {
            System.out.println("⚠️ 警告：正在使用demo API密钥，某些功能可能受限");
            System.out.println("💡 建议：请注册OpenWeatherMap获取免费API密钥");
            System.out.println("🔗 注册地址：https://openweathermap.org/api");
            System.out.println("📝 配置方法：在application.yml中设置weather.api.key为你的API密钥");
            return;
        }

        WebClient webClient = WebClient.builder()
                .baseUrl("http://api.openweathermap.org/data/2.5")
                .build();

        String testUrl = "/weather?q=London&appid=" + apiKey + "&units=metric";

        try {
            String response = webClient.get()
                    .uri(testUrl)
                    .retrieve()
                    .bodyToMono(String.class)
                    .timeout(java.time.Duration.ofSeconds(30)) // 增加超时时间到30秒
                    .block();

            if (response.contains("401")) {
                System.out.println("❌ API密钥无效或已过期");
                System.out.println("💡 请检查API密钥是否正确，或重新生成API密钥");
                System.out.println("🔗 获取免费API密钥：https://openweathermap.org/api");
            } else if (response.contains("cod") && response.contains("200")) {
                System.out.println("✅ API密钥有效，连接正常");
            } else {
                System.out.println("⚠️ API响应异常，请检查网络连接");
                System.out.println("📡 响应内容：" + response);
            }
        } catch (WebClientResponseException e) {
            System.out.println("❌ HTTP错误: " + e.getStatusCode() + " - " + e.getStatusText());
            if (e.getStatusCode().value() == 401) {
                System.out.println("💡 请检查API密钥是否正确");
                System.out.println("🔗 获取免费API密钥：https://openweathermap.org/api");
            } else if (e.getStatusCode().value() == 404) {
                System.out.println("💡 404错误通常表示API端点不存在，请检查API版本");
                System.out.println("📝 当前使用API v2.5，这是免费版本");
            }
        } catch (Exception e) {
            System.out.println("❌ API测试失败: " + e.getMessage());
            if (e.getMessage().contains("timeout")) {
                System.out.println("💡 网络连接超时，请检查网络设置或稍后重试");
            }
        }
    }
} 