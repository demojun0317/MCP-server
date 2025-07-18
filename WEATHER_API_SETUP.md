# OpenWeatherMap API 配置指南

## 问题解决

如果你看到以下错误：
```
❌ HTTP错误: 404 NOT_FOUND - Not Found
```

这通常表示API密钥配置有问题。请按照以下步骤解决：

## 1. 获取免费API密钥

1. 访问 [OpenWeatherMap API](https://openweathermap.org/api)
2. 点击 "Get API Key" 或 "Sign Up"
3. 注册一个免费账户
4. 登录后，在 "My API Keys" 页面获取你的API密钥

## 2. 配置API密钥

编辑 `src/main/resources/application.yml` 文件：

```yaml
weather:
  api:
    key: YOUR_API_KEY_HERE  # 替换为你的真实API密钥
```

## 3. 验证配置

重启应用程序，你应该看到：
```
✅ API密钥有效，连接正常
```

## 4. 常见问题

### 404错误
- 确保使用的是API v2.5（免费版本）
- 检查API密钥是否正确复制

### 401错误
- API密钥无效或已过期
- 重新生成API密钥

### 网络超时
- 检查网络连接
- 确保可以访问 api.openweathermap.org

## 5. 免费版限制

- 每天最多1000次API调用
- 支持基本的天气查询功能
- 不支持高级功能（如历史数据）

## 6. 测试API密钥

你可以使用以下URL测试你的API密钥：
```
https://api.openweathermap.org/data/2.5/weather?q=London&appid=YOUR_API_KEY&units=metric
```

如果返回JSON数据，说明API密钥有效。 