package test_java.test.socket.bio;

import java.io.IOException;
import java.util.Random;

/**
 * 测试方法
 * 
 * @author yangtao__anxpp.com
 * @version 1.0 测试代码，为了方便在控制台看输出结果，放到同一个程序（jvm）中运行： 测试运行结果是一样的。
 *          我们知道，如果使用CachedThreadPool线程池（不限制线程数量，如果不清楚请参考文首提供的文章），其实除了能自动帮我们管理线程
 *          （复用），看起来也就像是1:1的客户端：线程数模型，而使用FixedThreadPool我们就有效的控制了线程的最大数量，
 *          保证了系统有限的资源的控制，实现了N:M的伪异步I/O模型。
 *          但是，正因为限制了线程数量，如果发生大量并发请求，超过最大数量的线程就只能等待，直到线程池中的有空闲的线程可以被复用。
 *          而对Socket的输入流就行读取时，会一直阻塞，直到发生： 有数据可读 可用数据以及读取完毕 发生空指针或I/O异常
 *          所以在读取数据较慢时（比如数据量大、网络传输慢等），大量并发的情况下，其他接入的消息，只能一直等待，这就是最大的弊端。
 *          而后面即将介绍的NIO，就能解决这个难题。
 */
public class Test {
	// 测试主方法
	public static void main(String[] args) throws InterruptedException {
		// 运行服务器
		new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					ServerBetter.start();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}).start();
		// 避免客户端先于服务器启动前执行代码
		Thread.sleep(100);
		// 运行客户端
		char operators[] = { '+', '-', '*', '/' };
		Random random = new Random(System.currentTimeMillis());
		new Thread(new Runnable() {
			@SuppressWarnings("static-access")
			@Override
			public void run() {
				while (true) {
					// 随机产生算术表达式
					String expression = random.nextInt(10) + "" + operators[random.nextInt(4)]
							+ (random.nextInt(10) + 1);
					Client.send(expression);
					try {
						Thread.currentThread().sleep(random.nextInt(1000));
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}).start();
	}
}
