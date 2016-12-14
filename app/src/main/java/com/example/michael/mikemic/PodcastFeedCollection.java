package com.example.michael.mikemic;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by Michael on 11/11/2016.
 */

public class PodcastFeedCollection {

    // TODO - public or private?  Is there a way to wrap it in a read only list like c#?
    // TODO - list or arraylist?
    //public List<PodcastFeed> feeds;
    public ArrayList<PodcastFeed> feeds;

    // TODO - public or private?
    public PodcastFeedCollection()
    {
        this.feeds = new ArrayList<PodcastFeed>();
    }


    public static PodcastFeedCollection InitFromFile(String fileName)
    {
        return null;
    }

    public void ExportToFile(String fileName)
    {

    }

    // TODO - bool?
    public void Add(String feedUrl)
    {
        //PodcastFeed feed = new PodcastFeed(feedUrl);
        PodcastFeed feed = PodcastFeed.InitializeFromUrl(feedUrl);
        if (feed != null)
        {
            this.Add(feed);
        }
    }

    // TODO - bool?
    public void Add(PodcastFeed feed)
    {
        this.feeds.add(feed);
    }

    public static String SerializePodcastCollectionToXml(PodcastEpisode episode)
    {
        return CreateDummyXml();
    }

    public static PodcastEpisode DeserializePodcastCollectionFromXml(String xml)
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
