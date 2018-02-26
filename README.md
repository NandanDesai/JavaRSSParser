# JavaRSSParser
A Java library for parsing RSS[https://en.wikipedia.org/wiki/RSS] feeds.
This project is actually meant for my personal use (I will be using the binaries of this project for some other task). Feel free to view the source code and modify it as per your needs.
There are many XML parsing libraries for Java and each one of them have their own pros and cons.
I found JDOM[http://www.jdom.org/] to be very easy to use and I have used it in this project.


## How to use this library?
```java
try {
            //https://www.techrepublic.com/rssfeeds/topic/security/

            //https://fossbytes.com/feed/
            URL url = new URL("https://fossbytes.com/feed/");
            System.setProperty("http.agent", "Chrome");
            FeedParser parser = new FeedParser(url);
            Feed feed = parser.getFeed();

            System.out.println("feed title: " + feed.getFeedTitle());
            System.out.println("feed desc: " + feed.getFeedDesc());
            System.out.println("feed link: " + feed.getFeedLink());
            System.out.println();
            System.out.println();
            ArrayList<FeedItem> items = feed.getFeedItems();
            Iterator it = items.iterator();

            while (it.hasNext()) {
                FeedItem fi = (FeedItem) it.next();
                System.out.println("title: " + fi.getTitle());
                System.out.println("link: " + fi.getLink());
                System.out.println("desc: " + fi.getDescription());
                System.out.println("category: " + fi.getCategory());
                System.out.println("pub date: " + fi.getPubDate());
                System.out.println("author: " + fi.getAuthor());
                System.out.println("guid: " + fi.getGuid());
                System.out.println();
                System.out.println();
            }
        } catch (Exception e) {
            System.out.println(e);
        }
```
