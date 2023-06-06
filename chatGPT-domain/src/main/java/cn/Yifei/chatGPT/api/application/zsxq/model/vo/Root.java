package cn.Yifei.chatGPT.api.application.zsxq.model.vo;

import cn.Yifei.chatGPT.api.application.zsxq.model.res.Resp_data;

/**
 * @author Yifei
 * @description
 * @date 2023/6/6
 */

public class Root
{
    private boolean succeeded;

    private Resp_data resp_data;

    public void setSucceeded(boolean succeeded){
        this.succeeded = succeeded;
    }
    public boolean getSucceeded(){
        return this.succeeded;
    }
    public void setResp_data(Resp_data resp_data){
        this.resp_data = resp_data;
    }
    public Resp_data getResp_data(){
        return this.resp_data;
    }
}
