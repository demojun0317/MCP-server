package com.lcry.demo.config;

import com.lcry.demo.service.ActionAiService;
import org.springframework.ai.tool.ToolCallbackProvider;
import org.springframework.ai.tool.method.MethodToolCallbackProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * ToolConfig
 *
 * @author lcry
 * @since 2025/04/22 21:08
 */
@Component
public class ToolConfig {
    @Bean
    public ToolCallbackProvider myTools(ActionAiService actionAiService) {
        return MethodToolCallbackProvider.builder()
                .toolObjects(actionAiService)
                .build();
    }
}
