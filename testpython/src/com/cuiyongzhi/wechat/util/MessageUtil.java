package com.cuiyongzhi.wechat.util;

import java.io.InputStream;
import java.io.Writer;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;


import com.cuiyongzhi.wechat.message.resp.Article;
import com.cuiyongzhi.wechat.message.resp.ImageMessage;
import com.cuiyongzhi.wechat.message.resp.MusicMessage;
import com.cuiyongzhi.wechat.message.resp.NewsMessage;
import com.cuiyongzhi.wechat.message.resp.TextMessage;
import com.cuiyongzhi.wechat.message.resp.VideoMessage;
import com.cuiyongzhi.wechat.message.resp.VoiceMessage;


import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.core.util.QuickWriter;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;
import com.thoughtworks.xstream.io.xml.PrettyPrintWriter;
import com.thoughtworks.xstream.io.xml.XppDriver;

public class MessageUtil {
	/**
	 * ������Ϣ���ͣ��ı�
	 */
	public static final String RESP_MESSAGE_TYPE_TEXT = "text";

	/**
	 * ������Ϣ���ͣ�����
	 */
	public static final String RESP_MESSAGE_TYPE_MUSIC = "music";

	/**
	 * ������Ϣ���ͣ�ͼ��
	 */
	public static final String RESP_MESSAGE_TYPE_NEWS = "news";

	/**
	 * ������Ϣ���ͣ��ı�
	 */
	public static final String REQ_MESSAGE_TYPE_TEXT = "text";

	/**
	 * ������Ϣ���ͣ�ͼƬ
	 */
	public static final String REQ_MESSAGE_TYPE_IMAGE = "image";

	/**
	 * ������Ϣ���ͣ�����
	 */
	public static final String REQ_MESSAGE_TYPE_LINK = "link";

	/**
	 * ������Ϣ���ͣ�����λ��
	 */
	public static final String REQ_MESSAGE_TYPE_LOCATION = "location";

	/**
	 * ������Ϣ���ͣ���Ƶ
	 */
	public static final String REQ_MESSAGE_TYPE_VOICE = "voice";

	/**
	 * ������Ϣ���ͣ�����
	 */
	public static final String REQ_MESSAGE_TYPE_EVENT = "event";

	/**
	 * �¼����ͣ�subscribe(����)
	 */
	public static final String EVENT_TYPE_SUBSCRIBE = "subscribe";

	/**
	 * �¼����ͣ�unsubscribe(ȡ������)
	 */
	public static final String EVENT_TYPE_UNSUBSCRIBE = "unsubscribe";

	/**
	 * �¼����ͣ�CLICK(�Զ���˵�����¼�)
	 */
	public static final String EVENT_TYPE_CLICK = "CLICK";

	/**
	 * ������Ϣ���ͣ���Ƶ
	 */
	public static final String REQ_MESSAGE_TYPE_VIDEO = "video";

	/**
	 * �¼����ͣ�VIEW(�Զ���˵� URl ��ͼ)
	 */
	public static final String EVENT_TYPE_VIEW = "VIEW";

	/**
	 * �¼����ͣ�LOCATION(�ϱ�����λ���¼�)
	 */
	public static final String EVENT_TYPE_LOCATION = "LOCATION";

	/**
	 * �¼����ͣ�LOCATION(�ϱ�����λ���¼�)
	 */
	public static final String EVENT_TYPE_SCAN = "SCAN";

