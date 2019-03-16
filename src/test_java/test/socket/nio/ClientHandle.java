package test_java.test.socket.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.Set;

import javax.swing.JTextArea;

import org.junit.Test;

import com.alibaba.fastjson.JSON;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import test_java.test.ProtocolBaseParameter;
import test_java.test.ProtocolHeader;
import test_java.test.ProtocolMsg;
import test_java.test.socket.utils.Bytes2util;
import test_java.test.socket.utils.Util2Bytes;

/**
 * NIO客户端
 * 
 * @author yangtao__anxpp.com
 * @version 1.0
 */
public class ClientHandle implements Runnable {
	private String host;
	private int port;
	private Selector selector;
	private SocketChannel socketChannel;
	private volatile boolean started;

	public ClientHandle(String ip, int port) {
		this.host = ip;
		this.port = port;
		try {
			// 创建选择器
			selector = Selector.open();
			// 打开监听通道
			socketChannel = SocketChannel.open();
			// 如果为 true，则此通道将被置于阻塞模式；如果为 false，则此通道将被置于非阻塞模式
			socketChannel.configureBlocking(false);// 开启非阻塞模式
			started = true;
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
		try {
			doConnect();
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(1);
		}
		// 循环遍历selector
		while (started) {
			try {
				// 无论是否有读写事件发生，selector每隔1s被唤醒一次
				selector.select(1000);
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
						if (key != null) {
							key.cancel();
							if (key.channel() != null) {
								key.channel().close();
							}
						}
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
				System.exit(1);
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

	static final int MESSAGE_LENGTH_HEAD = 4;
	byte[] head = new byte[4];
	int bodylen = -1;
	int count = 0;
	ByteBuffer readbuffer;

	private void handleInput(SelectionKey key) throws IOException {
		if (key.isValid()) {
			SocketChannel sc = (SocketChannel) key.channel();
			if (key.isConnectable()) {
				if (sc.finishConnect())
					;
				else
					System.exit(1);
			}
			// 读消息
			if (key.isReadable()) {
				
				System.out.println(" ----- read message ----- ");

				read(sc, key);


				/*// 创建ByteBuffer，并开辟一个1M的缓冲区
				ByteBuffer buffer = ByteBuffer.allocate(1024);
				// 读取请求码流，返回读取到的字节数
				int readBytes = sc.read(buffer);
				// 读取到字节，对字节进行编解码
				if (readBytes > 0) {
					// 将缓冲区当前的limit设置为position=0，用于后续对缓冲区的读取操作
					buffer.flip();
					// 根据缓冲区可读字节数创建字节数组
					byte[] bytes = new byte[buffer.remaining()];
					// 将缓冲区可读字节数组复制到新建的数组中
					buffer.get(bytes);
					String result = new String(bytes, "UTF-8");
					// System.out.println("客户端收到消息：" + result);
					System.out.println("客户端收到消息：" + "");

					if (result.contains("dataType")) {
						try {
							CBaseDataBean cbdb = JSON.parseObject(result, CBaseDataBean.class);
							System.out.println(cbdb);
							switch (cbdb.getDataType()) {
							case CMsgTypeBean.MSG_TYPE_GET_GOODS_BASE_CAT:
								CBaseDataBean cbbean = new CBaseDataBean();
								cbbean.setDataType(CMsgTypeBean.MSG_TYPE_GET_GOODS_BASE_CAT);
								cbbean.setJson(result);
								result = JSON.toJSONString(cbbean);

								break;
							default:
								break;
							}
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					if (textArea != null)
						textArea.append("Server : " + result + "\n");
				}
				// 没有读取到字节 忽略
				// else if(readBytes==0);
				// 链路已经关闭，释放资源
				else if (readBytes < 0) {
					key.cancel();
					sc.close();
				}*/
			}
		}
	}

	// 异步发送消息
	private void doWrite(SocketChannel channel, String request) throws IOException {
		// 将消息编码为字节数组
		byte[] bytes = request.getBytes();
		// 根据数组容量创建ByteBuffer
		ByteBuffer writeBuffer = ByteBuffer.allocate(bytes.length);
		// 将字节数组复制到缓冲区
		writeBuffer.put(bytes);
		// flip操作
		writeBuffer.flip();
		// 发送缓冲区的字节数组
		channel.write(writeBuffer);
		if (textArea != null)
			textArea.append("Client : " + request + "\n");
		// ****此处不含处理“写半包”的代码
	}

	private void doConnect() throws IOException {
		if (socketChannel.connect(new InetSocketAddress(host, port)))
			;
		else
			socketChannel.register(selector, SelectionKey.OP_CONNECT);
	}

	public void sendMsg(String msg) throws Exception {
		socketChannel.register(selector, SelectionKey.OP_READ);
		doWrite(socketChannel, msg);
	}

	JTextArea textArea;

	public void sendMsg(JTextArea textArea, String msg1) throws Exception {
		if (this.textArea == null)
			this.textArea = textArea;
		socketChannel.register(selector, SelectionKey.OP_READ);// 这里要注册
		
		
		ProtocolBaseParameter parameter = new ProtocolBaseParameter();
		String par = JSON.toJSONString(parameter);
		// 发送消息给服务器
		ProtocolMsg msg = new ProtocolMsg();
		ProtocolHeader protocolHeader = new ProtocolHeader();
		//protocolHeader.setMagic(magic);
		protocolHeader.setMsgType((byte) 0x04);
		protocolHeader.setReserve((short) 0);
		protocolHeader.setSn((short) 0);

		byte[] bodyBytes = par.getBytes(Charset.forName("utf-8"));
		int bodySize = bodyBytes.length;
		protocolHeader.setLen(bodySize);

		msg.setProtocolHeader(protocolHeader);
		msg.setBody(par);
		
		System.out.println("sendMsg " + msg);// 序列化
		
		String jsonStr = JSON.toJSONString(msg);
		System.out.println("sendMsg " + jsonStr);
		
		
		
		doWrite(socketChannel, msg);
	}
	
	// 异步发送消息
	private void doWrite(SocketChannel channel, ProtocolMsg msg) throws IOException {

		ProtocolHeader header = msg.getProtocolHeader();
		String body = msg.getBody();
		byte[] bodyBytes = body.getBytes(Charset.forName("utf-8"));
		int bodySize = bodyBytes.length;
		
		ByteBuffer out = ByteBuffer.allocate(bodySize+10);
		// 1.写入消息的开头的信息标志(byte类型) 
		out.put(header.getMagic());
		// 2.写入消息的类型
		out.put(header.getMsgType());
		// 3.写入消息的
		out.putShort(header.getReserve());
		// 4.写入消息的
		out.putShort(header.getSn());
		// 5.写入消息的长度(int 类型)
		out.putInt(bodySize);
		// 6.写入消息的内容
		out.put(bodyBytes);
		//out.put(bodyBytes, 10, bodySize+10);
		// flip操作
		out.flip();
		
		System.out.println(out.toString());

		channel.write(out);
		if (textArea != null)
			textArea.append("Client : " + msg + "\n");
		// ****此处不含处理“写半包”的代码
	}

	protected void encode(ChannelHandlerContext ctx, ProtocolMsg msg,
			ByteBuf out) throws Exception {
		if (msg == null | msg.getProtocolHeader() == null) {
			throw new Exception("The encode message is null");
		}
		ProtocolHeader header = msg.getProtocolHeader();
		String body = msg.getBody();
		byte[] bodyBytes = body.getBytes(Charset.forName("utf-8"));
		int bodySize = bodyBytes.length;
		
		// 1.写入消息的开头的信息标志(byte类型) 
		out.writeByte(header.getMagic());
		// 2.写入消息的类型
		out.writeByte(header.getMsgType());
		// 3.写入消息的
		out.writeShort(header.getReserve());
		// 4.写入消息的
		out.writeShort(header.getSn());
		// 5.写入消息的长度(int 类型)
		out.writeInt(bodySize);
		// 6.写入消息的内容
		out.writeBytes(bodyBytes);
	}

	public void close() throws Exception {
		socketChannel.close();
	}

	StringBuilder sBuilder = new StringBuilder();
	public synchronized void read(SocketChannel socket, SelectionKey sk) throws IOException {
		ByteBuffer input = ByteBuffer.allocate(1024);
		socket.read(input);
		// 将缓冲区当前的limit设置为position=0，用于后续对缓冲区的读取操作
		input.flip();
//		// 根据缓冲区可读字节数创建字节数组
//		byte[] bytes = new byte[input.remaining()];
//		// 将缓冲区可读字节数组复制到新建的数组中
//		input.get(bytes);
//		String result = new String(bytes, "UTF-8");
//		sBuilder.append(result);
//		if (textArea != null)
//			textArea.append("Server : " + result + "\n");

		// 读取数据的原则: 要么读取一个完整的包头，要么读取一个完整包体。不满足这两种情况，不对ByteBuffer进行任何的get操作
		// 但是要注意可能发生上次读取了一个完整的包头，下次读才读取一个完整包体情况。
		// 所以包头部分必须用类的成员变量进行暂时的存储，当完整读取包头和包体后，在给业务处理部分。
		System.out.println("1: remain=" + input.remaining() + " bodylen=" + bodylen);
		int remain = -1;
		while ((remain = input.remaining()) == 1024) {
			count++;
			if (bodylen < 0) // 还没有生成完整的包头部分,
								// 该变量初始值为-1，并且在拼凑一个完整的消息包以后，再将该值设置为-1
			{
				if (input.remaining() >= MESSAGE_LENGTH_HEAD) // ByteBuffer缓冲区的字节数够拼凑一个包头
				{
					input.get(head, 0, 4);
					bodylen = Util2Bytes.bytes2bigint(head);
					System.out.println("2: remain=" + input.remaining() + " bodylen=" + bodylen);
					readbuffer = ByteBuffer.allocate(bodylen);
					
				} else// ByteBuffer缓冲区的字节数不够拼凑一个包头，什么操作都不做，退出这次处理，继续等待
				{
					System.out.println("3: remain=" + input.remaining() + " bodylen=" + bodylen);
					break;
				}
			} else if (bodylen > 0) // 包头部分已经完整生成.
			{
				if (input.remaining() >= bodylen) // 缓冲区的内容够一个包体部分
				{
					byte[] body = new byte[bodylen];
					input.get(body, 0, bodylen);
					byte[] headandbody = new byte[MESSAGE_LENGTH_HEAD + bodylen];
					System.arraycopy(head, 0, headandbody, 0, head.length);
					System.arraycopy(body, 0, headandbody, head.length, body.length);
					bodylen = -1;
					System.out.println("4: remain=" + input.remaining() + " bodylen=" + bodylen);
					Bytes2util.outputHex(headandbody, 16);
				} else /// 缓冲区的内容不够一个包体部分，继续等待，跳出循环等待下次再出发该函数
				{
					System.out.println("5: remain=" + input.remaining() + " bodylen=" + bodylen);
					break;
				}
			} else if (bodylen == 0) // 没有包体部分，仅仅有包头的情况
			{
				byte[] headandbody = new byte[MESSAGE_LENGTH_HEAD + bodylen];
				System.arraycopy(head, 0, headandbody, 0, head.length);
				Bytes2util.outputHex(headandbody, 16);
				bodylen = -1;
			}
			System.out.println(" while count "+count);
		}
		System.out.println("count "+count);

		if((count *1024 + remain - 4) == bodylen){//包接收完成了
			System.out.println(" end count "+count);
			if (textArea != null)
				textArea.append("Server : " + sBuilder.toString() + "\n");
		}
		sk.interestOps(SelectionKey.OP_READ);
	}
}
