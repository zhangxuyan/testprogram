package com.cuiyongzhi.wechat.message.req;

/**
 * ClassName: ImageMessage
 * @Description: ͼƬ��Ϣ
 * @author dapengniao
 * @date 2016 �� 3 �� 7 �� ���� 3:04:52
 */
public class ImageMessage extends BaseMessage {
    // ͼƬ����
    private String PicUrl;

    public String getPicUrl() {
        return PicUrl;
    }

    public void setPicUrl(String picUrl) {
        PicUrl = picUrl;
    }
}