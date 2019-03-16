package test_java.test.test_xml;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.QName;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;
import org.junit.Test;

public class Dom4JMain {
	
	String filePath ;
	{
		filePath = "F:\\kaifa_tool\\eclipse-jee-mars-1-win32-x86_64\\eclipse\\workspace\\test_java\\src\\test_java\\test\\test_xml\\";
		
	}
	
	@Test
	public void testRead() throws Exception {
	
		SAXReader saxReader = new SAXReader();
		Document document =  saxReader.read(new File(filePath+"test.xml"));
		
		Element element = document.getRootElement();
		
		List<Element> elements = element.elements();
		
		for (Element element2 : elements) {

			List<Element> elementss = element2.elements();
			for (Element element3 : elementss) {
				//System.out.println(element3.getText());
			}
		}
		
		QName qName = new QName("Student");
		List<Element> elementName = element.elements(qName);
		
		for (Element element2 : elementName) {
			System.out.println(element2.getName());
		}
		
	}
	
	@Test
	public void testaddElement() throws Exception {
		SAXReader saxReader = new SAXReader();
		Document document =  saxReader.read(new File(filePath+"test.xml"));
		
		Element rootelement = document.getRootElement();
		
		Element tElement = rootelement.addElement("test");
		Element daElement = tElement.addElement("da");
		daElement.setText("da");
		
		OutputStreamWriter outputStreamWriter = new OutputStreamWriter(new FileOutputStream(new File(filePath+"test1.xml")), "UTF-8");
		XMLWriter xmlWriter = new XMLWriter(outputStreamWriter);
		xmlWriter.write(document);
		xmlWriter.close();
		
	}
	
	@Test
	public void testcreateDocument() throws Exception {
		
		Element rootElement = DocumentHelper.createElement("root");
		Document document = DocumentHelper.createDocument(rootElement);
		
		rootElement.addElement("test");
		
		/*Document document2 = DocumentHelper.createDocument();
		Element element = document2.addElement("root");
		element.addElement("test");*/
		

		OutputStreamWriter outputStreamWriter = new OutputStreamWriter(new FileOutputStream(new File(filePath+"test2.xml")), "UTF-8");
		XMLWriter xmlWriter = new XMLWriter(outputStreamWriter);
		xmlWriter.write(document);
		xmlWriter.close();
		
	}
	
}
