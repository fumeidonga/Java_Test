package test_java.test.test_xml;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.junit.Test;
import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.Locator;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.helpers.DefaultHandler;

public class SaxMain {

	SAXParserFactory mSaxParserFactory ;
	
	SAXParser mSaxParser ;
	
	MyHandler myHandler;

	File mFile = new File("F:\\kaifa_tool\\eclipse-jee-mars-1-win32-x86_64\\eclipse\\workspace\\test_java\\src\\test_java\\test\\test_xml\\test.xml");

	
	{
		try {
			//1. 得到SAX 解析器的工厂实例
			mSaxParserFactory = SAXParserFactory.newInstance();
			
			//2. 通过factory 获取 SAX 解析器
			mSaxParser = mSaxParserFactory.newSAXParser();
			
			//3. 创建一个监听器类,重写自己感兴趣的事件
			myHandler = new MyHandler();
			
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * @throws IOException 
	 * @throws SAXException 
	 * 
	 */
	@Test
	public void test() throws SAXException, IOException{
		
		//1、开始解析
		mSaxParser.parse(mFile, myHandler);
		
		
	}
	
	class MyHandler extends DefaultHandler {

		/**
		 * 开始解析文档，开始XML 根元素时调用
		 */
		@Override
		public void startDocument() throws SAXException {
			super.startDocument();
			System.out.println("startDocument");
		}

		@Override
		public void endDocument() throws SAXException {
			super.endDocument();
			System.out.println("endDocument");
		}
		
		/**
		 * 开始解析每个元素时调用
		 */
		@Override
		public void startElement(String uri, String localName, String qName, Attributes attrs)
				throws SAXException {
			super.startElement(uri, localName, qName, attrs);
			System.out.println("startElement"); 
		}

		@Override
		public void endElement(String uri, String localName, String qName) throws SAXException {
			super.endElement(uri, localName, qName);
			System.out.println("endElement");
		}

		/**
		 * 解析到每个元素内容时调用
		 */
		@Override
		public void characters(char[] ch, int start, int length) throws SAXException {
			super.characters(ch, start, length);
			System.out.println("characters");
		}
		
		@Override
		public InputSource resolveEntity(String publicId, String systemId) throws IOException, SAXException {
			System.out.println("resolveEntity");
			return super.resolveEntity(publicId, systemId);
		}

		@Override
		public void notationDecl(String name, String publicId, String systemId) throws SAXException {
			super.notationDecl(name, publicId, systemId);
			System.out.println("notationDecl");
		}

		@Override
		public void unparsedEntityDecl(String name, String publicId, String systemId, String notationName)
				throws SAXException {
			super.unparsedEntityDecl(name, publicId, systemId, notationName);
			System.out.println("unparsedEntityDecl");
		}

		@Override
		public void setDocumentLocator(Locator locator) {
			super.setDocumentLocator(locator);
			System.out.println("setDocumentLocator");
		}

		@Override
		public void startPrefixMapping(String prefix, String uri) throws SAXException {
			super.startPrefixMapping(prefix, uri);
			System.out.println("startPrefixMapping");
		}

		@Override
		public void endPrefixMapping(String prefix) throws SAXException {
			super.endPrefixMapping(prefix);
			System.out.println("endPrefixMapping");
		}

		@Override
		public void ignorableWhitespace(char[] ch, int start, int length) throws SAXException {
			super.ignorableWhitespace(ch, start, length);
			System.out.println("ignorableWhitespace");
		}

		@Override
		public void processingInstruction(String target, String data) throws SAXException {
			super.processingInstruction(target, data);
			System.out.println("processingInstruction");
		}

		@Override
		public void skippedEntity(String name) throws SAXException {
			super.skippedEntity(name);
			System.out.println("skippedEntity");
		}

		@Override
		public void warning(SAXParseException e) throws SAXException {
			super.warning(e);
			System.out.println("warning");
		}

		@Override
		public void error(SAXParseException e) throws SAXException {
			super.error(e);
			System.out.println("error");
		}

		@Override
		public void fatalError(SAXParseException e) throws SAXException {
			super.fatalError(e);
			System.out.println("fatalError");
		}
		
	}
}
