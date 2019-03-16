package test_java.test.test_xstream.annitions.conver;

import org.junit.Test;

import com.thoughtworks.xstream.XStream;

import test_java.test.test_xstream.annitions.Person;

/**
 * 自定义转换器
 * @author david
 *
 */
public class DefineMain {

	/**
	 * 测试xstream的注释
	 * 使用Xstream注解前需要对Xstream进行配置，可以使用两种方式：应用某个JavaBean类的注解或自动使用JavaBean类的注解
	 * 1. xstream.processAnnotations(Person.class);//应用Person类的注解
	 * 2. xstream.autodetectAnnotations(true);//自动检测注解
	 */
	@Test
	public void test() {
		DefinePerson bean = new DefinePerson("张三", 19, "nan", "李四", "王五", "赵六");
		XStream xstream = new XStream();
		
		//对Xstream进行配置
		xstream.processAnnotations(DefinePerson.class);//应用Person类的注解
		//xstream.autodetectAnnotations(true);//自动检测注解
		
		// 序列化
		String xml = xstream.toXML(bean);
		System.out.println(xml);

		// 反序列化
		bean = (DefinePerson) xstream.fromXML(xml);
		System.out.println(bean);

	}
}
