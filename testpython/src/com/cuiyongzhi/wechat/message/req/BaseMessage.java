package com.cuiyongzhi.wechat.message.req;

//������Ϣ�ķ��༰ʵ��Ĵ���
/**
 * ClassName: BaseMessage
 * 
 * @Description: ΢��������Ϣ������
 * @author dapengniao
 * @date 2016 �� 3 �� 7 �� ���� 3:03:59
 */
public class BaseMessage {
	// ������΢�ź�
	private String ToUserName;
	// ���ͷ��ʺţ�һ�� OpenID��
	private String FromUserName;
	// ��Ϣ����ʱ�� �����ͣ�
	private long CreateTime;
	// ��Ϣ���ͣ�text/image/location/link/video/shortvideo��
	private String MsgType;
	// ��Ϣ id��64 λ����
	private long MsgId;

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

	public long getMsgId() {
		return MsgId;
	}

	public void setMsgId(long msgId) {
		MsgId = msgId;
	}
}