package com.cuiyongzhi.wechat.message.req;

/**
 * ClassName: TextMessage
 * @Description: �ı���Ϣ
 * @author dapengniao
 * @date 2016 �� 3 �� 7 �� ���� 3:06:40
 */
public class TextMessage extends BaseMessage {  
    // ��Ϣ����   
    private String Content;  

    public String getContent() {  
        return Content;  
    }  

    public void setContent(String content) {  
        Content = content;  
    }  
}