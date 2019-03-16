package test_java.test.socket.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

import com.alibaba.fastjson.JSON;

import test_java.test.socket.bean.CBaseDataBean;
import test_java.test.socket.bean.CMsgTypeBean;
import test_java.test.socket.utils.PacketWrapper;

/**
 * NIO服务端 创建NIO服务端的主要步骤如下： @1 打开ServerSocketChannel，监听客户端连接 @2
 * 绑定监听端口，设置连接为非阻塞模式 @3 创建Reactor线程，创建多路复用器并启动线程 @1
 * 将ServerSocketChannel注册到Reactor线程中的Selector上，监听ACCEPT事件 @1
 * Selector轮询准备就绪的key @1 Selector监听到新的客户端接入，处理新的接入请求，完成TCP三次握手，简历物理链路 @1
 * 设置客户端链路为非阻塞模式 @1 将新接入的客户端连接注册到Reactor线程的Selector上，监听读操作，读取客户端发送的网络消息 @1
 * 异步读取客户端消息到缓冲区 @1 对Buffer编解码，处理半包消息，将解码成功的消息封装成Task @1
 * 将应答消息编码为Buffer，调用SocketChannel的write将消息异步发送给客户端
 * 
 * @author yangtao__anxpp.com
 * @version 1.0
 */
public class ServerHandle implements Runnable {
	private Selector selector;
	private ServerSocketChannel serverChannel;
	private volatile boolean started;

	// INT头信息的缓存池大小
	public int IntLength = 1024;

	/**
	 * 构造方法
	 * 
	 * @param port
	 *            指定要监听的端口号
	 */
	public ServerHandle(int port) {
		try {
			// 创建选择器
			selector = Selector.open();
			// 打开监听通道
			serverChannel = ServerSocketChannel.open();
			// 如果为 true，则此通道将被置于阻塞模式；如果为 false，则此通道将被置于非阻塞模式
			serverChannel.configureBlocking(false);// 开启非阻塞模式
			// 绑定端口 backlog设为1024
			serverChannel.socket().bind(new InetSocketAddress(port), 1024);
			// 监听客户端连接请求,为了将Channel和Selector配合使用，必须将channel注册到selector上
			// 与Selector一起使用时，Channel必须处于非阻塞模式下。
			// 这意味着不能将FileChannel与Selector一起使用，因为FileChannel不能切换到非阻塞模式。而套接字通道都可以。
			// Connect
			// Accept
			// Read
			// Write
			serverChannel.register(selector, SelectionKey.OP_ACCEPT);
			// 标记服务器已开启
			started = true;
			System.out.println("服务器已启动，端口号：" + port);
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(1);
		}
	}

	public void stop() {
		started = false;
	}

