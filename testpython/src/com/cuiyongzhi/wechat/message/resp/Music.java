package com.cuiyongzhi.wechat.message.resp;

/**
 * ClassName: Music
 * @Description: ������Ϣ��Ϣ��
 * @author dapengniao
 * @date 2016 �� 3 �� 7 �� ���� 3:54:00
 */
public class Music {  
    // ��������   
    private String Title;  
    // ��������   
    private String Description;  
    // ��������   
    private String MusicUrl;  
    // �������������ӣ�WIFI ��������ʹ�ø����Ӳ�������   
    private String HQMusicUrl;

    private String ThumbMediaId; //����ͼ��ý�� id

    public String getThumbMediaId() {
        return ThumbMediaId;
    }

    public void setThumbMediaId(String thumbMediaId) {
        ThumbMediaId = thumbMediaId;
    }

    public String getTitle() {  
        return Title;  
    }  

    public void setTitle(String title) {  
        Title = title;  
    }  

    public String getDescription() {  
        return Description;  
    }  

    public void setDescription(String description) {  
        Description = description;  
    }  

    public String getMusicUrl() {  
        return MusicUrl;  
    }  

    public void setMusicUrl(String musicUrl) {  
        MusicUrl = musicUrl;  
    }  

    public String getHQMusicUrl() {  
        return HQMusicUrl;  
    }  

    public void setHQMusicUrl(String musicUrl) {  
        HQMusicUrl = musicUrl;  
    }  

}