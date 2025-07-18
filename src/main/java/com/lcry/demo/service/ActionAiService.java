package com.lcry.demo.service;

import org.springframework.ai.tool.annotation.Tool;
import org.springframework.ai.tool.annotation.ToolParam;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.time.Duration;

/**
 * ActionAiService - 插件平台服务
 *
 * @author lxq
 * @since 2025/07/16 9:26
 */
@Service
public class ActionAiService {
    private final WebClient webClient;

    @Value("${action-ai.api.DouYinApiBaseUrl}")
    private String ACTIONAI_API_BASE_URL;
    @Value("${action-ai.api.querykeyUrl}")
    private String querykeyUrl;




    public ActionAiService(WebClient webClient) {
        this.webClient = webClient;
    }

    /********************************************抖音系列***************************************************/
    @Tool(description = "根据抖音分享链接获取视频及文案")
    public String DouyinVideoToInfo(@ToolParam(description = "秘钥") String api_key, @ToolParam(description = "抖音分享内容") String share_link, @ToolParam(description = "1：视频地址、视频封面地址 2：视频地址、视频封面地址、音频地址 3：视频地址、视频封面地址、音频地址、字幕文案") String type) {
        try {
            // 使用 MULTIPART_FORM_DATA 和 fromMultipartData，与测试保持一致
            var multipartData = org.springframework.web.reactive.function.BodyInserters
                    .fromMultipartData("method", "douyinVideoToInfo")
                    .with("api_key", api_key)
                    .with("share_link", share_link)
                    .with("type", type);
            return webClient.post()
                    .uri(ACTIONAI_API_BASE_URL)
                    .contentType(org.springframework.http.MediaType.MULTIPART_FORM_DATA)
                    .body(multipartData)
                    .retrieve()
                    .bodyToMono(String.class)
                    .timeout(Duration.ofSeconds(30))
                    .onErrorReturn("获取信息失败，请检查参数是否正常。")
                    .block();
        } catch (Exception e) {
            return "获取信息时发生错误: " + e.getMessage();
        }
    }
    @Tool(description = "解析抖音视频下载地址（无水印）")
    public String douyinVideoToMessage(@ToolParam(description = "秘钥") String api_key,@ToolParam(description = "作品链接") String video_url) {
        try {
            // 使用 MULTIPART_FORM_DATA 和 fromMultipartData，与测试保持一致
            var multipartData = org.springframework.web.reactive.function.BodyInserters
                    .fromMultipartData("method", "douyinVideoToMessage")
                    .with("api_key", api_key)
                    .with("video_url", video_url);
            return webClient.post()
                    .uri(ACTIONAI_API_BASE_URL)
                    .contentType(org.springframework.http.MediaType.MULTIPART_FORM_DATA)
                    .body(multipartData)
                    .retrieve()
                    .bodyToMono(String.class)
                    .timeout(Duration.ofSeconds(30))
                    .onErrorReturn("获取信息失败，请检查参数是否正常。")
                    .block();
        } catch (Exception e) {
            return "获取信息时发生错误: " + e.getMessage();
        }
    }

