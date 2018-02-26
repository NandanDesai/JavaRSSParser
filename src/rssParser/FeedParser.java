package rssParser;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

/**
 *
 * @author nandan
 */
public class FeedParser {

    private URL rssUrl;
    
    public FeedParser(String rssUrl) throws MalformedURLException {
        this.rssUrl = new URL(rssUrl);
    }

    public FeedParser(URL rssUrl) {
        this.rssUrl = rssUrl;
    }

    public FeedParser() {
    }

    public Feed getFeed() throws IOException, JDOMException {
        Feed feed = null;
        FeedItem feedItem=null;
        String itemTitle="";
        String itemDesc="";
        String itemLink="";
        String itemCategory="";
        String itemAuthor="";
        String itemPubDate="";
        String itemGuid="";
        InputStream stream = rssUrl.openStream();
        SAXBuilder saxBuilder = new SAXBuilder();
        Document document = saxBuilder.build(stream);
        
        Element classElement = document.getRootElement();
        Element channel = classElement.getChild("channel");
        Element title = channel.getChild("title");
        String titleText = title.getText();
        Element description = channel.getChild("description");
        String descText = description.getText();
        Element link = channel.getChild("link");
        String linkText = link.getText();
        feed = new Feed(titleText, descText, linkText);
        List<Element> itemList=channel.getChildren("item");
        for(int i=0;i<itemList.size();i++){
            Element item=itemList.get(i);
            itemTitle=item.getChildText("title");
            itemDesc=item.getChildText("description");
            itemLink=item.getChildText("link");
            itemCategory=item.getChildText("category");
            itemAuthor=item.getChildText("author");
            itemPubDate=item.getChildText("pubDate");
            itemGuid=item.getChildText("guid");
            feedItem=new FeedItem(itemTitle,itemLink,itemDesc,itemCategory,itemAuthor,itemPubDate,itemGuid);
            feed.addFeedItem(feedItem);
        }
        return feed;
    }
}
