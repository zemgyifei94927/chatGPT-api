package cn.Yifei.chatGPT.api.application.zsxq.service;

import cn.Yifei.chatGPT.api.application.zsxq.IZsxqApi;
import cn.Yifei.chatGPT.api.application.zsxq.model.aggregates.MyQuestionAggregates;
import cn.Yifei.chatGPT.api.application.zsxq.model.req.AnswerReq;
import cn.Yifei.chatGPT.api.application.zsxq.model.req.Req_data;
import cn.Yifei.chatGPT.api.application.zsxq.model.res.AnswerRes;
import com.alibaba.fastjson.JSON;
import net.sf.json.JSONObject;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.IOException;

/**
 * @author Yifei
 * @description
 * @date 2023/6/6
 */
@Service
public class ZsxqApi implements IZsxqApi {

    private Logger logger = LoggerFactory.getLogger(ZsxqApi.class);

    @Override
    public MyQuestionAggregates queryQuestion(String cookie) throws IOException {
        // httpclient用于执行http request
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        // url是我提的一个问题, 因为是爬取所以用get
        HttpGet get = new HttpGet("https://api.zsxq.com/v2/topics/412282841855418/info");
        get.addHeader("cookie", cookie);
        get.addHeader("Content-Type", "application/json;  text/plain");

        CloseableHttpResponse response = httpClient.execute(get);
        // 如果返回正常则执行以下
        if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK){
            String jsonStr = EntityUtils.toString(response.getEntity());
            logger.info("拉取提问数据。jsonStr: {}", jsonStr);
            return JSON.parseObject(jsonStr, MyQuestionAggregates.class);
        }else{
            throw new RuntimeException("queryQuestion Err code is " + response.getStatusLine().getStatusCode());
        }
    }

    @Override
    public boolean answer(String cookie, String text) throws IOException {
        // httpclient用于执行http request
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        // url是我提的一个问题的回复选项
        HttpPost post = new HttpPost("https://api.zsxq.com/v2/topics/412282841855418/comments");
        post.addHeader("cookie", cookie);
        post.addHeader("Content-Type", "application/json;  text/plain");
        post.addHeader("user-agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/114.0.0.0 Safari/537.36");

        AnswerReq answerReq = new AnswerReq(new Req_data(text));
        String paramJson = JSONObject.fromObject(answerReq).toString();

        StringEntity stringEntity = new StringEntity(paramJson, ContentType.create("text/json", "UTF-8"));
        post.setEntity(stringEntity);
        CloseableHttpResponse response = httpClient.execute(post);
        // 如果返回正常则执行以下
        if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK){
            String jsonStr = EntityUtils.toString(response.getEntity());
            logger.info("回答问题结果。jsonStr: {}", jsonStr);
            AnswerRes answerRes = JSON.parseObject(jsonStr, AnswerRes.class);
            return answerRes.isSucceeded();
        }else{
            throw new RuntimeException("queryQuestion Err code is " + response.getStatusLine().getStatusCode());
        }
    }
}