    @Tool(description = "抓取抖音主页数据（带翻页）")
    public String douyinVideoToHome(@ToolParam(description = "秘钥") String api_key,@ToolParam(description = "主页链接") String home_page,@ToolParam(description = "最大翻页数，每页20条数据，1代表不翻页") String max_pages) {
        try {
            // 使用 MULTIPART_FORM_DATA 和 fromMultipartData，与测试保持一致
            var multipartData = org.springframework.web.reactive.function.BodyInserters
                    .fromMultipartData("method", "douyinVideoToHome")
                    .with("api_key", api_key)
                    .with("home_page", home_page)
                    .with("max_pages", max_pages);
            return webClient.post()
                    .uri(ACTIONAI_API_BASE_URL)
                    .contentType(org.springframework.http.MediaType.MULTIPART_FORM_DATA)
                    .body(multipartData)
                    .retrieve()
                    .bodyToMono(String.class)
                    .timeout(Duration.ofSeconds(30))
                    .onErrorReturn("获取信息失败，请检查参数是否正常。")
                    .block();
        } catch (Exception e) {
            return "获取信息时发生错误: " + e.getMessage();
        }
    }
    @Tool(description = "抖音作品数据解析")
    public String douyinVideoToData(@ToolParam(description = "秘钥") String api_key,@ToolParam(description = "抖音作品链接") String video_url) {
        try {
            // 使用 MULTIPART_FORM_DATA 和 fromMultipartData，与测试保持一致
            var multipartData = org.springframework.web.reactive.function.BodyInserters
                    .fromMultipartData("method", "douyinVideoToData")
                    .with("api_key", api_key)
                    .with("video_url", video_url);
            return webClient.post()
                    .uri(ACTIONAI_API_BASE_URL)
                    .contentType(org.springframework.http.MediaType.MULTIPART_FORM_DATA)
                    .body(multipartData)
                    .retrieve()
                    .bodyToMono(String.class)
                    .timeout(Duration.ofSeconds(30))
                    .onErrorReturn("获取信息失败，请检查参数是否正常。")
                    .block();
        } catch (Exception e) {
            return "获取信息时发生错误: " + e.getMessage();
        }
    }
    @Tool(description = "抓取抖音作品评论")
    public String douyinVideoToComment(@ToolParam(description = "秘钥") String api_key,@ToolParam(description = "抖音作品链接") String video_url,@ToolParam(description = "评论数，最大50条") String max_count) {
        try {
            // 使用 MULTIPART_FORM_DATA 和 fromMultipartData，与测试保持一致
            var multipartData = org.springframework.web.reactive.function.BodyInserters
                    .fromMultipartData("method", "douyinVideoToComment")
                    .with("api_key", api_key)
                    .with("video_url", video_url)
                    .with("max_count", max_count);
            return webClient.post()
                    .uri(ACTIONAI_API_BASE_URL)
                    .contentType(org.springframework.http.MediaType.MULTIPART_FORM_DATA)
                    .body(multipartData)
                    .retrieve()
                    .bodyToMono(String.class)
                    .timeout(Duration.ofSeconds(30))
                    .onErrorReturn("获取信息失败，请检查参数是否正常。")
                    .block();
        } catch (Exception e) {
            return "获取信息时发生错误: " + e.getMessage();
        }
    }
    @Tool(description = "音视频转文字")
    public String audioToExtraction(@ToolParam(description = "秘钥") String api_key,@ToolParam(description = "音频可访问链接") String file_url) {
        try {
            // 使用 MULTIPART_FORM_DATA 和 fromMultipartData，与测试保持一致
            var multipartData = org.springframework.web.reactive.function.BodyInserters
                    .fromMultipartData("method", "audioToExtraction")
                    .with("api_key", api_key)
                    .with("file_url", file_url);
            return webClient.post()
                    .uri(ACTIONAI_API_BASE_URL)
                    .contentType(org.springframework.http.MediaType.MULTIPART_FORM_DATA)
                    .body(multipartData)
                    .retrieve()
                    .bodyToMono(String.class)
                    .timeout(Duration.ofSeconds(30))
                    .onErrorReturn("获取信息失败，请检查参数是否正常。")
                    .block();
        } catch (Exception e) {
            return "获取信息时发生错误: " + e.getMessage();
        }
    }
    @Tool(description = "抖音关键词搜索视频")
    public String douyinVideoToSearch(@ToolParam(description = "秘钥") String api_key,@ToolParam(description = "搜索关键词") String keyword,@ToolParam(description = "最大页数，每页10条") String max_pages,@ToolParam(description = "发布时间，默认0，0-不限 1-最近一天 7-最近一周 180-最近半年") String publish_time,@ToolParam(description = "排序方式，默认0，0-综合排序 1-最多点赞 2-最新发布") String sort_type) {
        try {
            // 使用 MULTIPART_FORM_DATA 和 fromMultipartData，与测试保持一致
            var multipartData = org.springframework.web.reactive.function.BodyInserters
                    .fromMultipartData("method", "douyinVideoToSearch")
                    .with("api_key", api_key)
                    .with("keyword", keyword)
                    .with("max_pages", max_pages)
                    .with("keyword", keyword)
                    .with("publish_time", publish_time)
                    .with("sort_type", sort_type);
            return webClient.post()
                    .uri(ACTIONAI_API_BASE_URL)
                    .contentType(org.springframework.http.MediaType.MULTIPART_FORM_DATA)
                    .body(multipartData)
                    .retrieve()
                    .bodyToMono(String.class)
                    .timeout(Duration.ofSeconds(30))
                    .onErrorReturn("获取信息失败，请检查参数是否正常。")
                    .block();
        } catch (Exception e) {
            return "获取信息时发生错误: " + e.getMessage();
        }
    }
    @Tool(description = "抖音关键词搜索视频 V2")
    public String douyinVideoToSearchs(@ToolParam(description = "秘钥") String api_key,@ToolParam(description = "搜索关键词") String keyword) {
        try {
            // 使用 MULTIPART_FORM_DATA 和 fromMultipartData，与测试保持一致
            var multipartData = org.springframework.web.reactive.function.BodyInserters
                    .fromMultipartData("method", "douyinVideoToSearchs")
                    .with("api_key", api_key)
                    .with("keyword", keyword);
            return webClient.post()
                    .uri(ACTIONAI_API_BASE_URL)
                    .contentType(org.springframework.http.MediaType.MULTIPART_FORM_DATA)
                    .body(multipartData)
                    .retrieve()
                    .bodyToMono(String.class)
                    .timeout(Duration.ofSeconds(30))
                    .onErrorReturn("获取信息失败，请检查参数是否正常。")
                    .block();
        } catch (Exception e) {
            return "获取信息时发生错误: " + e.getMessage();
        }
    }
    @Tool(description = "抓取抖音即时热搜榜")
    public String douyinToHot(@ToolParam(description = "秘钥") String api_key) {
        try {
            // 使用 MULTIPART_FORM_DATA 和 fromMultipartData，与测试保持一致
            var multipartData = org.springframework.web.reactive.function.BodyInserters
                    .fromMultipartData("method", "douyinToHot")
                    .with("api_key", api_key);
            return webClient.post()
                    .uri(ACTIONAI_API_BASE_URL)
                    .contentType(org.springframework.http.MediaType.MULTIPART_FORM_DATA)
                    .body(multipartData)
                    .retrieve()
                    .bodyToMono(String.class)
                    .timeout(Duration.ofSeconds(30))
                    .onErrorReturn("获取信息失败，请检查参数是否正常。")
                    .block();
        } catch (Exception e) {
            return "获取信息时发生错误: " + e.getMessage();
        }
    }
    @Tool(description = "抖音单视频解析")
    public String douyinVideoToInfos(@ToolParam(description = "秘钥") String api_key,@ToolParam(description = "抖音分享链接") String url) {
        try {
            // 使用 MULTIPART_FORM_DATA 和 fromMultipartData，与测试保持一致
            var multipartData = org.springframework.web.reactive.function.BodyInserters
                    .fromMultipartData("method", "douyinVideoToInfos")
                    .with("api_key", api_key)
                    .with("url", url);
            return webClient.post()
                    .uri(ACTIONAI_API_BASE_URL)
                    .contentType(org.springframework.http.MediaType.MULTIPART_FORM_DATA)
                    .body(multipartData)
                    .retrieve()
                    .bodyToMono(String.class)
                    .timeout(Duration.ofSeconds(30))
                    .onErrorReturn("获取信息失败，请检查参数是否正常。")
                    .block();
        } catch (Exception e) {
            return "获取信息时发生错误: " + e.getMessage();
        }
    }
    @Tool(description = "聚合短视频解析")
    public String aggregateToVideo(@ToolParam(description = "秘钥") String api_key,@ToolParam(description = "抖音快手火山视频西瓜视频皮皮虾秒拍头条视频腾讯微视美图秀秀美拍微博小红书网易云等视频访问地址") String url) {
        try {
            // 使用 MULTIPART_FORM_DATA 和 fromMultipartData，与测试保持一致
            var multipartData = org.springframework.web.reactive.function.BodyInserters
                    .fromMultipartData("method", "aggregateToVideo")
                    .with("api_key", api_key)
                    .with("url", url);
            return webClient.post()
                    .uri(ACTIONAI_API_BASE_URL)
                    .contentType(org.springframework.http.MediaType.MULTIPART_FORM_DATA)
                    .body(multipartData)
                    .retrieve()
                    .bodyToMono(String.class)
                    .timeout(Duration.ofSeconds(30))
                    .onErrorReturn("获取信息失败，请检查参数是否正常。")
                    .block();
        } catch (Exception e) {
            return "获取信息时发生错误: " + e.getMessage();
        }
    }
    @Tool(description = "抖音分享文本解析链接")
    public String douyinToTextUrl(@ToolParam(description = "秘钥") String api_key,@ToolParam(description = "抖音分享内容") String share_url
    ) {
        try {
            // 使用 MULTIPART_FORM_DATA 和 fromMultipartData，与测试保持一致
            var multipartData = org.springframework.web.reactive.function.BodyInserters
                    .fromMultipartData("method", "douyinToTextUrl")
                    .with("api_key", api_key)
                    .with("share_url", share_url);
            return webClient.post()
                    .uri(ACTIONAI_API_BASE_URL)
                    .contentType(org.springframework.http.MediaType.MULTIPART_FORM_DATA)
                    .body(multipartData)
                    .retrieve()
                    .bodyToMono(String.class)
                    .timeout(Duration.ofSeconds(30))
                    .onErrorReturn("获取信息失败，请检查参数是否正常。")
                    .block();
        } catch (Exception e) {
            return "获取信息时发生错误: " + e.getMessage();
        }
    }
    @Tool(description = "抖音用户信息查询")
    public String douyinVideoToAuthor(@ToolParam(description = "秘钥") String api_key,@ToolParam(description = "抖音用户主页地址") String url
    ) {
        try {
            // 使用 MULTIPART_FORM_DATA 和 fromMultipartData，与测试保持一致
            var multipartData = org.springframework.web.reactive.function.BodyInserters
                    .fromMultipartData("method", "douyinVideoToAuthor")
                    .with("api_key", api_key)
                    .with("url", url);
            return webClient.post()
                    .uri(ACTIONAI_API_BASE_URL)
                    .contentType(org.springframework.http.MediaType.MULTIPART_FORM_DATA)
                    .body(multipartData)
                    .retrieve()
                    .bodyToMono(String.class)
                    .timeout(Duration.ofSeconds(30))
                    .onErrorReturn("获取信息失败，请检查参数是否正常。")
                    .block();
        } catch (Exception e) {
            return "获取信息时发生错误: " + e.getMessage();
        }
    }




