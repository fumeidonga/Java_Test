package test_java.test.annotation;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

import org.junit.Test;

@TargetClassClass(uri="432")
public class Main {
	
	@TargetMethod(data="2017/02/09", uri="333")
	public void testInterface(String string){
		System.out.println(string);
	}

	@TargetMethod(author="", data="2017/02/09", version=9, uri="333")
	public void testInterface1(String string){
		System.out.println(string);
	}
	//作用域注解
	@Test
	public void test(){
		AnnotationUtils.parseFields(Person.class);
	}
	
	// 得到类注解
	@Test
	public void test1(){
		AnnotationUtils.parseClass(Main.class);
		AnnotationUtils.parseClass(Person.class);
	}

	// 得到方法注解
	@Test
	public void test2(){
		AnnotationUtils.parseMethod(Main.class);
	}


	// 得到构造方法注解
	@Test
	public void test3(){
		//AnnotationUtils.parseConstructor(Main.class);
		AnnotationUtils.parseConstructor(new Person("d"));
	}
	
	//权限拦截
	@Test
	public void test4(){
		AnnotationUtils.intercept(Person.class);
		AnnotationUtils.intercept(Person2.class);
	}


	@Test
	public void test5(){
		get("1", 1);
	}
	
	public void get(Object...objects) {
		System.out.println(objects[0] instanceof String);
		System.out.println(objects[0].toString());
		
	}
}
