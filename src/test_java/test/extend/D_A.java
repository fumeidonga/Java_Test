package test_java.test.extend;

public class D_A extends A {

	{
		System.out.println("D_A{}");
	}


	static {
		System.out.println("static D_A{}");
	}
	
	public D_A(){
		System.out.println("D_A");
	}
	
	@Override
    public void test(String a){
    	super.test(a);
		System.out.println("D_A " + a);
    }
    
}
