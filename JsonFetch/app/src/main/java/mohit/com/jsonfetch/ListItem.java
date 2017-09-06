package mohit.com.jsonfetch;

/**
 * Created by MOHIT AGARWAL on 06-09-2017.
 */

public class ListItem {

    private String heading;
    private String desc;
    private String imageUrl;

    public ListItem(String heading, String desc, String imageUrl) {
        this.heading = heading;
        this.desc = desc;
        this.imageUrl = imageUrl;
    }

    public String getHeading() {
        return heading;
    }

    public String getDesc() {
        return desc;
    }

    public String getImageUrl() {
        return imageUrl;
    }
}
