package com.cuiyongzhi.wechat.message.resp;

//�ı���Ϣ��Ϣ��
/**
 * ClassName: TextMessage
 * 
 * @Description: �ı���Ϣ��Ϣ��
 * @author dapengniao
 * @date 2016 �� 3 �� 7 �� ���� 3:54:22
 */
public class TextMessage extends BaseMessage {
	// �ظ�����Ϣ����
	private String Content;

	public String getContent() {
		return Content;
	}

	public void setContent(String content) {
		Content = content;
	}
}