    /********************************************小红书系列***************************************************/
    @Tool(description = "抓取小红书主页笔记（带翻页）")
    public String xiaohongshuToReader(@ToolParam(description = "秘钥") String api_key,@ToolParam(description = "用户ID") String user_id,@ToolParam(description = "最大页数，每页20条笔记") String max_pages) {
        try {
            // 使用 MULTIPART_FORM_DATA 和 fromMultipartData，与测试保持一致
            var multipartData = org.springframework.web.reactive.function.BodyInserters
                    .fromMultipartData("method", "xiaohongshuToReader")
                    .with("api_key", api_key)
                    .with("user_id", user_id)
                    .with("max_pages", max_pages);
            return webClient.post()
                    .uri(ACTIONAI_API_BASE_URL)
                    .contentType(org.springframework.http.MediaType.MULTIPART_FORM_DATA)
                    .body(multipartData)
                    .retrieve()
                    .bodyToMono(String.class)
                    .timeout(Duration.ofSeconds(30))
                    .onErrorReturn("获取信息失败，请检查参数是否正常。")
                    .block();
        } catch (Exception e) {
            return "获取信息时发生错误: " + e.getMessage();
        }
    }
    @Tool(description = "抓取小红书主页笔记（带翻页）高速版")
    public String xiaohongshuToReaderHigh(@ToolParam(description = "秘钥") String api_key,@ToolParam(description = "用户ID") String user_id,@ToolParam(description = "最大页数，每页20条笔记") String max_pages) {
        try {
            // 使用 MULTIPART_FORM_DATA 和 fromMultipartData，与测试保持一致
            var multipartData = org.springframework.web.reactive.function.BodyInserters
                    .fromMultipartData("method", "xiaohongshuToReaderHigh")
                    .with("api_key", api_key)
                    .with("user_id", user_id)
                    .with("max_pages", max_pages);
            return webClient.post()
                    .uri(ACTIONAI_API_BASE_URL)
                    .contentType(org.springframework.http.MediaType.MULTIPART_FORM_DATA)
                    .body(multipartData)
                    .retrieve()
                    .bodyToMono(String.class)
                    .timeout(Duration.ofSeconds(30))
                    .onErrorReturn("获取信息失败，请检查参数是否正常。")
                    .block();
        } catch (Exception e) {
            return "获取信息时发生错误: " + e.getMessage();
        }
    }
    @Tool(description = "小红书关键词搜索笔记")
    public String xiaohongshuToSearch(@ToolParam(description = "秘钥") String api_key,@ToolParam(description = "搜索关键词") String keyword,@ToolParam(description = "最大页数，每页20条笔记") String max_pages,@ToolParam(description = "笔记类型：0(全部)、1(视频)、2(图文)") String note_type,@ToolParam(description = "排序方式：general(综合)、time_descending(最新)、popularity_descending(最热)") String sort_type) {
        try {
            // 使用 MULTIPART_FORM_DATA 和 fromMultipartData，与测试保持一致
            var multipartData = org.springframework.web.reactive.function.BodyInserters
                    .fromMultipartData("method", "xiaohongshuToSearch")
                    .with("api_key", api_key)
                    .with("keyword", keyword)
                    .with("max_pages", max_pages)
                    .with("note_type", note_type)
                    .with("sort_type", sort_type);
            return webClient.post()
                    .uri(ACTIONAI_API_BASE_URL)
                    .contentType(org.springframework.http.MediaType.MULTIPART_FORM_DATA)
                    .body(multipartData)
                    .retrieve()
                    .bodyToMono(String.class)
                    .timeout(Duration.ofSeconds(30))
                    .onErrorReturn("获取信息失败，请检查参数是否正常。")
                    .block();
        } catch (Exception e) {
            return "获取信息时发生错误: " + e.getMessage();
        }
    }
    @Tool(description = "小红书关键词搜索笔记 高速版")
    public String xiaohongshuToSearchHigh(@ToolParam(description = "秘钥") String api_key,@ToolParam(description = "搜索关键词") String keyword,@ToolParam(description = "最大页数，每页20条笔记") String max_pages,@ToolParam(description = "笔记类型：0(全部)、1(视频)、2(图文)") String note_type,@ToolParam(description = "排序方式：general(综合)、time_descending(最新)、popularity_descending(最热)") String sort_type,@ToolParam(description = "发布时间 (不限, one_day, one_week, half_year)") String note_time) {
        try {
            // 使用 MULTIPART_FORM_DATA 和 fromMultipartData，与测试保持一致
            var multipartData = org.springframework.web.reactive.function.BodyInserters
                    .fromMultipartData("method", "xiaohongshuToSearchHigh")
                    .with("api_key", api_key)
                    .with("keyword", keyword)
                    .with("max_pages", max_pages)
                    .with("note_type", note_type)
                    .with("sort_type", sort_type)
                    .with("note_time", note_time);
            return webClient.post()
                    .uri(ACTIONAI_API_BASE_URL)
                    .contentType(org.springframework.http.MediaType.MULTIPART_FORM_DATA)
                    .body(multipartData)
                    .retrieve()
                    .bodyToMono(String.class)
                    .timeout(Duration.ofSeconds(30))
                    .onErrorReturn("获取信息失败，请检查参数是否正常。")
                    .block();
        } catch (Exception e) {
            return "获取信息时发生错误: " + e.getMessage();
        }
    }
    @Tool(description = "抓取小红书单品笔记信息")
    public String xiaohongshuToNoteReader(@ToolParam(description = "秘钥") String api_key,@ToolParam(description = "笔记链接，长链接或短链接均可") String url) {
        try {
            // 使用 MULTIPART_FORM_DATA 和 fromMultipartData，与测试保持一致
            var multipartData = org.springframework.web.reactive.function.BodyInserters
                    .fromMultipartData("method", "xiaohongshuToNoteReader")
                    .with("api_key", api_key)
                    .with("url", url);
            return webClient.post()
                    .uri(ACTIONAI_API_BASE_URL)
                    .contentType(org.springframework.http.MediaType.MULTIPART_FORM_DATA)
                    .body(multipartData)
                    .retrieve()
                    .bodyToMono(String.class)
                    .timeout(Duration.ofSeconds(30))
                    .onErrorReturn("获取信息失败，请检查参数是否正常。")
                    .block();
        } catch (Exception e) {
            return "获取信息时发生错误: " + e.getMessage();
        }
    }
    @Tool(description = "小红书文案发布")
    public String notesBySupplier(@ToolParam(description = "秘钥") String api_key,@ToolParam(description = "标题") String title,@ToolParam(description = "内容") String content,@ToolParam(description = "以字符串逗号分割传递") String images) {
        try {
            // 使用 MULTIPART_FORM_DATA 和 fromMultipartData，与测试保持一致
            var multipartData = org.springframework.web.reactive.function.BodyInserters
                    .fromMultipartData("method", "notesBySupplier")
                    .with("api_key", api_key)
                    .with("title", title)
                    .with("content", content)
                    .with("images", images);
            return webClient.post()
                    .uri(ACTIONAI_API_BASE_URL)
                    .contentType(org.springframework.http.MediaType.MULTIPART_FORM_DATA)
                    .body(multipartData)
                    .retrieve()
                    .bodyToMono(String.class)
                    .timeout(Duration.ofSeconds(30))
                    .onErrorReturn("获取信息失败，请检查参数是否正常。")
                    .block();
        } catch (Exception e) {
            return "获取信息时发生错误: " + e.getMessage();
        }
    }

    @Tool(description = "抓取小红书笔记评论 高速版")
    public String xiaohongshuToNoteComment(@ToolParam(description = "秘钥") String api_key,@ToolParam(description = "web端url链接") String share_text,@ToolParam(description = "最大翻页数") String max_pages) {
        try {
            // 使用 MULTIPART_FORM_DATA 和 fromMultipartData，与测试保持一致
            var multipartData = org.springframework.web.reactive.function.BodyInserters
                    .fromMultipartData("method", "xiaohongshuToNoteComment")
                    .with("api_key", api_key)
                    .with("share_text", share_text)
                    .with("max_pages", max_pages);
            return webClient.post()
                    .uri(ACTIONAI_API_BASE_URL)
                    .contentType(org.springframework.http.MediaType.MULTIPART_FORM_DATA)
                    .body(multipartData)
                    .retrieve()
                    .bodyToMono(String.class)
                    .timeout(Duration.ofSeconds(30))
                    .onErrorReturn("获取信息失败，请检查参数是否正常。")
                    .block();
        } catch (Exception e) {
            return "获取信息时发生错误: " + e.getMessage();
        }
    }
    @Tool(description = "根据小红书id抓取小红书单品笔记信息")
    public String xiaohongshuToNoteReaderMax(@ToolParam(description = "秘钥") String api_key,@ToolParam(description = "笔记ID") String note_id) {
        try {
            // 使用 MULTIPART_FORM_DATA 和 fromMultipartData，与测试保持一致
            var multipartData = org.springframework.web.reactive.function.BodyInserters
                    .fromMultipartData("method", "xiaohongshuToNoteReaderMax")
                    .with("api_key", api_key)
                    .with("note_id", note_id);
            return webClient.post()
                    .uri(ACTIONAI_API_BASE_URL)
                    .contentType(org.springframework.http.MediaType.MULTIPART_FORM_DATA)
                    .body(multipartData)
                    .retrieve()
                    .bodyToMono(String.class)
                    .timeout(Duration.ofSeconds(30))
                    .onErrorReturn("获取信息失败，请检查参数是否正常。")
                    .block();
        } catch (Exception e) {
            return "获取信息时发生错误: " + e.getMessage();
        }
    }
    @Tool(description = "小红书获取作者信息")
    public String xiaohongshuToUserInfo(@ToolParam(description = "秘钥") String api_key,@ToolParam(description = "用户ID") String user_id) {
        try {
            // 使用 MULTIPART_FORM_DATA 和 fromMultipartData，与测试保持一致
            var multipartData = org.springframework.web.reactive.function.BodyInserters
                    .fromMultipartData("method", "xiaohongshuToUserInfo")
                    .with("api_key", api_key)
                    .with("user_id", user_id);
            return webClient.post()
                    .uri(ACTIONAI_API_BASE_URL)
                    .contentType(org.springframework.http.MediaType.MULTIPART_FORM_DATA)
                    .body(multipartData)
                    .retrieve()
                    .bodyToMono(String.class)
                    .timeout(Duration.ofSeconds(30))
                    .onErrorReturn("获取信息失败，请检查参数是否正常。")
                    .block();
        } catch (Exception e) {
            return "获取信息时发生错误: " + e.getMessage();
        }
    }


