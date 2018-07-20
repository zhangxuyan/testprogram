package com.cuiyongzhi.wechat.controller;

import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.cuiyongzhi.wechat.dispatcher.EventDispatcher;
import com.cuiyongzhi.wechat.dispatcher.MsgDispatcher;
import com.cuiyongzhi.wechat.util.MessageUtil;
import com.cuiyongzhi.wechat.util.SignUtil;

@Controller
@RequestMapping("/wechat")
public class WechatSecurity {
	private static Logger logger = Logger.getLogger(WechatSecurity.class);

	// /**
	// *
	// * @Description: ���ڽ��� get ������������֤����
	// * @param @param
	// * request
	// * @param @param
	// * response
	// * @param @param
	// * signature
	// * @param @param
	// * timestamp
	// * @param @param
	// * nonce
	// * @param @param
	// * echostr
	// * @author dapengniao
	// * @date 2016 �� 3 �� 4 �� ���� 6:20:00
	// */
	// @RequestMapping(value = "security", method = RequestMethod.GET)
	// public void doGet(HttpServletRequest request, HttpServletResponse
	// response,
	// @RequestParam(value = "signature", required = true) String signature,
	// @RequestParam(value = "timestamp", required = true) String timestamp,
	// @RequestParam(value = "nonce", required = true) String nonce,
	// @RequestParam(value = "echostr", required = true) String echostr) {
	// try {
	// if (SignUtil.checkSignature(signature, timestamp, nonce)) {
	// PrintWriter out = response.getWriter();
	// out.print(echostr);
	// out.close();
	// } else {
	// logger.info("������ڷǷ�����");
	// }
	// } catch (Exception e) {
	// logger.error(e, e);
	// }
	// }

	//
	// @RequestMapping(value = "security", method = RequestMethod.POST)
	// // post �������ڽ���΢�ŷ������Ϣ
	// public void DoPost() {
	// System.out.println("���� post ������");
	// }

	// @RequestMapping(value = "security", method = RequestMethod.POST)
	// // post �������ڽ���΢�ŷ������Ϣ
	// public void DoPost(HttpServletRequest request, HttpServletResponse
	// response) {
	// System.out.println("���� post ������");
	// try {
	// Map<String, String> map = MessageUtil.parseXml(request);
	// System.out.println("=============================" + map.get("Content"));
	// } catch (Exception e) {
	// logger.error(e, e);
	// }
	// }

	/**
	 * 
	 * @Description: ���ڽ��� get ������������֤����
	 * @param @param
	 *            request
	 * @param @param
	 *            response
	 * @param @param
	 *            signature
	 * @param @param
	 *            timestamp
	 * @param @param
	 *            nonce
	 * @param @param
	 *            echostr
	 * @author dapengniao
	 * @date 2016 �� 3 �� 4 �� ���� 6:20:00
	 */
	@RequestMapping(value = "security", method = RequestMethod.GET)
	public void doGet(HttpServletRequest request, HttpServletResponse response,
			@RequestParam(value = "signature", required = true) String signature,
			@RequestParam(value = "timestamp", required = true) String timestamp,
			@RequestParam(value = "nonce", required = true) String nonce,
			@RequestParam(value = "echostr", required = true) String echostr) {
		try {
			if (SignUtil.checkSignature(signature, timestamp, nonce)) {
				PrintWriter out = response.getWriter();
				out.print(echostr);
				out.close();
			} else {
				logger.info("������ڷǷ�����");
			}
		} catch (Exception e) {
			logger.error(e, e);
		}
	}

	/**
	 * @Description: ����΢�Ŷ���Ϣ�������ַ�
	 * @param @param
	 *            request
	 * @param @param
	 *            response
	 * @author dapengniao
	 * @date 2016 �� 3 �� 7 �� ���� 4:06:47
	 */
	@RequestMapping(value = "security", method = RequestMethod.POST)
	public void DoPost(HttpServletRequest request, HttpServletResponse response) {
		try {
			Map<String, String> map = MessageUtil.parseXml(request);
			String msgtype = map.get("MsgType");
			if (MessageUtil.REQ_MESSAGE_TYPE_EVENT.equals(msgtype)) {
				EventDispatcher.processEvent(map); // �����¼�����
			} else {
				MsgDispatcher.processMessage(map); // ������Ϣ����
			}
		} catch (Exception e) {
			logger.error(e, e);
		}
	}

}