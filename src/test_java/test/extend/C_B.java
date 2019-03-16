package test_java.test.extend;

public class C_B extends B_A {

	public C_B(){

		System.out.println("C");
	}

	@Override
    public void test(String a){
		System.out.println("c 1" + a);
    	super.test(a);
		System.out.println("c 2" + a);
    }
}
