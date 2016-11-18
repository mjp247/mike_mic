package com.example.michael.mikemic;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Michael on 11/11/2016.
 */

public class SimpleRssFeedAdapter extends ArrayAdapter<PodcastFeed>
{
    public SimpleRssFeedAdapter(Context context, ArrayList<PodcastFeed> collection)
    {
        super(context, 0, collection);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        PodcastFeed feed = getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_rss_feed_simple, parent, false);
        }

        MiscUtils.setTextViewContents(convertView, R.id.feedUrl, feed.feedUrl);
        MiscUtils.setTextViewContents(convertView, R.id.feedTitle, feed.title);
        MiscUtils.setTextViewContents(convertView, R.id.feedDescription, feed.description);
        MiscUtils.setTextViewContents(convertView, R.id.feedImageLink, feed.imageLink);
        MiscUtils.setTextViewContents(convertView, R.id.feedAuthor, feed.author);

        return convertView;
    }

    // TODO - on tap, open list of episodes (on here or on activity?)
}
