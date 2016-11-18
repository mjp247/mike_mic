package com.example.michael.mikemic;

import android.app.ListActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;

//public class ViewSubscriptionsSimpleActivity extends AppCompatActivity {
public class ViewSubscriptionsSimpleActivity extends ListActivity {

    // TODO - ListActivity - on item tap?

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // TODO - customize view after I get it working with the default
        //setContentView(R.layout.activity_view_subscriptions_simple);

        ListAdapter adapter = new SimpleRssFeedAdapter(
                this,
                MainActivity.instance.myFeeds.feeds);

        setListAdapter(adapter);
    }
}
