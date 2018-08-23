package com.esage.wechat;

public class urlData {
	String corpid;
	String corpsecret;
	String Get_Token_Url;
	String SendMessage_Url;

	public String getCorpid() {
		return corpid;
	}

	public void setCorpid(String corpid) {
		this.corpid = corpid;
	}

	public String getCorpsecret() {
		return corpsecret;
	}

	public void setCorpsecret(String corpsecret) {
		this.corpsecret = corpsecret;
	}

	public void setGet_Token_Url(String corpid, String corpsecret) {
		//this.Get_Token_Url = "https://qyapi.weixin.qq.com/cgi-bin/gettoken?corpid=" + corpid + "&corpsecret="
			//	+ corpsecret;
		this.Get_Token_Url = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=" + corpid +"&secret="+ corpsecret;
		
	}

	public String getGet_Token_Url() {
		return Get_Token_Url;
	}

	public String getSendMessage_Url() {
//		SendMessage_Url = "https://qyapi.weixin.qq.com/cgi-bin/message/send?access_token=";
		SendMessage_Url = "https://api.weixin.qq.com/cgi-bin/message/custom/send?access_token=";
		return SendMessage_Url;
	}
}
