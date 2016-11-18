package com.example.michael.mikemic;

import android.app.ListActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListAdapter;

import java.util.ArrayList;

public class ViewEpisodesSimpleActivity extends ListActivity
{

    // TODO - do I do the initialization on onCreate or the ctor?
    // Probably onCreate, since the ctor gets implicitly called via the intent
    // so I will have to figure out how to actually pass that init info in

    // for now, maybe init with the first?

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // TODO - customize view after I get it working with the default
        //setContentView(R.layout.activity_view_episodes_simple);

        // TODO - check non-null
        ArrayList<PodcastEpisode> episodes = MainActivity.instance.myFeeds.feeds.get(0).episodes;

        ListAdapter adapter = new SimpleRssEpisodeAdapter(
                this,
                episodes);

        setListAdapter(adapter);
    }

}
