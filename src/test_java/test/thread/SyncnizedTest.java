package test_java.test.thread;

import org.junit.Test;

/**
 * 生产者消费者
 * 
 * @author david
 *
 */
public class SyncnizedTest {

	public int mAllNum = 10;

	// 生产
	public synchronized void producer(String name) throws Exception {
		if (mAllNum >= 10) {
			this.wait();
			System.out.println(Thread.currentThread().getName() + "：存放等待---仓库库存足够");
			return;
		}
		mAllNum++;
		System.out.println(Thread.currentThread().getName() + "存放了一台" + name + "电脑,目前库存电脑总数为:" + mAllNum);
		notifyAll();
	}

	// 消费
	public synchronized void consumer(String name) throws Exception {
		if (mAllNum > 0) {
			mAllNum--;
			System.out.println(Thread.currentThread().getName() + "取出了一台" + name + "电脑,目前电脑总数为:" + mAllNum);
			notifyAll();
		} else {
			this.wait();
			System.out.println(Thread.currentThread().getName() + ": 取电脑受阻-因为库存余数为0");
			return;
		}
	}

	public static void main(String[] args) {
		SyncnizedTest computer = new SyncnizedTest();
		// 构造生产者
		Producer producer = new Producer(computer);

		// 构造消费者
		Consumer consumer = new Consumer(computer);

		// 创建生产者两个线程
		Thread t1 = new Thread(producer);
		t1.setName("生产者A");
		Thread t2 = new Thread(producer);
		t2.setName("生产者B");

		// 创建消费者两个线程
		Thread t3 = new Thread(consumer);
		t3.setName("消费者A");
		Thread t4 = new Thread(consumer);
		t4.setName("消费者B");
		Thread t5 = new Thread(consumer);
		t5.setName("消费者c");

		// 启动线程
		t1.start();
		//t2.start();
		t3.start();
		t4.start();
		t5.start();

	}

	public static class Producer implements Runnable {

		SyncnizedTest test;

		public Producer(SyncnizedTest t) {
			// TODO Auto-generated constructor stub
			test = t;
		}

		@Override
		public void run() {
			// TODO Auto-generated method stub
			while (true) {
				try {
					System.out.println("aaa");
					test.producer("ddd");
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					System.out.println(e);
				}
			}

		}

	}

	public static class Consumer implements Runnable {

		SyncnizedTest test;

		public Consumer(SyncnizedTest t) {
			// TODO Auto-generated constructor stub
			test = t;
		}

		@Override
		public void run() {
			// TODO Auto-generated method stub
			while (true) {
				try {
					System.out.println("bbb");
					test.consumer("ddd");
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					System.out.println(e);
				}
			}

		}

	}

}
