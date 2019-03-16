package test_java.test.thread;

public class SyncTest {

	public Object obj =  new Object();
	
	public void method1(){
		synchronized (SyncTest.class){
			System.out.println("method1");
			method2();
		}
	}
	
	public void method2(){
	
		synchronized(SyncTest.class){
			System.out.println("method2");
		}
	}
	
	//重入锁
	@org.junit.Test
	public void test(){
		
		new SyncTest().method1();
	}
}
