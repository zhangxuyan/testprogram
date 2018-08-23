package com.esage.wechat;

import java.io.IOException;

public class wechatTest {
	public static void main(String[] args) {

		send_weChatMsg sw = new send_weChatMsg();
		for (int i = 0; i < 1; i++) {
			try {
				String token = sw.getToken("wxc3d6d3d47f0cd58d", "0268ecedbbf89047d81af918b71235ca");// o294703AnBL8xEQcVDGUMBOgZDHc
																										// /
																										// o294705BFZf-Kui1UcWKWhiL3GDQ
				String postdata = sw.createpostdata("o294705BFZf-Kui1UcWKWhiL3GDQ", "text", 1, "content", "love wj");
				String resp = sw.post("utf-8", send_weChatMsg.CONTENT_TYPE, (new urlData()).getSendMessage_Url(),
						postdata, token);
				System.out.println("获取到的token======>" + token);
				System.out.println("请求数据======>" + postdata);
				System.out.println("发送微信的响应数据======>" + resp);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
// 11_BBNqtvyn-5bz6ynOAbPfhf8y8u3TeN9GUhcYNhjLuqJtBCSNe_EjjGUwSGJwkMe-BNe48Ctt6nGIpjRx514kmZU9iS0vlBWH9v_9mQhKCmEfpXNy3bUvKfbEMojMMVcyxbGa9YbugjAkc_EHNVDgAHAGOW
// 11_DAYsHQFWuZ_7Mg6pLUUaZ67eS_prQMtYfRhLuqrZDMTj2zHJnp_LVM-DtM_4FjMpHsTWml-5ZZ645zdbxzBYAOWoR98MVASZ9OJkxpgmGHwvRC9ieX1Ik54rldQzlRH4pdIenAxUI2MaATcSEIRiAIAJNW