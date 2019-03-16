package test_java.test.test_json.benas;

import java.io.Serializable;

/**
 *  界面顶部 ViewPager 滚动显示的显示内容
 */
public class LastNewsTopStories implements Serializable {

    private String ga_prefix;
    private String id;
    private String multipic;
    private String title;
    private String type;
    private String image;
    private String url;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGa_prefix() {
        return ga_prefix;
    }

    public String getId() {
        return id;
    }

    public String getMultipic() {
        return multipic;
    }

    public String getTitle() {
        return title;
    }

    public String getType() {
        return type;
    }

    public String getImage() {
        return image;
    }

    public void setGa_prefix(String ga_prefix) {
        this.ga_prefix = ga_prefix;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setMultipic(String multipic) {
        this.multipic = multipic;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "LastNewsTopStories{" +
                "ga_prefix='" + ga_prefix + '\'' +
                ", id='" + id + '\'' +
                ", multipic='" + multipic + '\'' +
                ", title='" + title + '\'' +
                ", type='" + type + '\'' +
                ", image='" + image + '\'' +
                '}';
    }
}
