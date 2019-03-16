package test_java.test.test_json.benas;

/**
 * @author xk
 * @version 1.0.0  by xk 18/7/17
 */
public class BannerEntity {
    private String begin_time;
    private String end_time;
    private String id;
    private String image;
    private String link;
    private String order;
    private String show_percent;
    private String statistical_code;
    private String title;
    private String type;

    public BannerEntity() {
    }

    public BannerEntity(String image) {
        this.image = image;
    }

    public String getBegin_time() {
        return begin_time;
    }

    public void setBegin_time(String begin_time) {
        this.begin_time = begin_time;
    }

    public String getEnd_time() {
        return end_time;
    }

    public void setEnd_time(String end_time) {
        this.end_time = end_time;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    public String getShow_percent() {
        return show_percent;
    }

    public void setShow_percent(String show_percent) {
        this.show_percent = show_percent;
    }

    public String getStatistical_code() {
        return statistical_code;
    }

    public void setStatistical_code(String statistical_code) {
        this.statistical_code = statistical_code;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "BannerEntity{" +
                "begin_time='" + begin_time + '\'' +
                ", end_time='" + end_time + '\'' +
                ", id='" + id + '\'' +
                ", image='" + image + '\'' +
                ", link='" + link + '\'' +
                ", order='" + order + '\'' +
                ", show_percent='" + show_percent + '\'' +
                ", statistical_code='" + statistical_code + '\'' +
                ", title='" + title + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
