package test_java.test.test_json.benas;

import java.util.List;

/**
 * Created by Administrator on 2018/8/3.
 */

public class UpdateResponse {
    public String updatetype;   // update
    public String appkey;      // 请求appkey
    public String channel;     // 请求渠道编号
    public String downurl;     // 下载包URL地址
    public String packname;    // 包唯一命名
    public String filename;    // 文件名
    public String filesize;    // 文件大小
    public String md5;       // 文件MD5
    public String version;    // 系统版本号
    public String user_version;// 自定义版本号
    public String updatelog;  // 升级日志 \r\n换行
    public String need_update;  // 强制更新系统版本，多个使用逗号隔开
    //升级的版本集合
    public List<String> upgrade_interval;

    public String message;  //

    public String getUpdatetype() {
        return updatetype;
    }

    public void setUpdatetype(String updatetype) {
        this.updatetype = updatetype;
    }

    public String getAppkey() {
        return appkey;
    }

    public void setAppkey(String appkey) {
        this.appkey = appkey;
    }

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }

    public String getDownurl() {
        return downurl;
    }

    public void setDownurl(String downurl) {
        this.downurl = downurl;
    }

    public String getPackname() {
        return packname;
    }

    public void setPackname(String packname) {
        this.packname = packname;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String getFilesize() {
        return filesize;
    }

    public void setFilesize(String filesize) {
        this.filesize = filesize;
    }

    public String getMd5() {
        return md5;
    }

    public void setMd5(String md5) {
        this.md5 = md5;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getUser_version() {
        return user_version;
    }

    public void setUser_version(String user_version) {
        this.user_version = user_version;
    }

    public String getUpdatelog() {
        return updatelog;
    }

    public void setUpdatelog(String updatelog) {
        this.updatelog = updatelog;
    }

    public String getNeed_update() {
        return need_update;
    }

    public void setNeed_update(String need_update) {
        this.need_update = need_update;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<String> getUpgrade_interval() {
        return upgrade_interval;
    }

    public void setUpgrade_interval(List<String> upgrade_interval) {
        this.upgrade_interval = upgrade_interval;
    }

    @Override
    public String toString() {
        return "UpdateResponse{" +
                "updatetype='" + updatetype + '\'' +
                ", appkey='" + appkey + '\'' +
                ", channel='" + channel + '\'' +
                ", downurl='" + downurl + '\'' +
                ", packname='" + packname + '\'' +
                ", filename='" + filename + '\'' +
                ", filesize='" + filesize + '\'' +
                ", md5='" + md5 + '\'' +
                ", version='" + version + '\'' +
                ", user_version='" + user_version + '\'' +
                ", updatelog='" + updatelog + '\'' +
                ", need_update='" + need_update + '\'' +
                ", upgrade_interval=" + upgrade_interval +
                ", message='" + message + '\'' +
                '}';
    }

}
