package test_java.test.test_json.benas;

/**
 * Created by haowang on 17/8/18.
 */

public class InviteCodeResponse {

    /**
     * status : 0
     * data : {"money":"测试内容1stj","vipDays":72202,"vipEndTime":12084}
     * message : 测试内容634l
     */

    private int status;
    @Override
	public String toString() {
		return "InviteCodeResponse [status=" + status + ", data=" + data + ", message=" + message + "]";
	}

	private DataBean data;
    private String message;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public static class DataBean {
        /**
         * money : 测试内容1stj
         * vipDays : 72202
         * vipEndTime : 12084
         */

        private String money;
  
		private int vipDays;
        private int vipEndTime;
        private int currency;

        @Override
		public String toString() {
			return "DataBean [money=" + money + ", vipDays=" + vipDays + ", vipEndTime=" + vipEndTime + ", currency="
					+ null + "]";
		}

		public int getCurrency() {
			return currency;
		}

		public void setCurrency(int currency) {
			this.currency = currency;
		}

		public String getMoney() {
            return money;
        }

        public void setMoney(String money) {
            this.money = money;
        }

        public int getVipDays() {
            return vipDays;
        }

        public void setVipDays(int vipDays) {
            this.vipDays = vipDays;
        }

        public int getVipEndTime() {
            return vipEndTime;
        }

        public void setVipEndTime(int vipEndTime) {
            this.vipEndTime = vipEndTime;
        }
    }
}
