package test_java.test.test_json.benas;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by haowang on 17/8/18.
 */

public class MyDiscipleResponse {

    /**
     * data : {"notActivationNum":30450,"apprenticeList":[{"phone":"测试内容5imz","countContribution":"测试内容1v8w"}],"inactivatedShare":{"share_url":"测试内容zub5","share_content":"测试内容l34q","share_title":"测试内容gsi3"},"apprenticeNum":70143,"inactivatedList":[{"phone":"测试内容xde2"}],"apprenticePageCount":31420,"inactivatedPageCount":42066}
     * status : 0
     * message : 测试内容r58d
     */
	@SerializedName("data")
    private DataBean data1;
    private int status;
    private String message;

    @Override
	public String toString() {
		return "MyDiscipleResponse "
				
				+ "\n[data=" + data1 + ", \nstatus=" + status + "\n, message=" + message + "]";
	}

	public DataBean getData() {
        return data1;
    }

    public void setData(DataBean data) {
        this.data1 = data;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public static class DataBean {
        /**
         * notActivationNum : 30450
         * apprenticeList : [{"phone":"测试内容5imz","countContribution":"测试内容1v8w"}]
         * inactivatedShare : {"share_url":"测试内容zub5","share_content":"测试内容l34q","share_title":"测试内容gsi3"}
         * apprenticeNum : 70143
         * inactivatedList : [{"phone":"测试内容xde2"}]
         * apprenticePageCount : 31420
         * inactivatedPageCount : 42066
         */

        @SerializedName("not_activationNum")
        private int notActivationNum;
        @Override
		public String toString() {
			return "DataBean \n[notActivationNum=" + notActivationNum + ", inactivatedShare=" + inactivatedShare
					+ ", inactivatedPageCount=" + inactivatedPageCount + ", inactivatedList=" + inactivatedList
					+ ", apprenticeNum=" + apprenticeNum + ", apprenticePageCount=" + apprenticePageCount
					+ ", apprenticeList=" + apprenticeList + "]";
		}

		@SerializedName("inactivated_share")
        private InactivatedShareBean inactivatedShare;
        @SerializedName("inactivated_page_count")
        private int inactivatedPageCount;
        @SerializedName("inactivated_list")
        private List<ApprenticeListBean> inactivatedList;

        @SerializedName("apprentice_num")
        private int apprenticeNum;
        @SerializedName("apprentice_page_count")
        private int apprenticePageCount;
        @SerializedName("apprentice_list")
        private List<ApprenticeListBean> apprenticeList;

        public int getNotActivationNum() {
            return notActivationNum;
        }

        public void setNotActivationNum(int notActivationNum) {
            this.notActivationNum = notActivationNum;
        }

        public InactivatedShareBean getInactivatedShare() {
            return inactivatedShare;
        }

        public void setInactivatedShare(InactivatedShareBean inactivatedShare) {
            this.inactivatedShare = inactivatedShare;
        }

        public int getApprenticeNum() {
            return apprenticeNum;
        }

        public void setApprenticeNum(int apprenticeNum) {
            this.apprenticeNum = apprenticeNum;
        }

        public int getApprenticePageCount() {
            return apprenticePageCount;
        }

        public void setApprenticePageCount(int apprenticePageCount) {
            this.apprenticePageCount = apprenticePageCount;
        }

        public int getInactivatedPageCount() {
            return inactivatedPageCount;
        }

        public void setInactivatedPageCount(int inactivatedPageCount) {
            this.inactivatedPageCount = inactivatedPageCount;
        }

        public List<ApprenticeListBean> getApprenticeList() {
            return apprenticeList;
        }

        public void setApprenticeList(List<ApprenticeListBean> apprenticeList) {
            this.apprenticeList = apprenticeList;
        }

        public List<ApprenticeListBean> getInactivatedList() {
            return inactivatedList;
        }

        public void setInactivatedList(List<ApprenticeListBean> inactivatedList) {
            this.inactivatedList = inactivatedList;
        }

        public static class InactivatedShareBean {
            /**
             * share_url : 测试内容zub5
             * share_content : 测试内容l34q
             * share_title : 测试内容gsi3
             */

            private String share_url;
            @Override
			public String toString() {
				return "InactivatedShareBean [share_url=" + share_url + ", share_content=" + share_content
						+ ", share_title=" + share_title + "]";
			}

			private String share_content;
            private String share_title;

            public String getShare_url() {
                return share_url;
            }

            public void setShare_url(String share_url) {
                this.share_url = share_url;
            }

            public String getShare_content() {
                return share_content;
            }

            public void setShare_content(String share_content) {
                this.share_content = share_content;
            }

            public String getShare_title() {
                return share_title;
            }

            public void setShare_title(String share_title) {
                this.share_title = share_title;
            }
        }

        public static class ApprenticeListBean {
            /**
             * phone : 测试内容5imz
             * countContribution : 测试内容1v8w
             */

            private String phone;
            @SerializedName("user_image")
            private String userImage;
            @SerializedName("user_passid")
            private String userPassid;
            @SerializedName("user_name")
            private String userName;
            @SerializedName("count_contribution")
            private String countContribution1;

            public String getPhone() {
                return phone;
            }

            public void setPhone(String phone) {
                this.phone = phone;
            }

            public String getUserImage() {
                return userImage;
            }

            public void setUserImage(String userImage) {
                this.userImage = userImage;
            }

            public String getUserPassid() {
                return userPassid;
            }

            public void setUserPassid(String userPassid) {
                this.userPassid = userPassid;
            }

            public String getUserName() {
                return userName;
            }

            public void setUserName(String userName) {
                this.userName = userName;
            }

            public String getCountContribution1() {
                return countContribution1;
            }

            public void setCountContribution1(String countContribution1) {
                this.countContribution1 = countContribution1;
            }

            @Override
            public String toString() {
                return "ApprenticeListBean{" +
                        "phone='" + phone + '\'' +
                        ", userImage='" + userImage + '\'' +
                        ", userPassid='" + userPassid + '\'' +
                        ", userName='" + userName + '\'' +
                        ", countContribution1='" + countContribution1 + '\'' +
                        '}';
            }
        }
    }
}
