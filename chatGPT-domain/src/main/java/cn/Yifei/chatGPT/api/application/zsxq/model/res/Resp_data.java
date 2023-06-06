package cn.Yifei.chatGPT.api.application.zsxq.model.res;

import cn.Yifei.chatGPT.api.application.zsxq.model.vo.Topic;

/**
 * @author Yifei
 * @description Response data
 * @date 2023/6/6
 */

public class Resp_data
{
    private Topic topic;

    private String type;

    public void setTopic(Topic topic){
        this.topic = topic;
    }
    public Topic getTopic(){
        return this.topic;
    }
    public void setType(String type){
        this.type = type;
    }
    public String getType(){
        return this.type;
    }
}
