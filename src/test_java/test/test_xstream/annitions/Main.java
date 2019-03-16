package test_java.test.test_xstream.annitions;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.thoughtworks.xstream.XStream;

import test_java.test.test_xstream.annitions.Person.BankCard;

public class Main {

	/**
	 * 测试xstream的注释
	 * 使用Xstream注解前需要对Xstream进行配置，可以使用两种方式：应用某个JavaBean类的注解或自动使用JavaBean类的注解
	 * 1. xstream.processAnnotations(Person.class);//应用Person类的注解
	 * 2. xstream.autodetectAnnotations(true);//自动检测注解
	 */
	@Test
	public void test() {
		Person.BankCard bankCard = new Person.BankCard("1", 1);
		Person.BankCard bankCard2 = new Person.BankCard("1", 1);
		List<BankCard> bankCards = new ArrayList<>();
		bankCards.add(bankCard);
		bankCards.add(bankCard2);
		
		Person bean = new Person("张三", 19, false, "李四", "王五", "赵六");
		XStream xstream = new XStream();
		bean.setBankCards(bankCards);
		
		//对Xstream进行配置
		xstream.processAnnotations(Person.class);//应用Person类的注解
		//xstream.autodetectAnnotations(true);//自动检测注解
		
		// 序列化
		String xml = xstream.toXML(bean);
		System.out.println(xml);

		// 反序列化
		bean = (Person) xstream.fromXML(xml);
		System.out.println(bean);

	}
}
