package test_java.test.test_json.benas;

public class Ad {

	private int online; //上线
	private int offline; //下线
	private String image_url; //图片地址
	private String link; //跳转地址
	private int frequency; //频率 比如一天一次
	private int showtime = 3;
	private String statistics;

	private String type; // 类型：1 活动 2 广告
	private String probability; // 广告显示概率

	private int id;

	/**
	 * @return the showtime
	 */
	public int getShowtime() {
		if (showtime == 0) {
			showtime = 3;
		}
		return showtime;
	}

	/**
	 * @param showtime
	 *            the showtime to set
	 */
	public void setShowtime(int showtime) {
		this.showtime = showtime;
	}

	/**
	 * @return the online
	 */
	public int getOnline() {
		return online;
	}

	/**
	 * @param online
	 *            the online to set
	 */
	public void setOnline(int online) {
		this.online = online;
	}

	/**
	 * @return the offline
	 */
	public int getOffline() {
		return offline;
	}

	/**
	 * @param offline
	 *            the offline to set
	 */
	public void setOffline(int offline) {
		this.offline = offline;
	}

	/**
	 * @return the image_url
	 */
	public String getImage_url() {
		return image_url;
	}

	/**
	 * @param image_url
	 *            the image_url to set
	 */
	public void setImage_url(String image_url) {
		this.image_url = image_url;
	}

	/**
	 * @return the link
	 */
	public String getLink() {
		return link;
	}

	/**
	 * @param link
	 *            the link to set
	 */
	public void setLink(String link) {
		this.link = link;
	}

	/**
	 * @return the frequency
	 */
	public int getFrequency() {
		return frequency;
	}

	/**
	 * @param frequency
	 *            the frequency to set
	 */
	public void setFrequency(int frequency) {
		this.frequency = frequency;
	}

	public String getStatistics() {
		return statistics;
	}

	public void setStatistics(String statistics) {
		this.statistics = statistics;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getProbability() {
		return probability;
	}

	public void setProbability(String probability) {
		this.probability = probability;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Ad{" +
				"online=" + online +
				", offline=" + offline +
				", image_url='" + image_url + '\'' +
				", link='" + link + '\'' +
				", frequency=" + frequency +
				", showtime=" + showtime +
				", statistics='" + statistics + '\'' +
				", type='" + type + '\'' +
				", probability='" + probability + '\'' +
				", id=" + id +
				'}';
	}
}
