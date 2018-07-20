package com.cuiyongzhi.wechat.common;

import java.util.HashMap;
import com.cuiyongzhi.web.util.GlobalConstants;
import com.cuiyongzhi.wechat.util.HttpUtils;

import net.sf.json.JSONObject;

/**
 * ClassName: GetUseInfo
 * @Description: ��ȡ΢���û���Ϣ
 * @author dapengniao
 * @date 2016 �� 3 �� 18 �� ���� 2:00:52
 */
public class GetUseInfo {
    /**
     * @Description: ͨ�� openid ��ȡ�û�΢����Ϣ
     * @param @param openid
     * @param @return
     * @param @throws Exception   
     * @author dapengniao
     * @date 2016 �� 3 �� 18 �� ���� 2:01:30
     */
    public static HashMap<String, String> Openid_userinfo(String openid)
            throws Exception {
        HashMap<String, String> params = new HashMap<String, String>();
        params.put("access_token",
                GlobalConstants.getInterfaceUrl("access_token"));  //��ʱ���л�ȡ���� token
        params.put("openid", openid);  //��Ҫ��ȡ���û��� openid
        params.put("lang", "zh_CN");
        String subscribers = HttpUtils.sendGet(
                GlobalConstants.getInterfaceUrl("OpenidUserinfoUrl"), params);
        System.out.println(subscribers);
        params.clear();
        //���ﷵ�ز���ֻȡ���ǳơ�ͷ�񡢺��Ա�
        params.put("nickname",
                JSONObject.fromObject(subscribers).getString("nickname")); //�ǳ�
        params.put("headimgurl",
                JSONObject.fromObject(subscribers).getString("headimgurl"));  //ͼ��
        params.put("sex", JSONObject.fromObject(subscribers).getString("sex"));  //�Ա�
        return params;
    }

}