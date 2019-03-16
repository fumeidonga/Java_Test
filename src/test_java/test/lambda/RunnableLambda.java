package test_java.test.lambda;

import org.junit.Test;

public class RunnableLambda {
	
	
	@Test
	public void test(){
		
		// Anonymous Runnable
		Runnable runnable1 = new Runnable() {
			
			@Override
			public void run() {
				System.out.println("runnable1");
			}
		};
		
		// Lambda Runnable
		Runnable runnable2 = () -> System.out.println("runnable2");
		
		runnable1.run();
		runnable2.run();
	}

}
