package cn.Yifei.chatGPT.api.application.zsxq.model.aggregates;

import cn.Yifei.chatGPT.api.application.zsxq.model.res.Resp_data;

/**
 * @author Yifei
 * @description The aggregated information of one question that I posted on ZSXQ
 * @date 2023/6/6
 */

public class MyQuestionAggregates {
    private boolean succeeded;
    private Resp_data resp_data;

    public boolean isSucceeded() {
        return succeeded;
    }

    public void setSucceeded(boolean succeeded) {
        this.succeeded = succeeded;
    }

    public Resp_data getResp_data() {
        return resp_data;
    }

    public void setResp_data(Resp_data resp_data) {
        this.resp_data = resp_data;
    }
}
