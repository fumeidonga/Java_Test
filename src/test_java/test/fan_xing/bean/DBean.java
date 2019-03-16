package test_java.test.fan_xing.bean;

import test_java.test.fan_xing.FanXingInterface;

public class DBean<T> implements FanXingInterface<T> {

	public T t;
	
	public DBean(T t){
		this.t = t;
	}
	
	@Override
	public void test() {
		
	}

}
