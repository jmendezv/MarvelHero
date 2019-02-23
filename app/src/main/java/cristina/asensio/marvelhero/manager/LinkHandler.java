package cristina.asensio.marvelhero.manager;

import android.support.annotation.Nullable;

import java.util.List;

import cristina.asensio.marvelhero.model.Link;
import cristina.asensio.marvelhero.util.LinkType;

public class LinkHandler {

    private LinkHandler() {

    }

    /**
     *
     * Gets the correct url for the current button
     *
     * @param links All the links for the hero
     * @param linkTypeNeeded Type of current button
     * @return Url for the current button
     */
    @Nullable
    public static String getUrl(List<Link> links, LinkType linkTypeNeeded) {
        for(final Link link : links) {
            final String type = link.getType();

            if(LinkType.valueOf(type.toUpperCase()).equals(linkTypeNeeded)) {
                return link.getUrl();
            }
        }
        return null;
    }
}
