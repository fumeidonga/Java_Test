package test_java.test.test_json.benas;

import java.util.List;

/**
 * @Description 开屏广告图
 * @author ahq
 * @date 2016年3月10日
 * @version V1.0.0
 */

public class AdResponse {
	private int status;
	private List<Ad> data;
	private String modified;

	/**
	 * @return the staus
	 */
	public int getStatus() {
		return status;
	}

	/**
	 * @param staus
	 *            the staus to set
	 */
	public void setStatus(int staus) {
		this.status = staus;
	}

	/**
	 * @return the data
	 */
	public List<Ad> getData() {
		return data;
	}

	/**
	 * @param data
	 *            the message to set
	 */
	public void setData(List<Ad> data) {
		this.data = data;
	}

	public String getModified() {
		return modified;
	}

	public void setModified(String modified) {
		this.modified = modified;
	}
}
