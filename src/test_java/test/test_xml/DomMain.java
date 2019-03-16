package test_java.test.test_xml;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.junit.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

/**
 * 旨在学习 Dom 解析xml文档
 * @author david
 *
 */
public class DomMain {
	
	DocumentBuilderFactory mDocumentBuilderFactory = null;
	
	DocumentBuilder mDocumentBuilder = null;
	
	Document mDocument = null;
	
	File mFile = new File("F:\\kaifa_tool\\eclipse-jee-mars-1-win32-x86_64\\eclipse\\workspace\\test_java\\src\\test_java\\test\\test_xml\\test.xml");

	{
		try {
			//1. 得到DOM 解析器的工厂实例
			mDocumentBuilderFactory = DocumentBuilderFactory.newInstance();
			
			//2. 通过工厂实例获取DOM解析器
			mDocumentBuilder = mDocumentBuilderFactory.newDocumentBuilder();
			
			//3. 使用解析器解析parse方法XML 文件、流等，得到XML文档的文档树模型Document，后面所有的操作都在Document中进行
			mDocument = mDocumentBuilder.parse(mFile);
			
		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}
	
	/**
	 * <School>
	    	<Student>
		        <Name>沈浪</Name>
		        <Num>1006010022</Num>
		        <Classes>信管2</Classes>
		        <Address>浙江杭州3</Address>
		        <Tel>123456</Tel>
	    	</Student>
		</School>
	 */
	
	/**
	 * 插入XML 元素
	 * @throws FileNotFoundException 
	 * @throws TransformerException 
	 */
	@Test
	public void testInsertXML() throws FileNotFoundException, TransformerException{
		//插入元素一样，我们首先要得到XML 源的 Document，
		//如上的xml结构， 比如我现在要再插入一个student 的节点
		
		//1.我们要在School节点下插入student ，先获取到School
		NodeList schoolList = mDocument.getElementsByTagName("School");
		Element school = (Element) schoolList.item(0);
				
		//2. 创建student节点
		Element student = mDocument.createElement("Student");
		
		//3. Student 节点下面还有 5 个子节点，我们需要一一创建
		Element name = mDocument.createElement("Name");
		Element num = mDocument.createElement("Num");
		Element classes = mDocument.createElement("Classes");
		Element address = mDocument.createElement("Address");
		Element tel = mDocument.createElement("Tel");
		
		//4. 给子节点赋值
		name.appendChild(mDocument.createTextNode("1"));
		num.appendChild(mDocument.createTextNode("1"));
		classes.appendChild(mDocument.createTextNode("1"));
		address.appendChild(mDocument.createTextNode("1"));
		tel.appendChild(mDocument.createTextNode("1"));
		
		//5. student 节点添加子节点
		student.appendChild(name);
		student.appendChild(num);
		student.appendChild(classes);
		student.appendChild(address);
		student.appendChild(tel);
		
		//6. school 添加 student 节点
		school.appendChild(student);
		
		//7. 写入文件
		TransformerFactory tf = TransformerFactory.newInstance();  
		Transformer transformer = tf.newTransformer();  
		DOMSource source = new DOMSource(mDocument);  
		transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");  
		transformer.setOutputProperty(OutputKeys.INDENT, "yes");//设置文档的换行与缩进  
		PrintWriter pw = new PrintWriter(new FileOutputStream("src/test_java/test/test_xml/insertSchool.xml"));  
		StreamResult result = new StreamResult(pw);  
		transformer.transform(source, result);  
        System.out.println("成功");
	}
	
	/**
	 * 遍历XML 文档
	 */
	@Test
	public void test(){
		//获取所有名字为Student 的 节点 Node
		NodeList nodeList = mDocument.getElementsByTagName("Student");
		
		for(int i = 0; i < nodeList.getLength(); i++){
			Element element = (Element) nodeList.item(i);
			System.out.println(element.getElementsByTagName("Name").item(0).getFirstChild().getNodeValue());
			System.out.println(element.getElementsByTagName("Num").item(0).getFirstChild().getNodeValue());
			System.out.println(element.getElementsByTagName("Classes").item(0).getFirstChild().getNodeValue());
			System.out.println(element.getElementsByTagName("Address").item(0).getFirstChild().getNodeValue());
			System.out.println(element.getElementsByTagName("Tel").item(0).getFirstChild().getNodeValue());
			System.out.println("-------------------------------------------------------");
		}
	}
	
	
	/**
	 * 创建xml文档
	 */
	@Test
	public void testCreateXML(){
		
	}
	
	
}
