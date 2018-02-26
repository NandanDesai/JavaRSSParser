
package rssParser;

import java.util.ArrayList;


/**
 *
 * @author nandan
 */
public class Feed {
    private String title;
    private String description;
    private String link;
    private ArrayList<FeedItem> feedItem=new ArrayList<>();
    public Feed(String title,String description,String link){
        this.title=title;
        this.description=description;
        this.link=link;
        
    }
    
    public void addFeedItem(FeedItem item){
       feedItem.add(item);
    }
    public ArrayList<FeedItem> getFeedItems(){
        return feedItem;
    }
    public String getFeedTitle(){
        return title;
    }
    public String getFeedDesc(){
        return description;
    }
    public String getFeedLink(){
        return link;
    }
    
}
