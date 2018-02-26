
package rssParser;

/**
 *
 * @author nandan
 */
public class FeedItem {
    private String title;
    private String link;
    private String description;
    private String category;
    private String author;
    private String pubDate;
    private String guid;
    public FeedItem(String title,String link,String description,String category,String author,String pubDate,String guid){
        this.title=title;
        this.link=link;
        this.description=description;
        this.category=category;
        this.author=author;
        this.pubDate=pubDate;
        this.guid=guid;
    }
    public String getTitle(){
        return title;
    }
    public String getLink(){
        return link;
    }
    public String getDescription(){
        return description;
    }
    public String getCategory(){
        return category;
    }
    public String getAuthor(){
        return author;
    }
    public String getPubDate(){
        return pubDate;
    }
    public String getGuid(){
        return guid;
    }
}
