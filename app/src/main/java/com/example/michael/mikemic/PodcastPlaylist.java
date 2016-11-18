package com.example.michael.mikemic;

import java.util.ArrayList;

/**
 * Created by Michael on 11/15/2016.
 */

public class PodcastPlaylist
{
    // TODO - instead, maybe have a list of tuples (episode, progress)
    public ArrayList<PodcastEpisode> episodes;

    // TODO - is this even necessary?  Can't I just use the first episode in the list?
    // I had wanted to store data for the current episode like progress into it,
    // but I want to be able to continue from the middle later on, so I should just save it that
    // way to begin with
    public PodcastEpisode currentEpisode;

    public PodcastPlaylist()
    {
        this.episodes = new ArrayList<PodcastEpisode>();
    }

    public static PodcastPlaylist InitFromFile(String fileName)
    {
        return null;
    }

    public void ExportToFile(String fileName)
    {

    }

    // TODO - bool?
    public void Add(PodcastEpisode episode)
    {
        this.episodes.add(episode);
    }
}
