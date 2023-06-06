package cn.Yifei.chatGPT.api.test;

import cn.Yifei.chatGPT.api.application.zsxq.IZsxqApi;
import cn.Yifei.chatGPT.api.application.zsxq.model.aggregates.MyQuestionAggregates;
import cn.Yifei.chatGPT.api.application.zsxq.service.ZsxqApi;
import com.alibaba.fastjson.JSON;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


import javax.annotation.Resource;
import java.io.IOException;

/**
 * @author Yifei
 * @description
 * @date 2023/6/6
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootRunTest {

    private Logger logger = LoggerFactory.getLogger(SpringBootRunTest.class);


    @Value("${chatGPT-api.cookie}")
    private String cookie;

    @Resource
    private IZsxqApi zsxqApi;

    @Test
    public void test_zsxqApi() throws IOException {
        MyQuestionAggregates myQuestionAggregates = zsxqApi.queryQuestion(cookie);
        logger.info("测试结果: {}", JSON.toJSONString(myQuestionAggregates));

        String text = myQuestionAggregates.getResp_data().getTopic().getTalk().getText();
        logger.info("topicQuestion: {}", text);

        //回答问题
        zsxqApi.answer(cookie, text);
    }
}
