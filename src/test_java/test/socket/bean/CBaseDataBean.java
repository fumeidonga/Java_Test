package test_java.test.socket.bean;

import java.io.Serializable;

public class CBaseDataBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1997739604826327549L;

	/**
	 * 数据类型
	 */
	public int dataType;

	/**
	 * 数据长度
	 */
	public int dataLength;
	
	public int storeId;
	
	public String json;

	public int getDataType() {
		return dataType;
	}

	public void setDataType(int dataType) {
		this.dataType = dataType;
	}

	public String getJson() {
		return json;
	}

	public void setJson(String json) {
		//this.json="{\"result\":1,\"message\":\""+json+"\"}";
        this.json="{\"result\":1,\"message\":"+json+"}";
	}

	public int getDataLength() {
		return dataLength;
	}

	public int getStoreId() {
		return storeId;
	}

	public void setStoreId(int storeId) {
		this.storeId = storeId;
	}

	public void setDataLength(int dataLength) {
		this.dataLength = dataLength;
	}

	@Override
	public String toString() {
		return "CBaseDataBean [dataType=" + dataType + ", json=" + json + "]";
	}

}
