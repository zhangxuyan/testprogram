package com.cuiyongzhi.wechat.message.req;

/**
 * ClassName: VoiceMessage
 * @Description: ������Ϣ
 * @author dapengniao
 * @date 2016 �� 3 �� 7 �� ���� 3:07:10
 */
public class VoiceMessage extends BaseMessage {  
    // ý�� ID   
    private String MediaId;  
    // ������ʽ   
    private String Format;  

    public String getMediaId() {  
        return MediaId;  
    }  

    public void setMediaId(String mediaId) {  
        MediaId = mediaId;  
    }  

    public String getFormat() {  
        return Format;  
    }  

    public void setFormat(String format) {  
        Format = format;  
    }  
}