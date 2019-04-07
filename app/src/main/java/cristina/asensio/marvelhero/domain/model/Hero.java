package cristina.asensio.marvelhero.domain.model;

import com.squareup.moshi.Json;

import java.util.List;

public class Hero {

    private final long id;
    private final String name;
    private final String description;
    private final Thumbnail thumbnail;

    @Json(name = "urls")
    private final List<Link> links;

    public Hero(long id, String name, String description, Thumbnail thumbnail, List<Link> links) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.thumbnail = thumbnail;
        this.links = links;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Thumbnail getThumbnail() {
        return thumbnail;
    }

    public List<Link> getLinks() {
        return links;
    }

    @Override
    public String toString() {
        return "Hero{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", thumbnail=" + thumbnail +
                ", links=" + links +
                '}';
    }
}
