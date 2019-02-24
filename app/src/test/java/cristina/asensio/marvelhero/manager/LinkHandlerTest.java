package cristina.asensio.marvelhero.manager;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import cristina.asensio.marvelhero.model.Link;
import cristina.asensio.marvelhero.util.LinkType;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class LinkHandlerTest {

    private List<Link> links;

    @Before
    public void init() {
        links = Arrays.asList(
                new Link("detail", "http://detail/url/fake"),
                new Link("wiki", "http://wiki/url/fake"),
                new Link("comiclink", "http://comiclink/url/fake")
        );
    }

    @Test
    public void linkHandler_getUrlForDetailLink_detailUrlProvided() {
        String url = LinkHandler.getUrl(links, LinkType.DETAIL);
        String expectedUrl = "http://detail/url/fake";
        assertThat(url, is(expectedUrl));
    }

    @Test
    public void linkHandler_getUrlForWikiLink_wikiUrlProvided() {
        String url = LinkHandler.getUrl(links, LinkType.WIKI);
        String expectedUrl = "http://wiki/url/fake";
        assertThat(url, is(expectedUrl));
    }


    @Test
    public void linkHandler_getUrlForComiclink_comiclinkUrlProvided() {
        String url = LinkHandler.getUrl(links, LinkType.COMICLINK);
        String expectedUrl = "http://comiclink/url/fake";
        assertThat(url, is(expectedUrl));
    }

}