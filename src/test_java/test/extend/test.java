package test_java.test.extend;

import org.junit.Test;

public class test {
	
	//存在两个类，B 继承 A，C 继承 B，我们能将 B 转换为 C 么？如 C = (C) B；下转
	@Test
	public void testa(){
		B_A b = new B_A();
//		b.test("b");
		
//		B b1 = new B();
		C_B c = (C_B) b;
		c.test("c");
//		System.out.println(c);
//		b.test("123");
//		b1.test("456");
//		System.out.println(3*0.1 == 0.3);
	}

}
