package test_java.test.extend;

public abstract class A {
	
	{
		System.out.println("A{}");
	}

	static {
		System.out.println("static A{}");
	}
	
	public A(){
		System.out.println("A");
	}
	
	
	public void test(String s){

		System.out.println("A test(s)" + s);
	}

}
