package com.example.michael.mikemic;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Michael on 11/15/2016.
 */

public class SimpleRssEpisodeAdapter extends ArrayAdapter<PodcastEpisode>
{
    public SimpleRssEpisodeAdapter(Context context, ArrayList<PodcastEpisode> collection)
    {
        super(context, 0, collection);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        PodcastEpisode episode = getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_rss_episode_simple, parent, false);
        }

        MiscUtils.setTextViewContents(convertView, R.id.episodeUrl, episode.url);
        MiscUtils.setTextViewContents(convertView, R.id.episodeTitle, episode.title);
        MiscUtils.setTextViewContents(convertView, R.id.episodeDescription, episode.description);
        MiscUtils.setTextViewContents(convertView, R.id.episodeImageLink, episode.imageLink);
        MiscUtils.setTextViewContents(convertView, R.id.episodeAuthor, episode.author);

        return convertView;
    }
}