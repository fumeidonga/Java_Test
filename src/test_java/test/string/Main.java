package test_java.test.string;

import org.junit.Test;

/**
 * test {@String} {@StringBuilder} {@StringBuffer} 如果操作少量数据，用string，
 * 如果单线程操作大量数据用stringbuilder，多线程操作大量数据用stringbuffer。 应该要避免使用 string +
 * 的方式来拼接字符串，因为这样会额外的在创建string stringbuffer等对象。
 * 从安全上来说，stringbuffer是线程安全的，它的大部分方法都是用了线程锁synchronized来描述。(信扩奶子的- _-!),
 * 
 * stringbuffer & stringbuilder实现上都差不错，可以看源码
 * 
 * stringbuilder一般用在方法内部，应为是线程不安全的，用完后就可以gc掉了 stringbuffer
 * 一般用在全局变量上，因为不知道这个变量会不会再线程里面
 * 
 * @author david
 * 
 *
 */
public class Main {

	@Test
	public void testString() {
		long begin = System.currentTimeMillis();

		String string = "";
		for (int i = 0; i < 100000; i++) {
			string += i;
		}

		long end = System.currentTimeMillis();
		long time = end - begin;
		sysout(time);

	}

	@Test
	public void testStringBuffer() {
		long begin = System.currentTimeMillis();

		StringBuffer sBuffer = new StringBuffer();
		for (int i = 0; i < 100000; i++) {
			sBuffer.append("i");
		}

		long end = System.currentTimeMillis();
		long time = end - begin;
		sysout(time);

	}

	@Test
	public void testStringBuilder() {

		long begin = System.currentTimeMillis();

		StringBuilder sBuilder = new StringBuilder();
		for (int i = 0; i < 100000; i++) {
			sBuilder.append("i");
		}

		long end = System.currentTimeMillis();
		long time = end - begin;

		sysout(time);

	}

	public void sysout(Object string) {

		System.out.println(string);
	}
}
