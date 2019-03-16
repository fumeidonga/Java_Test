package test_java.test.test_json.benas;

import java.util.List;


/**
 * Created by Administrator on 2018/4/16.
 */

public class InviteDataBean {

    /**
     * 分享的途径，
     */
    private List<ModuleShareEntity> share_list;

    private String invite_code;


    @Override
	public String toString() {
		return "InviteDataBean [share_list=" + share_list + ", invite_code=" + invite_code + "]";
	}


    public List<ModuleShareEntity> getShare_list() {
        return share_list;
    }

    public void setShare_list(List<ModuleShareEntity> share_list) {
        this.share_list = share_list;
    }

    public String getInvite_code() {
        return invite_code;
    }

    public void setInvite_code(String invite_code) {
        this.invite_code = invite_code;
    }
}