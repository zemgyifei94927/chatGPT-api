package cn.Yifei.chatGPT.api.application.zsxq.model.vo;

/**
 * @author Yifei
 * @description
 * @date 2023/6/6
 */

public class Talk
{
    private Owner owner;

    private String text;

    public void setOwner(Owner owner){
        this.owner = owner;
    }
    public Owner getOwner(){
        return this.owner;
    }
    public void setText(String text){
        this.text = text;
    }
    public String getText(){
        return this.text;
    }
}
