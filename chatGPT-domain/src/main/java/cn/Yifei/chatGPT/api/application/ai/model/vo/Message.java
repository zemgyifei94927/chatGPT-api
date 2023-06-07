package cn.Yifei.chatGPT.api.application.ai.model.vo;

/**
 * @author Yifei
 * @description
 * @date 2023/6/7
 */

public class Message
{
    private String role;

    private String content;

    public void setRole(String role){
        this.role = role;
    }
    public String getRole(){
        return this.role;
    }
    public void setContent(String content){
        this.content = content;
    }
    public String getContent(){
        return this.content;
    }
}
