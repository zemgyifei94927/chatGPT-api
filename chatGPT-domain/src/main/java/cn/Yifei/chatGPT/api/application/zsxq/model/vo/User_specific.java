package cn.Yifei.chatGPT.api.application.zsxq.model.vo;

/**
 * @author Yifei
 * @description
 * @date 2023/6/6
 */

public class User_specific
{
    private boolean liked;

    private boolean subscribed;

    public void setLiked(boolean liked){
        this.liked = liked;
    }
    public boolean getLiked(){
        return this.liked;
    }
    public void setSubscribed(boolean subscribed){
        this.subscribed = subscribed;
    }
    public boolean getSubscribed(){
        return this.subscribed;
    }
}
