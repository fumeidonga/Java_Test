package test_java.test;

/**
 * 请求数据时所带的参数
 * 
 * @author david
 *
 */
public class ProtocolBaseParameter {
	public int mPageSize;
	public int mPageNumber;
	public Integer mStoreId;
	public String mDateTime;
	public String mStartTime;
	public String mEndTime;
	public String mWxOpenId;
	public Integer mUserId;
	public Integer mMemberId;
	public String mPassWord;

	public int getmPageSize() {
		return mPageSize;
	}

	public void setmPageSize(int mPageSize) {
		this.mPageSize = mPageSize;
	}

	public int getmPageNumber() {
		return mPageNumber;
	}

	public void setmPageNumber(int mPageNumber) {
		this.mPageNumber = mPageNumber;
	}

	public Integer getmStoreId() {
		return mStoreId;
	}

	public void setmStoreId(Integer mStoreId) {
		this.mStoreId = mStoreId;
	}

	public String getmDateTime() {
		return mDateTime;
	}

	public void setmDateTime(String mDateTime) {
		this.mDateTime = mDateTime;
	}

	public String getmStartTime() {
		return mStartTime;
	}

	public void setmStartTime(String mStartTime) {
		this.mStartTime = mStartTime;
	}

	public String getmEndTime() {
		return mEndTime;
	}

	public void setmEndTime(String mEndTime) {
		this.mEndTime = mEndTime;
	}

	public String getmWxOpenId() {
		return mWxOpenId;
	}

	public void setmWxOpenId(String mWxOpenId) {
		this.mWxOpenId = mWxOpenId;
	}

	public Integer getmUserId() {
		return mUserId;
	}

	public void setmUserId(Integer mUserId) {
		this.mUserId = mUserId;
	}

	public Integer getmMemberId() {
		return mMemberId;
	}

	public void setmMemberId(Integer mMemberId) {
		this.mMemberId = mMemberId;
	}

	public String getmPassWord() {
		return mPassWord;
	}

	public void setmPassWord(String mPassWord) {
		this.mPassWord = mPassWord;
	}

	@Override
	public String toString() {
		return "ProtocalParameter [mPageSize=" + mPageSize + ", mPageNumber=" + mPageNumber + ", mStoreId=" + mStoreId
				+ ", mDateTime=" + mDateTime + ", mStartTime=" + mStartTime + ", mEndTime=" + mEndTime + ", mWxOpenId="
				+ mWxOpenId + ", mUserId=" + mUserId + ", mMemberId=" + mMemberId + ", mPassWord=" + mPassWord + "]";
	}

}
