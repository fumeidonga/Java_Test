package test_java.test.fan_xing.bean1;

public class Box {
	
	private Object object;
	/**
	 * 按照声明，其中的set()方法可以接受任何java对象作为参数
	 * （任何对象都是Object的子类），假如在某个地方使用该类，
	 * set()方法预期的输入对象为Integer类型，但是实际输入的
	 * 却是String类型，就会抛出一个运行时错误，这个错误在编译阶段是无法检测的
	 * 例如：
	 * Box box = new Box; 
	 * box.set("abc"); 
	 * Integer a =(Integer)box.get();  //编译时不会报错，但是运行时会报ClassCastException
	 */
	public void setObject(Object object){
		this.object = object;
	}

	public Object getObject(){
		return object;
	}
}