    /********************************************微博系列***************************************************/
    @Tool(description = "获取微博实时热搜榜")
    public String weiboToHot(@ToolParam(description = "秘钥") String api_key) {
        try {
            // 使用 MULTIPART_FORM_DATA 和 fromMultipartData，与测试保持一致
            var multipartData = org.springframework.web.reactive.function.BodyInserters
                    .fromMultipartData("method", "weiboToHot")
                    .with("api_key", api_key);
            return webClient.post()
                    .uri(ACTIONAI_API_BASE_URL)
                    .contentType(org.springframework.http.MediaType.MULTIPART_FORM_DATA)
                    .body(multipartData)
                    .retrieve()
                    .bodyToMono(String.class)
                    .timeout(Duration.ofSeconds(30))
                    .onErrorReturn("获取信息失败，请检查参数是否正常。")
                    .block();
        } catch (Exception e) {
            return "获取信息时发生错误: " + e.getMessage();
        }
    }
    @Tool(description = "获取微博实时热搜榜C1")
    public String weiboToHotC1(@ToolParam(description = "秘钥") String api_key) {
        try {
            // 使用 MULTIPART_FORM_DATA 和 fromMultipartData，与测试保持一致
            var multipartData = org.springframework.web.reactive.function.BodyInserters
                    .fromMultipartData("method", "weiboToHotC1")
                    .with("api_key", api_key);
            return webClient.post()
                    .uri(ACTIONAI_API_BASE_URL)
                    .contentType(org.springframework.http.MediaType.MULTIPART_FORM_DATA)
                    .body(multipartData)
                    .retrieve()
                    .bodyToMono(String.class)
                    .timeout(Duration.ofSeconds(30))
                    .onErrorReturn("获取信息失败，请检查参数是否正常。")
                    .block();
        } catch (Exception e) {
            return "获取信息时发生错误: " + e.getMessage();
        }
    }



    /********************************************聊天系列***************************************************/
    @Tool(description = "OpenAI文本聊天")
    public String textToChat(@ToolParam(description = "秘钥") String api_key,@ToolParam(description = "用户提示词") String user_content,@ToolParam(description = "系统提示词") String system_content,@ToolParam(description = "模型示例值: gpt-4o") String model) {
        try {
            // 使用 MULTIPART_FORM_DATA 和 fromMultipartData，与测试保持一致
            var multipartData = org.springframework.web.reactive.function.BodyInserters
                    .fromMultipartData("method", "textToChat")
                    .with("api_key", api_key)
                    .with("user_content", user_content)
                    .with("system_content", system_content)
                    .with("model", model);
            return webClient.post()
                    .uri(ACTIONAI_API_BASE_URL)
                    .contentType(org.springframework.http.MediaType.MULTIPART_FORM_DATA)
                    .body(multipartData)
                    .retrieve()
                    .bodyToMono(String.class)
                    .timeout(Duration.ofSeconds(30))
                    .onErrorReturn("获取信息失败，请检查参数是否正常。")
                    .block();
        } catch (Exception e) {
            return "获取信息时发生错误: " + e.getMessage();
        }
    }
    @Tool(description = "OpenAI文本聊天接口")
    public String textToChatCompletions(@ToolParam(description = "秘钥") String api_key,@ToolParam(description = "用户提示词") String user_text,@ToolParam(description = "系统提示词") String system_text,@ToolParam(description = "模型示例值:gpt-4o") String model) {
        try {
            // 使用 MULTIPART_FORM_DATA 和 fromMultipartData，与测试保持一致
            var multipartData = org.springframework.web.reactive.function.BodyInserters
                    .fromMultipartData("method", "textToChatCompletions")
                    .with("api_key", api_key)
                    .with("user_text", user_text)
                    .with("system_text", system_text)
                    .with("model", model);
            return webClient.post()
                    .uri(ACTIONAI_API_BASE_URL)
                    .contentType(org.springframework.http.MediaType.MULTIPART_FORM_DATA)
                    .body(multipartData)
                    .retrieve()
                    .bodyToMono(String.class)
                    .timeout(Duration.ofSeconds(30))
                    .onErrorReturn("获取信息失败，请检查参数是否正常。")
                    .block();
        } catch (Exception e) {
            return "获取信息时发生错误: " + e.getMessage();
        }
    }
    @Tool(description = "Claude文本聊天")
    public String textToChatChris(@ToolParam(description = "秘钥") String api_key,@ToolParam(description = "用户提示词") String user_content,@ToolParam(description = "系统提示词") String system_content,@ToolParam(description = "模型 支持claude-3-7和claude-4") String model) {
        try {
            // 使用 MULTIPART_FORM_DATA 和 fromMultipartData，与测试保持一致
            var multipartData = org.springframework.web.reactive.function.BodyInserters
                    .fromMultipartData("method", "textToChatChris")
                    .with("api_key", api_key)
                    .with("user_content", user_content)
                    .with("system_content", system_content)
                    .with("model", model);
            return webClient.post()
                    .uri(ACTIONAI_API_BASE_URL)
                    .contentType(org.springframework.http.MediaType.MULTIPART_FORM_DATA)
                    .body(multipartData)
                    .retrieve()
                    .bodyToMono(String.class)
                    .timeout(Duration.ofSeconds(30))
                    .onErrorReturn("获取信息失败，请检查参数是否正常。")
                    .block();
        } catch (Exception e) {
            return "获取信息时发生错误: " + e.getMessage();
        }
    }

    @Tool(description = "Gemini文本聊天")
    public String geminiToChat(@ToolParam(description = "秘钥") String api_key,@ToolParam(description = "用户提示词") String user_content,@ToolParam(description = "系统提示词") String system_content,@ToolParam(description = "模型 支持claude-3-7和claude-4") String model) {
        try {
            // 使用 MULTIPART_FORM_DATA 和 fromMultipartData，与测试保持一致
            var multipartData = org.springframework.web.reactive.function.BodyInserters
                    .fromMultipartData("method", "geminiToChat")
                    .with("api_key", api_key)
                    .with("user_content", user_content)
                    .with("system_content", system_content)
                    .with("model", model);
            return webClient.post()
                    .uri(ACTIONAI_API_BASE_URL)
                    .contentType(org.springframework.http.MediaType.MULTIPART_FORM_DATA)
                    .body(multipartData)
                    .retrieve()
                    .bodyToMono(String.class)
                    .timeout(Duration.ofSeconds(30))
                    .onErrorReturn("获取信息失败，请检查参数是否正常。")
                    .block();
        } catch (Exception e) {
            return "获取信息时发生错误: " + e.getMessage();
        }
    }


    /********************************************图片系列***************************************************/
    @Tool(description = "图片格式转换")
    public String imageToFormat(@ToolParam(description = "秘钥") String api_key,@ToolParam(description = "可访问图片地址") String url,@ToolParam(description = "原图片类型") String from,@ToolParam(description = "转换后类型") String to) {
        try {
            // 使用 MULTIPART_FORM_DATA 和 fromMultipartData，与测试保持一致
            var multipartData = org.springframework.web.reactive.function.BodyInserters
                    .fromMultipartData("method", "imageToFormat")
                    .with("api_key", api_key)
                    .with("url", url)
                    .with("from", from)
                    .with("to", to);
            return webClient.post()
                    .uri(ACTIONAI_API_BASE_URL)
                    .contentType(org.springframework.http.MediaType.MULTIPART_FORM_DATA)
                    .body(multipartData)
                    .retrieve()
                    .bodyToMono(String.class)
                    .timeout(Duration.ofSeconds(30))
                    .onErrorReturn("获取信息失败，请检查参数是否正常。")
                    .block();
        } catch (Exception e) {
            return "获取信息时发生错误: " + e.getMessage();
        }
    }
    @Tool(description = "获取高质量美女图片")
    public String imageTolist(@ToolParam(description = "秘钥") String api_key,@ToolParam(description = "获取数量，单次最大为10") String size) {
        try {
            // 使用 MULTIPART_FORM_DATA 和 fromMultipartData，与测试保持一致
            var multipartData = org.springframework.web.reactive.function.BodyInserters
                    .fromMultipartData("method", "imageTolist")
                    .with("api_key", api_key)
                    .with("size", size);
            return webClient.post()
                    .uri(ACTIONAI_API_BASE_URL)
                    .contentType(org.springframework.http.MediaType.MULTIPART_FORM_DATA)
                    .body(multipartData)
                    .retrieve()
                    .bodyToMono(String.class)
                    .timeout(Duration.ofSeconds(30))
                    .onErrorReturn("获取信息失败，请检查参数是否正常。")
                    .block();
        } catch (Exception e) {
            return "获取信息时发生错误: " + e.getMessage();
        }
    }
    @Tool(description = "图片黑白化")
    public String imageToBlack(@ToolParam(description = "秘钥") String api_key,@ToolParam(description = "可访问图片地址") String url) {
        try {
            // 使用 MULTIPART_FORM_DATA 和 fromMultipartData，与测试保持一致
            var multipartData = org.springframework.web.reactive.function.BodyInserters
                    .fromMultipartData("method", "imageToBlack")
                    .with("api_key", api_key)
                    .with("url", url);
            return webClient.post()
                    .uri(ACTIONAI_API_BASE_URL)
                    .contentType(org.springframework.http.MediaType.MULTIPART_FORM_DATA)
                    .body(multipartData)
                    .retrieve()
                    .bodyToMono(String.class)
                    .timeout(Duration.ofSeconds(30))
                    .onErrorReturn("获取信息失败，请检查参数是否正常。")
                    .block();
        } catch (Exception e) {
            return "获取信息时发生错误: " + e.getMessage();
        }
    }

