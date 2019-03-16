package test_java.test.lambda;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Stream;

import javax.swing.JButton;

public class MainTest {

	/**
	 * http://www.cnblogs.com/aoeiuv/p/5911692.html
	 * 
	 * 什么时候使用Lambda
	 * 
	 * 函数式接口： 所谓函数式接口，我们可以理解为就是只有一个方法的接口。
	 * 接口名	参数	      返回值	     用途
	 * Predicate	T	boolean	断言
	 * Consumer		T	void	消费
	 * Function		T	R	函数
	 * Function		T	R	函数
	 * Supplier		None	T	工程方法
	 * UnaryOperator	T	T	逻辑非
	 * BinaryOperator	(T,T)	T	二元操作
	 * 
	 * 函数描述符： 函数式接口的签名基本上就是Lambda表达式的签名。我们降这种抽象方法叫做函数描述符。举个例子，Ruannable
	 * 方法就可以看做一个什么都不接受， 什么都不返回的函数。这个时候我们可以发现传入的 Lambda 函数为 ()->void
	 */
	public static void main(String[] args) {

		Predicate<Integer> i = (n) -> false;
		Callable<Integer> c = true ? (() -> 23) : (() -> 42);

		Runnable result = () -> {
		};

		// 函数式接口： 所谓函数式接口，我们可以理解为就是只有一个方法的接口
		// 先定义一个接口MathOperation
		MathOperation addition = (int a, int b) -> add(a, b);
		System.out.println("10 + 5 = " + operate(10, 5, addition));
		// with out type declaration
		MathOperation subtraction = (a, b) -> a - b;
		System.out.println("10 - 5 = " + operate(10, 5, subtraction));
		// with return statement along with curly braces
		MathOperation multiplication = (int a, int b) -> {
			return a * b;
		};
		System.out.println("10 x 5 = " + operate(10, 5, multiplication));
		// without return statement and without curly braces
		MathOperation division = (int a, int b) -> a / b;
		System.out.println("10 / 5 = " + operate(10, 5, division));

		System.out.println();
		testList();
		testListener();
		testPredicate();
		testMethod();
		testBianliang();
		testStream();

	}

	interface MathOperation {
		int operation(int a, int b);
	}

	private static int operate(int a, int b, MathOperation mathOperation) {
		return mathOperation.operation(a, b);
	}
	private static int add(int i, int j){
		return i + j;
	}

	/*
	 * 
	 */
	public static void testList() {
		// Java 8之前：
		List<String> features = Arrays.asList("Lambdas", "Default Method", "Stream API", "Date and Time API");
		for (String feature : features) {
			System.out.println(feature);
		}

		// Java 8之后：
		features.forEach(n -> System.out.println(n));
		//方法引用写法
		// 使用Java 8的方法引用更方便，方法引用由::双冒号操作符标示，
		// 看起来像C++的作用域解析运算符
		features.forEach(System.out::println);
	}

