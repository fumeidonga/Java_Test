package test_java.test.lambda;


//定义一个函数式接口
@FunctionalInterface
public interface IWorkerInterface2 <T> {
	boolean doSomeWork(T i);
}
