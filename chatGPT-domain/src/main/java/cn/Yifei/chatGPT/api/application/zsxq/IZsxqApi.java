package cn.Yifei.chatGPT.api.application.zsxq;

import cn.Yifei.chatGPT.api.application.zsxq.model.aggregates.MyQuestionAggregates;

import java.io.IOException;

/**
 * @author Yifei
 * @description ZSXQ API Interface
 * @date 2023/6/6
 */
public interface IZsxqApi {
    MyQuestionAggregates queryQuestion( String cookie) throws IOException;
    boolean answer(String cookie, String text) throws IOException;
}