	/*
	 * 事件
	 */
	public static void testListener() {
		// Java 8之前：
		JButton show = new JButton("Show");
		show.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("Event handling without lambda expression is boring");
			}
		});

		// Java 8方式：
		show.addActionListener((e) -> {
			System.out.println("Light, Camera, Action !! Lambda expressions Rocks");
		});
	}

	/*
	 * java.util.function.Predicate 允许将两个或更多的 Predicate
	 * 合成一个。它提供类似于逻辑操作符AND和OR的方法，名字叫做and()、or()和xor()， 用于将传入 filter()
	 * 方法的条件合并起来。例如，要得到所有以J开始，长度为四个字母的语言
	 */
	public static void testPredicate() {
		List<String> languages = Arrays.asList("Java", "Scala", "C++", "Haskell", "Lisp");
		Predicate<String> sPredicate = (n) -> n.startsWith("j");
		Predicate<String> sPredicate1 = (n) -> n.endsWith("j");
		Predicate<String> fourLetterLong = (n) -> n.length() == 4;
		Predicate istrue = (n) -> true;
		Predicate<Boolean> isfalse = (s) -> true;
		System.out.println("Print no language : ");
		filter(languages, (str) -> false);

		System.out.println("Print language whose length greater than 4:");
		filter(languages, (str) -> ((String) str).length() > 4);

		languages.stream().filter(sPredicate.and(fourLetterLong))
				.forEach((n) -> System.out.print("nName, which starts with 'J' and four letter long is : " + n));

		// 抽象方法
		//
		// boolean test(T t);
		// 该方法对传入的参数进行验证，满足条件返回true，否则返回false。
		// 使用Lambda表达式实现Predicate接口

		// Predicate<String> predicate = e -> "mattie".equals(e);
		// predicate.test("mattie"); //true
		// predicate.test("hello"); //false

		// Predicate<Integer> p = e -> e > 5;
		// //取反
		// instance.conditionFilter(list, p.negate()); // 5 6 7 8 9 10

		// //and
		// instance.conditionFilter(list, p.and(e -> e < 9));//6 7 8

		// //or
		// instance.conditionFilter(list, p.or(e -> e < 4));//1 2 3 6 7 8 9 10

	}

	public static void filter(List<String> names, Predicate condition) {
		for (String name : names) {
			if (condition.test(name)) {
				System.out.println(name + " ");
			}
		}
	}

	/*
	 * map 本例介绍最广为人知的函数式编程概念map。它允许你将对象进行转换。例如在本例中，我们将 costBeforeTax
	 * 列表的每个元素转换成为税后的值。 我们将 x -> x*x lambda表达式传到 map() 方法， 后者将其应用到流中的每一个元素。然后用
	 * forEach() 将列表元素打印出来。 还有一个 reduce()
	 * 函数可以将所有值合并成一个。Map和Reduce操作是函数式编程的核心操作，因为其功能，reduce 又被称为折叠操作。另外， reduce
	 * 并不是一个新的操作，你有可能已经在使用它。 SQL中类似 sum()、avg() 或者 count() 的聚集函数，实际上就是 reduce
	 * 操作，因为它们接收多个值并返回一个值。
	 */
	public static void testMap() {
		// 不使用lambda表达式为每个订单加上12%的税
		double total = 0;
		List<Integer> costBeforeTax = Arrays.asList(100, 200, 300, 400, 500);
		for (Integer cost : costBeforeTax) {
			double price = cost + .12 * cost;
			System.out.println(price);
			total = total + price;
		}
		System.out.println("Total : " + total);

		// 使用lambda表达式
		costBeforeTax.stream().map((cost) -> cost + .12 * cost).forEach(System.out::println);

		// reduce() 函数可以将所有值合并成一个
		// 新方法：total
		double bill = costBeforeTax.stream().map((cost) -> cost + .12 * cost).reduce((sum, cost) -> sum + cost).get();
		System.out.println("Total : " + bill);
	}

	/*
	 * 如果将lambda表达式的参数作为参数传递给一个方法，他们的执行效果是相同的， 则该lambda表达式可以使用Method
	 * Reference表达，以下两种方式是等价的：
	 */
	public static void testMethod() {
		// Method Reference主要有三种形式：
		// object::instanceMethod
		// Class::staticMethod
		// Class::instanceMethod

		// (x) -> System.out.println(x);
		// System.out::println;
		//
		// Math::pow
		// (x, y) -> Math.pow(x, y)
		//
		// String::compareToIgnoreCase
		// (s1, s2) -> s1.compareToIgnoreCase(s2)

		// expression lambda
		// Comparator<String> comp1 = (first, second) ->
		// Integer.compare(first.length(), second.length());

		// statement lambda
		// Comparator<String> comp2 = (first, second) -> { return
		// Integer.compare(first.length(), second.length());};

		// List<String> languages = Arrays.asList("Java", "Scala", "C++",
		// "Haskell", "Lisp");
		// Arrays.sort(languages, (first, second) ->
		// Integer.compare(first.length(), second.length()));

		// Constructor Reference与Method
		// Reference类似，只不过是特殊的method：new，具体调用的是哪个构造函数，由上下文环境决定，比如：

		// List<String> labels = ...;
		// Stream<Button> stream = labels.stream().map(Button::new);
		// Button::new等价于(x) -> Button(x)，所以调用的构造函数是：Button(x);

		// 除了创建单个对象，也可以创建对象数组，如下面两种方式等价：

		// int[]::new
		// (x) -> new int[x]

		// Arrays.sort(cities, (first, second) ->
		// Integer.compare(first.length(), second.length()));
		// Arrays.sort(cities, Comparator.comparingInt(String::length));

		// jobList.sort((JobInfo job1,JobInfo
		// job2)->job1.getUpdateTime.compareTo(job2.getUpdateTime);
		// jobList.sort(comparing(JobInfo::getUpdateTime));

	}
	
	public static void testBianliang(){
//		先举例：

//		//将为列表中的字符串添加前缀字符串
//		String waibu = "lambda :";
//		List<String> proStrs = Arrays.asList(new String[]{"Ni","Hao","Lambda"});
//		List<String>execStrs = proStrs.stream().map(chuandi -> {
//		Long zidingyi = System.currentTimeMillis();
//		return waibu + chuandi + " -----:" + zidingyi;
//		}).collect(Collectors.toList());
//		execStrs.forEach(System.out::println);

//		输出:

//		lambda :Ni -----:1474622341604
//		lambda :Hao -----:1474622341604
//		lambda :Lambda -----:1474622341604

		 

//		变量waibu ：外部变量

//		变量chuandi ：传递变量

//		变量zidingyi ：内部自定义变量
	}
	
	
	public static void testStream(){
//		两句话理解Stream：

//		1.Stream是元素的集合，这点让Stream看起来用些类似Iterator；
//		2.可以支持顺序和并行的对原Stream进行汇聚的操作；

//		大家可以把Stream当成一个装饰后的Iterator
		
		//获取stream
		Stream<Integer> integerStream = Stream.of(1, 2, 3, 5);
		Stream<String> stringStream = Stream.of("taobao");
		
		Stream.generate(new Supplier<Double>() {
		    @Override
		    public Double get() {
		         return Math.random();
		    }
		});
		Stream.generate(() -> Math.random());
		Stream.generate(Math::random);
		
		Stream.iterate(1, item -> item + 1).limit(10).forEach(System.out::println);
		
		//Collection接口有一个stream方法，所以其所有子类都都可以获取对应的Stream对象。
		/*public interface Collection<E> extends Iterable<E> {
		      //其他方法省略
		     default Stream<E> stream() {
		          return StreamSupport.stream(spliterator(), false);
		     }
		}*/
		
		//转换stream 
		//转换Stream其实就是把一个Stream通过某些行为转换成一个新的Stream
		//1. distinct: 对于Stream中包含的元素进行去重操作（去重逻辑依赖元素的equals方法），新生成的Stream中没有重复的元素
		//2. filter: 对于Stream中包含的元素使用给定的过滤函数进行过滤操作，新生成的Stream只包含符合条件的元素
		//3. map: 对于Stream中包含的元素使用给定的转换函数进行转换操作，新生成的Stream只包含转换生成的元素
		//4. flatMap：和map类似，不同的是其每个元素转换得到的是Stream对象，会把子Stream中的元素压缩到父集合中；
		//5. peek: 生成一个包含原Stream的所有元素的新Stream，同时会提供一个消费函数（Consumer实例），新Stream每个元素被消费的时候都会执行给定的消费函数；
		//6. limit: 对一个Stream进行截断操作，获取其前N个元素，如果原Stream中包含的元素个数小于N，那就获取其所有的元素；
		//7. skip: 返回一个丢弃原Stream的前N个元素后剩下元素组成的新Stream，如果原Stream中包含的元素个数小于N，那么返回空Stream；
		
		
		
		
		
		
		
		
	}

}
