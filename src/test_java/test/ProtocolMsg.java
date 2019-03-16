package test_java.test;

/**
 * 说明：消息对象
 *## 消息格式

类型		| 名称		 | 字节序列	| 取值范围	  | 备注
--- 	| ----- 	 | ---------| ---------   |----
消息头	| magic 	 | 0 		|0x80、0x81 	  | 帧头
		| msgType	 | 1 		|0x00-0xff    | 消息类型
		| reserve	 | 2-3 		|0x00	 	  | 保留字，以备扩展
		| sn		 |4-5		|0-32767      | 序列号。是一个事务标识，从0开始，每次递增1，响应消息中的序列号是从请求消息中拷贝来的。当序列号达到最大值时（32767），则又从0开始。
		| len		 |6-9		|0-2147483647 | 消息体长度。	
		
消息体	| body		 |变长		|0-           |消息体。格式和消息类型相关，不同的消息类型有不同的消息体格式。消息大小不应超过2G
 */
public class ProtocolMsg {
	 
	private ProtocolHeader protocolHeader = new ProtocolHeader();
 	private String body;
 	
	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
        //this.body="{\"result\":1,\"message\":"+body+"}";
	}


	/**
	 * 
	 */
	public ProtocolMsg() {
		// TODO Auto-generated constructor stub
	}
	
	public ProtocolHeader getProtocolHeader() {
		return protocolHeader;
	}

	public void setProtocolHeader(ProtocolHeader protocolHeader) {
		this.protocolHeader = protocolHeader;
	}

	@Override
	public String toString() {
		return "ProtocolMsg [protocolHeader=" + protocolHeader + ", body=" + body + "]";
	}

}
