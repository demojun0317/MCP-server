# 天气API故障排除指南

## 问题诊断

如果你遇到"获取不到天气信息"的问题，请按以下步骤进行排查：

### 1. 检查API密钥

首先确保你的OpenWeatherMap API密钥是有效的：

1. 访问 https://openweathermap.org/api
2. 注册并获取免费的API密钥
3. 将密钥替换到 `src/main/resources/application.yml` 文件中

### 2. 验证API密钥

启动应用时，控制台会显示API密钥测试结果：
- ✅ API密钥有效
- ❌ API密钥无效或已过期
- ⚠️ API响应异常，请检查网络连接

### 3. 常见问题及解决方案

#### 问题1：API密钥无效
**症状**：控制台显示"❌ API密钥无效或已过期"
**解决方案**：
1. 检查API密钥是否正确复制
2. 确保API密钥没有多余的空格
3. 等待几分钟（新注册的API密钥可能需要几分钟才能激活）

#### 问题2：网络连接问题
**症状**：控制台显示"⚠️ API响应异常，请检查网络连接"
**解决方案**：
1. 检查网络连接
2. 确保可以访问 https://api.openweathermap.org
3. 检查防火墙设置

#### 问题3：城市名称问题
**症状**：返回"无法获取天气信息，请检查城市名称是否正确"
**解决方案**：
1. 使用英文城市名称（如：Beijing, Shanghai, London）
2. 确保城市名称拼写正确
3. 尝试使用城市的标准名称

### 4. API使用限制

OpenWeatherMap免费版限制：
- 每分钟最多60次调用
- 每天最多1000次调用
- 如果超过限制，API会返回错误

### 5. 测试API密钥

你可以手动测试API密钥是否有效：

```bash
curl "https://api.openweathermap.org/data/2.5/weather?q=London&appid=YOUR_API_KEY&units=metric"
```

将 `YOUR_API_KEY` 替换为你的实际API密钥。

### 6. 获取新的API密钥

如果当前API密钥无效，请按以下步骤获取新密钥：

1. 访问 https://openweathermap.org/api
2. 点击 "Get API key"
3. 注册新账户或登录现有账户
4. 复制生成的API密钥
5. 更新 `application.yml` 文件中的密钥
6. 重启应用

### 7. 技术支持

如果问题仍然存在，请：
1. 检查应用日志获取详细错误信息
2. 确认OpenWeatherMap服务状态
3. 联系技术支持

## 配置示例

正确的 `application.yml` 配置：

```yaml
weather:
  api:
    key: your_actual_api_key_here  # 替换为你的真实API密钥
    url: https://api.openweathermap.org/data/2.5/weather
```

注意：
- 不要使用示例中的API密钥
- 确保API密钥没有引号包围
- 不要在密钥前后添加空格 