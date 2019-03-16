package test_java.test.extend;

public class B_A extends A {

	{
		System.out.println("B{}");
	}


	static {
		System.out.println("static B{}");
	}
	
	public B_A(){
		System.out.println("B");
	}
	
	@Override
    public void test(String a){
		System.out.println("B 1" + a);
    	super.test(a);
		System.out.println("B 2" + a);
    }
    
}
