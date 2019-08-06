package com.test.xml;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.ContentHandler;
import org.xml.sax.Locator;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;

public class SaxXmlDemo {

	public static void main(String[] args) throws Exception {
		saxParseTest();
	}

	public static void saxParseTest() throws Exception {
		// 加载文件返回文件的输入流
		InputStream is = new FileInputStream("E:\\TradeCenter\\workspace\\Test\\src\\main\\resource\\users.xml");
		XmlParseHandler handler = new XmlParseHandler();
		// 1. 得到SAX解析工厂
		SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
		// 2. 让工厂生产一个sax解析器
		SAXParser newSAXParser = saxParserFactory.newSAXParser();
		// 3. 传入输入流和handler，解析
		newSAXParser.parse(is, handler);
		is.close();
	}

	public static void saxParseTest2() throws Exception {
		// 1.创建解析工厂
		SAXParserFactory factory = SAXParserFactory.newInstance();
		// 2.得到解析器
		SAXParser sp = factory.newSAXParser();
		// 3得到解读器
		XMLReader reader = sp.getXMLReader();
		// 设置内容处理器
		reader.setContentHandler(new ListHandler());
		// 读取xml的文档内容
		reader.parse("E:\\TradeCenter\\workspace\\Test\\src\\main\\resource\\books.xml");
	}
}

class User {
	private long id;

	private String name;

	private String password;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}

class Book {
	private String name;
	private String author;
	private String price;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Book [name=" + name + ", author=" + author + ", price=" + price + "]";
	}
}

class XmlParseHandler extends DefaultHandler {

	private List<User> users;

	private String currentTag;

	private User user;

	@Override
	public void endDocument() throws SAXException {
		super.endDocument();
		System.out.println("-endDocument()");
	}

	@Override
	public void startDocument() throws SAXException {
		super.startDocument();
		System.out.println("startDocument()");
		users = new ArrayList<>();
	}

	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		super.startElement(uri, localName, qName, attributes);
		System.out.println("startElement " + qName + "-startElement()");
		if ("user".equals(qName)) {

			user = new User();

			for (int i = 0; i < attributes.getLength(); i++) {
				System.out.println("attributes attribute_name:" + attributes.getLocalName(i) + " attribute_value:"
						+ attributes.getValue(i));
				if ("id".equals(attributes.getLocalName(i))) {
					user.setId(Long.parseLong(attributes.getValue(i)));
				}
			}
		}

		currentTag = qName;
	}

	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		super.endElement(uri, localName, qName);
		System.out.println("endElement " + qName + "-endElement()");
		if ("user".equals(qName)) {
			users.add(user);
			user = null;
		}

		currentTag = null;
	}

	@Override
	public void characters(char[] ch, int start, int end) throws SAXException {
		super.characters(ch, start, end);
		String value = new String(ch, start, end);
		System.out.println("characters " + value);
		if ("name".equals(currentTag)) {
			user.setName(value);
		} else if ("password".equals(currentTag)) {
			user.setPassword(value);
		}

	}

	public List<User> getUsers() {
		return users;
	}

}

class ListHandler implements ContentHandler {

	/**
	 * 当读取到第一个元素时开始做什么
	 */

	@Override
	public void startElement(String uri, String localName, String qName, Attributes atts) throws SAXException {
		System.out.print("<" + qName);
		for (int i = 0; atts != null && i < atts.getLength(); i++) {
			String attName = atts.getQName(i);
			String attValueString = atts.getValue(i);
			System.out.print(" " + attName + "=" + attValueString);
			System.out.print(">");
		}

	}

	/**
	 * 表示读取到第一个元素结尾时做什么
	 */
	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		System.out.print("</" + qName + ">");

	}

	/**
	 * 表示读取字符串时做什么
	 */
	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		System.out.print(new String(ch, start, length));

	}

	@Override
	public void setDocumentLocator(Locator locator) {
		// TODO Auto-generated method stub

	}

	@Override
	public void startDocument() throws SAXException {
		// TODO Auto-generated method stub

	}

	@Override
	public void endDocument() throws SAXException {
		// TODO Auto-generated method stub

	}

	@Override
	public void startPrefixMapping(String prefix, String uri) throws SAXException {
		// TODO Auto-generated method stub

	}

	@Override
	public void endPrefixMapping(String prefix) throws SAXException {
		// TODO Auto-generated method stub

	}

	@Override
	public void ignorableWhitespace(char[] ch, int start, int length) throws SAXException {
		// TODO Auto-generated method stub

	}

	@Override
	public void processingInstruction(String target, String data) throws SAXException {
		// TODO Auto-generated method stub

	}

	@Override
	public void skippedEntity(String name) throws SAXException {
		// TODO Auto-generated method stub

	}

}
