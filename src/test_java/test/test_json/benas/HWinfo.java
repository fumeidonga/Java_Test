package test_java.test.test_json.benas;

/**
 * Created by Administrator on 2018/4/4.
 * @author Luo Kun
 */

public class HWinfo {

    private String amount;

    private String applicationID;

    private String country;

    private String currency;

    private String extReserved;

    private String merchantId;

    private String merchantName;

    private String productDesc;

    private String productName;

    private String requestId;

    private String sdkChannel;

    private String serviceCatalog;

    private String sign;

    private String urlVer;

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getAmount() {
        return this.amount;
    }

    public void setApplicationID(String applicationID) {
        this.applicationID = applicationID;
    }

    public String getApplicationID() {
        return this.applicationID;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCountry() {
        return this.country;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getCurrency() {
        return this.currency;
    }

    public void setExtReserved(String extReserved) {
        this.extReserved = extReserved;
    }

    public String getExtReserved() {
        return this.extReserved;
    }

    public void setMerchantId(String merchantId) {
        this.merchantId = merchantId;
    }

    public String getMerchantId() {
        return this.merchantId;
    }

    public void setMerchantName(String merchantName) {
        this.merchantName = merchantName;
    }

    public String getMerchantName() {
        return this.merchantName;
    }

    public void setProductDesc(String productDesc) {
        this.productDesc = productDesc;
    }

    public String getProductDesc() {
        return this.productDesc;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductName() {
        return this.productName;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public String getRequestId() {
        return this.requestId;
    }

    public void setSdkChannel(String sdkChannel) {
        this.sdkChannel = sdkChannel;
    }

    public String getSdkChannel() {
        return this.sdkChannel;
    }

    public void setServiceCatalog(String serviceCatalog) {
        this.serviceCatalog = serviceCatalog;
    }

    public String getServiceCatalog() {
        return this.serviceCatalog;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public String getSign() {
        return this.sign;
    }

    public void setUrlVer(String urlVer) {
        this.urlVer = urlVer;
    }

    public String getUrlVer() {
        return this.urlVer;
    }

	@Override
	public String toString() {
		return "HWinfo [amount=" + amount + ", applicationID=" + applicationID + ", country=" + country + ", currency="
				+ currency + ", extReserved=" + extReserved + ", merchantId=" + merchantId + ", merchantName="
				+ merchantName + ", productDesc=" + productDesc + ", productName=" + productName + ", requestId="
				+ requestId + ", sdkChannel=" + sdkChannel + ", serviceCatalog=" + serviceCatalog + ", sign=" + sign
				+ ", urlVer=" + urlVer + "]";
	}
}
