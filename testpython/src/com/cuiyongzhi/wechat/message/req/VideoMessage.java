package com.cuiyongzhi.wechat.message.req;

/**
 * ClassName: VideoMessage
 * @Description: ��Ƶ/С������Ϣ
 * @author dapengniao
 * @date 2016 �� 3 �� 7 �� ���� 3:12:51
 */
public class VideoMessage extends BaseMessage {

    private String MediaId; // ��Ƶ��Ϣý�� id�����Ե��ö�ý���ļ����ؽӿ���ȡ����
    private String ThumbMediaId; // ��Ƶ��Ϣ����ͼ��ý�� id�����Ե��ö�ý���ļ����ؽӿ���ȡ����

    public String getMediaId() {
        return MediaId;
    }

    public void setMediaId(String mediaId) {
        MediaId = mediaId;
    }

    public String getThumbMediaId() {
        return ThumbMediaId;
    }

    public void setThumbMediaId(String thumbMediaId) {
        ThumbMediaId = thumbMediaId;
    }

}