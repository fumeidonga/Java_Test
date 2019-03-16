package test_java.test.fan_xing;

public class FanXingClass<T, V> {
	//泛型
    private T t;
    private V v;
    
    public FanXingClass(){
		System.out.println("FanXingClass()");
    	
    }
    //构造方法
    public FanXingClass(T t, V v){
        this.t = t;
        this.v = v;
		System.out.println("FanXingClass(t, v)");
    }

}
