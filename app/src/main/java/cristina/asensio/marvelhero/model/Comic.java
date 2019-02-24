package cristina.asensio.marvelhero.model;

public class Comic {

    private final String title;
    private final String description;
    private final Thumbnail thumbnail;

    public Comic(String title, String description, Thumbnail thumbnail) {
        this.title = title;
        this.description = description;
        this.thumbnail = thumbnail;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public Thumbnail getThumbnail() {
        return thumbnail;
    }

    @Override
    public String toString() {
        return "Comic{" +
                "title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", thumbnail=" + thumbnail +
                '}';
    }
}
