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
			+ "<MsgType><![CDATA[text]]></MsgType>" + "<Content><![CDATA[你好]]></Content>"
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
	 * 根据节点名称，读取节点值
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

	// 在第一个标签的末尾添加一个元素<sex></sex>
	public static void addSex() throws Exception {
		/*
		 * 1、创建解析器 2、得到document 3、得到根节点 4、获取到第一个p1 5、在p1下面添加元素 6、在添加的元素下面添加文本
		 * 7、回写xml
		 */

		// 创建解析器
		SAXReader saxReader = new SAXReader();
		// 得到document
		Document document = saxReader.read("src/p1.xml");
		// 得到根节点
		Element root = document.getRootElement();
		// 得到第一个p1元素
		Element p1 = root.element("p1");
		// 在p1下面直接添加元素,使用addElement("标签名")方法 返回一个Element
		Element sex = p1.addElement("sex");
		// 在sex下面添加文本
		sex.addText("female");
		// 回写xml
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
