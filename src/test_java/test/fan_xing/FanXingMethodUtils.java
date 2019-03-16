package test_java.test.fan_xing;

import test_java.test.extend.test;
import test_java.test.fan_xing.bean.DBean;
import test_java.test.fan_xing.bean1.Box;
import test_java.test.fan_xing.bean1.BoxFanx;

public class FanXingMethodUtils {
		
	//定义泛型方法，只需将泛型参数列表置于返回值之前
	public static <T, V> T getT(T t, V v){
		return null;
	}
	
	public static <T> void sysOut(T t){
		System.out.println(t.getClass().getName());
	}
	
	public <T, V> void getTv(T t, V v){
		
	}

	public static <T> T sysOut1(T t){
		System.out.println(t.getClass().getName());
		return t;
	}
	
	public <K extends Box,V extends BoxFanx<T>, T> void test(K k, V v){
		
	}
	
	public <K extends Box> void test11(K k){
		
	}
	
//	通配符
	public <K> void test23(DBean<? extends Number> dbean){
		
	}
	

}
