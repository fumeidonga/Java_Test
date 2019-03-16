package test_java.test.fan_xing;

import org.junit.Test;

import test_java.test.fan_xing.bean.ABean;
import test_java.test.fan_xing.bean.ABean.Builder;
import test_java.test.fan_xing.bean1.Box;
import test_java.test.fan_xing.bean1.BoxFanx;
import test_java.test.fan_xing.bean.BBean;
import test_java.test.fan_xing.bean.CBean;
import test_java.test.fan_xing.bean.DBean;
import test_java.test.fan_xing.bean.EBean;
import test_java.test.fan_xing.build.Customer;
import test_java.test.fan_xing.build.Person;

public class Main {
	
	@Test
	public void test (){
		//A a = new A(new C(), new B());
		
		FanXingBianjie fanXingBianjie = new FanXingBianjie(new EBean(new CBean()), new CBean());
		fanXingBianjie.getClass();
	}
	
	
	
	public <T extends Comparable<T>> T te(T t){
		return t;
	}
	
	

	@Test
	public void testbuild (){

		Customer customer = new Customer.Builder("Tom", 13999999999L, "北京市XXX")
		        .age("20") //此处返回类型为 Person.Builder
		        .alias("用户昵称")  //错误，不存在该方法
		        .intro("用户自我介绍")
		        .build();
		System.out.println(customer);
		
		Customer customer1 = new Customer.Builder("Tom", 13999999999L, "北京市XXX")
		        .age("20") //此处返回类型为 Person.Builder
		        .alias("用户昵称")  //错误，不存在该方法
		        .intro("用户自我介绍")
		        .setV(null)
		        .build1();
		
		
		
	}
	
	
	@Test
	public void testbean1(){
		Box box = new Box();
		box.setObject("a");
		System.out.println(box.getObject());
		
		BoxFanx boxFanx = new BoxFanx();
		boxFanx.setT("a");
		System.out.println(boxFanx.getT());
		
		DBean<String> dBean = new DBean<String>("");
		DBean<Integer> dBean2 = new DBean<Integer>(1);
		
	}

}

