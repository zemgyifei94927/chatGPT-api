package cn.Yifei.chatGPT.api.application.job;

import cn.Yifei.chatGPT.api.application.ai.IOpenAI;
import cn.Yifei.chatGPT.api.application.zsxq.IZsxqApi;
import cn.Yifei.chatGPT.api.application.zsxq.model.aggregates.MyQuestionAggregates;
import cn.Yifei.chatGPT.api.application.zsxq.service.ZsxqApi;
import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import javax.annotation.Resource;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Random;

/**
 * @author Yifei
 * @description 问答任务
 * @date 2023/6/8
 */

@EnableScheduling
@Configuration
public class ChatBotSchedule {
    private Logger logger = LoggerFactory.getLogger(ChatBotSchedule.class);

    @Value("${chatGPT-api.cookie}")
    private String cookie;

    @Resource
    private IZsxqApi zsxqApi;
    @Resource
    private IOpenAI openAI;


    @Scheduled(cron = "0/30 * * * * ? ")
    public void run(){
        try{
            // 加上随机布尔值，模仿真人
            if (new Random().nextBoolean()){
                logger.info("自动打烊中.....");
                return;
            }
            // 凌晨不回答
            GregorianCalendar calendar = new GregorianCalendar();
            int hour = calendar.get(Calendar.HOUR);
            if(hour > 22 || hour < 7){
                logger.info("夜深了.....明早再来提问吧！");
                return;
            }
            // 1 提取zsxq问题
            MyQuestionAggregates myQuestionAggregates = zsxqApi.queryQuestion(cookie);
            logger.info("知识星球问题: {}", JSON.toJSONString(myQuestionAggregates));
            // 2 chatgpt提问
              //若已经有回答则不再回答
            if (myQuestionAggregates.getResp_data().getTopic().getComments_count() != 0){
                logger.info("该问题已得到回答！");
                return;
            }
              //若没有回答
            String answer = openAI.doChatGPT(myQuestionAggregates.getResp_data().getTopic().getTalk().getText());
            logger.info("chatGPT回答 :{}", answer);

            // 3 回答zdxq问题
            boolean status = zsxqApi.answer(cookie, answer);
            logger.info("知识星球评论状态 : {}", status);

        }catch(Exception e){
            logger.error("自动回答问题异常.", e);
        }
    }

}