    @Tool(description = "图片转油画")
    public String imageToCanvas(@ToolParam(description = "秘钥") String api_key,@ToolParam(description = "可访问图片地址") String url) {
        try {
            // 使用 MULTIPART_FORM_DATA 和 fromMultipartData，与测试保持一致
            var multipartData = org.springframework.web.reactive.function.BodyInserters
                    .fromMultipartData("method", "imageToCanvas")
                    .with("api_key", api_key)
                    .with("url", url);
            return webClient.post()
                    .uri(ACTIONAI_API_BASE_URL)
                    .contentType(org.springframework.http.MediaType.MULTIPART_FORM_DATA)
                    .body(multipartData)
                    .retrieve()
                    .bodyToMono(String.class)
                    .timeout(Duration.ofSeconds(30))
                    .onErrorReturn("获取信息失败，请检查参数是否正常。")
                    .block();
        } catch (Exception e) {
            return "获取信息时发生错误: " + e.getMessage();
        }
    }
    @Tool(description = "图片高斯模糊")
    public String imageToBlurred(@ToolParam(description = "秘钥") String api_key,@ToolParam(description = "可访问图片地址") String url) {
        try {
            // 使用 MULTIPART_FORM_DATA 和 fromMultipartData，与测试保持一致
            var multipartData = org.springframework.web.reactive.function.BodyInserters
                    .fromMultipartData("method", "imageToBlurred")
                    .with("api_key", api_key)
                    .with("url", url);
            return webClient.post()
                    .uri(ACTIONAI_API_BASE_URL)
                    .contentType(org.springframework.http.MediaType.MULTIPART_FORM_DATA)
                    .body(multipartData)
                    .retrieve()
                    .bodyToMono(String.class)
                    .timeout(Duration.ofSeconds(30))
                    .onErrorReturn("获取信息失败，请检查参数是否正常。")
                    .block();
        } catch (Exception e) {
            return "获取信息时发生错误: " + e.getMessage();
        }
    }
    @Tool(description = "图片压缩")
    public String imageToCompress(@ToolParam(description = "秘钥") String api_key,@ToolParam(description = "可访问图片地址") String url) {
        try {
            // 使用 MULTIPART_FORM_DATA 和 fromMultipartData，与测试保持一致
            var multipartData = org.springframework.web.reactive.function.BodyInserters
                    .fromMultipartData("method", "imageToCompress")
                    .with("api_key", api_key)
                    .with("url", url);
            return webClient.post()
                    .uri(ACTIONAI_API_BASE_URL)
                    .contentType(org.springframework.http.MediaType.MULTIPART_FORM_DATA)
                    .body(multipartData)
                    .retrieve()
                    .bodyToMono(String.class)
                    .timeout(Duration.ofSeconds(30))
                    .onErrorReturn("获取信息失败，请检查参数是否正常。")
                    .block();
        } catch (Exception e) {
            return "获取信息时发生错误: " + e.getMessage();
        }
    }
    @Tool(description = "获取动、静态壁纸")
    public String imageToWallpaper(@ToolParam(description = "秘钥") String api_key,@ToolParam(description = "需要搜索的图片描述") String msg,@ToolParam(description = "页数")String page,@ToolParam(description = "返回数量")String limit,@ToolParam(description = "android/pc,安卓和pc端")String type) {
        try {
            // 使用 MULTIPART_FORM_DATA 和 fromMultipartData，与测试保持一致
            var multipartData = org.springframework.web.reactive.function.BodyInserters
                    .fromMultipartData("method", "imageToWallpaper")
                    .with("api_key", api_key)
                    .with("msg", msg)
                    .with("page", page)
                    .with("limit", limit)
                    .with("type", type);
            return webClient.post()
                    .uri(ACTIONAI_API_BASE_URL)
                    .contentType(org.springframework.http.MediaType.MULTIPART_FORM_DATA)
                    .body(multipartData)
                    .retrieve()
                    .bodyToMono(String.class)
                    .timeout(Duration.ofSeconds(30))
                    .onErrorReturn("获取信息失败，请检查参数是否正常。")
                    .block();
        } catch (Exception e) {
            return "获取信息时发生错误: " + e.getMessage();
        }
    }
    @Tool(description = "gpt4o图片生成")
    public String imageToGptGenerate(@ToolParam(description = "秘钥") String api_key,@ToolParam(description = "生成图片的描述") String content) {
        try {
            // 使用 MULTIPART_FORM_DATA 和 fromMultipartData，与测试保持一致
            var multipartData = org.springframework.web.reactive.function.BodyInserters
                    .fromMultipartData("method", "imageToGptGenerate")
                    .with("api_key", api_key)
                    .with("content", content);
            return webClient.post()
                    .uri(ACTIONAI_API_BASE_URL)
                    .contentType(org.springframework.http.MediaType.MULTIPART_FORM_DATA)
                    .body(multipartData)
                    .retrieve()
                    .bodyToMono(String.class)
                    .timeout(Duration.ofSeconds(30))
                    .onErrorReturn("获取信息失败，请检查参数是否正常。")
                    .block();
        } catch (Exception e) {
            return "获取信息时发生错误: " + e.getMessage();
        }
    }


    /********************************************B站系列***************************************************/
    @Tool(description = "哔哩哔哩视频解析")
    public String bilibiliToInfo(@ToolParam(description = "秘钥") String api_key,@ToolParam(description = "视频BV号") String bvid) {
        try {
            // 使用 MULTIPART_FORM_DATA 和 fromMultipartData，与测试保持一致
            var multipartData = org.springframework.web.reactive.function.BodyInserters
                    .fromMultipartData("method", "bilibiliToInfo")
                    .with("api_key", api_key)
                    .with("bvid", bvid);
            return webClient.post()
                    .uri(ACTIONAI_API_BASE_URL)
                    .contentType(org.springframework.http.MediaType.MULTIPART_FORM_DATA)
                    .body(multipartData)
                    .retrieve()
                    .bodyToMono(String.class)
                    .timeout(Duration.ofSeconds(30))
                    .onErrorReturn("获取信息失败，请检查参数是否正常。")
                    .block();
        } catch (Exception e) {
            return "获取信息时发生错误: " + e.getMessage();
        }
    }
    @Tool(description = "获取B站热搜榜")
    public String bilibiliToHot(@ToolParam(description = "秘钥") String api_key) {
        try {
            // 使用 MULTIPART_FORM_DATA 和 fromMultipartData，与测试保持一致
            var multipartData = org.springframework.web.reactive.function.BodyInserters
                    .fromMultipartData("method", "bilibiliToHot")
                    .with("api_key", api_key);
            return webClient.post()
                    .uri(ACTIONAI_API_BASE_URL)
                    .contentType(org.springframework.http.MediaType.MULTIPART_FORM_DATA)
                    .body(multipartData)
                    .retrieve()
                    .bodyToMono(String.class)
                    .timeout(Duration.ofSeconds(30))
                    .onErrorReturn("获取信息失败，请检查参数是否正常。")
                    .block();
        } catch (Exception e) {
            return "获取信息时发生错误: " + e.getMessage();
        }
    }
    @Tool(description = "B站视频搜索")
    public String bilibiliToVideo(@ToolParam(description = "秘钥") String api_key,@ToolParam(description = "视频描述") String msg,@ToolParam(description = "第N个视频，最大10") String n) {
        try {
            // 使用 MULTIPART_FORM_DATA 和 fromMultipartData，与测试保持一致
            var multipartData = org.springframework.web.reactive.function.BodyInserters
                    .fromMultipartData("method", "bilibiliToVideo")
                    .with("api_key", api_key)
                    .with("msg", msg)
                    .with("n", n);
            return webClient.post()
                    .uri(ACTIONAI_API_BASE_URL)
                    .contentType(org.springframework.http.MediaType.MULTIPART_FORM_DATA)
                    .body(multipartData)
                    .retrieve()
                    .bodyToMono(String.class)
                    .timeout(Duration.ofSeconds(30))
                    .onErrorReturn("获取信息失败，请检查参数是否正常。")
                    .block();
        } catch (Exception e) {
            return "获取信息时发生错误: " + e.getMessage();
        }
    }

