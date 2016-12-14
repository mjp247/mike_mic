package com.example.michael.mikemic;

import com.einmalfel.earl.EarlParser;
import com.einmalfel.earl.Feed;
import com.einmalfel.earl.Item;

import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by Michael on 11/11/2016.
 */

// Note - rename Rss* fo Podcast* for my code; reserve Rss* for lib

// TODO - does Java do out params?

// TODO - For some other RSS Parsing stuff, see: http://stackoverflow.com/questions/6343166/how-to-fix-android-os-networkonmainthreadexception

// TODO - this should correspond to Feed, not RssFeed or AtomFeed
public class PodcastFeed
{
    // TODO - correctly use getters and setters
    public String feedUrl; // TODO - rename to link
    public Date publicationDate;
    public String title;
    public String description;
    public String copyright;
    public String imageLink;
    public String author;

    // TODO - collection of items
    public ArrayList<PodcastEpisode> episodes;

        /*
    Thread thread = new Thread(new Runnable() {

        @Override
        public void run() {
            try  {
                //Your code goes here
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    });

    thread.start();
    //*/

    public static PodcastFeed InitializeFromUrl(final String url)
    {
        PodcastFeed feed = new PodcastFeed();
        feed.PopulateFromUrl(url);
        return feed;
    }

    // TODO - I should remove this when I have a better threading solution
    private Feed sourceFeed = null;
    private Object tempLock = new Object();

    //private InputStream tempStream = null;
    private URL tempUrl = null;

    // TODO - I can't do this on the main thread
    // TODO - this should be static
    //public static PodcastFeed InitializeFromUrl(final String url)
    //public PodcastFeed InitializeFromUrl(final String url)
    private void PopulateFromUrl(final String url)
    {
        //InputStream inputStream = null;
        //Feed feed = null;

        /*
        try {
            inputStream = new URL(url).openConnection().getInputStream();
            feed = EarlParser.parseOrThrow(inputStream, 0);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (DataFormatException e) {
            e.printStackTrace();
        } catch (XmlPullParserException e) {
            e.printStackTrace();
        }

        if(feed != null)
        {
            //return new PodcastFeed(feed);
        }

        //return null;
        //*/


        //Feed feed = null;

        try
        {
            this.tempUrl = new URL(url);
        } catch (Exception e) {
            e.printStackTrace();
        }

        Thread thread = new Thread(new Runnable() {

            @Override
            public void run() {
                try
                {
                    //InputStream inputStream = new URL(url).openConnection().getInputStream();
                    InputStream inputStream = tempUrl.openConnection().getInputStream();
                    //feed = EarlParser.parseOrThrow(inputStream, 0);
                    sourceFeed = EarlParser.parseOrThrow(inputStream, 0);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        thread.start();

        //synchronized (this.tempLock)
        //synchronized (this.sourceFeed)
        //synchronized (this)
        //synchronized (this.tempUrl)
        {
            try {

                //thread.wait();

                // I don't want to do this :(
                Thread.sleep(1000);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        //return null;

        this.PopulateFromFeed(sourceFeed);
    }

    private void PopulateFromFeed(Feed feed)
    {
        this.feedUrl = feed.getLink();
        this.publicationDate = feed.getPublicationDate();
        this.title = feed.getTitle();
        this.description = feed.getDescription();
        this.copyright = feed.getCopyright();
        this.imageLink = feed.getImageLink();
        this.author = feed.getAuthor();

        this.episodes = new ArrayList<PodcastEpisode>();

        for (Item item : feed.getItems())
        {
            this.episodes.add(new PodcastEpisode(item));
        }
    }

    private PodcastFeed(Feed feed)
    {
        this.PopulateFromFeed(feed);
    }

    private PodcastFeed()
    {
    }

    /*
    // TODO - private?
    class LoadFeedFromUrlTask extends AsyncTask<String, Void, PodcastFeed>
    {
        private Exception exception;

        protected PodcastFeed doInBackground(String... feedUrls)
        {
            InputStream inputStream = null;
            Feed feed = null;

            try
            {
                inputStream = new URL(feedUrls[0]).openConnection().getInputStream();
                feed = EarlParser.parseOrThrow(inputStream, 0);
                return new PodcastFeed(feed);
            }
            catch (Exception e)
            {
                e.printStackTrace();
                this.exception = e;
                return null;
            }
        }

        protected void onPostExecute(PodcastFeed feed)
        {
            // TODO: check this.exception
            // TODO: do something with the feed
        }
    }
    //*/

    public static String SerializePodcastFeedToXml(PodcastEpisode episode)
    {
        return CreateDummyXml();
    }

    public static PodcastEpisode DeserializePodcastFeedFromXml(String xml)
    {
        return CreateDummyEpisode();
    }


    public static String CreateDummyXml()
    {
        return "<Episode Url=\"\" PubDate=\"\" Title=\"\" Desc=\"\" Link=\"\" Auth=\"\" Id=\"\" />";
    }

    // TODO - dummy values
    public static PodcastEpisode CreateDummyEpisode()
    {
        PodcastEpisode episode = new PodcastEpisode();

        episode.url = "";
        episode.publicationDate = new Date();
        episode.title = "";
        episode.description = "";
        episode.imageLink = "";
        episode.author = "";
        episode.id = "";

        return episode;
    }
}
