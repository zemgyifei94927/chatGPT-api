package cn.Yifei.chatGPT.api.application.ai;

import java.io.IOException;

/**
 * @author Yifei
 * @description ChatGPT open ai 接口
 * @date 2023/6/7
 */
public interface IOpenAI {
    String doChatGPT(String question) throws IOException;
}
