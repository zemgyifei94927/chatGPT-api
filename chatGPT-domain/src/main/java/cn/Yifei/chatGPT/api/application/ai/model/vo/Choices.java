package cn.Yifei.chatGPT.api.application.ai.model.vo;

/**
 * @author Yifei
 * @description
 * @date 2023/6/7
 */

public class Choices
{
    private Message message;

    private String finish_reason;

    private int index;

    public void setMessage(Message message){
        this.message = message;
    }
    public Message getMessage(){
        return this.message;
    }
    public void setFinish_reason(String finish_reason){
        this.finish_reason = finish_reason;
    }
    public String getFinish_reason(){
        return this.finish_reason;
    }
    public void setIndex(int index){
        this.index = index;
    }
    public int getIndex(){
        return this.index;
    }
}
