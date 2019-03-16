package test_java.test.test_json.benas;

import com.google.gson.annotations.SerializedName;

import java.util.List;


/**
 * @author Administrator
 */
public class InviteDiscipleShareResponse extends BaseResponse{

    private DataBean data;

    @Override
	public String toString() {
		return "InviteDiscipleShareResponse [data=" + data + "]";
	}

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        @SerializedName("has_open")
        private int hasOpen;
        Introduction introduction;
        @SerializedName("invite_friends")
        InviteFriends inviteFriends;

        @Override
		public String toString() {
			return "DataBean [hasOpen=" + hasOpen + ", introduction=" + introduction + ", inviteFriends="
					+ inviteFriends + "]";
		}

		public int getHasOpen() {
            return hasOpen;
        }

        public void setHasOpen(int hasOpen) {
            this.hasOpen = hasOpen;
        }

        public Introduction getIntroduction() {
            return introduction;
        }

        public void setIntroduction(Introduction introduction) {
            this.introduction = introduction;
        }

        public InviteFriends getInviteFriends() {
            return inviteFriends;
        }

        public void setInviteFriends(InviteFriends inviteFriends) {
            this.inviteFriends = inviteFriends;
        }

        /**
         * 好友介绍页
         */
        public static class Introduction{

            @SerializedName("share_type")
            private int shareType;
            @SerializedName("inactivated_share")
            private ShareListBean shareListBean;

            @Override
			public String toString() {
				return "Introduction [shareType=" + shareType + ", shareListBean=" + shareListBean + "]";
			}

			public int getShareType() {
                return shareType;
            }

            public void setShareType(int shareType) {
                this.shareType = shareType;
            }

            public ShareListBean getShareListBean() {
                return shareListBean;
            }

            public void setShareListBean(ShareListBean shareListBean) {
                this.shareListBean = shareListBean;
            }
        }

        /**
         * 邀请好友
         */
        public static class InviteFriends{

            /**
             * 邀请码
             */
            @SerializedName("invite_code")
            private String inviteCode;
            /**
             * 规则
             */
            @SerializedName("invite_codedescurl")
            private String inviteCodeDescUrl;
            @SerializedName("detail_rulesurl")
            private String detailRulesUrl;
            private int step;

        	@SerializedName("inactivated_list")
            private List<IncomeDetails> inactivateList;

			public List<IncomeDetails> getInactivateList() {
                return inactivateList;
            }

            public void setInactivateList(List<IncomeDetails> inactivateList) {
                this.inactivateList = inactivateList;
            }
            @SerializedName("invite_data")
            InviteDataBean inviteDataBean;

            @SerializedName("income_details")
            private List<IncomeDetails> incomeDetailList;

			public List<IncomeDetails> getIncomeDetailList() {
                return incomeDetailList;
            }

            public void setIncomeDetailList(List<IncomeDetails> incomeDetailList) {
                this.incomeDetailList = incomeDetailList;
            }

            @SerializedName("marqueeview_data")
            private List<IncomeDetails> marqueList;

			public List<IncomeDetails> getMarqueList() {
                return marqueList;
            }

            public void setMarqueList(List<IncomeDetails> marqueList) {
                this.marqueList = marqueList;
            }


			@Override
			public String toString() {
				return "InviteFriends [inviteCode=" + inviteCode + ", inviteCodeDescUrl=" + inviteCodeDescUrl
						+ ", detailRulesUrl=" + detailRulesUrl + ", step=" + step + ", inactivateList=" + inactivateList
						+ ", inviteDataBean=" + inviteDataBean + ", incomeDetailList=" + incomeDetailList
						+ ", marqueList=" + marqueList + "]";
			}

			public String getInviteCode() {
                return inviteCode;
            }

            public void setInviteCode(String inviteCode) {
                this.inviteCode = inviteCode;
            }

            public String getInviteCodeDescUrl() {
                return inviteCodeDescUrl;
            }

            public void setInviteCodeDescUrl(String inviteCodeDescUrl) {
                this.inviteCodeDescUrl = inviteCodeDescUrl;
            }

            public String getDetailRulesUrl() {
                return detailRulesUrl;
            }

            public void setDetailRulesUrl(String detailRulesUrl) {
                this.detailRulesUrl = detailRulesUrl;
            }

            public int getStep() {
                return step;
            }

            public void setStep(int step) {
                this.step = step;
            }

            public InviteDataBean getInviteDataBean() {
                return inviteDataBean;
            }

            public void setInviteDataBean(InviteDataBean inviteDataBean) {
                this.inviteDataBean = inviteDataBean;
            }

        }
    }

    /**
     * 分享列表
     */
    public static class InviteDataBean {
        private int shareType;
        @SerializedName("share_list")
        private List<ShareListBean> shareList;

        @Override
		public String toString() {
			return "InviteDataBean [shareType=" + shareType + ", shareList=" + shareList + "]";
		}

		public int getShareType() {
            return shareType;
        }

        public void setShareType(int shareType) {
            this.shareType = shareType;
        }

        public List<ShareListBean> getShareList() {
            return shareList;
        }

        public void setShareList(List<ShareListBean> shareList) {
            this.shareList = shareList;
        }

    }

    /**
     * 分享
     */
    public static class ShareListBean {
        private String share_content;
        private String share_title;
        private int type;

        @SerializedName("qrcode_url")
        private String qrcodeUrl;
        @SerializedName("show_title")
        private String showTitle;
        private String share_url;

        @Override
		public String toString() {
			return "ShareListBean [share_content=" + share_content + ", share_title=" + share_title + ", type=" + type
					+ ", qrcodeUrl=" + qrcodeUrl + ", showTitle=" + showTitle + ", share_url=" + share_url + "]";
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

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public String getQrcodeUrl() {
            return qrcodeUrl;
        }

        public void setQrcodeUrl(String qrcodeUrl) {
            this.qrcodeUrl = qrcodeUrl;
        }

        public String getShowTitle() {
            return showTitle;
        }

        public void setShowTitle(String showTitle) {
            this.showTitle = showTitle;
        }

        public String getShare_url() {
            return share_url;
        }

        public void setShare_url(String share_url) {
            this.share_url = share_url;
        }
    }

    public static class IncomeDetails{
        @SerializedName("user_image")
        public  String userImage;
        @SerializedName("user_name")
        public  String userName;
        @SerializedName("red_envelope_money")
        public  String redEnvilopeMoney;
        @SerializedName("red_envelope_id")
        public  String redEnvilopeId;
        @SerializedName("withdraw_type")
        public  int withdrawType;

        @Override
		public String toString() {
			return "IncomeDetails [userImage=" + userImage + ", userName=" + userName + ", redEnvilopeMoney="
					+ redEnvilopeMoney + ", redEnvilopeId=" + redEnvilopeId + ", withdrawType=" + withdrawType + "]";
		}

		public String getUserImage() {
            return userImage;
        }

        public void setUserImage(String userImage) {
            this.userImage = userImage;
        }

        public String getUserName() {
            return userName;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }

        public String getRedEnvilopeMoney() {
            return redEnvilopeMoney;
        }

        public void setRedEnvilopeMoney(String redEnvilopeMoney) {
            this.redEnvilopeMoney = redEnvilopeMoney;
        }

        public String getRedEnvilopeId() {
            return redEnvilopeId;
        }

        public void setRedEnvilopeId(String redEnvilopeId) {
            this.redEnvilopeId = redEnvilopeId;
        }

        public int getWithdrawType() {
            return withdrawType;
        }

        public void setWithdrawType(int withdrawType) {
            this.withdrawType = withdrawType;
        }
    }
}
