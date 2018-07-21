package com.cuiyongzhi.wechat.dispatcher;

import java.util.Map;

import com.cuiyongzhi.wechat.util.MessageUtil;

/**
 * ClassName: EventDispatcher
 * @Description: �¼���Ϣҵ��ַ���
 * @author dapengniao
 * @date 2016 �� 3 �� 7 �� ���� 4:04:41
 */
public class EventDispatcher {
    public static String processEvent(Map<String, String> map) {
        if (map.get("Event").equals(MessageUtil.EVENT_TYPE_SUBSCRIBE)) { //��ע�¼�
            System.out.println("==============���ǹ�ע�¼���");
        }

        if (map.get("Event").equals(MessageUtil.EVENT_TYPE_UNSUBSCRIBE)) { //ȡ����ע�¼�
            System.out.println("==============����ȡ����ע�¼���");
        }

        if (map.get("Event").equals(MessageUtil.EVENT_TYPE_SCAN)) { //ɨ���ά���¼�
            System.out.println("==============����ɨ���ά���¼���");
        }

        if (map.get("Event").equals(MessageUtil.EVENT_TYPE_LOCATION)) { //λ���ϱ��¼�
            System.out.println("==============����λ���ϱ��¼���");
        }

        if (map.get("Event").equals(MessageUtil.EVENT_TYPE_CLICK)) { //�Զ���˵�����¼�
            System.out.println("==============�����Զ���˵�����¼���");
        }

        if (map.get("Event").equals(MessageUtil.EVENT_TYPE_VIEW)) { //�Զ���˵� View �¼�
            System.out.println("==============�����Զ���˵� View �¼���");
        }

        return null;
    }
}