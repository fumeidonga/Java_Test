package test_java.test.test_json.benas;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/7/12.
 */

public class UserFragmentEntity {


    @SerializedName("user_entrances")
    List<Panel> userEntrances;

    @SerializedName("banners")
    List<BannerEntity> banners;

    public Meta meta;

    private String cash;

    private String coin;

    private String id;

    private String title;

    private String today_read_duration;

    private String type;

    public void setBanners(List<BannerEntity> banners){
        this.banners = banners;
    }
    public List<BannerEntity> getBanners(){
        return this.banners;
    }
    public void setCash(String cash){
        this.cash = cash;
    }
    public String getCash(){
        return this.cash;
    }
    public void setCoin(String coin){
        this.coin = coin;
    }
    public String getCoin(){
        return this.coin;
    }
    public void setId(String id){
        this.id = id;
    }
    public String getId(){
        return this.id;
    }
    public void setTitle(String title){
        this.title = title;
    }
    public String getTitle(){
        return this.title;
    }
    public void setToday_read_duration(String today_read_duration){
        this.today_read_duration = today_read_duration;
    }
    public String getToday_read_duration(){
        return this.today_read_duration;
    }
    public void setType(String type){
        this.type = type;
    }
    public String getType(){
        return this.type;
    }

    public List<Panel> getUserEntrances() {
        return userEntrances;
    }

    public void setUserEntrances(List<Panel> userEntrances) {
        this.userEntrances = userEntrances;
    }

    @Override
    public String toString() {
        return "UserFragmentEntity{" +
                "userEntrances=" + userEntrances +
                "\n" +
                ", banners=" + banners +
                "\n" +
                ", cash='" + cash + '\'' +
                ", meta='" + meta + '\'' +
                ", coin='" + coin + '\'' +
                ", id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", today_read_duration='" + today_read_duration + '\'' +
                ", type='" + type + '\'' +
                '}';
    }

    public static class Meta{

        public String banners_show_type;

        public String getBanners_show_type() {
            return banners_show_type;
        }

        public void setBanners_show_type(String banners_show_type) {
            this.banners_show_type = banners_show_type;
        }

        @Override
        public String toString() {
            return "Meta{" +
                    "banners_show_type='" + banners_show_type + '\'' +
                    '}';
        }
    }

    public static class Panel {
        ArrayList<UserEntrances> list;

        public ArrayList<UserEntrances> getList() {
            return list;
        }

        public void setList(ArrayList<UserEntrances> list) {
            this.list = list;
        }

        @Override
        public String toString() {
            return "Panel{" +
                    "list=" + list +
                    '}';
        }
    }

    public Meta getMeta() {
        return meta;
    }

    public void setMeta(Meta meta) {
        this.meta = meta;
    }

    public static class UserEntrances {

        //点击按钮跳转的地址
        private String button_lnk_url;

        //按钮标题
        private String button_title;

        private String callback_url;

        private String first_title;

        private String icon_url;

        private String id;

        //按钮是否可点击 0 可  1 不可
        private String is_button_click;

        private String link_type;

        /**
         * link_url 为5表示此item需要隐藏
         */
        private String link_url;

        private String second_title;

        /**
         * 1, 普通list，3 两行list，带按钮 2。两行list 不带按钮
         */
        private String show_type;

        private String statistical_code;

        private String type;

        /**
         * 1, 活动list，2 普通list
         */
        private int itemType;

        public int getItemType() {
            return itemType;
        }

        public void setItemType(int itemType) {
            this.itemType = itemType;
        }

        public void setButton_title(String button_title){
            this.button_title = button_title;
        }
        public String getButton_title(){
            return this.button_title;
        }
        public void setCallback_url(String callback_url){
            this.callback_url = callback_url;
        }
        public String getCallback_url(){
            return this.callback_url;
        }
        public void setFirst_title(String first_title){
            this.first_title = first_title;
        }
        public String getFirst_title(){
            return this.first_title;
        }
        public void setIcon_url(String icon_url){
            this.icon_url = icon_url;
        }
        public String getIcon_url(){
            return this.icon_url;
        }
        public void setId(String id){
            this.id = id;
        }
        public String getId(){
            return this.id;
        }
        public void setLink_type(String link_type){
            this.link_type = link_type;
        }
        public String getLink_type(){
            return this.link_type;
        }
        public void setLink_url(String link_url){
            this.link_url = link_url;
        }
        public String getLink_url(){
            return this.link_url;
        }
        public void setSecond_title(String second_title){
            this.second_title = second_title;
        }
        public String getSecond_title(){
            return this.second_title;
        }
        public void setShow_type(String show_type){
            this.show_type = show_type;
        }
        public String getShow_type(){
            return this.show_type;
        }
        public void setStatistical_code(String statistical_code){
            this.statistical_code = statistical_code;
        }
        public String getStatistical_code(){
            return this.statistical_code;
        }
        public void setType(String type){
            this.type = type;
        }
        public String getType(){
            return this.type;
        }

        public String getButton_lnk_url() {
            return button_lnk_url;
        }

        public void setButton_lnk_url(String button_lnk_url) {
            this.button_lnk_url = button_lnk_url;
        }

        public String getIs_button_click() {
            return is_button_click;
        }

        public void setIs_button_click(String is_button_click) {
            this.is_button_click = is_button_click;
        }

        @Override
        public String toString() {
            return "UserEntrances{" +
                    "button_lnk_url='" + button_lnk_url + '\'' +
                    ", button_title='" + button_title + '\'' +
                    ", callback_url='" + callback_url + '\'' +
                    ", first_title='" + first_title + '\'' +
                    ", icon_url='" + icon_url + '\'' +
                    "\n" +
                    ", id='" + id + '\'' +
                    ", is_button_click='" + is_button_click + '\'' +
                    ", link_type='" + link_type + '\'' +
                    ", link_url='" + link_url + '\'' +
                    "\n" +
                    ", second_title='" + second_title + '\'' +
                    ", show_type='" + show_type + '\'' +
                    ", statistical_code='" + statistical_code + '\'' +
                    ", type='" + type + '\'' +
                    ", itemType=" + itemType +
                    '}';
        }
    }
}
