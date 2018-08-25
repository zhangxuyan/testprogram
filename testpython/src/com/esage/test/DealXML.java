package com.esage.test;

import java.io.FileOutputStream;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

public class DealXML {
	private String content = "";

	private static String XMLStr = "<xml>" + "<ToUserName><![CDATA[ToUserName]]></ToUserName>"
			+ "<FromUserName><![CDATA[FromUserName]]></FromUserName>" + "<CreateTime>15176558190</CreateTime>"
			+ "<MsgType><![CDATA[text]]></MsgType>" + "<Content><![CDATA[���]]></Content>"
			+ "<MsgId>6518192292999800190</MsgId>" + "</xml>"

	;

	/**
	 * 
	 * @param node
	 * @return
	 */
	public String readNodes(Element node) {
		content += node.getName() + ":" + node.getTextTrim() + "\n";
		List<Element> listElement = node.elements();

		for (Element e : listElement) {

			readNodes(e);

		}

		return content;
	}

	/**
	 * 
	 * ���ݽڵ����ƣ���ȡ�ڵ�ֵ
	 * 
	 * @param root
	 * @param name
	 * @return
	 */
	public static String readNode(Element root, String name) {
		Element e = root.element(name);
		String nodeString = e.getTextTrim();

		return nodeString;
	}

	// �ڵ�һ����ǩ��ĩβ���һ��Ԫ��<sex></sex>
	public static void addSex() throws Exception {
		/*
		 * 1������������ 2���õ�document 3���õ����ڵ� 4����ȡ����һ��p1 5����p1�������Ԫ�� 6������ӵ�Ԫ����������ı�
		 * 7����дxml
		 */

		// ����������
		SAXReader saxReader = new SAXReader();
		// �õ�document
		Document document = saxReader.read("src/p1.xml");
		// �õ����ڵ�
		Element root = document.getRootElement();
		// �õ���һ��p1Ԫ��
		Element p1 = root.element("p1");
		// ��p1����ֱ�����Ԫ��,ʹ��addElement("��ǩ��")���� ����һ��Element
		Element sex = p1.addElement("sex");
		// ��sex��������ı�
		sex.addText("female");
		// ��дxml
		XMLWriter xmlWriter = new XMLWriter(new FileOutputStream("src/p1.xml"), OutputFormat.createPrettyPrint());
		xmlWriter.write(document);
		xmlWriter.close();
	}

	public static void main(String[] args) {

		// test1();
		try {
			DealXML.addSex();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static void test1() {
		SAXReader saxReader = new SAXReader();

		Document document;
		try {
			document = saxReader.read("src/p1.xml");
			// document = DocumentHelper.parseText(XMLStr);
			Element root = document.getRootElement();
			DealXML dXml = new DealXML();
			System.out.println(dXml.readNodes(root));
			// System.out.println("MsgType:" + dXml.readNode(root, "MsgType"));
			// System.out.println("Content:" + dXml.readNode(root, "Content"));
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