	@Override
	public void run() {
		// 循环遍历selector
		while (started) {
			try {
				// 无论是否有读写事件发生，selector每隔1s被唤醒一次
				selector.select(1000);
				System.out.println("--循环遍历selector--");
				// 阻塞,只有当至少一个注册的事件发生的时候才会继续.
				// selector.select();
				Set<SelectionKey> keys = selector.selectedKeys();
				Iterator<SelectionKey> it = keys.iterator();
				SelectionKey key = null;
				while (it.hasNext()) {
					key = it.next();
					it.remove();
					try {
						handleInput(key);
					} catch (Exception e) {
						System.out.println("--循环遍历selector e--" + e);
						e.printStackTrace();
						if (key != null) {
							key.cancel();
							if (key.channel() != null) {
								key.channel().close();
							}
						}
					}
				}
			} catch (Throwable t) {
				t.printStackTrace();
			}
		}
		// selector关闭后会自动释放里面管理的资源
		if (selector != null)
			try {
				selector.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
	}

	/*
	 * 消息处理
	 * 
	 * @param key
	 * 
	 * @throws IOException
	 */
	private void handleInput(SelectionKey key) throws Exception {
		if (key.isValid()) {
			// 处理新接入的请求消息
			if (key.isValid() && key.isAcceptable()) {
				ServerSocketChannel ssc = (ServerSocketChannel) key.channel();
				// 通过ServerSocketChannel的accept创建SocketChannel实例
				// 完成该操作意味着完成TCP三次握手，TCP物理链路正式建立
				SocketChannel sc = ssc.accept();
				// 设置为非阻塞的
				sc.configureBlocking(false);
				// 注册为读
				sc.register(selector, SelectionKey.OP_READ);
			}
			// 读消息
			if (key.isValid() && key.isReadable()) {
				System.out.println(" read message begin ");

				SocketChannel sc = (SocketChannel) key.channel();

				// 读取INT头信息的缓存池
				ByteBuffer bbInt = ByteBuffer.allocate(IntLength);

				// 创建ByteBuffer，并开辟一个1M的缓冲区
				ByteBuffer buffer = ByteBuffer.allocate(1024);

				//-------------------------------------粘包  半包------------------------------------------
	            //非阻塞通信（ServerSocketChannels，SocketChannels）中无法用ObjectInputStream,ObjectOutputStream？
				/*ObjectInputStream ois = new ObjectInputStream(sc.socket().getInputStream());

				CBaseDataBean s = (CBaseDataBean) ois.readObject();
	            System.out.println("String is: '" + s + "'");*/
				// 有效数据长度
				/*int ObjLength;
				// 从NIO信道中读出的数据长度
				int readObj;
				ByteArrayInputStream bIn;
				ObjectInputStream in;
				// 接收到的数据
				CBaseDataBean cbdb;
				// 读取请求码流，返回读取到的字节数
				int readbbBytes = sc.read(bbInt);
				System.out.println(" readbbBytes " + readbbBytes);
				
				// 读出INT数据头
				while (sc.read(bbInt) == IntLength) {
					// 获取INT头中标示的有效数据长度信息并清空INT缓存池
					ObjLength = bbInt.getInt(0);
					bbInt.clear();
					// 清空有效数据缓存池设置有效缓存池的大小
					buffer.clear();
					buffer.limit(ObjLength);
					// 循环读满缓存池以保证数据完整性
					readObj = sc.read(buffer);
					while (readObj != ObjLength) {
						readObj += sc.read(buffer);
					}
					bIn = new ByteArrayInputStream(buffer.array());
					in = new ObjectInputStream(bIn);
					cbdb = (CBaseDataBean) in.readObject();
					System.out.println(cbdb);
					
					 * 根据不同的数据类型调用不同的方法
					 
					switch (cbdb.getDataType()) {
					case CMsgTypeBean.MSG_TYPE_COMMAND:

						break;
					}
					in.close();
				}*/
				//-------------------------------------------------------------------------------

				// 读取请求码流，返回读取到的字节数
				int readBytes = sc.read(buffer);

				System.out.println(" readBytes " + readBytes);
				// 读取到字节，对字节进行编解码
				if (readBytes > 0) {
					// 将缓冲区当前的limit设置为position=0，用于后续对缓冲区的读取操作
					buffer.flip();
					// 根据缓冲区可读字节数创建字节数组
					byte[] bytes = new byte[buffer.remaining()];
					// 将缓冲区可读字节数组复制到新建的数组中
					buffer.get(bytes);
					String expression = new String(bytes, "UTF-8");
					//expression = expression.replace("\r\n", "");
					System.out.println("服务器收到消息: " + expression);
					
					// 处理数据
					String result = "result";
					/*if(expression.contains("dataType")){
						CBaseDataBean cbdb = JSON.parseObject(expression, CBaseDataBean.class);
						System.out.println(cbdb);
						switch (cbdb.getDataType()) {
						case CMsgTypeBean.MSG_TYPE_GET_GOODS_BASE_CAT:
							result = SocketMessageUtils.getGoodsBaseCat();

			            	CBaseDataBean cbbean = new CBaseDataBean();
			            	cbbean.setDataType(CMsgTypeBean.MSG_TYPE_GET_GOODS_BASE_CAT);
			            	cbbean.setJson(result);
			            	// 将消息编码为字节数组
			            	byte[] resultbytes = result.getBytes();
			            	cbbean.setDataLength(resultbytes.length);
			            	result = JSON.toJSONString(cbbean);
			                
							break;
						case CMsgTypeBean.MSG_TYPE_GET_GOODS_BASE_CAT_STORE:
							break;
						case CMsgTypeBean.MSG_TYPE_GET_GOODS_BASE_CAT_STORE_ADD:
							break;
						case CMsgTypeBean.MSG_TYPE_GET_GOODS:
							int storeid = cbdb.getStoreId();

							result = SocketMessageUtils.getAllGoods(storeid);
			            	CBaseDataBean cbbean1 = new CBaseDataBean();
			            	cbbean1.setDataType(CMsgTypeBean.MSG_TYPE_GET_GOODS);
			            	cbbean1.setJson(result);
			            	result = JSON.toJSONString(cbbean1);
							break;
						default:
							result = expression;
							break;
						}
					}*/
					// try {
					// result = Calculator.cal(expression).toString();
					// } catch (Exception e) {
					// result = "计算错误：" + e.getMessage();
					// }
					// 发送应答消息
					doWrite(sc, result);
				}
				// 没有读取到字节 忽略
				// else if(readBytes==0);
				// 链路已经关闭，释放资源
				else if (readBytes < 0) {
					System.out.println(" read message 0 ");
					key.cancel();
					sc.close();
				}
			}
		}
	}

	// 异步发送应答消息
	private void doWrite(SocketChannel channel, String response) {
		try {
			System.out.println(" doWrite message begin  " + response);
			
			// 将消息编码为字节数组
			//byte[] bytes = response.getBytes();
			// 添加长度首部的工具类
			byte[] bytes = new PacketWrapper(response).getBytes();
			
			// 根据数组容量创建ByteBuffer
			ByteBuffer writeBuffer = ByteBuffer.allocate(bytes.length);
			// 将字节数组复制到缓冲区
			writeBuffer.put(bytes);
			// flip操作
			writeBuffer.flip();
			// 发送缓冲区的字节数组
			channel.write(writeBuffer);

			// 直接socket 链接要调用关闭？
			// channel.close();
			// ****此处不含处理“写半包”的代码
			System.out.println(" doWrite message end ");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
