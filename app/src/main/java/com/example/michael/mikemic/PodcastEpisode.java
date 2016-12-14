package com.example.michael.mikemic;

import com.einmalfel.earl.Item;

import java.util.Date;

/**
 * Created by Michael on 11/15/2016.
 */

// TODO - separate class for podcast episode instance, that tracks progress?
// Or maybe put into a wrapper that wraps this and the number of seconds

// This should correspond to Item
public class PodcastEpisode
{
    // TODO - correctly use getters and setters
    public String url; // TODO - rename to "link"
    public Date publicationDate;
    public String title;
    public String description;
    public String imageLink;
    public String author;

    // TODO - hopefully this will be a unique ID
    public String id;

    // TODO - state - played, unplayed, downloaded - or maybe put in in the wrapper class

    // TODO - download location?

    // TODO - what are enclosures?  There's a list of enclosures on the Item
    // Maybe print them out as a test before I design an actual UI for them

    // TODO - refcount?  for number of playlists this is in?

    public PodcastEpisode()
    {
    }

    public PodcastEpisode(Item item)
    {
        this.url = item.getLink();
        this.publicationDate = item.getPublicationDate();
        this.title = item.getTitle();
        this.description = item.getDescription();
        this.imageLink = item.getImageLink();
        this.author = item.getAuthor();
        //this.id = item.getId();
        this.id = ""; // TODO - why is this getter not working?
    }

    public static String SerializePodcastEpisodeToXml(PodcastEpisode episode)
    {
        return CreateDummyXml();
    }

    public static PodcastEpisode DeserializePodcastEpisodeFromXml(String xml)
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