    @Tool(description = "获取BiliBili热榜视频")
    public String bilibiliToVideoList(@ToolParam(description = "秘钥") String api_key) {
        try {
            // 使用 MULTIPART_FORM_DATA 和 fromMultipartData，与测试保持一致
            var multipartData = org.springframework.web.reactive.function.BodyInserters
                    .fromMultipartData("method", "bilibiliToVideoList")
                    .with("api_key", api_key);
            return webClient.post()
                    .uri(ACTIONAI_API_BASE_URL)
                    .contentType(org.springframework.http.MediaType.MULTIPART_FORM_DATA)
                    .body(multipartData)
                    .retrieve()
                    .bodyToMono(String.class)
                    .timeout(Duration.ofSeconds(30))
                    .onErrorReturn("获取信息失败，请检查参数是否正常。")
                    .block();
        } catch (Exception e) {
            return "获取信息时发生错误: " + e.getMessage();
        }
    }
    @Tool(description = "Bilibili视频搜索")
    public String bilibiliToVideoInfos(@ToolParam(description = "秘钥") String api_key,@ToolParam(description = "搜索关键词") String msg,@ToolParam(description = "选择的视频编号，不传则返回搜索列表") String b) {
        try {
            // 使用 MULTIPART_FORM_DATA 和 fromMultipartData，与测试保持一致
            var multipartData = org.springframework.web.reactive.function.BodyInserters
                    .fromMultipartData("method", "bilibiliToVideoInfos")
                    .with("api_key", api_key)
                    .with("msg", msg)
                    .with("b", b);
            return webClient.post()
                    .uri(ACTIONAI_API_BASE_URL)
                    .contentType(org.springframework.http.MediaType.MULTIPART_FORM_DATA)
                    .body(multipartData)
                    .retrieve()
                    .bodyToMono(String.class)
                    .timeout(Duration.ofSeconds(30))
                    .onErrorReturn("获取信息失败，请检查参数是否正常。")
                    .block();
        } catch (Exception e) {
            return "获取信息时发生错误: " + e.getMessage();
        }
    }

    /********************************************快手系列***************************************************/
    @Tool(description = "随机抓取快手小姐姐视频")
    public String kuaishouToVideo(@ToolParam(description = "秘钥") String api_key) {
        try {
            // 使用 MULTIPART_FORM_DATA 和 fromMultipartData，与测试保持一致
            var multipartData = org.springframework.web.reactive.function.BodyInserters
                    .fromMultipartData("method", "kuaishouToVideo")
                    .with("api_key", api_key);
            return webClient.post()
                    .uri(ACTIONAI_API_BASE_URL)
                    .contentType(org.springframework.http.MediaType.MULTIPART_FORM_DATA)
                    .body(multipartData)
                    .retrieve()
                    .bodyToMono(String.class)
                    .timeout(Duration.ofSeconds(30))
                    .onErrorReturn("获取信息失败，请检查参数是否正常。")
                    .block();
        } catch (Exception e) {
            return "获取信息时发生错误: " + e.getMessage();
        }
    }

    /********************************************微信系列***************************************************/
    @Tool(description = "微信文章视频获取")
    public String wechatToVideo(@ToolParam(description = "秘钥") String api_key,@ToolParam(description = "微信文章地址") String url) {
        try {
            // 使用 MULTIPART_FORM_DATA 和 fromMultipartData，与测试保持一致
            var multipartData = org.springframework.web.reactive.function.BodyInserters
                    .fromMultipartData("method", "wechatToVideo")
                    .with("api_key", api_key)
                    .with("url", url);
            return webClient.post()
                    .uri(ACTIONAI_API_BASE_URL)
                    .contentType(org.springframework.http.MediaType.MULTIPART_FORM_DATA)
                    .body(multipartData)
                    .retrieve()
                    .bodyToMono(String.class)
                    .timeout(Duration.ofSeconds(30))
                    .onErrorReturn("获取信息失败，请检查参数是否正常。")
                    .block();
        } catch (Exception e) {
            return "获取信息时发生错误: " + e.getMessage();
        }
    }

    /********************************************网易云音乐***************************************************/
    @Tool(description = "网易云音乐排行榜")
    public String musicToHot(@ToolParam(description = "秘钥") String api_key,@ToolParam(description = " 1：原创榜，2：新歌榜，3：飙升榜 4：热歌榜") String type) {
        try {
            // 使用 MULTIPART_FORM_DATA 和 fromMultipartData，与测试保持一致
            var multipartData = org.springframework.web.reactive.function.BodyInserters
                    .fromMultipartData("method", "musicToHot")
                    .with("api_key", api_key)
                    .with("type", type);
            return webClient.post()
                    .uri(ACTIONAI_API_BASE_URL)
                    .contentType(org.springframework.http.MediaType.MULTIPART_FORM_DATA)
                    .body(multipartData)
                    .retrieve()
                    .bodyToMono(String.class)
                    .timeout(Duration.ofSeconds(30))
                    .onErrorReturn("获取信息失败，请检查参数是否正常。")
                    .block();
        } catch (Exception e) {
            return "获取信息时发生错误: " + e.getMessage();
        }
    }
    @Tool(description = "网易MV无水印解析视频")
    public String musicToVideo(@ToolParam(description = "秘钥") String api_key,@ToolParam(description = "网易云音乐mv编号") String vid) {
        try {
            // 使用 MULTIPART_FORM_DATA 和 fromMultipartData，与测试保持一致
            var multipartData = org.springframework.web.reactive.function.BodyInserters
                    .fromMultipartData("method", "musicToVideo")
                    .with("api_key", api_key)
                    .with("user_text", vid);
            return webClient.post()
                    .uri(ACTIONAI_API_BASE_URL)
                    .contentType(org.springframework.http.MediaType.MULTIPART_FORM_DATA)
                    .body(multipartData)
                    .retrieve()
                    .bodyToMono(String.class)
                    .timeout(Duration.ofSeconds(30))
                    .onErrorReturn("获取信息失败，请检查参数是否正常。")
                    .block();
        } catch (Exception e) {
            return "获取信息时发生错误: " + e.getMessage();
        }
    }
    @Tool(description = "网易云音乐解析")
    public String musicToAudio(@ToolParam(description = "秘钥") String api_key,@ToolParam(description = "网易云音乐编号") String music_id) {
        try {
            // 使用 MULTIPART_FORM_DATA 和 fromMultipartData，与测试保持一致
            var multipartData = org.springframework.web.reactive.function.BodyInserters
                    .fromMultipartData("method", "musicToAudio")
                    .with("api_key", api_key)
                    .with("music_id", music_id);
            return webClient.post()
                    .uri(ACTIONAI_API_BASE_URL)
                    .contentType(org.springframework.http.MediaType.MULTIPART_FORM_DATA)
                    .body(multipartData)
                    .retrieve()
                    .bodyToMono(String.class)
                    .timeout(Duration.ofSeconds(30))
                    .onErrorReturn("获取信息失败，请检查参数是否正常。")
                    .block();
        } catch (Exception e) {
            return "获取信息时发生错误: " + e.getMessage();
        }
    }

    @Tool(description = "网易云音乐单曲解析")
    public String musicToAudioInfo(@ToolParam(description = "秘钥") String api_key,@ToolParam(description = "用户提示词") String music_id,@ToolParam(description = "standard(标准音质), exhigh(极高音质), lossless(无损音质), hires(Hi-Res音质), jyeffect(高清环绕声), sky(沉浸环绕声), jymaster(超清母带)，默认lossless(无损音质)") String level) {
        try {
            // 使用 MULTIPART_FORM_DATA 和 fromMultipartData，与测试保持一致
            var multipartData = org.springframework.web.reactive.function.BodyInserters
                    .fromMultipartData("method", "musicToAudioInfo")
                    .with("api_key", api_key)
                    .with("music_id", music_id)
                    .with("level", level);
            return webClient.post()
                    .uri(ACTIONAI_API_BASE_URL)
                    .contentType(org.springframework.http.MediaType.MULTIPART_FORM_DATA)
                    .body(multipartData)
                    .retrieve()
                    .bodyToMono(String.class)
                    .timeout(Duration.ofSeconds(30))
                    .onErrorReturn("获取信息失败，请检查参数是否正常。")
                    .block();
        } catch (Exception e) {
            return "获取信息时发生错误: " + e.getMessage();
        }
    }

