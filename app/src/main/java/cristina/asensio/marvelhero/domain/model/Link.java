package cristina.asensio.marvelhero.domain.model;

public class Link {

    private final String type;
    private final String url;

    public Link(String type, String url) {
        this.type = type;
        this.url = url;
    }

    public String getType() {
        return type;
    }

    public String getUrl() {
        return url;
    }

    @Override
    public String toString() {
        return "Link{" +
                "type='" + type + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
