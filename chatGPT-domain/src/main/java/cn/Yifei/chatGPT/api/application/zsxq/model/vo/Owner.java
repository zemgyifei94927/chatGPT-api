package cn.Yifei.chatGPT.api.application.zsxq.model.vo;

/**
 * @author Yifei
 * @description
 * @date 2023/6/6
 */

public class Owner
{
    private Long user_id;

    private String name;

    private String avatar_url;

    private String location;

    public void setUser_id(Long user_id){
        this.user_id = user_id;
    }
    public Long getUser_id(){
        return this.user_id;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return this.name;
    }
    public void setAvatar_url(String avatar_url){
        this.avatar_url = avatar_url;
    }
    public String getAvatar_url(){
        return this.avatar_url;
    }
    public void setLocation(String location){
        this.location = location;
    }
    public String getLocation(){
        return this.location;
    }
}