    /********************************************视频号***************************************************/
    @Tool(description = "微信视频号搜索")
    public String finderToSsearch(@ToolParam(description = "秘钥") String api_key,@ToolParam(description = "搜索关键词") String query,@ToolParam(description = "类型 0混合动态和视频号搜索 1视频号搜索 2动态搜索 13是直播") String scene,@ToolParam(description = "默认：空，如需取下一页数据，需传递上一次请求返回的lastBuff值") String last_buffer) {
        try {
            // 使用 MULTIPART_FORM_DATA 和 fromMultipartData，与测试保持一致
            var multipartData = org.springframework.web.reactive.function.BodyInserters
                    .fromMultipartData("method", "finderToSsearch")
                    .with("api_key", api_key)
                    .with("query", query)
                    .with("scene", scene)
                    .with("last_buffer", last_buffer);
            return webClient.post()
                    .uri(ACTIONAI_API_BASE_URL)
                    .contentType(org.springframework.http.MediaType.MULTIPART_FORM_DATA)
                    .body(multipartData)
                    .retrieve()
                    .bodyToMono(String.class)
                    .timeout(Duration.ofSeconds(30))
                    .onErrorReturn("获取信息失败，请检查参数是否正常。")
                    .block();
        } catch (Exception e) {
            return "获取信息时发生错误: " + e.getMessage();
        }
    }
    @Tool(description = "获取微信视频号用户页视频列表")
    public String finderToUserPage(@ToolParam(description = "秘钥") String api_key,@ToolParam(description = "视频号username，视频号搜索结果中获取") String username,@ToolParam(description = "默认：空，如需取下一页数据，需传递上一次请求返回的lastBuff值") String last_buffer) {
        try {
            // 使用 MULTIPART_FORM_DATA 和 fromMultipartData，与测试保持一致
            var multipartData = org.springframework.web.reactive.function.BodyInserters
                    .fromMultipartData("method", "finderToUserPage")
                    .with("api_key", api_key)
                    .with("username", username)
                    .with("last_buffer", last_buffer);
            return webClient.post()
                    .uri(ACTIONAI_API_BASE_URL)
                    .contentType(org.springframework.http.MediaType.MULTIPART_FORM_DATA)
                    .body(multipartData)
                    .retrieve()
                    .bodyToMono(String.class)
                    .timeout(Duration.ofSeconds(30))
                    .onErrorReturn("获取信息失败，请检查参数是否正常。")
                    .block();
        } catch (Exception e) {
            return "获取信息时发生错误: " + e.getMessage();
        }
    }
    @Tool(description = "获取微信视频号视频详情")
    public String finderToDetail(@ToolParam(description = "秘钥") String api_key,@ToolParam(description = "视频的object_id，视频号搜索结果中获取") String object_id,@ToolParam(description = "视频的object_nonce_id，视频号搜索结果中获取") String object_nonce_id,@ToolParam(description = "视频的object_id，视频号搜索结果中获取") String last_buffer) {
        try {
            // 使用 MULTIPART_FORM_DATA 和 fromMultipartData，与测试保持一致
            var multipartData = org.springframework.web.reactive.function.BodyInserters
                    .fromMultipartData("method", "finderToDetail")
                    .with("api_key", api_key)
                    .with("object_id", object_id)
                    .with("object_nonce_id", object_nonce_id)
                    .with("last_buffer", last_buffer);
            return webClient.post()
                    .uri(ACTIONAI_API_BASE_URL)
                    .contentType(org.springframework.http.MediaType.MULTIPART_FORM_DATA)
                    .body(multipartData)
                    .retrieve()
                    .bodyToMono(String.class)
                    .timeout(Duration.ofSeconds(30))
                    .onErrorReturn("获取信息失败，请检查参数是否正常。")
                    .block();
        } catch (Exception e) {
            return "获取信息时发生错误: " + e.getMessage();
        }
    }

    /********************************************文档系列***************************************************/
    @Tool(description = "markdown文本生成PDF文档")
    public String markdownToPDF(@ToolParam(description = "秘钥") String api_key,@ToolParam(description = "标题") String title,@ToolParam(description = "markdown文本内容") String content) {
        try {
            // 使用 MULTIPART_FORM_DATA 和 fromMultipartData，与测试保持一致
            var multipartData = org.springframework.web.reactive.function.BodyInserters
                    .fromMultipartData("method", "markdownToPDF")
                    .with("api_key", api_key)
                    .with("title", title)
                    .with("content", content);
            return webClient.post()
                    .uri(ACTIONAI_API_BASE_URL)
                    .contentType(org.springframework.http.MediaType.MULTIPART_FORM_DATA)
                    .body(multipartData)
                    .retrieve()
                    .bodyToMono(String.class)
                    .timeout(Duration.ofSeconds(30))
                    .onErrorReturn("获取信息失败，请检查参数是否正常。")
                    .block();
        } catch (Exception e) {
            return "获取信息时发生错误: " + e.getMessage();
        }
    }
    @Tool(description = "markdown文本生成Docx文档")
    public String markdownToDocx(@ToolParam(description = "秘钥") String api_key,@ToolParam(description = "标题") String title,@ToolParam(description = "markdown文本内容") String content) {
        try {
            // 使用 MULTIPART_FORM_DATA 和 fromMultipartData，与测试保持一致
            var multipartData = org.springframework.web.reactive.function.BodyInserters
                    .fromMultipartData("method", "markdownToDocx")
                    .with("api_key", api_key)
                    .with("title", title)
                    .with("content", content);
            return webClient.post()
                    .uri(ACTIONAI_API_BASE_URL)
                    .contentType(org.springframework.http.MediaType.MULTIPART_FORM_DATA)
                    .body(multipartData)
                    .retrieve()
                    .bodyToMono(String.class)
                    .timeout(Duration.ofSeconds(30))
                    .onErrorReturn("获取信息失败，请检查参数是否正常。")
                    .block();
        } catch (Exception e) {
            return "获取信息时发生错误: " + e.getMessage();
        }
    }
    @Tool(description = "文档链接解析为文本内容")
    public String markdownToDocx1(@ToolParam(description = "秘钥") String api_key,@ToolParam(description = "可访问文档地址，支持html、xml、doc、docx、txt、pdf、csv、xlsx）") String file_url) {
        try {
            // 使用 MULTIPART_FORM_DATA 和 fromMultipartData，与测试保持一致
            var multipartData = org.springframework.web.reactive.function.BodyInserters
                    .fromMultipartData("method", "markdownToDocx")
                    .with("api_key", api_key)
                    .with("file_url", file_url);
            return webClient.post()
                    .uri(ACTIONAI_API_BASE_URL)
                    .contentType(org.springframework.http.MediaType.MULTIPART_FORM_DATA)
                    .body(multipartData)
                    .retrieve()
                    .bodyToMono(String.class)
                    .timeout(Duration.ofSeconds(30))
                    .onErrorReturn("获取信息失败，请检查参数是否正常。")
                    .block();
        } catch (Exception e) {
            return "获取信息时发生错误: " + e.getMessage();
        }
    }


    /********************************************综合系列***************************************************/
    @Tool(description = "获取各平台热搜热榜集合")
    public String hotlistToAll(@ToolParam(description = "秘钥") String api_key) {
        try {
            // 使用 MULTIPART_FORM_DATA 和 fromMultipartData，与测试保持一致
            var multipartData = org.springframework.web.reactive.function.BodyInserters
                    .fromMultipartData("method", "markdownToPDF")
                    .with("api_key", api_key);
            return webClient.post()
                    .uri(ACTIONAI_API_BASE_URL)
                    .contentType(org.springframework.http.MediaType.MULTIPART_FORM_DATA)
                    .body(multipartData)
                    .retrieve()
                    .bodyToMono(String.class)
                    .timeout(Duration.ofSeconds(30))
                    .onErrorReturn("获取信息失败，请检查参数是否正常。")
                    .block();
        } catch (Exception e) {
            return "获取信息时发生错误: " + e.getMessage();
        }
    }

    /********************************************头条系列***************************************************/
    @Tool(description = "获取今日头条热榜")
    public String toutiaoToHot(@ToolParam(description = "秘钥") String api_key) {
        try {
            // 使用 MULTIPART_FORM_DATA 和 fromMultipartData，与测试保持一致
            var multipartData = org.springframework.web.reactive.function.BodyInserters
                    .fromMultipartData("method", "toutiaoToHot")
                    .with("api_key", api_key);
            return webClient.post()
                    .uri(ACTIONAI_API_BASE_URL)
                    .contentType(org.springframework.http.MediaType.MULTIPART_FORM_DATA)
                    .body(multipartData)
                    .retrieve()
                    .bodyToMono(String.class)
                    .timeout(Duration.ofSeconds(30))
                    .onErrorReturn("获取信息失败，请检查参数是否正常。")
                    .block();
        } catch (Exception e) {
            return "获取信息时发生错误: " + e.getMessage();
        }
    }

