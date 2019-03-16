package test_java.test.test_xstream;

import org.junit.Test;

import com.thoughtworks.xstream.XStream;

public class Main {

	// xml 序列化
	// xStream.toXML(bean)
	@Test
	public void test() {
		Person bean = new Person("张三", 19);

		XStream xStream = new XStream();
		
		//将包重命名
		xStream.aliasPackage("test", "test_java.test.test_xstream");
		
		//将类重命名
		xStream.alias("人", Person.class);
		
		//为类的字段节点重命名
		xStream.aliasField("姓名", Person.class,"name");

		String xml = xStream.toXML(bean);

		System.out.println(xml);

	}

	//XML反序列化
	//xStream.fromXML(xml)
	@Test
	public void testToBean() {
		Person bean = new Person("张三", 19);

		XStream xStream = new XStream();

		String xml = xStream.toXML(bean);

		System.out.println(xml);
		
		Person beantest = (Person) xStream.fromXML(xml);
		
		System.out.println(beantest);
	}
	
	//省略集合根节点：Xstream.addImplicitCollection()方法
	//把字段节点设置成属性：Xstream.useAttributeFor()方法
	//隐藏字段：xstream.omitField()方法
	//
	public void testddd(){
		
	}
	
}
