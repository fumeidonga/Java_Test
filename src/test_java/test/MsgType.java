/**
 * 
 */
package test_java.test;

/**
 * 说明：消息类型
 *
 * @author <a href="http://www.waylau.com">waylau.com</a> 2015年11月5日 
 */
public enum MsgType {
	/**
	 * 查询基本分类
	 */
	MSG_TYPE_GET_GOODS_BASE_CAT((byte) 0x00),
	/**
	 * 查询某个店铺的分类
	 */
	MSG_TYPE_GET_GOODS_BASE_CAT_STORE((byte) 0x01),
	/**
	 * 添加某个店铺的分类
	 */
	MSG_TYPE_GET_GOODS_BASE_CAT_STORE_ADD((byte) 0x02),
	/**
	 * 添加某个店铺的分类
	 */
	MSG_TYPE_GET_GOODS((byte) 0x03);
	
	private byte value;

	public byte getValue() {
		return value;
	}

	private MsgType(byte value) {
		this.value = value;
	}
}