    /********************************************音频系列***************************************************/
    @Tool(description = "文字转语音")
    public String textToAudioUrl(@ToolParam(description = "秘钥") String api_key,@ToolParam(description = "秘钥") String voice) {
        try {
            // 使用 MULTIPART_FORM_DATA 和 fromMultipartData，与测试保持一致
            var multipartData = org.springframework.web.reactive.function.BodyInserters
                    .fromMultipartData("method", "textToAudioUrl")
                    .with("api_key", api_key)
                    .with("voice", voice);
            return webClient.post()
                    .uri(ACTIONAI_API_BASE_URL)
                    .contentType(org.springframework.http.MediaType.MULTIPART_FORM_DATA)
                    .body(multipartData)
                    .retrieve()
                    .bodyToMono(String.class)
                    .timeout(Duration.ofSeconds(30))
                    .onErrorReturn("获取信息失败，请检查参数是否正常。")
                    .block();
        } catch (Exception e) {
            return "获取信息时发生错误: " + e.getMessage();
        }
    }

    /********************************************皮皮虾系列***************************************************/
    @Tool(description = "皮皮虾分享链接解析")
    public String pipixiaToVideo(@ToolParam(description = "秘钥") String api_key,@ToolParam(description = "皮皮虾分享链接") String url) {
        try {
            // 使用 MULTIPART_FORM_DATA 和 fromMultipartData，与测试保持一致
            var multipartData = org.springframework.web.reactive.function.BodyInserters
                    .fromMultipartData("method", "pipixiaToVideo")
                    .with("api_key", api_key)
                    .with("url", url);
            return webClient.post()
                    .uri(ACTIONAI_API_BASE_URL)
                    .contentType(org.springframework.http.MediaType.MULTIPART_FORM_DATA)
                    .body(multipartData)
                    .retrieve()
                    .bodyToMono(String.class)
                    .timeout(Duration.ofSeconds(30))
                    .onErrorReturn("获取信息失败，请检查参数是否正常。")
                    .block();
        } catch (Exception e) {
            return "获取信息时发生错误: " + e.getMessage();
        }
    }

    /********************************************淘宝系列***************************************************/
    @Tool(description = "获取淘宝商品详情")
    public String taobaoToGoodInfo(@ToolParam(description = "秘钥") String api_key,@ToolParam(description = "淘宝的商品id") String itemid) {
        try {
            // 使用 MULTIPART_FORM_DATA 和 fromMultipartData，与测试保持一致
            var multipartData = org.springframework.web.reactive.function.BodyInserters
                    .fromMultipartData("method", "taobaoToGoodInfo")
                    .with("api_key", api_key)
                    .with("itemid", itemid);
            return webClient.post()
                    .uri(ACTIONAI_API_BASE_URL)
                    .contentType(org.springframework.http.MediaType.MULTIPART_FORM_DATA)
                    .body(multipartData)
                    .retrieve()
                    .bodyToMono(String.class)
                    .timeout(Duration.ofSeconds(30))
                    .onErrorReturn("获取信息失败，请检查参数是否正常。")
                    .block();
        } catch (Exception e) {
            return "获取信息时发生错误: " + e.getMessage();
        }
    }
    @Tool(description = "获取天猫商品详情")
    public String taobaoToTmallInfo(@ToolParam(description = "秘钥") String api_key,@ToolParam(description = "商品id") String itemid) {
        try {
            // 使用 MULTIPART_FORM_DATA 和 fromMultipartData，与测试保持一致
            var multipartData = org.springframework.web.reactive.function.BodyInserters
                    .fromMultipartData("method", "taobaoToTmallInfo")
                    .with("api_key", api_key)
                    .with("itemid", itemid);
            return webClient.post()
                    .uri(ACTIONAI_API_BASE_URL)
                    .contentType(org.springframework.http.MediaType.MULTIPART_FORM_DATA)
                    .body(multipartData)
                    .retrieve()
                    .bodyToMono(String.class)
                    .timeout(Duration.ofSeconds(30))
                    .onErrorReturn("获取信息失败，请检查参数是否正常。")
                    .block();
        } catch (Exception e) {
            return "获取信息时发生错误: " + e.getMessage();
        }
    }

    /********************************************京东系列***************************************************/
    @Tool(description = "京东商品类目查询")
    public String jingdongToCategory(@ToolParam(description = "秘钥") String api_key,@ToolParam(description = "类目级别(类目级别 0，1，2 代表一、二、三级类目)") String grade,@ToolParam(description = "父类目id(一级父类目为0)") String parentid) {
        try {
            // 使用 MULTIPART_FORM_DATA 和 fromMultipartData，与测试保持一致
            var multipartData = org.springframework.web.reactive.function.BodyInserters
                    .fromMultipartData("method", "jingdongToCategory")
                    .with("api_key", api_key)
                    .with("grade", grade)
                    .with("parentid", parentid);
            return webClient.post()
                    .uri(ACTIONAI_API_BASE_URL)
                    .contentType(org.springframework.http.MediaType.MULTIPART_FORM_DATA)
                    .body(multipartData)
                    .retrieve()
                    .bodyToMono(String.class)
                    .timeout(Duration.ofSeconds(30))
                    .onErrorReturn("获取信息失败，请检查参数是否正常。")
                    .block();
        } catch (Exception e) {
            return "获取信息时发生错误: " + e.getMessage();
        }
    }
    @Tool(description = "获取京东商品详情")
    public String jingdongToGoodInfo(@ToolParam(description = "秘钥") String api_key,@ToolParam(description = "商品ID") String itemid) {
        try {
            // 使用 MULTIPART_FORM_DATA 和 fromMultipartData，与测试保持一致
            var multipartData = org.springframework.web.reactive.function.BodyInserters
                    .fromMultipartData("method", "jingdongToGoodInfo")
                    .with("api_key", api_key)
                    .with("itemid", itemid);
            return webClient.post()
                    .uri(ACTIONAI_API_BASE_URL)
                    .contentType(org.springframework.http.MediaType.MULTIPART_FORM_DATA)
                    .body(multipartData)
                    .retrieve()
                    .bodyToMono(String.class)
                    .timeout(Duration.ofSeconds(30))
                    .onErrorReturn("获取信息失败，请检查参数是否正常。")
                    .block();
        } catch (Exception e) {
            return "获取信息时发生错误: " + e.getMessage();
        }
    }

    /********************************************阿里巴巴系列***************************************************/
    @Tool(description = "获取阿里巴巴商品详情")
    public String alibabaToGoodInfo(@ToolParam(description = "秘钥") String api_key,@ToolParam(description = "商品ID") String itemid,@ToolParam(description = "是否需要视频信息 bollean") String video,@ToolParam(description = "是否需要优惠信息 boolean") String preferential) {
        try {
            // 使用 MULTIPART_FORM_DATA 和 fromMultipartData，与测试保持一致
            var multipartData = org.springframework.web.reactive.function.BodyInserters
                    .fromMultipartData("method", "jingdongToGoodInfo")
                    .with("api_key", api_key)
                    .with("itemid", itemid)
                    .with("video", video)
                    .with("preferential", preferential);
            return webClient.post()
                    .uri(ACTIONAI_API_BASE_URL)
                    .contentType(org.springframework.http.MediaType.MULTIPART_FORM_DATA)
                    .body(multipartData)
                    .retrieve()
                    .bodyToMono(String.class)
                    .timeout(Duration.ofSeconds(30))
                    .onErrorReturn("获取信息失败，请检查参数是否正常。")
                    .block();
        } catch (Exception e) {
            return "获取信息时发生错误: " + e.getMessage();
        }
    }

    /********************************************查询秘钥剩余次数和时长***************************************************/
    @Tool(description = "查询秘钥剩余次数和时长")
    public String queryKeyInfo() {
        try {
            return webClient.post()
                    .uri(querykeyUrl)
                    .retrieve()
                    .bodyToMono(String.class)
                    .timeout(Duration.ofSeconds(30))
                    .onErrorReturn("获取信息失败，请检查参数是否正常。")
                    .block();
        } catch (Exception e) {
            return "获取信息时发生错误: " + e.getMessage();
        }
    }

}
