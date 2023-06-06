package cn.Yifei.chatGPT.api.application.zsxq.model.vo;

/**
 * @author Yifei
 * @description
 * @date 2023/6/6
 */

public class Group
{
    private Long group_id;

    private String name;

    private String type;

    public void setGroup_id(Long group_id){
        this.group_id = group_id;
    }
    public Long getGroup_id(){
        return this.group_id;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return this.name;
    }
    public void setType(String type){
        this.type = type;
    }
    public String getType(){
        return this.type;
    }
}
