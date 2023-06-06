package cn.Yifei.chatGPT.api.application.zsxq.model.req;

/**
 * @author Yifei
 * @description
 * @date 2023/6/6
 */

public class Req_data {
    private String text;
    private String[] image_ids = new String[]{};
    private String[] mentioned_user_ids = new String[]{};

    public Req_data(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String[] getImage_ids() {
        return image_ids;
    }

    public void setImage_ids(String[] image_ids) {
        this.image_ids = image_ids;
    }

    public String[] getMentioned_user_ids() {
        return mentioned_user_ids;
    }

    public void setMentioned_user_ids(String[] mentioned_user_ids) {
        this.mentioned_user_ids = mentioned_user_ids;
    }
}
