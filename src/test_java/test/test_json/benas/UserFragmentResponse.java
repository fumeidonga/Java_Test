package test_java.test.test_json.benas;


/**
 * Created by Administrator on 2018/7/12.
 */

public class UserFragmentResponse extends BaseResponse {

    private UserFragmentEntity data;

    public UserFragmentEntity getData() {
        return data;
    }

    public void setData(UserFragmentEntity data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "UserFragmentResponse{" +
                "data=" + data +
                '}';
    }
}
