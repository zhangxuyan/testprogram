package com.cuiyongzhi.wechat.message.resp;

//�ظ���Ϣ�����ʵ��
/**
 * ClassName: BaseMessage
 * 
 * @Description: ������Ϣ��-������Ϣ
 * @author dapengniao
 * @date 2016 �� 3 �� 7 �� ���� 3:16:57
 */
public class BaseMessage {
	// ���շ��ʺţ��յ��� OpenID��
	private String ToUserName;
	// ������΢�ź�
	private String FromUserName;
	// ��Ϣ����ʱ�� �����ͣ�
	private long CreateTime;
	// ��Ϣ���ͣ�text/music/news��
	private String MsgType;

	public String getToUserName() {
		return ToUserName;
	}

	public void setToUserName(String toUserName) {
		ToUserName = toUserName;
	}

	public String getFromUserName() {
		return FromUserName;
	}

	public void setFromUserName(String fromUserName) {
		FromUserName = fromUserName;
	}

	public long getCreateTime() {
		return CreateTime;
	}

	public void setCreateTime(long createTime) {
		CreateTime = createTime;
	}

	public String getMsgType() {
		return MsgType;
	}

	public void setMsgType(String msgType) {
		MsgType = msgType;
	}

}