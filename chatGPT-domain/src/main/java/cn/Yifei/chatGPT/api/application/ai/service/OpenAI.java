package cn.Yifei.chatGPT.api.application.ai.service;

import cn.Yifei.chatGPT.api.application.ai.IOpenAI;
import cn.Yifei.chatGPT.api.application.ai.model.aggregates.AIAnswer;
import cn.Yifei.chatGPT.api.application.ai.model.vo.Choices;
import com.alibaba.fastjson.JSON;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;

/**
 * @author Yifei
 * @description
 * @date 2023/6/7
 */
@Service
public class OpenAI implements IOpenAI {
    private Logger logger = LoggerFactory.getLogger(OpenAI.class);

    @Value("${chatGPT-api.chatGPTkey}")
    private String chatGPTkey;

    @Override
    public String doChatGPT(String question) throws IOException {
        // httpclient用于执行http request
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        // url是chatGPT的API
        HttpPost post = new HttpPost("https://api.openai.com/v1/chat/completions");
        post.addHeader("Content-Type", "application/json");
        post.addHeader("Authorization", "Bearer " + chatGPTkey);
        String paramJson = "{\"model\": \"gpt-3.5-turbo\", \"messages\": [{\"role\": \"user\", \"content\": \"" + question + "\"}],\"temperature\": 0.7}";
        StringEntity stringEntity = new StringEntity(paramJson, ContentType.create("text/json", "UTF-8"));
        post.setEntity(stringEntity);
        CloseableHttpResponse response = httpClient.execute(post);
        // 如果返回正常则执行以下
        if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK){
            String jsonStr = EntityUtils.toString(response.getEntity());
            AIAnswer aiAnswer = JSON.parseObject(jsonStr, AIAnswer.class);
            StringBuilder answer = new StringBuilder();
            for (Choices choice:aiAnswer.getChoices()){
                answer.append(choice.getMessage().getContent());
            }
            return answer.toString();
        }else{
            throw new RuntimeException("api.openai.com Err Code is " + response.getStatusLine().getStatusCode());
        }

    }
}
