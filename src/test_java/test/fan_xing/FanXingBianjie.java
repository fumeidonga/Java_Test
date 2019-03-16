package test_java.test.fan_xing;

import test_java.test.fan_xing.bean.CBean;

public class FanXingBianjie<T extends FanXingInterface<V>, V>  {
	
	public FanXingBianjie(){
		System.out.println("FanXingBianjie");
	}
	
	public FanXingBianjie(T t, V v){
		System.out.println("FanXingBianjie(t, v)");
	}

}
