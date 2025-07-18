package com.lcry.demo.test;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;
import reactor.core.publisher.Mono;

import java.time.Duration;

/**
 * 抖音API密钥测试类
 */
@Component
public class DouyinApiKeyTest {

    public static void main(String[] args) {
        // 创建WebClient实例，配置超时和重定向
        WebClient webClient = WebClient.builder()
                .codecs(configurer -> configurer.defaultCodecs().maxInMemorySize(10 * 1024 * 1024)) // 10MB
                .build();
        var multipartData = BodyInserters
                .fromMultipartData("method", "douyinVideoToInfo")
                .with("share_link", "8.48 c@A.tR Euf:/ 01/30 每天一分钟轻松学古诗 山行 杜牧 远上寒山石径斜@抖音小助手 # 看见音乐计划 # 诗词鉴赏 # # 国学启蒙 # 动画古诗轻松学会 # 即梦ai https://v.douyin.com/BJZulrLzwIQ/ 复制此链接，打开Dou音搜索，直接观看视频！")
                .with("type", "1")
                .with("api_key", "9e6868e608ad09db26081a9ba86313e0");
        Object respone = webClient.post()
                .uri("https://www.action-ai.cn/index.php/api/index")
                .contentType(MediaType.MULTIPART_FORM_DATA)
                .body(multipartData)
                .retrieve()
                .bodyToMono(Object.class)
                .timeout(Duration.ofSeconds(30))
                .onErrorReturn("获取信息失败，请检查地址是否正常。")
                .block();
        System.out.println(respone);
    }


} 