	/**
	 * @Description: ����΢�ŷ���������XML��
	 * @param @param
	 *            request
	 * @param @return
	 * @param @throws
	 *            Exception
	 * @author dapengniao
	 * @date 2016 �� 3 �� 7 �� ���� 10:04:02
	 */
	@SuppressWarnings("unchecked")
	public static Map<String, String> parseXml(HttpServletRequest request) throws Exception {
		// ����������洢�� HashMap ��
		Map<String, String> map = new HashMap<String, String>();

		// �� request ��ȡ��������
		InputStream inputStream = request.getInputStream();
		// ��ȡ������
		SAXReader reader = new SAXReader();
		Document document = reader.read(inputStream);
		// �õ� xml ��Ԫ��
		Element root = document.getRootElement();
		// �õ���Ԫ�ص������ӽڵ�
		List<Element> elementList = root.elements();

		// ���������ӽڵ�
		for (Element e : elementList)
			map.put(e.getName(), e.getText());

		// �ͷ���Դ
		inputStream.close();
		inputStream = null;

		return map;
	}

	/**
	 * @Description: �ı���Ϣ����ת���� xml
	 * @param @param
	 *            textMessage
	 * @param @return
	 * @author dapengniao
	 * @date 2016 �� 3 �� 8 �� ���� 4:13:22
	 */
	public static String textMessageToXml(TextMessage textMessage) {
		xstream.alias("xml", textMessage.getClass());
		return xstream.toXML(textMessage);
	}

	/**
	 * @Description: ͼ����Ϣ����ת���� xml
	 * @param @param
	 *            newsMessage
	 * @param @return
	 * @author dapengniao
	 * @date 2016 �� 3 �� 8 �� ���� 4:14:09
	 */
	public static String newsMessageToXml(NewsMessage newsMessage) {
		xstream.alias("xml", newsMessage.getClass());
		xstream.alias("item", new Article().getClass());
		return xstream.toXML(newsMessage);
	}

	/**
	 * @Description: ͼƬ��Ϣ����ת���� xml
	 * @param @param
	 *            imageMessage
	 * @param @return
	 * @author dapengniao
	 * @date 2016 �� 3 �� 9 �� ���� 9:25:51
	 */
	public static String imageMessageToXml(ImageMessage imageMessage) {
		xstream.alias("xml", imageMessage.getClass());
		return xstream.toXML(imageMessage);
	}

	/**
	 * @Description: ������Ϣ����ת���� xml
	 * @param @param
	 *            voiceMessage
	 * @param @return
	 * @author dapengniao
	 * @date 2016 �� 3 �� 9 �� ���� 9:27:26
	 */
	public static String voiceMessageToXml(VoiceMessage voiceMessage) {
		xstream.alias("xml", voiceMessage.getClass());
		return xstream.toXML(voiceMessage);
	}

	/**
	 * @Description: ��Ƶ��Ϣ����ת���� xml
	 * @param @param
	 *            videoMessage
	 * @param @return
	 * @author dapengniao
	 * @date 2016 �� 3 �� 9 �� ���� 9:31:09
	 */
	public static String videoMessageToXml(VideoMessage videoMessage) {
		xstream.alias("xml", videoMessage.getClass());
		return xstream.toXML(videoMessage);
	}

	/**
	 * @Description: ������Ϣ����ת���� xml
	 * @param @param
	 *            musicMessage
	 * @param @return
	 * @author dapengniao
	 * @date 2016 �� 3 �� 8 �� ���� 4:13:36
	 */
	public static String musicMessageToXml(MusicMessage musicMessage) {
		xstream.alias("xml", musicMessage.getClass());
		return xstream.toXML(musicMessage);
	}

	@SuppressWarnings("unused")
	private static XStream xstream = new XStream(new XppDriver() {
		public HierarchicalStreamWriter createWriter(Writer out) {
			return new PrettyPrintWriter(out) {
				// ������ xml �ڵ��ת�������� CDATA ���
				boolean cdata = true;

				@SuppressWarnings("rawtypes")
				public void startNode(String name, Class clazz) {
					super.startNode(name, clazz);
				}

				protected void writeText(QuickWriter writer, String text) {
					if (cdata) {
						writer.write("<![CDATA[");
						writer.write(text);
						writer.write("]]>");
					} else {
						writer.write(text);
					}
				}
			};
		}
	});

}
