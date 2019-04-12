package test_java.test.lambda;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

import org.junit.Test;

public class TestMain {

	public static void main(String[] args) {

		testFunctionInterface();
		
		testFor();
		
		testInnerClass();
		
	}
	
	//测试lambda函数式接口 begin
	public static void testFunctionInterface(){
		execute(new IWorkerInterface() {
			
			@Override
			public void doSomeWork() {
				System.out.println("1");
				
			}
		});
		
		execute(() -> {System.out.println("2");});
		
	}
	public static void execute(IWorkerInterface worker) {
	    worker.doSomeWork();
	}

	//测试lambda函数式接口 end
	
	// -------------------------for 循环 begin----------------------------------
	public static void testFor(){
		String[] atp = {"Rafael Nadal", "Novak Djokovic",
		       "Stanislas Wawrinka"};
		List<String> players =  Arrays.asList(atp);
		
		// 以前的循环方式
		for (String player : players) {
		     System.out.println(player + "; ");
		}
		
		System.out.println("-------------");
		players.forEach((player) -> {
		     System.out.println("forEach: " + player + "; ");
	     });
			
	}
	// -------------------------for 循环 end----------------------------------
	
	// ---------------------------lambda 表示匿名内部类begin --------------------------------
	public static void testInnerClass(){
		new Thread(() -> {System.out.println( " this is runnable ");}).start();
	}
	
	// ---------------------------lambda 表示匿名内部类 end --------------------------------
	
	// -----------------------------排序 begin------------------------------
	public static void testPaiXu() {

		String[] atp = {"Rafael Nadal", "Novak Djokovic",
		       "Stanislas Wawrinka"};
		
		Arrays.sort(atp, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				return o1.compareTo(o2);
			}
		});

		Arrays.sort(atp, (String s1, String s2) -> (s1.compareTo(s2)));
		//Arrays.sort(atp, (String s1, String s2) -> {s1.compareTo(s2)});
		
		
	
	}
	// ------------------------------排序 end-----------------------------
	
	// ------------------------定义一个函数式接口 来比较大小-----------------------------------
	public static void test(){
		//Consumer<String > consumer = () -> "ddd";
		
		//这个意思是i > 1返回true
		IWorkerInterface2<Integer> iwo = i -> i > 1;
		
		//等同于
		IWorkerInterface2<Integer> iwo1 = new IWorkerInterface2<Integer>() {
			
			@Override
			public boolean doSomeWork(Integer i) {
				// TODO Auto-generated method stub
				return i > 1;
			}
		};
		
	}
	// -----------------------------stream filter------------------------------
	@Test
	public void testStream() {

		String[] atp = {"Rafael Nadal", "Novak Djokovic",
		       "Stanislas Wawrinka"};

		List<String> players =  Arrays.asList(atp);
		players.stream()
			.filter(p -> p.equals("Rafael Nadal"))
			.limit(3)
			.forEach(p -> System.out.println(p));
		
		
		//Function<String, Boolean> function = String::equals
	
	}
	// ------------------------------stream end-----------------------------
	
	
	

}
