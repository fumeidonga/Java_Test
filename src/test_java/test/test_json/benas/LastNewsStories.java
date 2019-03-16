package test_java.test.test_json.benas;

import java.io.Serializable;
import java.util.Arrays;

/**
 * 当日新闻
 */
public class LastNewsStories implements Serializable {

    private String ga_prefix;
    private String id;
    private String multipic;
    private String title;
    private String type;
    private String[] images;

    public void setGa_prefix(String ga_prefix) {
        this.ga_prefix = ga_prefix;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setMultipic(String multipic) {
        this.multipic = multipic;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setImages(String[] images) {
        this.images = images;
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

    public String[] getImages() {
        return images;
    }

    @Override
    public String toString() {
        return "LastNewsStories{" +
                "ga_prefix='" + ga_prefix + '\'' +
                ", id='" + id + '\'' +
                ", multipic='" + multipic + '\'' +
                ", title='" + title + '\'' +
                ", type='" + type + '\'' +
                ", images=" + Arrays.toString(images) +
                '}';
    }
}
